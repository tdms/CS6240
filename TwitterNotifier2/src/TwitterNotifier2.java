import net.unto.twitter.Api;
import net.unto.twitter.TwitterProtos.Status;
import net.unto.twitter.TwitterProtos.User;
import net.unto.twitter.methods.DirectMessagesRequest;
import net.unto.twitter.methods.ShowUserRequest;
import net.unto.twitter.TwitterProtos.DirectMessage;

import java.util.List;
import java.util.StringTokenizer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

class EventConditionParser
{
	public String userID;
	public String password;
	public String[] messageHas = new String[10];
	public String[] messageHasNot = new String[10];
	public String[] statusHas = new String[10];
	public String[] statusHasNot = new String[10];
	int messageHasIndex, messageHasNotIndex, statusHasIndex, statusHasNotIndex;
	
	int min2(int a, int b)
	{
		if(a<b)
			return a;
		else
			return b;
	}
	void parseCondition(String condition)
	{
		//System.out.println(condition);
		int totalLength = condition.length();
		
		System.out.println("String in parseCondition: " + condition);
		
		StringTokenizer st = new StringTokenizer(condition,">");
		String temp,temp1, temp2,temp3="";
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
	 	
		messageHasIndex = 0;
        messageHasNotIndex = 0;
        statusHasIndex = 0;
        statusHasNotIndex = 0;
		
		
		while (st.hasMoreTokens()) {
			
			String ds1 = "message";
			String ds2 = "status";
			String ds3 = "has";
			String ds4 = "hasnot";
			
	        temp = st.nextToken();
	        temp1 = temp.substring(1,ds1.length()+1);	        
	        temp2 = temp.substring(1,ds2.length()+1);	        
	        
	       
	        if(temp1.compareTo(ds1) == 0)
	        {
	        	int len = ds1.length() + 1;
	        	temp1 = temp.substring(len + 1,min2(len + 1 + ds3.length(), totalLength));	        
		        temp2 = temp.substring(len + 1,min2(len + 1 + ds4.length(), totalLength));	       
	        	
		         if(temp2.compareTo(ds4)==0)
		         {
		        	temp3 = temp.substring(len + 1 + ds4.length()+1,temp.length());
		        	messageHasNot[messageHasNotIndex++] = temp3.toLowerCase(); 
		        	
		         }
		         else if(temp1.compareTo(ds3)==0)
			      {
			        	temp3 = temp.substring(len + 1 + ds3.length()+1,temp.length());
			        	messageHas[messageHasIndex++] = temp3.toLowerCase(); 		        				     
			      }
			      else
		        	System.out.println("invalid condition: has/hasnot problem");
		        
	        }
	        else if(temp2.compareTo(ds2) == 0)
	        {
	        	int len = ds2.length() + 1;
	        	temp1 = temp.substring(len + 1,min2(len + 1 + ds3.length(),totalLength));	        
		        temp2 = temp.substring(len + 1,min2(len + 1 + ds4.length(),totalLength));	       
	        	
		         if(temp2.compareTo(ds4)==0)
		         {
		        	temp3 = temp.substring(len + 1 + ds4.length()+1,temp.length());
		        	statusHasNot[statusHasNotIndex++] = temp3.toLowerCase(); 
		        	
		         }
		         else if(temp1.compareTo(ds3)==0)
			      {
			        	temp3 = temp.substring(len + 1 + ds3.length()+1,temp.length());
			        	statusHas[statusHasIndex++] = temp3.toLowerCase(); 		        				     
			      }
			      else
		        	System.out.println("invalid condition: has/hasnot problem");
		        
	        }
	        else
	        	System.out.println("Invalid condition. Expected: " + ds1 +"/" + ds2 +", Received: " + temp1 );
	        
	         
	     }
		
		
	}

	boolean satisfiesCodition(String event, int type)	//type = 0 ->status, type = 1 -> message
	{	
		event = event.toLowerCase();
		
		if( type == 0 && statusHasIndex == 0 && statusHasNotIndex == 0)
			return false;
		if( type == 1 && messageHasIndex == 0 && messageHasNotIndex == 0)
			return false;
		
		
		if( type == 0)
		{
			for(int i = 0; i < statusHasIndex; i++)
			{
				if(event.lastIndexOf(statusHas[i]) == -1 )
					return false;
			}
			for(int i = 0; i < statusHasNotIndex; i++)
			{
				if(event.lastIndexOf(statusHasNot[i]) != -1 )
					return false;
				
			}
		}
		else if(type == 1)
		{
			for(int i = 0; i < messageHasIndex; i++)
			{
				if(event.lastIndexOf(messageHas[i]) == -1 )
					return false;
			}
			for(int i = 0; i < messageHasNotIndex; i++)
			{
				if(event.lastIndexOf(messageHasNot[i]) != -1 )
					return false;				
			}
			
		}
		
		return true;
	}
}
public class TwitterNotifier2 implements Runnable {

