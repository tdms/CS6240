import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;
import java.io.*;

import javax.mail.*;
import javax.mail.internet.*;



public class MailServer implements Runnable{
	Thread t;
	
    private String protocol = "imaps";
    static String host = "imap.gmail.com";
    static String user = null;
    static String password = null;
    private String advisorEmail[];
    private int advisorEmailLength;
    
    private int index;
    
    static String mbox = null;
    static String url = null;
    static int port = -1;
    static boolean showStructure = false;
    static boolean saveAttachments = false;    
    static int attnum = 1;
    static int newMessagesCount = 10;

    //info for a particular mail

    static String mailFrom = null;
    static String mailSubject = null;
    static String mailSendDate = null;
    static String mailFlags = null;
    static String mailContent = null;
    
    
	String clientName = null;
	String notificationType = null;

    private Folder folder = null;
    private Store store = null;
   	int msgnum = -1;
   	private String alreadyNotifiedList = "a";

    private Scanner input;
    private String totalMsg;
    
    private Connection conn=null;
	private Statement stmt;
	private ResultSet rs=null;
	
	private EventConditionParser eventConditionParser;
	SocketManager sm ;

	
    long sleepTime = 4000;			//in milisec
    
    MailServer()
    {    
        user="munir66";
    	password="dhanmondi2";   
    	
    	
		init();
		
		t = new Thread(this, "Mail Server");
		t.start();
    }
    
