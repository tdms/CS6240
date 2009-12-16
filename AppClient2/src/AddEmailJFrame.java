import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.ListModel;

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
public class AddEmailJFrame extends javax.swing.JFrame {
	private JLabel jLabel1;
	private JLabel jLabel2;
	private JLabel jLabel3;
	private JLabel jLabel4;
	private JLabel jLabel5;
	private JPanel jPanel1;
	private JSeparator jSeparator2;
	private JComboBox typeList2;
	private JLabel jLabel13;
	private JLabel jLabel12;
	private JLabel jLabel11;
	private JLabel jLabel10;
	private JLabel jLabel9;
	private JButton addEmailButton;
	private JComboBox notificationList;
	private JTextField bodyTextField;
	private JTextField subjectTextField;
	private JTextField notEmailTextField;
	private JPasswordField userPasswordField;
	private JTextField userEmailTextField;
	private JLabel jLabel8;
	private JLabel jLabel7;
	private JLabel jLabel6;
	
	private String userName;
	private String type1, type2, condition, notification;
	private AddConditionBHandler bhandler;
	private Connection conn=null;
	private JComboBox typeList;
	private Statement stmt;
	private ResultSet rs=null;
	private String viewCondition,viewType1,viewType2;
	
	/**
	* Auto-generated main method to display this JFrame
	*/
	/*public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				AddEmailJFrame inst = new AddEmailJFrame();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}*/
	
	public AddEmailJFrame(String uName) {
		super("Add Event Description for Email Notification");
		userName=new String(uName);
		initGUI();
	}
	
