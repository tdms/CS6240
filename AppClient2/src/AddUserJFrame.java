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

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

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
public class AddUserJFrame extends javax.swing.JFrame {
	private JLabel jLabel1;
	private JTextField userNameTextField;
	private JLabel jLabel2;
	private JPasswordField jPasswordField1;
	private JPasswordField jPasswordField2;
	private JLabel jLabel5;
	private JSeparator jSeparator1;
	private JButton registerButton;
	private JTextField jTextField1;
	private JLabel jLabel4;
	private JLabel jLabel3;

	private Connection conn=null;
	private Statement stmt;
	private ResultSet rs=null;
		
	private ButtonHandler bhandler;
	
	/**
	* Auto-generated main method to display this JFrame
	/
	/*public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				AddUserJFrame inst = new AddUserJFrame();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}*/
	
	public AddUserJFrame() {
		super("Register New User");
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
				registerButton = new JButton();
				registerButton.setText("Register !");
				bhandler=new ButtonHandler();
				registerButton.addActionListener(bhandler);
			}
			
			{
				jLabel5 = new JLabel();
				jLabel5.setText("Enter information for registration");
				jLabel5.setFont(new java.awt.Font("Segoe UI",1,14));
			}
			{
				jSeparator1 = new JSeparator();
			}
			{
				jLabel4 = new JLabel();
				jLabel4.setText("Cell Phone Number: ");
			}
			{
				jTextField1 = new JTextField();
			}
			{
				jLabel2 = new JLabel();
				jLabel2.setText("Password:");
			}
			{
				jPasswordField1 = new JPasswordField();
			}
			{
				jLabel3 = new JLabel();
				jLabel3.setText("Verify Password:");
			}
			{
				jPasswordField2 = new JPasswordField();
			}
			{
				userNameTextField = new JTextField();
			}
			thisLayout.setVerticalGroup(thisLayout.createSequentialGroup()
				.addContainerGap(21, 21)
				.addComponent(jLabel5, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 0, Short.MAX_VALUE)
				.addComponent(jSeparator1, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 0, GroupLayout.PREFERRED_SIZE)
				.addGroup(thisLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				    .addComponent(userNameTextField, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				    .addComponent(jLabel1, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED, 1, GroupLayout.PREFERRED_SIZE)
				.addGroup(thisLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				    .addComponent(jPasswordField1, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				    .addComponent(jLabel2, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED, 1, GroupLayout.PREFERRED_SIZE)
				.addGroup(thisLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				    .addComponent(jPasswordField2, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				    .addComponent(jLabel3, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED, 1, GroupLayout.PREFERRED_SIZE)
				.addGroup(thisLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				    .addComponent(jTextField1, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				    .addComponent(jLabel4, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(35)
				.addComponent(registerButton, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				.addContainerGap(29, 29));
			thisLayout.setHorizontalGroup(thisLayout.createSequentialGroup()
				.addContainerGap(46, 46)
				.addGroup(thisLayout.createParallelGroup()
				    .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				        .addComponent(jLabel4, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
				        .addGap(0, 7, Short.MAX_VALUE)
				        .addGroup(thisLayout.createParallelGroup()
				            .addComponent(jTextField1, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)
				            .addComponent(jPasswordField2, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)
				            .addComponent(jPasswordField1, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)
				            .addComponent(userNameTextField, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)
				            .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				                .addComponent(registerButton, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
				                .addGap(43)))
				        .addGap(32))
				    .addGroup(thisLayout.createSequentialGroup()
				        .addGap(20)
				        .addGroup(thisLayout.createParallelGroup()
				            .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				                .addComponent(jLabel3, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
				                .addGap(60)
				                .addComponent(jSeparator1, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				                .addGap(0, 131, Short.MAX_VALUE))
				            .addGroup(thisLayout.createSequentialGroup()
				                .addGap(24)
				                .addGroup(thisLayout.createParallelGroup()
				                    .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				                        .addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
				                        .addGap(0, 201, Short.MAX_VALUE))
				                    .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				                        .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
				                        .addGap(0, 200, Short.MAX_VALUE))
				                    .addComponent(jLabel5, GroupLayout.Alignment.LEADING, 0, 264, Short.MAX_VALUE))))))
				.addContainerGap(78, 78));
			pack();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private class ButtonHandler implements ActionListener
	{
		int row_count, flag=0;
		
		public void actionPerformed( ActionEvent event )
		{
			flag=0;
			try
			{
				conn=DriverManager.getConnection("jdbc:mysql://localhost/db1?"+"user=root&password=munir");
				stmt=conn.createStatement();
												
				stmt.execute("select username from users");
				rs = stmt.getResultSet();
				
				row_count=0;
				while(rs.next())
				{
					row_count++;
					if(rs.getString(1).equals(userNameTextField.getText()))
					{
						JOptionPane.showMessageDialog(null, "User name already exists ! Try another name");
						flag=1;
						userNameTextField.setText("");
						jPasswordField1.setText("");
						jPasswordField2.setText("");
						jTextField1.setText("");
						
						break;
					}					
				}
				
				if(!jPasswordField1.getText().equals(jPasswordField2.getText()))
				{
					JOptionPane.showMessageDialog(null, "Password does not match, please confirm the passwords again");
					flag=1;
					userNameTextField.setText("");
					jPasswordField1.setText("");
					jPasswordField2.setText("");
					jTextField1.setText("");					
				}
					
				System.out.print("count: "+row_count+"flag "+flag); //getRow()
				
				if(flag==0)
				{
					System.out.println("insert now:");
					System.out.print("insert into users values("+userNameTextField.getText().trim()+","+jPasswordField1.getText().trim()+","+jTextField1.getText()+")");
					
					stmt.execute("insert into users(username,password,cellphone_number) values(\'"+userNameTextField.getText().trim()+"\',\'"+jPasswordField1.getText().trim()+"\',\'"+jTextField1.getText()+"\')");
					stmt.execute("commit");
					
					JOptionPane.showMessageDialog(null, "You are succesfully registered!");
					javax.swing.JFrame t = (JFrame) registerButton.getParent().getParent().getParent().getParent();
					t.dispose();
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
