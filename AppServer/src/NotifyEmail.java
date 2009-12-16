import java.util.*;
import org.smslib.*;

public class NotifyEmail {
	private String userid;
	 private String emailFrom;
	 private String emailSubject;
	 private String emailDate;
	 private String emailBody;
	 
	 //private String str;
	 
	 NotifyEmail(String str, String PhoneNumber)
	 {
		//System.out.println(condition);
			StringTokenizer st = new StringTokenizer(str,">");
			String temp,temp1, temp2,temp3="";
			String definedString, msgToSend;
				
			definedString = "clientName";
			temp = st.nextToken();
			temp1 = temp.substring(1,definedString.length()+1);
			temp2 = temp.substring(definedString.length()+2, temp.length());
			if(temp1.compareTo(definedString)!=0)
				System.out.println("Invalid condition. Expected: " + definedString +", Received: " + temp1 );
			//System.out.println("type: " + temp1 + ",value: " + temp2);
			this.userid = temp2;
				
			definedString = "from";
			temp = st.nextToken();
			temp1 = temp.substring(1,definedString.length()+1);
			temp2 = temp.substring(definedString.length()+2, temp.length());
			if(temp1.compareTo(definedString)!=0)
				System.out.println("Invalid condition. Expected: " + definedString +", Received: " + temp1 );
			//System.out.println("type: " + temp1 + ",value: " + temp2);
			this.emailFrom = temp2;
			 	
			definedString = "subject";
			temp = st.nextToken();
			temp1 = temp.substring(1,definedString.length()+1);
			temp2 = temp.substring(definedString.length()+2, temp.length());
			if(temp1.compareTo(definedString)!=0)
				System.out.println("Invalid condition. Expected: " + definedString +", Received: " + temp1 );
			//System.out.println("type: " + temp1 + ",value: " + temp2);
			this.emailSubject = temp2;
			
			definedString = "date";
			temp = st.nextToken();
			temp1 = temp.substring(1,definedString.length()+1);
			temp2 = temp.substring(definedString.length()+2, temp.length());
			if(temp1.compareTo(definedString)!=0)
				System.out.println("Invalid condition. Expected: " + definedString +", Received: " + temp1 );
			//System.out.println("type: " + temp1 + ",value: " + temp2);
			this.emailDate = temp2;
			
			definedString = "body";
			temp = st.nextToken();
			temp1 = temp.substring(1,definedString.length()+1);
			temp2 = temp.substring(definedString.length()+2, temp.length());
			if(temp1.compareTo(definedString)!=0)
				System.out.println("Invalid condition. Expected: " + definedString +", Received: " + temp1 );
			//System.out.println("type: " + temp1 + ",value: " + temp2);
			this.emailBody = temp2;
			
			while(st.hasMoreTokens())
			{
				String toktemp=st.nextToken();
				System.out.println("Token: "+toktemp);
				
				StringTokenizer st2=new StringTokenizer(toktemp,",");
				if(st2.nextToken().equals("<notificationType"))
					;
				else 
					this.emailBody+=toktemp;
			}
				
			System.out.println("userid: "+userid);
			System.out.println("from: "+emailFrom);
			System.out.println("subject: "+emailSubject);
			System.out.println("date: "+emailDate);
			System.out.println("body: "+emailBody);
			
			msgToSend=new String();
			msgToSend+="From: "+emailFrom+"\nSubject: "+emailSubject+"\nBody: "+emailBody;
				
			System.out.println("EMAIL: SMS this message: "+msgToSend);
			
			//PhoneNumber="8587053795";
			System.out.println("phone number: "+PhoneNumber);
			
			
			CService Service = new CService("COM11", 57600, "Nokia", "");
	        	       
	        Service.setSmscNumber("+13123149810");
	        
	        
	        COutgoingMessage NewSMS = new COutgoingMessage(PhoneNumber, msgToSend);
	       	        
	        try
	        {
	            System.out.print("Before Connection");
	            Service.connect();
	           
	            System.out.print("Connection Done");
	                      
	            Service.sendMessage(NewSMS);
	            System.out.print("Sending Done");
	           
	            Service.disconnect();
	            System.out.print("Disconnect Done");
	           
	        }
	        catch (Exception VisionException)
	        {
	            VisionException.printStackTrace();
	            try{
	            Service.disconnect();
	            }catch(Exception e){
               
	            }
	        }
	 }
}
