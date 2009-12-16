import java.io.*;
import java.net.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.concurrent.SynchronousQueue;
import java.sql.*;


public class SocketManager {
	int listeningPortNo = 4445;
	ServerSocket server;
	LinkedList<ClientWorker> workers = new LinkedList<ClientWorker>();
	
	
	public void listenSocket(SMSSender smsSender){
		  try{
		    server = new ServerSocket(listeningPortNo);
		  } catch (IOException e) {
		    System.out.println("Could not listen on port " + listeningPortNo);
		    System.exit(-1);
		  }
		  while(true){
		    ClientWorker w;
		    try{
		      w = new ClientWorker(server.accept(), this, smsSender);
		      workers.add(w);
		      
		      Thread t = new Thread(w);
		      t.start();
		    } catch (IOException e) {
		      System.out.println("Accept failed: " + listeningPortNo);
		      //System.exit(-1);
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
		
	  private Connection conn=null;
	  private Statement stmt;
	  private ResultSet rs=null;
	  private SMSSender smsSender = null;	
		
	  ClientWorker(Socket client, SocketManager sm, SMSSender smsSender) {
	    this.client = client;
	    this.sm = sm;
	    this.smsSender = smsSender;
	  }
	  
	  String getClientName(String str)
	  {
		  return str.substring(11, str.length());
	  }
	  
	  boolean intendedForSms(String str)
	  {
		  StringTokenizer st = new StringTokenizer(str,">");
			String temp,temp1;
			String definedString, notType, definedString1;
			
			definedString = "clientName";
			temp = st.nextToken();
			temp1 = temp.substring(1,definedString.length()+1);
							
			definedString1="<notificationType";
			notType="";
			
			
			while(st.hasMoreTokens())
			{
				StringTokenizer st1 = new StringTokenizer(st.nextToken(),",");
				while(st1.hasMoreTokens()){
					String tempToken=st1.nextToken();
					
					//System.out.println("tempToken: "+tempToken);
					
					if(tempToken.compareTo(definedString1)==0)
						notType=st1.nextToken().trim();
								
				}								
			}
			
			if(notType.compareTo("sms")==0)
				return true;
			else
				return false;
	  }
	  
	  String getContactNo(String str)
	  {
		  	StringTokenizer st = new StringTokenizer(str,">");
			String temp,temp1, temp2,temp3="", userid="",cellnumber="";
			String definedString;
				
			definedString = "clientName";
			temp = st.nextToken();
			temp1 = temp.substring(1,definedString.length()+1);
			temp2 = temp.substring(definedString.length()+2, temp.length());
			if(temp1.compareTo(definedString)!=0)
				System.out.println("Invalid condition. Expected: " + definedString +", Received: " + temp1 );
			
			userid = temp2;
			
						
			try
			{
    			conn=DriverManager.getConnection("jdbc:mysql://localhost/db1?"+"user=root&password=munir");
    			stmt=conn.createStatement();
    			
    			stmt.execute("select cellphone_number from users where username=\'"+userid+"\'");
    			rs = stmt.getResultSet();
    			
    			//count=0;
    			while(rs.next()){
    				//count++;
    				cellnumber=rs.getString(1);
    			}
			}
			catch(Exception e){
				System.out.println("Exception: "+e);    			
    		}
			
			return cellnumber;
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
	      //System.exit(-1);
	    }

	    //read client ID
	    try{
	    	clientID = in.readLine();
        
	    	System.out.println("server received client ID: " + clientID);
	    }
        catch (IOException e) {
	        System.out.println("Read failed");
	        //System.exit(-1);
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
	    		
	    		if(intendedForSms(line))
   			 	{
	   				 System.out.println("AppServer: for SMS");
	   				 String contactNo = getContactNo(line);
	   				 smsSender.send(line,contactNo);
	   				 continue;
   			 	}

	    		for(int i = sm.workers.size() - 1; i >= 0; i-- )
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
		        break;
		        //System.exit(-1);
	       }
	        catch (Exception e)
	        {
	        	e.printStackTrace();
	        }
	    }
	  }
	}

