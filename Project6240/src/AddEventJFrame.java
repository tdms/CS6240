import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
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
	private AddSocialJFrame addSocial;
	
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
			{
				jMenuBar1 = new JMenuBar();
				setJMenuBar(jMenuBar1);
				{
					jMenu1 = new JMenu();
					jMenuBar1.add(jMenu1);
					jMenu1.setText("Add Event Description");
					ActionHandler itemHandler = new ActionHandler(); 
					
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
					jMenu2.setText("Edit Event Description");
				}
				{
					jMenu3 = new JMenu();
					jMenuBar1.add(jMenu3);
					jMenu3.setText("Delete Event Description");
				}
				{
					jMenu4 = new JMenu();
					jMenuBar1.add(jMenu4);
					jMenu4.setText("About");
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
			}
			thisLayout.setVerticalGroup(thisLayout.createSequentialGroup()
				.addContainerGap()
				.addComponent(logoutButton, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
				.addGap(23)
				.addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
				.addContainerGap(222, Short.MAX_VALUE));
			thisLayout.setHorizontalGroup(thisLayout.createSequentialGroup()
				.addContainerGap(188, 188)
				.addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
				.addGap(0, 157, Short.MAX_VALUE)
				.addComponent(logoutButton, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
				.addContainerGap());
			pack();
			setSize(550, 500);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private class ActionHandler implements ActionListener
	{
	    // process color and font selections
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
	    }
	}

}