    public void run()
    {
    	try{
    		while(true)
    		{
    			checkMail();
    			Thread.sleep(sleepTime);
    		}
    	}
    	catch(InterruptedException e)
    	{
    		System.out.println("Exception in main controller.");
    	}
    }
    void init()
    {
       	
		eventConditionParser = new EventConditionParser();
		
		try{
			conn=DriverManager.getConnection("jdbc:mysql://localhost/db1?"+"user=root&password=munir");
			//conn=DriverManager.getConnection("jdbc:mysql://localhost/db1?"+"user=root&password=tanima");
			stmt=conn.createStatement();
		}
		catch(Exception e)
		{
			System.out.println("Exceptoin: " + e.getMessage());
		}

		sm = new SocketManager();
		sm.establishConnection();

		String sendData = "server_mailserver";
		sm.sendData(sendData);

    }
    boolean initSessions()
    {
    	//prev initialization
        totalMsg=new String();
        
    	InputStream msgStream = System.in;
    	
	    // Get a Properties object
	    Properties props = System.getProperties();

	    // Get a Session object
	    Session session = Session.getInstance(props, null);
	    try{
		    try{
		    	
			    store = session.getStore(protocol);
			    store.connect(host, port, user, password);
			    
			    folder = store.getDefaultFolder();
			    		    
			    if (folder == null) {
					System.out.println("No default folder");
					//System.exit(1);
					return false;
			    }
		    }
		    catch(Exception e)
		    {
		    	//System.out.println("Caught Exception. Invalid user-id/password for gmail.");
		    	//System.out.println("UserID: " + user);
		    	//System.out.println("Password: " + password);
		    	return false;
		    }
		    
		    
		    if (mbox == null)
				mbox = "INBOX";
		    
	        folder = folder.getFolder(mbox);
			folder.open(Folder.READ_ONLY);

		    if (folder == null)
		    {
		    	System.out.println("Invalid folder");
		    	//System.exit(1);
		    	return false;
		    }
	    }
	    catch(Exception e)
	    {
	    	e.printStackTrace();
	    }
	    return true;
    	
    }
    
   
	void checkMail()
	{
		
		
		int count = 0;
		String username = null;
		String event_type = null;
		String event_condition = null;
		String notification = null;
		
		try{
			if(stmt.execute("select * from events where event_type = 'gmail' order by username;"))
				rs = stmt.getResultSet();
			
			
			while(rs.next())
			{
				
				username = rs.getString(1);
				event_type = rs.getString(2);
				event_condition = rs.getString(3);
				notification = rs.getString(4);
				
				//System.out.println("result: "+rs.getString(1) + " "+rs.getString(2) + " "+rs.getString(3) + " "+rs.getString(4));
				
				clientName = username;
				notificationType = notification;
				
				eventConditionParser.parseCondition(event_condition);					
				user = eventConditionParser.userID;
				password  = eventConditionParser.password;
				
				//System.out.println(eventConditionParser.senderHas[0] + " " + eventConditionParser.subjectHasNot[0] + " " + eventConditionParser.bodyHasNot[0]);
	
				count++;
	
				if(initSessions() == false)
					continue;
				
				
				checkMailStatus();
			}
			System.out.print("count: "+count); //getRow()
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}
	void checkMailStatus()
	{		
		
		try{
		   int totalMessages = 0;
		    
		    try {
				//folder.open(Folder.READ_WRITE);
				//folder.open(Folder.READ_ONLY);
				totalMessages = folder.getMessageCount();
				System.out.println("Total messages: " + totalMessages);
		
		    } 
		    catch (MessagingException ex) {
		    		System.out.println("Folder openning problem.");
			 }
		    
		    
		    if (totalMessages == 0) {
				System.out.println("Empty folder");
				folder.close(false);
				store.close();
				System.exit(1);
			}

	        //fetching new mails
		    if (msgnum == -1) {
				
			Message[] msgs = folder.getMessages();
	
			// Use a suitable FetchProfile
			FetchProfile fp = new FetchProfile();
			fp.add(FetchProfile.Item.ENVELOPE);
			fp.add(FetchProfile.Item.FLAGS);
			fp.add("X-Mailer");
			folder.fetch(msgs, fp);
			
			int startingIndex = msgs.length - newMessagesCount;
			if(startingIndex < 0)
				startingIndex = 0;
	
			//actual message printing
			for (int i = startingIndex; i < msgs.length; i++) {
			    System.out.println("--------------------------");
			    System.out.println("MESSAGE #" + (i + 1) + ":");
			    dumpEnvelope(msgs[i]);
			    dumpPart(msgs[i]);
			    
			    System.out.println("FROM: " + mailFrom);
			    System.out.println("SUBJECT:" + mailSubject);
			    System.out.println("DATE:" + mailSendDate);
			    System.out.println("FLAGS: " + mailFlags);
			    System.out.println("BODY:\n");
			    System.out.println("=======================================\n");
			    System.out.println(mailContent);
			    System.out.println("=======================================\n");
			   
			    if(eventConditionParser.senderOK(mailFrom) && eventConditionParser.subjectOK(mailSubject) && eventConditionParser.bodyOK(mailContent)) //&& alreadyNotifiedList!= null && !alreadyNotifiedList.contains(mailFrom+mailSubject+mailSendDate)
			    {		
			    		System.out.println("********NOTIFY NOW !!!!******************");
			    		
					    totalMsg="";
					    totalMsg+="<clientName," + clientName +">";
					    totalMsg+="<from," + mailFrom+">";
					    totalMsg+="<subject," + mailSubject+ ">";
					    totalMsg+="<date," + mailSendDate + ">";
					    totalMsg+="<body," + mailContent+">";
					    totalMsg+="<notificationType," + notificationType+">";
					    
						sm.sendData(totalMsg.length()+"");
						sm.sendData(totalMsg);				
						
						System.out.println(totalMsg);

				 }
				}
		    } else {
			System.out.println("Getting message number: " + msgnum);
			Message m = null;
			
			try {
			    m = folder.getMessage(msgnum);
			    dumpPart(m);
			    
			    //uncomment these to see the messages....
			    
			    //System.out.println("FROM: " + mailFrom);
			    //System.out.println("SUBJECT:" + mailSubject);
			    //System.out.println("DATE:" + mailSendDate);
			    //System.out.println("FLAGS: " + mailFlags);
			    //System.out.println("BODY: " + mailContent);
			    		    		
			} catch (IndexOutOfBoundsException iex) {
			    System.out.println("Message number out of range");
			}
		    }
		    
						
		    //folder.close(false);
		    //store.close();
	    }
	    catch(Exception e)
	    {
	    	System.out.println("Exception caught.");
	    	e.printStackTrace();
	    }
	    
		    
    }

	public static void dumpPart(Part p) throws Exception {
		if (p instanceof Message)
		    dumpEnvelope((Message)p);
	
		/** Dump input stream .. 
	
		InputStream is = p.getInputStream();
		// If "is" is not already buffered, wrap a BufferedInputStream
		// around it.
		if (!(is instanceof BufferedInputStream))
		    is = new BufferedInputStream(is);
		int c;
		while ((c = is.read()) != -1)
		    System.out.write(c);
	
		**/
	
		String ct = p.getContentType();
		try {
		    pr("CONTENT-TYPE: " + (new ContentType(ct)).toString());
		} catch (ParseException pex) {
		    pr("BAD CONTENT-TYPE: " + ct);
		}
		String filename = p.getFileName();
		if (filename != null)
		    pr("FILENAME: " + filename);
	
		/*
		 * Using isMimeType to determine the content type avoids
		 * fetching the actual content data until we need it.
		 */
		if (p.isMimeType("text/plain")) {
		    pr("This is plain text");
		    pr("---------------------------");
		    if (!showStructure && !saveAttachments)
			//System.out.println((String)p.getContent());
		    pr((String)p.getContent());
		    
		    mailContent = (String)p.getContent();
		    return;
		    
		} else if (p.isMimeType("multipart/*")) {
		    pr("This is a Multipart");
		    pr("---------------------------");
		    Multipart mp = (Multipart)p.getContent();
		    level++;
		    int count = mp.getCount();
		    for (int i = 0; i < count; i++)
			dumpPart(mp.getBodyPart(i));
		    level--;
		} else if (p.isMimeType("message/rfc822")) {
		    pr("This is a Nested Message");
		    pr("---------------------------");
		    level++;
		    dumpPart((Part)p.getContent());
		    level--;
		} else {
		    if (!showStructure && !saveAttachments) {
			/*
			 * If we actually want to see the data, and it's not a
			 * MIME type we know, fetch it and check its Java type.
			 */
			Object o = p.getContent();
			if (o instanceof String) {
			    pr("This is a string");
			    pr("---------------------------");
			    //System.out.println((String)o);		//change?
			    
			} else if (o instanceof InputStream) {
			    pr("This is just an input stream");
			    pr("---------------------------");
			    InputStream is = (InputStream)o;
			    int c;
			    while ((c = is.read()) != -1)
				System.out.write(c);
			} else {
			    pr("This is an unknown type");
			    pr("---------------------------");
			    pr(o.toString());
			}
		    } else {
			// just a separator
			pr("---------------------------");
		    }
		}
	
		/*
		 * If we're saving attachments, write out anything that
		 * looks like an attachment into an appropriately named
		 * file.  Don't overwrite existing files to prevent
		 * mistakes.
		 */
		if (saveAttachments && level != 0 && !p.isMimeType("multipart/*")) {
		    String disp = p.getDisposition();
		    // many mailers don't include a Content-Disposition
		    if (disp == null || disp.equalsIgnoreCase(Part.ATTACHMENT)) {
			if (filename == null)
			    filename = "Attachment" + attnum++;
			pr("Saving attachment to file " + filename);
			try {
			    File f = new File(filename);
			    if (f.exists())
				// XXX - could try a series of names
				throw new IOException("file exists");
			    ((MimeBodyPart)p).saveFile(f);
			} catch (IOException ex) {
			    pr("Failed to save attachment: " + ex);
			}
			pr("---------------------------");
		    }
		}
    }


	public static void dumpEnvelope(Message m) throws Exception {
		pr("This is the message envelope");
		pr("---------------------------");
		Address[] a;
		// FROM 
		if ((a = m.getFrom()) != null) {
		    for (int j = 0; j < a.length; j++)
			pr("FROM: " + a[j].toString());
		}
	    mailFrom = a[0].toString();
		
		// REPLY TO
		if ((a = m.getReplyTo()) != null) {
		    for (int j = 0; j < a.length; j++)
			pr("REPLY TO: " + a[j].toString());
		}
	
		// TO
		if ((a = m.getRecipients(Message.RecipientType.TO)) != null) {
		    for (int j = 0; j < a.length; j++) {
			pr("TO: " + a[j].toString());
			InternetAddress ia = (InternetAddress)a[j];
			if (ia.isGroup()) {
			    InternetAddress[] aa = ia.getGroup(false);
			    for (int k = 0; k < aa.length; k++)
				pr("  GROUP: " + aa[k].toString());
			}
		    }
		}
	
		// SUBJECT
		pr("SUBJECT: " + m.getSubject());
		mailSubject = m.getSubject();
		
		// DATE
		Date d = m.getSentDate();
		pr("SendDate: " +
		    (d != null ? d.toString() : "UNKNOWN"));
	
		mailSendDate = d.toString();
		
		// FLAGS
		Flags flags = m.getFlags();
		StringBuffer sb = new StringBuffer();
		Flags.Flag[] sf = flags.getSystemFlags(); // get the system flags
	
		boolean first = true;
		String s = null;
		for (int i = 0; i < sf.length; i++) {
		    
		    Flags.Flag f = sf[i];
		    if (f == Flags.Flag.ANSWERED)
			s = "\\Answered";
		    else if (f == Flags.Flag.DELETED)
			s = "\\Deleted";
		    else if (f == Flags.Flag.DRAFT)
			s = "\\Draft";
		    else if (f == Flags.Flag.FLAGGED)
			s = "\\Flagged";
		    else if (f == Flags.Flag.RECENT)
			s = "\\Recent";
		    else if (f == Flags.Flag.SEEN)
			s = "\\Seen";
		    else
			continue;	// skip it
		    if (first)
			first = false;
		    else
			sb.append(' ');
		    sb.append(s);
		}
		mailFlags = s;
	
		String[] uf = flags.getUserFlags(); // get the user flag strings
		for (int i = 0; i < uf.length; i++) {
		    if (first)
			first = false;
		    else
			sb.append(' ');
		    sb.append(uf[i]);
		}
		pr("FLAGS: " + sb.toString());
	
		// X-MAILER
		String[] hdrs = m.getHeader("X-Mailer");
		if (hdrs != null)
		    pr("X-Mailer: " + hdrs[0]);
		else
		    pr("X-Mailer NOT available");
	    }
	
	    static String indentStr = "                                               ";
	    static int level = 0;
	
	    /**
	     * Print a, possibly indented, string.
	     */
	    public static void pr(String s) {
		//if (showStructure)
		    //System.out.print(indentStr.substring(0, level * 2));
		//System.out.println(s);
    }

	public static void main(String[] args) {
		new MailServer();
	}

}

class EventConditionParser
{
	public String userID;
	public String password;
	public String[] senderHas = new String[10];
	public String[] senderHasNot = new String[10];
	public String[] subjectHas = new String[10];
	public String[] subjectHasNot = new String[10];
	public String[] bodyHas = new String[10];
	public String[] bodyHasNot = new String[10];
	
