import java.io.*;
import java.net.*;


public class SocketManager {
	Socket socket;
    BufferedReader in = null;
    PrintWriter out = null;
    int serverPort = 4445;
    String serverHostName = "localhost";

	public void establishConnection(){
		//Create socket connection
		   try{
		     socket = new Socket(serverHostName, serverPort);
		     out = new PrintWriter(socket.getOutputStream(), 
		                 true);
		     in = new BufferedReader(new InputStreamReader(
			        socket.getInputStream()));
		   } catch (UnknownHostException e) {
		     System.out.println("Unknown host: " + serverHostName);
		     System.exit(1);
		   } catch  (IOException e) {
		     System.out.println("No I/O");
		     System.exit(1);
		   }
		}
	public void sendData(String data)
	{
		out.println(data);
	}

}
