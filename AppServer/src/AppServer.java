
public class AppServer {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("hello world");
		//Runtime.getRuntime().gc();
		
		new SocketManager().listenSocket();
		
		

	}

}
