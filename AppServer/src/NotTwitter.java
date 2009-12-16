import java.util.StringTokenizer;
import org.smslib.*;

public class NotTwitter {
	
	private String clientName;
	private String from;
	private String type;
	private String content;
	
	NotTwitter(String str, String PhoneNumber)
	{
		StringTokenizer st = new StringTokenizer(str,">");
		String temp,temp1,temp2;
		String definedString, msgToSend;
			
		definedString = "clientName";
		temp = st.nextToken();
		temp1 = temp.substring(1,definedString.length()+1);
		temp2 = temp.substring(definedString.length()+2, temp.length());
		if(temp1.compareTo(definedString)!=0)
			System.out.println("Invalid condition. Expected: " + definedString +", Received: " + temp1 );
		//System.out.println("type: " + temp1 + ",value: " + temp2);
		this.clientName = temp2;
			
		String toktemp=st.nextToken();
		System.out.println("Token: "+toktemp);
		StringTokenizer st2=new StringTokenizer(toktemp,",");
		if(st2.nextToken().equals("<userName"))
		{
			this.type="Status";			
		}
		else this.type="Message";
		this.from=st2.nextToken();
		
		toktemp=st.nextToken();
		System.out.println("Token: "+toktemp);
		st2=new StringTokenizer(toktemp,",");
		st2.nextToken();
		this.content=st2.nextToken();
		
		while(st.hasMoreTokens())
		{
			toktemp=st.nextToken();
			System.out.println("Token: "+toktemp);
			
			st2=new StringTokenizer(toktemp,",");
			if(st2.nextToken().equals("<notificationType"))
				;
			else 
				this.content+=toktemp;
		}
			
		System.out.println("userid: "+clientName);
		System.out.println("from: "+from);
		System.out.println("type: "+type);
		System.out.println("content: "+content);

		msgToSend=new String();
		msgToSend+="From: "+from+"\nType: "+type+"\nContent: "+content;
			
		System.out.println("Twitter: SMS this message: "+msgToSend);
		
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