	private void initGUI() {
		try {
			GroupLayout thisLayout = new GroupLayout((JComponent)getContentPane());
			getContentPane().setLayout(thisLayout);
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			
			bhandler=new AddConditionBHandler();
			type1=new String();
			type2=new String();
			condition=new String();
			
			viewCondition=new String();
			viewType1=new String();
			viewType2=new String();
			
			{
				jLabel1 = new JLabel();
				jLabel1.setText("Add Event Description for Email Notification");
				jLabel1.setFont(new java.awt.Font("Segoe UI",1,12));
			}
			{
				jLabel2 = new JLabel();
				jLabel2.setText("Your Email ID @gmail.com:");
			}
			{
				jLabel3 = new JLabel();
				jLabel3.setText("Password to this account: ");
			}
			{
				jLabel4 = new JLabel();
				jLabel4.setText("Email address for which ");
			}
			{
				jPanel1 = new JPanel();
				GroupLayout jPanel1Layout = new GroupLayout((JComponent)jPanel1);
				jPanel1.setLayout(jPanel1Layout);
				{
					jLabel5 = new JLabel();
					GroupLayout jLabel5Layout = new GroupLayout((JComponent)jLabel5);
					jLabel5.setLayout(jLabel5Layout);
					jLabel5.setText("Subject:");
					jLabel5Layout.setVerticalGroup(jLabel5Layout.createSequentialGroup());
					jLabel5Layout.setHorizontalGroup(jLabel5Layout.createSequentialGroup());
				}
				{
					ComboBoxModel typeListModel = 
						new DefaultComboBoxModel(
								new String[] { "Has", "Does not have" });
					typeList = new JComboBox();
					typeList.setModel(typeListModel);
					typeList.addActionListener(bhandler);
				}
				{
					jLabel11 = new JLabel();
					GroupLayout jLabel11Layout = new GroupLayout((JComponent)jLabel11);
					jLabel11.setLayout(jLabel11Layout);
					jLabel11.setText("Add type:");
					jLabel11Layout.setVerticalGroup(jLabel11Layout.createSequentialGroup());
					jLabel11Layout.setHorizontalGroup(jLabel11Layout.createSequentialGroup());
				}
				{
					jLabel9 = new JLabel();
					GroupLayout jLabel9Layout = new GroupLayout((JComponent)jLabel9);
					jLabel9.setLayout(jLabel9Layout);
					jLabel9.setText("Contains Keyword:");
					jLabel9Layout.setVerticalGroup(jLabel9Layout.createSequentialGroup());
					jLabel9Layout.setHorizontalGroup(jLabel9Layout.createSequentialGroup());
				}
				{
					subjectTextField = new JTextField();
					GroupLayout subjectTextFieldLayout = new GroupLayout((JComponent)subjectTextField);
					subjectTextField.setLayout(subjectTextFieldLayout);
					subjectTextField.setSize(200, 23);
					subjectTextFieldLayout.setVerticalGroup(subjectTextFieldLayout.createSequentialGroup());
					subjectTextFieldLayout.setHorizontalGroup(subjectTextFieldLayout.createSequentialGroup());
				}
				jPanel1Layout.setVerticalGroup(jPanel1Layout.createSequentialGroup()
					.addContainerGap(22, 22)
					.addComponent(jLabel5, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(0, 28, GroupLayout.PREFERRED_SIZE)
					.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
					    .addComponent(typeList, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
					    .addComponent(jLabel11, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(16)
					.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
					    .addComponent(subjectTextField, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
					    .addComponent(jLabel9, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(0, 51, Short.MAX_VALUE));
				jPanel1Layout.setHorizontalGroup(jPanel1Layout.createSequentialGroup()
					.addGroup(jPanel1Layout.createParallelGroup()
					    .addGroup(jPanel1Layout.createParallelGroup()
					        .addGroup(GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
					            .addComponent(jLabel5, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)
					            .addGap(16))
					        .addGroup(GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
					            .addGap(74, 74, 74)
					            .addComponent(jLabel11, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)))
					    .addGroup(GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
					        .addGap(39)
					        .addComponent(jLabel9, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
					.addGroup(jPanel1Layout.createParallelGroup()
					    .addGroup(GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
					        .addComponent(typeList, GroupLayout.PREFERRED_SIZE, 186, GroupLayout.PREFERRED_SIZE)
					        .addGap(0, 14, Short.MAX_VALUE))
					    .addGroup(jPanel1Layout.createSequentialGroup()
					        .addComponent(subjectTextField, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
					        .addGap(0, 0, Short.MAX_VALUE)))
					.addContainerGap(47, 47));
			}
			{
				jLabel7 = new JLabel();
				jLabel7.setText("Notification medium:");
			}
			{
				jLabel8 = new JLabel();
				jLabel8.setText("to get notifaction:");
			}
			{
				userEmailTextField = new JTextField();
				userEmailTextField.setSize(200, 23);
			}
			{
				userPasswordField = new JPasswordField();
			}
			{
				notEmailTextField = new JTextField();
				notEmailTextField.setSize(200, 23);
			}
			{
				bodyTextField = new JTextField();
				bodyTextField.setSize(200, 23);
			}
			{
				ComboBoxModel notificationListModel = 
					new DefaultComboBoxModel(
							new String[] { "Pop-up Window", "Call at Cell phone", "Message to Cell phone", "Text to Speech Converter" });
				notificationList = new JComboBox();
				notificationList.setModel(notificationListModel);
				notificationList.addActionListener(bhandler);
			}
			{
				addEmailButton = new JButton();
				addEmailButton.setText("Add Email Event");
				addEmailButton.addActionListener(bhandler);
			}
			{
				jLabel6 = new JLabel();
				jLabel6.setText("Body:");
			}
			{
				jSeparator2 = new JSeparator();
			}
			{
				jLabel10 = new JLabel();
				jLabel10.setText("Contains Keyword:");
				jLabel10.setLayout(null);
				/*jLabel10Layout.setAutoCreateGaps(false);
				jLabel10Layout.setAutoCreateContainerGaps(false);
				jLabel10Layout.setHorizontalGroup(jLabel10Layout.createSequentialGroup());
				jLabel10Layout.setVerticalGroup(jLabel10Layout.createSequentialGroup());*/
			}
			{
				jLabel12 = new JLabel();
				jLabel12.setText("Add type:");
			}
			{
				jLabel13 = new JLabel();
				jLabel13.setText("Add type:");
			}
			{
				ComboBoxModel typeList2Model = 
					new DefaultComboBoxModel(
							new String[] { "Has", "Does not have" });
				typeList2 = new JComboBox();
				typeList2.setModel(typeList2Model);
				typeList2.addActionListener(bhandler);
			}
			thisLayout.setVerticalGroup(thisLayout.createSequentialGroup()
				.addGroup(thisLayout.createParallelGroup()
				    .addComponent(jLabel12, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 0, GroupLayout.PREFERRED_SIZE)
				    .addComponent(jSeparator2, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 0, GroupLayout.PREFERRED_SIZE))
				.addGap(20)
				.addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
				.addGap(18)
				.addGroup(thisLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				    .addComponent(userEmailTextField, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				    .addComponent(jLabel2, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
				.addGroup(thisLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				    .addComponent(userPasswordField, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
				    .addComponent(jLabel3, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(18)
				.addComponent(jLabel4, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				.addGroup(thisLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				    .addComponent(notEmailTextField, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				    .addComponent(jLabel8, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
				.addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
				.addComponent(jLabel6, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				.addGap(17)
				.addGroup(thisLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				    .addComponent(typeList2, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				    .addComponent(jLabel13, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(16)
				.addGroup(thisLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				    .addComponent(bodyTextField, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				    .addComponent(jLabel10, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(37)
				.addGroup(thisLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				    .addComponent(notificationList, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				    .addComponent(jLabel7, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(37)
				.addComponent(addEmailButton, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				.addContainerGap(25, Short.MAX_VALUE));
			thisLayout.setHorizontalGroup(thisLayout.createSequentialGroup()
				.addGroup(thisLayout.createParallelGroup()
				    .addComponent(jLabel12, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 0, GroupLayout.PREFERRED_SIZE)
				    .addComponent(jSeparator2, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(12)
				.addGroup(thisLayout.createParallelGroup()
				    .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				        .addComponent(jLabel8, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
				        .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 261, GroupLayout.PREFERRED_SIZE)
				        .addGap(0, 61, Short.MAX_VALUE))
				    .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				        .addComponent(jLabel3, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)
				        .addGap(0, 265, Short.MAX_VALUE))
				    .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				        .addGroup(thisLayout.createParallelGroup()
				            .addComponent(jLabel2, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 164, GroupLayout.PREFERRED_SIZE)
				            .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				                .addComponent(jLabel4, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)
				                .addGap(17)))
				        .addComponent(addEmailButton, GroupLayout.PREFERRED_SIZE, 164, GroupLayout.PREFERRED_SIZE)
				        .addGap(0, 107, Short.MAX_VALUE))
				    .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				        .addComponent(jLabel6, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
				        .addGroup(thisLayout.createParallelGroup()
				            .addGroup(thisLayout.createSequentialGroup()
				                .addComponent(jLabel10, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
				                .addGap(0, 0, Short.MAX_VALUE))
				            .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				                .addGap(48)
				                .addComponent(jLabel13, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
				                .addGap(0, 6, Short.MAX_VALUE)))
				        .addGap(265))
				    .addGroup(thisLayout.createSequentialGroup()
				        .addGap(7)
				        .addGroup(thisLayout.createParallelGroup()
				            .addGroup(thisLayout.createSequentialGroup()
				                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, 428, GroupLayout.PREFERRED_SIZE)
				                .addGap(0, 0, Short.MAX_VALUE))
				            .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				                .addGap(0, 44, GroupLayout.PREFERRED_SIZE)
				                .addComponent(jLabel7, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE)
				                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
				                .addGroup(thisLayout.createParallelGroup()
				                    .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				                        .addComponent(notificationList, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				                        .addGap(0, 52, GroupLayout.PREFERRED_SIZE))
				                    .addGroup(thisLayout.createSequentialGroup()
				                        .addComponent(bodyTextField, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
				                        .addGap(0, 0, Short.MAX_VALUE))
				                    .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				                        .addComponent(typeList2, GroupLayout.PREFERRED_SIZE, 177, GroupLayout.PREFERRED_SIZE)
				                        .addGap(0, 23, Short.MAX_VALUE))
				                    .addGroup(thisLayout.createSequentialGroup()
				                        .addComponent(notEmailTextField, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
				                        .addGap(0, 0, Short.MAX_VALUE))
				                    .addGroup(thisLayout.createSequentialGroup()
				                        .addComponent(userPasswordField, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
				                        .addGap(0, 0, Short.MAX_VALUE))
				                    .addGroup(thisLayout.createSequentialGroup()
				                        .addComponent(userEmailTextField, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
				                        .addGap(0, 0, Short.MAX_VALUE)))
				                .addGap(53)))))
				.addContainerGap(45, 45));
			pack();
			setSize(500, 630);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private class AddConditionBHandler implements ActionListener
	{
	    // process color and font selections
	    public void actionPerformed( ActionEvent event )
	    {
	    	if(event.getSource()==typeList)
	    	{
	    		if(typeList.getSelectedIndex()==0)
	    		{
	    			System.out.println("has subject");
	    			type1="subject,has";
	    			viewType1="Subject has ";
	    		}
		    	else if(typeList.getSelectedIndex()==1)
		    	{
		    		type1="subject,hasnot";
		    		viewType1="Subject does not have ";
		    	}
		    }
	    	else if(event.getSource()==typeList2)
	    	{
	    		if(typeList2.getSelectedIndex()==0)
	    		{
		    		type2="body,has";
		    		viewType2="Body has ";
	    		}
		    	else if(typeList2.getSelectedIndex()==1)
		    	{
		    		type2="body,hasnot";
		    		viewType2="Body does not have ";
		    	}
		    }
	    	else if(event.getSource()==notificationList)
	    	{
	    		if(notificationList.getSelectedIndex()==0)
	    			notification="popup";
	    		else if(notificationList.getSelectedIndex()==1)
	    			notification="call";
	    		else if(notificationList.getSelectedIndex()==2)
	    			notification="sms";
	    		else if(notificationList.getSelectedIndex()==3)
	    			notification="tts";
	    	}
	    	else if(event.getSource()==addEmailButton)
	    	{
	    		condition="<"+"userid,"+userEmailTextField.getText()+">"+"<"+"password,"+userPasswordField.getText()+">"+"<"+"sender,has,"+notEmailTextField.getText()+">"+"<"+type1+","+subjectTextField.getText().trim()+">"+"<"+type2+","+bodyTextField.getText().trim()+">";
	    		viewCondition="Sender: "+notEmailTextField.getText()+"  "+viewType1+subjectTextField.getText().trim()+"  "+viewType2+bodyTextField.getText().trim();
	    		System.out.println("condition in : "+condition);
	    		System.out.println("condition in : "+viewCondition);
	    		
	    		try{
	    			conn=DriverManager.getConnection("jdbc:mysql://localhost/db1?"+"user=root&password=munir");
	    			stmt=conn.createStatement();
	    			
	    			stmt.execute("insert into events(username,event_type,event_condition,notification) values(\'"+userName+"\',\'gmail\',\'"+condition+"\'"+","+"\'"+notification+"\')");
	    			//stmt.execute("commit");
	    			System.out.println("here");
	    			stmt.execute("insert into viewevents(username,event_type,view_condition,event_condition,notification) values(\'"+userName+"\',\'gmail\',\'"+viewCondition+"\',\'"+condition+"\',\'"+notification+"\')");
					//stmt.execute("commit");
					
					JOptionPane.showMessageDialog(null, "Event sucessfully added!");
					javax.swing.JFrame t = (JFrame) addEmailButton.getParent().getParent().getParent().getParent();
					t.dispose();
					
					conn.close();
	    		}
	    		
	    		catch(Exception e){
	    			
	    		}
	    	}
	    	
	    }
	}

}