	int senderHasIndex, senderHasNotIndex, subjectHasIndex, subjectHasNotIndex, bodyHasIndex, bodyHasNotIndex;
	
	
	void parseCondition(String condition)
	{
		//System.out.println(condition);
		StringTokenizer st = new StringTokenizer(condition,">");
		String temp,temp1, temp2,temp3="",temp5;
		String definedString;
		
		definedString = "userid";
		temp = st.nextToken();
		temp1 = temp.substring(1,definedString.length()+1);
		temp2 = temp.substring(definedString.length()+2, temp.length());
		if(temp1.compareTo(definedString)!=0)
			System.out.println("Invalid condition. Expected: " + definedString +", Received: " + temp1 );
		//System.out.println("type: " + temp1 + ",value: " + temp2);
		this.userID = temp2;
		
		definedString = "password";
		temp = st.nextToken();
		temp1 = temp.substring(1,definedString.length()+1);
		temp2 = temp.substring(definedString.length()+2, temp.length());
		if(temp1.compareTo(definedString)!=0)
			System.out.println("Invalid condition. Expected: " + definedString +", Received: " + temp1 );
		//System.out.println("type: " + temp1 + ",value: " + temp2);
		this.password = temp2;
	 	
		senderHasIndex = 0;
        senderHasNotIndex = 0;
        subjectHasIndex = 0;
        subjectHasNotIndex = 0;
        bodyHasIndex = 0;
        bodyHasNotIndex = 0;
		
		
		while (st.hasMoreTokens()) {
			
			String ds1 = "sender";
			String ds2 = "subject";
			String ds5 = "body";
			String ds3 = "has";
			String ds4 = "hasnot";
			
	        temp = st.nextToken();
	        temp1 = temp.substring(1,ds1.length()+1);	        
	        temp2 = temp.substring(1,ds2.length()+1);	 
	        temp5 = temp.substring(1,ds5.length()+1);
	        
	        
	       
	        if(temp1.compareTo(ds1) == 0)
	        {
	        	int len = ds1.length() + 1;
	        	temp1 = temp.substring(len + 1,len + 1 + ds3.length());	        
		        temp2 = temp.substring(len + 1,len + 1 + ds4.length());	       
	        	
		         if(temp2.compareTo(ds4)==0)
		         {
		        	temp3 = temp.substring(len + 1 + ds4.length()+1,temp.length());
		        	senderHasNot[senderHasNotIndex++] = temp3.toLowerCase(); 
		        	
		         }
		         else if(temp1.compareTo(ds3)==0)
			      {
			        	temp3 = temp.substring(len + 1 + ds3.length()+1,temp.length());
			        	senderHas[senderHasIndex++] = temp3.toLowerCase(); 		        				     
			      }
			      else
		        	System.out.println("invalid condition: has/hasnot problem");
		        
	        }
	        else if(temp2.compareTo(ds2) == 0)
	        {
	        	int len = ds2.length() + 1;
	        	temp1 = temp.substring(len + 1,len + 1 + ds3.length());	        
		        temp2 = temp.substring(len + 1,len + 1 + ds4.length());	       
	        	
		         if(temp2.compareTo(ds4)==0)
		         {
		        	temp3 = temp.substring(len + 1 + ds4.length()+1,temp.length());
		        	subjectHasNot[subjectHasNotIndex++] = temp3.toLowerCase(); 
		        	
		         }
		         else if(temp1.compareTo(ds3)==0)
			      {
			        	temp3 = temp.substring(len + 1 + ds3.length()+1,temp.length());
			        	subjectHas[subjectHasIndex++] = temp3.toLowerCase(); 		        				     
			      }
			      else
		        	System.out.println("invalid condition: has/hasnot problem");
		        
	        }
	        else if(temp5.compareTo(ds5) == 0)
	        {
	        	int len = ds5.length() + 1;
	        	temp1 = temp.substring(len + 1,len + 1 + ds3.length());	        
		        temp2 = temp.substring(len + 1,len + 1 + ds4.length());	       
	        	
		         if(temp2.compareTo(ds4)==0)
		         {
		        	temp3 = temp.substring(len + 1 + ds4.length()+1,temp.length());
		        	bodyHasNot[bodyHasNotIndex++] = temp3.toLowerCase(); 
		        	
		         }
		         else if(temp1.compareTo(ds3)==0)
			      {
			        	temp3 = temp.substring(len + 1 + ds3.length()+1,temp.length());
			        	bodyHas[bodyHasIndex++] = temp3.toLowerCase(); 		        				     
			      }
			      else
		        	System.out.println("invalid condition: has/hasnot problem");
	        	
	        }
	        else
	        	System.out.println("Invalid condition. Expected: " + ds1 +"/" + ds2 + "/" + ds3 + ", Received: " + temp1 );
	        	
	        
	         
	     }
		
		
	}

