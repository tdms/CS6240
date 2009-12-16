import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle;

import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;

import java.awt.event.*;


/**
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/
public class AddEventJFrame extends javax.swing.JFrame {
	private JLabel jLabel1;
	private JMenuBar jMenuBar1;
	private JMenu jMenu5;
	private JMenuItem jMenuItem8;
	private JButton logoutButton;
	private JMenu jMenu4;
	private JMenu jMenu3;
	private JMenu jMenu2;
	private JMenuItem jMenuItem7;
	private JMenuItem jMenuItem6;
	private JMenuItem jMenuItem5;
	private JMenuItem jMenuItem4;
	private JMenuItem jMenuItem3;
	private JMenuItem jMenuItem2;
	private JMenuItem jMenuItem1;
	private JMenu jMenu1;
	
	private String userName;
	private AddEmailJFrame addEmail;
	private AddNewsJFrame addNews;
	private JMenuItem jMenuItem9;
	private JMenuItem delEmailMenuItem;
	private AddSocialJFrame addSocial;
	private LogOffActionHandler lohandler;
	private SocketManager sm ;
	private ActionHandler itemHandler;
	private ViewEventsJFrame viewEvents;
	private DelEmailJFrame delEmail;
	private AboutHandler aboutHandler;
	private AboutJFrame about;
	/**
	* Auto-generated main method to display this JFrame
	*/
	/*public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				AddEventJFrame inst = new AddEventJFrame();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}*/
	
	public AddEventJFrame(String uName) {
		super("Home");
			
		userName=new String(uName);
		initGUI();
	}
	
	private void initGUI() {
		try {
			GroupLayout thisLayout = new GroupLayout((JComponent)getContentPane());
			getContentPane().setLayout(thisLayout);
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			sm = new SocketManager();
			
			{
				jMenuBar1 = new JMenuBar();
				setJMenuBar(jMenuBar1);
				{
					jMenu1 = new JMenu();
					jMenuBar1.add(jMenu1);
					jMenu1.setText("Add Event Description");
					itemHandler = new ActionHandler(); 
					lohandler=new LogOffActionHandler();
					aboutHandler=new AboutHandler();
					
					{
						jMenuItem1 = new JMenuItem();
						jMenu1.add(jMenuItem1);
						jMenuItem1.setText("E-mail Notification");
						jMenuItem1.addActionListener(itemHandler);
					}
					{
						jMenuItem2 = new JMenuItem();
						jMenu1.add(jMenuItem2);
						jMenuItem2.setText("Social Networks");
						jMenuItem2.addActionListener(itemHandler);
					}
					{
						jMenuItem3 = new JMenuItem();
						jMenu1.add(jMenuItem3);
						jMenuItem3.setText("News");
						jMenuItem3.addActionListener(itemHandler);
					}
					{
						jMenuItem4 = new JMenuItem();
						jMenu1.add(jMenuItem4);
						jMenuItem4.setText("Weather");
						jMenuItem4.addActionListener(itemHandler);
					}
					{
						jMenuItem5 = new JMenuItem();
						jMenu1.add(jMenuItem5);
						jMenuItem5.setText("Bank Accounts");
						jMenuItem5.addActionListener(itemHandler);
					}
					{
						jMenuItem6 = new JMenuItem();
						jMenu1.add(jMenuItem6);
						jMenuItem6.setText("Blog Entry");
						jMenuItem6.addActionListener(itemHandler);
					}
					{
						jMenuItem7 = new JMenuItem();
						jMenu1.add(jMenuItem7);
						jMenuItem7.setText("Websites");
						jMenuItem7.addActionListener(itemHandler);
					}
				}
				{
					jMenu2 = new JMenu();
					jMenuBar1.add(jMenu2);
					jMenu2.setText("View/Edit Event Description");
					{
						jMenuItem8 = new JMenuItem();
						jMenu2.add(jMenuItem8);
						jMenuItem8.setText("View Events");
						jMenuItem8.addActionListener(itemHandler);
					}
					
				}
				{
					jMenu3 = new JMenu();
					jMenuBar1.add(jMenu3);
					jMenu3.setText("Delete Event Description");
					{
						delEmailMenuItem = new JMenuItem();
						jMenu3.add(delEmailMenuItem);
						delEmailMenuItem.setText("Delete Events");
						delEmailMenuItem.addActionListener(itemHandler);
					}
				}
				{
					jMenu4 = new JMenu();
					jMenuBar1.add(jMenu4);
					jMenu4.setText("About");
					{
						jMenuItem9 = new JMenuItem();
						jMenu4.add(jMenuItem9);
						jMenuItem9.setText("Read About");
						jMenuItem9.addActionListener(aboutHandler);
					}
					
				}
				{
					jMenu5 = new JMenu();
					jMenuBar1.add(jMenu5);
					jMenu5.setText("Help");
				}
			}
			{
				jLabel1 = new JLabel();
				jLabel1.setText("Welcome "+userName+" !");
			}
			{
				logoutButton = new JButton();
				logoutButton.setText("Logout");
				logoutButton.addActionListener(lohandler);
			}
			thisLayout.setHorizontalGroup(thisLayout.createSequentialGroup()
				.addContainerGap(188, 188)
				.addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
				.addGap(0, 59, Short.MAX_VALUE)
				.addComponent(logoutButton, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
				.addContainerGap());
			thisLayout.setVerticalGroup(thisLayout.createSequentialGroup()
				.addContainerGap()
				.addComponent(logoutButton, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
				.addGap(23)
				.addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
				.addContainerGap(328, Short.MAX_VALUE));
			
			sm.establishConnection();

			String sendData = "client_"+userName;		//first handshaking
			sm.sendData(sendData);
			
			sm.readData();

			pack();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private class AboutHandler implements ActionListener
	{
	    public void actionPerformed( ActionEvent event )
	    {
	    	if(event.getSource()==jMenuItem9)
	    	{
	    		System.out.println("About!");
	    		about = new AboutJFrame();
				about.setLocationRelativeTo(null);
				about.setVisible(true);
	    	}
	    }
	}
	
	private class ActionHandler implements ActionListener
	{
	    public void actionPerformed( ActionEvent event )
	    {
	    	if(event.getSource()==jMenuItem1)
	    	{
	    		System.out.println("Email");
	    		addEmail = new AddEmailJFrame(userName);
				addEmail.setLocationRelativeTo(null);
				addEmail.setVisible(true);
	    	}
	    	else if(event.getSource()==jMenuItem2)
	    	{
	    		System.out.println("Social Networks");
	    		addSocial = new AddSocialJFrame(userName);
				addSocial.setLocationRelativeTo(null);
				addSocial.setVisible(true);
	    	}
	    	else if(event.getSource()==jMenuItem3)
	    	{
	    		System.out.println("News");
	    		addNews = new AddNewsJFrame();
				addNews.setLocationRelativeTo(null);
				addNews.setVisible(true);	    		
	    	}
	    	else if(event.getSource()==jMenuItem8)
	    	{
	    		System.out.println("View Events");
	    		
	    		viewEvents = new ViewEventsJFrame(userName);
	    		viewEvents.setLocationRelativeTo(null);
	    		viewEvents.setVisible(true);
	    	}
	    	else if(event.getSource()==delEmailMenuItem)
	    	{
	    		System.out.println("View Events");
	    		
	    		delEmail = new DelEmailJFrame(userName);
	    		delEmail.setLocationRelativeTo(null);
	    		delEmail.setVisible(true);
	    	}
	    }
	}
	
	private class LogOffActionHandler implements ActionListener
	{
	    public void actionPerformed( ActionEvent event )
	    {
	    	if(event.getSource()==logoutButton)
	    	{
	    		JOptionPane.showMessageDialog(null, "Successfully Logoff... Exiting");
	    		//sm.closeConnection();
	    		System.exit(0);
	    	}
	    	/*else if(event.getSource()==eventUpdateButton)
	    	{
	    		//setting up the client side for notification
	    		System.out.println("In addeventJFrame");
				
				sm.establishConnection();

				String sendData = "client_"+userName;		//first handshaking
				sm.sendData(sendData);
				
				sm.readData();
	    	}*/
	    }
	}
}
