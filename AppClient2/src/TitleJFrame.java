import java.awt.BorderLayout;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.LayoutStyle;

import javax.swing.WindowConstants;
import javax.swing.border.LineBorder;
import javax.swing.SwingUtilities;
import java.awt.event.*;

import javax.swing.BorderFactory;

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
public class TitleJFrame extends javax.swing.JFrame {
	private JLabel jLabel1;
	private JLabel jLabel2;
	private JMenuItem jMenuItem2;
	private JButton jButton1;
	private JMenuItem jMenuItem1;
	private JMenu jMenu2;
	private JMenu jMenu1;
	private JMenuBar About;
	private JButton jButton2;
	private ButtonHandler bhandler;
	private AddUserJFrame addUser;
	private LoginUserJFrame loginUser;
	private AboutHandler aboutHandler;
	private AboutJFrame about;
	private HelpJFrame1 help;
	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				TitleJFrame inst = new TitleJFrame();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public TitleJFrame() {
		super("CS6240 Project");
		initGUI();
	}
	
	private void initGUI() {
		try {
			GroupLayout thisLayout = new GroupLayout((JComponent)getContentPane());
			getContentPane().setLayout(thisLayout);
			setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
			aboutHandler=new AboutHandler();
			getContentPane().setBackground(new java.awt.Color(183,219,216));
			{
				About = new JMenuBar();
				setJMenuBar(About);
				About.setBackground(new java.awt.Color(222,245,244));
				About.setBorder(new LineBorder(new java.awt.Color(0,0,0), 1, false));
				{
					jMenu1 = new JMenu();
					About.add(jMenu1);
					jMenu1.setText("About");
					jMenu1.setFont(new java.awt.Font("Segoe UI",1,12));
					{
						jMenuItem1 = new JMenuItem();
						jMenu1.add(jMenuItem1);
						jMenuItem1.setText("Read About");
						jMenuItem1.addActionListener(aboutHandler);
					}
				}
				{
					jMenu2 = new JMenu();
					About.add(jMenu2);
					jMenu2.setText("Help");
					jMenu2.setFont(new java.awt.Font("Segoe UI",1,12));
					{
						jMenuItem2 = new JMenuItem();
						jMenu2.add(jMenuItem2);
						jMenuItem2.setText("Get help!");
						jMenuItem2.addActionListener(aboutHandler);
					}
				}
			}
			{
				jLabel1 = new JLabel();
				jLabel1.setText("An Intelligent Event Notifying System for ");
				jLabel1.setFont(new java.awt.Font("Garamond",0,26));
			}
			{
				jLabel2 = new JLabel();
				jLabel2.setText("Web Service Offered Information");
				jLabel2.setFont(new java.awt.Font("Garamond",0,26));
			}
			{
				jButton1 = new JButton();
				jButton1.setText("Sign Up!");
				bhandler=new ButtonHandler();
				jButton1.addActionListener(bhandler);
			}
			{
				jButton2 = new JButton();
				jButton2.setText("Login");
				jButton2.addActionListener(bhandler);
			}
			thisLayout.setVerticalGroup(thisLayout.createSequentialGroup()
				.addContainerGap(52, 52)
				.addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
				.addGap(17)
				.addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
				.addGap(120)
				.addGroup(thisLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				    .addComponent(jButton1, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
				    .addComponent(jButton2, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
				.addContainerGap(50, 50));
			thisLayout.setHorizontalGroup(thisLayout.createSequentialGroup()
				.addContainerGap(23, 23)
				.addGroup(thisLayout.createParallelGroup()
				    .addComponent(jLabel1, GroupLayout.Alignment.LEADING, 0, 448, Short.MAX_VALUE)
				    .addGroup(thisLayout.createSequentialGroup()
				        .addGap(46)
				        .addGroup(thisLayout.createParallelGroup()
				            .addGroup(thisLayout.createSequentialGroup()
				                .addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 369, GroupLayout.PREFERRED_SIZE)
				                .addGap(0, 0, Short.MAX_VALUE))
				            .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				                .addGap(39)
				                .addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
				                .addGap(98)
				                .addComponent(jButton2, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
				                .addGap(0, 64, Short.MAX_VALUE)))
				        .addGap(33)))
				.addContainerGap(21, 21));
			pack();
			setSize(500, 400);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private class AboutHandler implements ActionListener
	{
	    public void actionPerformed( ActionEvent event )
	    {
	    	if(event.getSource()==jMenuItem1)
	    	{
	    		System.out.println("About!");
	    		about = new AboutJFrame();
				about.setLocationRelativeTo(null);
				about.setVisible(true);
	    	}
	    	else if(event.getSource()==jMenuItem2)
	    	{
	    		System.out.println("Help!");
	    		help = new HelpJFrame1();
				help.setLocationRelativeTo(null);
				help.setVisible(true);
	    	}
	    }
	}
	
	private class ButtonHandler implements ActionListener{
		public void actionPerformed( ActionEvent event )
		{
			if(event.getSource()==jButton1)
			{
				addUser=new AddUserJFrame();
				addUser.setLocationRelativeTo(null);
				addUser.setVisible(true);
				
			}
			else if(event.getSource()==jButton2)
			{
				loginUser=new LoginUserJFrame();
				loginUser.setLocationRelativeTo(null);
				loginUser.setVisible(true);
				
				javax.swing.JFrame t = (JFrame) jButton2.getParent().getParent().getParent().getParent();
				t.dispose();
			}
		}
	}
}