	boolean senderOK(String event)	//type = 0 ->status, type = 1 -> message
	{	
		event = event.toLowerCase();
		for(int i = 0; i < senderHasIndex; i++)
		{
			if(event.lastIndexOf(senderHas[i]) == -1 )
				return false;
		}
		for(int i = 0; i < senderHasNotIndex; i++)
		{
			if(event.lastIndexOf(senderHasNot[i]) != -1 )
				return false;				
		}
		return true;
	}
	
	boolean subjectOK(String event)
	{
		event = event.toLowerCase();
		for(int i = 0; i < subjectHasIndex; i++)
		{
			if(event.lastIndexOf(subjectHas[i]) == -1 )
				return false;
		}
		for(int i = 0; i < subjectHasNotIndex; i++)
		{
			if(event.lastIndexOf(subjectHasNot[i]) != -1 )
				return false;
		}
		
		return true;
	}
	boolean bodyOK(String event)
	{
		event = event.toLowerCase();
		for(int i = 0; i < bodyHasIndex; i++)
		{
			if(event.lastIndexOf(bodyHas[i]) == -1 )
				return false;
		}
		for(int i = 0; i < bodyHasNotIndex; i++)
		{
			if(event.lastIndexOf(bodyHasNot[i]) != -1 )
				return false;
		}
		
		return true;
	}
}
