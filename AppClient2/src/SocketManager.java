import java.io.*;
import java.net.*;

import java.util.*;
import java.util.concurrent.SynchronousQueue;

public class SocketManager implements Runnable{
	
	private Thread runner;
	
	private Socket socket;
    private BufferedReader in = null;
    private PrintWriter out = null;
    private int serverPort = 4445;
    private String serverHostName = "localhost";
    
    private NotifyEmailJFrame notEmail[];
    private NotTwitterJFrame notTwitter[];
    
    private String tempStr[]; 

    public void establishConnection()
    {
    	notEmail=new NotifyEmailJFrame[100];
    	notTwitter=new NotTwitterJFrame[100];
    	
		//Create socket connection
		try{
			socket = new Socket(serverHostName, serverPort);
		    out = new PrintWriter(socket.getOutputStream(), true);
		    in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		} 
		catch (UnknownHostException e) {
		    System.out.println("Unknown host: " + serverHostName);
		    System.exit(1);
		} 
		catch  (IOException e) {
		    System.out.println("No I/O");
		    System.exit(1);
		}
	}
	
    public void closeConnection()
    {
    	try{
    		socket.close();
    	}
    	catch(Exception e)
    	{
    		System.out.println("Exception while closing connection: "+e);
    	}
    }
    
	public void sendData(String data)
	{
		out.println(data);
	}
	
	public void run()
	{
		int i, count, foundFlag;
		System.out.println("In readData()");
		char[] cbuf = new char[5000];
		tempStr=new String[100];
		
		for(i=0;i<100;i++)
			tempStr[i]="";
		
		count=0;
		
		while(true)
		{
			try
			{
				//Thread.sleep(500);
				
				int byteCount = Integer.parseInt(in.readLine());
	    		System.out.println("Tanima's received byte count: " + byteCount);
	    		
				int bytesRead = in.read(cbuf, 0, byteCount+2);
	    		
				String str = new String(cbuf,0, byteCount);
								
				System.out.println("Received Data At Tanima's client: "+str);
				
				if(count==0)
				{
					tempStr[0]=str;
					
					StringTokenizer st = new StringTokenizer(str,">");
					String temp,temp1;
					String definedString, notType, definedString1, definedString2, flagET;
					
					definedString = "clientName";
					temp = st.nextToken();
					temp1 = temp.substring(1,definedString.length()+1);
									
					definedString1="<notificationType";
					notType="";
					definedString2="<subject";
					flagET="";
					
					while(st.hasMoreTokens())
					{
						StringTokenizer st1 = new StringTokenizer(st.nextToken(),",");
						while(st1.hasMoreTokens()){
							String tempToken=st1.nextToken();
							
							System.out.println("tempToken: "+tempToken);
							
							if(tempToken.compareTo(definedString1)==0)
								notType=st1.nextToken().trim();
							
							else if(tempToken.compareTo(definedString2)==0)
								flagET="email";
						}								
					}
					
					System.out.println("Extracted Not type: "+notType);
					System.out.println("Extracted flag: "+flagET);
					
					if(notType.compareTo("popup")==0){			
					
						//if(temp1.compareTo(definedString)!=0 && flagET.compareTo("email")==0)
						if(flagET.compareTo("email")==0)
						{
							notEmail[0]=new NotifyEmailJFrame(str);
							notEmail[0].setLocationRelativeTo(null);
							notEmail[0].setVisible(true);
						}
						else{
							notTwitter[0]=new NotTwitterJFrame(str);
							notTwitter[0].setLocationRelativeTo(null);
							notTwitter[0].setVisible(true);
						}
						count++;
					}					
				}
				
				
				foundFlag=0;
				
				for(i=0;i<count;i++)
				{
					if(tempStr[i].equals(str))
					{
						foundFlag=1;																
					}
				}				
				
				if(foundFlag==0)
				{
					tempStr[count]=str;
									
					StringTokenizer st = new StringTokenizer(str,">");
					String temp,temp1;
					String definedString,notType, definedString1, definedString2, flagET;
					
					definedString = "clientName";
					temp = st.nextToken();
					temp1 = temp.substring(1,definedString.length()+1);
					
					definedString1="<notificationType";
					notType="";
					definedString2="<subject";
					flagET="";
					
					while(st.hasMoreTokens())
					{
						StringTokenizer st1 = new StringTokenizer(st.nextToken(),",");
						while(st1.hasMoreTokens()){
							String tempToken=st1.nextToken();
							//System.out.println("tempToken: "+tempToken);
							if(tempToken.compareTo(definedString1)==0)
								notType=st1.nextToken().trim();
							
							else if(tempToken.compareTo(definedString2)==0)
								flagET="email";
						}							
					}
									
					System.out.println("Extracted Not type: "+notType);
					//System.out.println("Extracted flag: "+flagET);
					
					if(notType.compareTo("popup")==0){	
						//if(temp1.compareTo(definedString)!=0 && flagET.compareTo("email")==0)
						
						if(flagET.compareTo("email")==0)
						{
							notEmail[count]=new NotifyEmailJFrame(str);
							notEmail[count].setLocationRelativeTo(null);
							notEmail[count].setVisible(true);
						}
						else{
							notTwitter[count]=new NotTwitterJFrame(str);
							notTwitter[count].setLocationRelativeTo(null);
							notTwitter[count].setVisible(true);
						}
						
						count++;
					}
				}
			}
			
			catch (IOException e) {
		        System.out.println("Read failed");
		        System.exit(-1);
	       }
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}
	
	public void readData()
	{
		runner=new Thread(this,"MailFetcher");
		runner.start();
	}
}
