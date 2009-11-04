import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;

import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;

import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


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
public class LoginUserJFrame extends javax.swing.JFrame {
	private JLabel jLabel1;
	private JLabel jLabel2;
	private JLabel jLabel5;
	private JButton loginButton;
	private JPasswordField passwordTextField;
	private JTextField userNameTextField;
	private ButtonHandler bhandler;
	private AddEventJFrame addEvent;
	
	private Connection conn=null;
	private Statement stmt;
	private ResultSet rs=null;
	
	/**
	* Auto-generated main method to display this JFrame
	*/
	/*public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				LoginUserJFrame inst = new LoginUserJFrame();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}*/
	
	public LoginUserJFrame() {
		super("Login");
		initGUI();
	}
	
	private void initGUI() {
		try {
			GroupLayout thisLayout = new GroupLayout((JComponent)getContentPane());
			getContentPane().setLayout(thisLayout);
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			{
				jLabel1 = new JLabel();
				jLabel1.setText("Username:");
			}
			{
				jLabel2 = new JLabel();
				jLabel2.setText("Password: ");
			}
			{
				userNameTextField = new JTextField();
			}
			{
				passwordTextField = new JPasswordField();
			}
			{
				loginButton = new JButton();
				loginButton.setText("Login");
				bhandler=new ButtonHandler();
				loginButton.addActionListener(bhandler);
			}
			{
				jLabel5 = new JLabel();
				jLabel5.setText("Login");
				jLabel5.setFont(new java.awt.Font("Segoe UI",1,14));
			}
			
			thisLayout.setVerticalGroup(thisLayout.createSequentialGroup()
				.addContainerGap(17, 17)
				.addComponent(jLabel5, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
				.addGap(20)
				.addGroup(thisLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				    .addComponent(userNameTextField, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				    .addComponent(jLabel1, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
				.addGap(19)
				.addGroup(thisLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				    .addComponent(passwordTextField, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				    .addComponent(jLabel2, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(52)
				.addComponent(loginButton, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				.addContainerGap(71, Short.MAX_VALUE));
			thisLayout.setHorizontalGroup(thisLayout.createSequentialGroup()
				.addContainerGap(72, 72)
				.addGroup(thisLayout.createParallelGroup()
				    .addComponent(jLabel2, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
				    .addComponent(jLabel1, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
				.addGroup(thisLayout.createParallelGroup()
				    .addGroup(thisLayout.createSequentialGroup()
				        .addComponent(passwordTextField, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE)
				        .addGap(0, 0, Short.MAX_VALUE))
				    .addGroup(thisLayout.createSequentialGroup()
				        .addComponent(userNameTextField, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE)
				        .addGap(0, 0, Short.MAX_VALUE))
				    .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				        .addComponent(loginButton, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
				        .addGap(0, 54, Short.MAX_VALUE))
				    .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				        .addPreferredGap(passwordTextField, jLabel5, LayoutStyle.ComponentPlacement.INDENT)
				        .addComponent(jLabel5, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
				        .addGap(0, 71, Short.MAX_VALUE)))
				.addContainerGap(91, 91));
			pack();
			setSize(400, 300);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private class ButtonHandler implements ActionListener{
		int row_count, flag=0;
		
		public void actionPerformed( ActionEvent event )
		{
			try
			{
				conn=DriverManager.getConnection("jdbc:mysql://localhost/db1?"+"user=root&password=tanima");
				stmt=conn.createStatement();
												
				stmt.execute("select username from users");
				rs = stmt.getResultSet();
				
				row_count=0;
				while(rs.next())
				{
					row_count++;
					if(rs.getString(1).equals(userNameTextField.getText()))
					{
						flag=1;
						break;
					}					
				}
				
				
				System.out.print("count: "+row_count+"flag "+flag); //getRow()
				
				if(flag==1 && row_count>0)
				{
					//System.out.print("here1");
					rs=null;
					stmt.execute("select password from users where username=\'"+userNameTextField.getText()+"\'");
					//System.out.print("here2");
					rs = stmt.getResultSet();
					//System.out.print("here3");
					rs.next();
					String password=rs.getString(1);
			
					if(password.equals(passwordTextField.getText()))
					{
						JOptionPane.showMessageDialog(null, "Login sucessful!");
						
						javax.swing.JFrame t = (JFrame) loginButton.getParent().getParent().getParent().getParent();
						t.dispose();
						
						addEvent=new AddEventJFrame();
						addEvent.setLocationRelativeTo(null);
						addEvent.setVisible(true);
					}
					else{
						JOptionPane.showMessageDialog(null, "Wrong Password, try again");
						userNameTextField.setText("");
						passwordTextField.setText("");
					}					
				}
				
				conn.close();				
			}
	
			catch(Exception e)
			{
				System.out.println("Exception: "+e.getMessage());
			}
						
		}
	}
}
