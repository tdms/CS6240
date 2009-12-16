import javax.swing.GroupLayout;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle;

import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;


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
public class HelpJFrame1 extends javax.swing.JFrame {
	private JLabel jLabel1;
	private JScrollPane jScrollPane1;
	private JTextArea help;

	/**
	* Auto-generated main method to display this JFrame
	*/
	/*public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				HelpJFrame1 inst = new HelpJFrame1();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}*/
	
	public HelpJFrame1() {
		super("Help");
		initGUI();
	}
	
	private void initGUI() {
		try {
			GroupLayout thisLayout = new GroupLayout((JComponent)getContentPane());
			getContentPane().setLayout(thisLayout);
			
			String helpString=new String();
			
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			{
				jLabel1 = new JLabel();
				jLabel1.setText("Help");
				jLabel1.setFont(new java.awt.Font("Tahoma",1,14));
			}
			{
				jScrollPane1 = new JScrollPane();
				{
					help = new JTextArea();
					jScrollPane1.setViewportView(help);
					helpString+="Welcome to the help for the system!"+"\n\n"+"Sign up:\n"+"In order to use the system, you have to be a signed up user."+"\n"+
							"If you are not signed up, press the \"Sign up\" button and give"+"\n"+ "your preferred username, password and the cell phone"+"\n"+ "number in the textfields."+"\n"+
							"The username must be unique with respect to the system "+"\n"+ "so if the username is already taken, please select another one. "+"\n"+ "Reenter the password to confirm it. "+
							"Enter the cell phone number where "+"\n"+ "you would like to get message into."+"\n\n"+
							"Login: \n"+"To login to the system, click on the \"Login\" button, enter the"+"\n"+ " username and password selected during signing up "+"\n"+ "in the textfields and press the button.";
					help.setText(helpString);
				}
			}
			thisLayout.setVerticalGroup(thisLayout.createSequentialGroup()
				.addContainerGap(23, 23)
				.addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				.addGap(19)
				.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 314, GroupLayout.PREFERRED_SIZE)
				.addContainerGap(43, Short.MAX_VALUE));
			thisLayout.setHorizontalGroup(thisLayout.createSequentialGroup()
				.addContainerGap(44, 44)
				.addGroup(thisLayout.createParallelGroup()
				    .addGroup(thisLayout.createSequentialGroup()
				        .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 326, GroupLayout.PREFERRED_SIZE)
				        .addGap(0, 0, Short.MAX_VALUE))
				    .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				        .addGap(119)
				        .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
				        .addGap(0, 162, Short.MAX_VALUE)))
				.addContainerGap(22, 22));
			pack();
			setSize(400, 450);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