	Thread t;
	String userID = "";
	String password ="";
	String clientName = "";	//as registered to our system
	String notificationType = "";
	long sleepTime = 73000;	//in milisec
	Api api;
	List dmr;				//for direct message list
	List followers;			//for followers list
	
	private Connection conn=null;
	private Statement stmt;
	private ResultSet rs=null;
	
	private EventConditionParser eventConditionParser;
	SocketManager sm ;

	TwitterNotifier2()
	{
		//userID = "_munir_";
		//password = "blackburne";
		
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

		String sendData = "server_twitter";
		sm.sendData(sendData);

		
		t = new Thread(this, "Web Server");
		t.start();		
	}
	
	public void run()
	{
		try
		{
			while(true)
			{
				//event_condition = "<userid,_munir_><password,blackburne><status,has,tanima><status,hasnot,phone><status,has,sms>";				
				//System.out.println( eventConditionParser.userID + " " + eventConditionParser.password );
				//System.out.println(eventConditionParser.messageHas + " " + eventConditionParser.messageHasNot);
				//System.out.println(eventConditionParser.statusHas[1] + " " + eventConditionParser.statusHasNot[0]);
								
				
				int count = 0;
				String username = null;
				String event_type = null;
				String event_condition = null;
				String notification = null;
				String twitter_userID_prev = "the_ugly_user_id_1298834523";

				if(stmt.execute("select * from events where event_type = 'twitter' order by username;"))
					rs = stmt.getResultSet();
				
				
				while(rs.next())
				{
					//System.out.println("result: "+rs.getString(1) + " "+rs.getString(2) + " "+rs.getString(3) + " "+rs.getString(4));
					
					username = rs.getString(1);
					event_type = rs.getString(2);
					event_condition = rs.getString(3);
					notification = rs.getString(4);
					
					clientName = username;
					notificationType = notification;
					
					eventConditionParser.parseCondition(event_condition);					
					String twitter_user_id = eventConditionParser.userID;
					String twitter_password = eventConditionParser.password;
					
					count++;
					
					if(twitter_userID_prev != null && twitter_user_id != null && twitter_user_id.compareTo(twitter_userID_prev) != 0)
					{
						twitter_userID_prev = twitter_user_id;
						api = Api.builder().username(twitter_user_id).password(twitter_password).build();						
						
						try{
							if( api.verifyCredentials().build().get().hasCreatedAt() == false)
								continue;
						}
						catch(Exception e)
						{
							System.out.println("Authentication error for :" + twitter_user_id);
							continue;
						}
						
						dmr = api.directMessages().build().get();
						followers = api.followers().build().get();
											
					}
					checkStatus();
				}
						
				System.out.print("count: "+count); //getRow()
			
				Thread.sleep(sleepTime);
			}
		}
		catch( Exception e)
		{
			System.out.println("Exception in web server.");
			e.printStackTrace();
		}
	}
	
	public void checkStatus()
	{
		String str = "";		
		//str = getHomePublicInfo(api);
		//str = getFollowersStatus(api);
		str = getFollowersStatus2(api);
		//str = getFollowingsStatus(api);
		str = getDirectMessages(api);
		
	}
	
	public String getHomePublicInfo(Api api2)
	{
		String str = "";
		//List publicTL = api2.publicTimeline().build().get();
		List publicTL = api2.friendsTimeline().build().get();		

		int totalStatuses = publicTL.size();
		for (int i = 0 ; i < totalStatuses; i++)
		{
			Status currentStatus = (Status) publicTL.get(i);
			String userName = currentStatus.getUser().getName();
			String userStatus = currentStatus.getText();
			
			System.out.println(userName + ": " + userStatus);
			
			String userID = currentStatus.getUser().getScreenName();			
			str = userID + " " + "..." + " " + userName + " " + "..." + " " + userStatus;
			if (eventConditionParser.satisfiesCodition(str, 0)== true)
			{
				System.out.println("-----------NOTIFY NOW--------------");
				String notifyString = "<clientName," + clientName+">" + "<userName," + userName+">" + "<userStatus," + userStatus+">" + "<notificationType," + notificationType + ">";
				sm.sendData(notifyString.length()+"");
				sm.sendData(notifyString);				
				
				System.out.println(notifyString);
				
			}

		}
		
		return str;
	
	}
	
	
	public String getFollowersStatus(Api api2)
	{
		long[] friendIds = api2.followerIds().build().get();		//followers		
		String str = "";
		
		int totalFriends = friendIds.length;
		System.out.println("Total Friends:  " + totalFriends);
		
		for(int i = 0; i < totalFriends; i++)
		{
			System.out.println(friendIds[i]);
			ShowUserRequest showUserReq = api2.showUser().userId(friendIds[i]).build();
			//ShowUserRequest showUserReq = api2.showUser().build();			
			//showUserReq = ShowUserRequest.builder().userId(friendIds[i]).build();
			
			String userName = showUserReq.get().getName();			
			String userStatus = showUserReq.get().getStatus().getText();
			
			System.out.println("User ID: " + friendIds[i] + ", User Name: " + userName + ", Status: " + userStatus);
			
			String userID = showUserReq.get().getScreenName();			
			str = userID + " " + "..." + " " + userName + " " + "..." + " " + userStatus;
			
			if (eventConditionParser.satisfiesCodition(str, 0)== true)
			{
				System.out.println("-----------NOTIFY NOW--------------");
				String notifyString = "<clientName," + clientName+">" + "<userName," + userName+">" + "<userStatus," + userStatus+">" + "<notificationType," + notificationType + ">";
				sm.sendData(notifyString.length()+"");
				sm.sendData(notifyString);				
				
				System.out.println(notifyString);
	
			}
			

		}
		return str;		
	}
	
