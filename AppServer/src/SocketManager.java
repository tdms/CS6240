import java.io.*;
import java.net.*;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.SynchronousQueue;


public class SocketManager {
	int listeningPortNo = 4445;
	ServerSocket server;
	LinkedList<ClientWorker> workers = new LinkedList<ClientWorker>();
	
	public void listenSocket(){
		  try{
		    server = new ServerSocket(listeningPortNo);
		  } catch (IOException e) {
		    System.out.println("Could not listen on port " + listeningPortNo);
		    System.exit(-1);
		  }
		  while(true){
		    ClientWorker w;
		    try{
		      w = new ClientWorker(server.accept(), this);
		      workers.add(w);
		      
		      Thread t = new Thread(w);
		      t.start();
		    } catch (IOException e) {
		      System.out.println("Accept failed: " + listeningPortNo);
		      System.exit(-1);
		    }
		  }
		}
}

class ClientWorker implements Runnable {
	  private Socket client;
	  private SocketManager sm;
	  String clientID;
	  //LinkedList<String> queue = new  LinkedList<String>();
	  List<String> queue = Collections.synchronizedList(new LinkedList<String>());
	  char[] cbuf = new char[5000];
		
	
	  ClientWorker(Socket client, SocketManager sm) {
	    this.client = client;
	    this.sm = sm;
	  }
	  
	  String getClientName(String str)
	  {
		  return str.substring(11, str.length());
	  }

	  public void run(){
	    String line;
	    BufferedReader in = null;
	    PrintWriter out = null;
	    try{
	      in = new BufferedReader(new 
	        InputStreamReader(client.getInputStream()));
	      out = new 
	        PrintWriter(client.getOutputStream(), true);
	    } catch (IOException e) {
	      System.out.println("in or out failed");
	      System.exit(-1);
	    }

	    //read client ID
	    try{
	    	clientID = in.readLine();
        
	    	System.out.println("server received client ID: " + clientID);
	    }
        catch (IOException e) {
	        System.out.println("Read failed");
	        System.exit(-1);
       }
        
        
	    
	    while(true){
	      
	      try{
	    	  
	    	line = "";
	    	
	    	if(clientID.toLowerCase().lastIndexOf("client") != -1)
	    	{
	    		//this is for a clientApp
	    		 Thread.sleep(200);
	    		 if(queue.size() > 0 )
	    		 {
	    			 String dataToSend = queue.remove(0);
	    			 System.out.println("Pushing data to client:" + dataToSend);
	    			 out.println(dataToSend.length());
	    			 out.println(dataToSend);	  
	    			 
	    			 System.out.println("Pushing data to tanima's client: " + dataToSend.length() + " " + dataToSend);
	    		 }
	    	}
	    		
	    	else
	    	{
	    		//this is for a serverApp
	    		int byteCount = Integer.parseInt(in.readLine());
	    		System.out.println("Server received byte count: " + byteCount);
	    		
	    		
	    		int bytesRead = in.read(cbuf, 0, byteCount+2);
	    		
	    		line = new String(cbuf,0, byteCount);
	    		
	    		System.out.println("server reads: " + bytesRead);
	    		System.out.println("Server received: " + line);
	    		
	    		String clientName = line.substring(12, line.indexOf('>')); //from <clientName,munir>
	    		System.out.println("Server got clientname: " + clientName);
	    		
	    		for(int i = 0; i <sm.workers.size(); i++ )
	    		{
	    			ClientWorker cw = (ClientWorker) sm.workers.get(i);
	    			String wholeCID = cw.clientID;
	    			if(wholeCID.lastIndexOf("client_") == -1)
	    				continue;
	    			
	    			String actualCID = wholeCID.substring(7, wholeCID.length()); //from client_munir
	    			System.out.println("server calc actual CID: " + actualCID );
	    			
	    			if(actualCID.compareTo(clientName) == 0)
	    			{
	    				System.out.println("pushing data to :" + actualCID + ",data: " + line);
	    				cw.queue.add(line);
	    				break;
	    			}
	    		}
	    	}
	        
	        //System.out.println(line);
	        
	       
	        }
	        catch (IOException e) {
		        System.out.println("Read failed at: " + clientID );
		        System.exit(-1);
	       }
	        catch (Exception e)
	        {
	        	e.printStackTrace();
	        }
	    }
	  }
	}

