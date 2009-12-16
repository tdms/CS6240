import java.util.StringTokenizer;


public class SMSSender {
	
	private NotifyEmail notEmail[];
    private NotTwitter notTwitter[];
    private String tempStr[];
    private int count;
    
    
    SMSSender()
    {
    	int i;
    	notEmail=new NotifyEmail[100];
    	notTwitter=new NotTwitter[100];
    	tempStr=new String[100];
    	for(i=0;i<100;i++)
			tempStr[i]="";
		
		count=0;
    }
    
    void send(String str,String cellNo)
    {
    	int i,foundFlag;
    	
    	//parse the data
        if(count==0)
		{
			tempStr[0]=str;
			
			StringTokenizer st = new StringTokenizer(str,">");
			String temp,temp1;
			String definedString, definedString2, flagET;
			
			definedString = "clientName";
			temp = st.nextToken();
			temp1 = temp.substring(1,definedString.length()+1);
							
			definedString2="<subject";
			flagET="";
			
			while(st.hasMoreTokens())
			{
				StringTokenizer st1 = new StringTokenizer(st.nextToken(),",");
				while(st1.hasMoreTokens()){
					String tempToken=st1.nextToken();
					
					//System.out.println("tempToken: "+tempToken);
					
					if(tempToken.compareTo(definedString2)==0)
						flagET="email";
				}								
			}
			
			//System.out.println("Extracted flag: "+flagET);
			
			//if(temp1.compareTo(definedString)!=0 && flagET.compareTo("email")==0)
			if(flagET.compareTo("email")==0)
			{
				notEmail[0]=new NotifyEmail(str, cellNo);
			}
			else{
				notTwitter[0]=new NotTwitter(str, cellNo);
			}
			count++;
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
			String definedString,definedString2, flagET;
			
			definedString = "clientName";
			temp = st.nextToken();
			temp1 = temp.substring(1,definedString.length()+1);
			
			definedString2="<subject";
			flagET="";
			
			while(st.hasMoreTokens())
			{
				StringTokenizer st1 = new StringTokenizer(st.nextToken(),",");
				while(st1.hasMoreTokens()){
					String tempToken=st1.nextToken();
					
					if(tempToken.compareTo(definedString2)==0)
						flagET="email";
				}							
			}
							
			if(flagET.compareTo("email")==0)
			{
				notEmail[count]=new NotifyEmail(str, cellNo);				
			}
			else{
				notTwitter[count]=new NotTwitter(str, cellNo);				
			}
				
			count++;
			
		}
	
        /* prepare a new SMS to be send */
        //COutgoingMessage NewSMS = new COutgoingMessage(cellNo, "TEST_ALERT");
        		
    }
}