	public String getFollowersStatus2(Api api2)	//alternate implementation
	{
		//List followers = api2.followers().build().get();		//followers		
		String str = "";
		
		int totalStatuses = followers.size();
		for (int i = 0 ; i < totalStatuses; i++)
		{
			
			User currentUser = (User) followers.get(i);
			String userName = currentUser.getName();
			String userStatus = currentUser.getStatus().getText();
			
			System.out.println(userName + ": " + userStatus);
			
			String userID = currentUser.getScreenName();			
			str = userID + " " + "..." + " " + userName + " " + "..." + " " + userStatus;
			if (eventConditionParser.satisfiesCodition(str, 0)== true)
			{
				System.out.println("-----------NOTIFY NOW--------------");
				String notifyString = "<clientName," + clientName+">" + "<userName," + userName+">" + "<userStatus," + userStatus+">" + "<notificationType," + notificationType + ">";
				sm.sendData(notifyString.length()+"");
				sm.sendData(notifyString);				
				
				System.out.println(notifyString);
				
			}

		}
		
		return str;
	}

	
	public String getFollowingsStatus(Api api2)
	{
		long[] friendIds = api2.friendIds().build().get();		//followings
		String str = "";
		
		int totalFriends = friendIds.length;
		System.out.println("Total Friends:  " + totalFriends);
		
		for(int i = 0; i < totalFriends; i++)
		{
			System.out.println(friendIds[i]);
			ShowUserRequest showUserReq = api2.showUser().userId(friendIds[i]).build();
			//ShowUserRequest showUserReq = api2.showUser().build();			
			//showUserReq = ShowUserRequest.builder().userId(friendIds[i]).build();
			
			String userName = showUserReq.get().getName();			
			String userStatus = showUserReq.get().getStatus().getText();
			System.out.println("User ID: " + friendIds[i] + ", User Name: " + userName + ", Status: " + userStatus);
			
			String userID = showUserReq.get().getScreenName();			
			str = userID + " " + "..." + " " + userName + " " + "..." + " " + userStatus;
			if (eventConditionParser.satisfiesCodition(str, 0)== true)
			{
				System.out.println("-----------NOTIFY NOW--------------");
				String notifyString = "<clientName," + clientName+">" + "<userName," + userName+">" + "<userStatus," + userStatus+">" + "<notificationType," + notificationType + ">";
				sm.sendData(notifyString.length()+"");
				sm.sendData(notifyString);				
				
				System.out.println(notifyString);

			}


		}
		return str;		
	}
	public String getDirectMessages(Api api2)
	{
		String str = "";
		//List dmr = api2.directMessages().build().get();
		System.out.println("Total Messages: " + dmr.size());
		
		for( int i = 0; i < dmr.size() ; i++)
		{
			DirectMessage dm = (DirectMessage) dmr.get(i);
			if(dm.hasText())
			{
				String message = dm.getText();
				String senderName = dm.getSender().getName();
				System.out.println("User Name: " + senderName + ", message: " + message );
				
				String userID = dm.getSenderScreenName();			
				str = userID + " " + "..." + " " + senderName + " " + "..." + " " + message;
				if (eventConditionParser.satisfiesCodition(str, 1)== true)
				{
					System.out.println("-----------NOTIFY NOW--------------");
					String notifyString = "<clientName," + clientName+">" + "<sender," + senderName+">" + "<message," + message+">"+ "<notificationType," + notificationType + ">";
					sm.sendData(notifyString.length()+"");
					sm.sendData(notifyString);				
					
					System.out.println(notifyString);
					
				}

			}
		}
		return str;
	}
	
	public static void main(String[] args) 
	{
		new TwitterNotifier2();
	}
}
