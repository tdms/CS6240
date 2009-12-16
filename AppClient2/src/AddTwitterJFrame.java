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
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;
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
public class AddTwitterJFrame extends javax.swing.JFrame {
	private JLabel jLabel1;
	private JLabel jLabel2;
	private JLabel jLabel3;
	private JLabel jLabel4;
	private JLabel jLabel5;
	private JSeparator jSeparator1;
	private JComboBox notificationList;
	private JButton jButton1;
	private JTextField keywordTestField;
	private JComboBox addTypeList;
	private JComboBox categoryList;
	private JButton jButton2;
	private String userName, email, password;
	private JScrollPane scroll;
	
	private AddConditionBHandler bhandler;
	String type, keyword, category, condition,conditionshow;
	private Connection conn=null;
	private JTextArea eventsTextArea;
	private JScrollPane jScrollPane1;
	private JLabel jLabel6;
	
	private JComboBox typeList;
	private Statement stmt;
	private ResultSet rs=null;
	private String notification;
	private String viewType,viewCondition;
	
	/**
	* Auto-generated main method to display this JFrame
	*/
	/*public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				AddTwitterJFrame inst = new AddTwitterJFrame();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}*/
	
	public AddTwitterJFrame(String uName, String email1, String pass1) {
		super("Add events for Twitter");
		userName=new String(uName);
		email=new String(email1);
		password=new String(pass1);
		
		initGUI();
	}
	
	private void initGUI() {
		try {
			GroupLayout thisLayout = new GroupLayout((JComponent)getContentPane());
			getContentPane().setLayout(thisLayout);
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			bhandler=new AddConditionBHandler();
			type=new String();
			keyword=new String();
			category=new String();
			condition=new String();
			conditionshow=new String();
			notification=new String();
			
			type="has";
			category="status";
			notification="popup";
			
			condition="<userid,"+email+">"+"<password,"+password+">";
			
			viewType=new String();
			viewCondition=new String();
			
			
			
			{
				jLabel1 = new JLabel();
				jLabel1.setText("Add Events for Twitter");
				jLabel1.setFont(new java.awt.Font("Tahoma",1,11));
			}
			{
				jLabel2 = new JLabel();
				jLabel2.setText("Catergory:");
			}
			{
				jLabel3 = new JLabel();
				jLabel3.setText("Type:");
			}
			{
				jLabel4 = new JLabel();
				jLabel4.setText("Keyword:");
			}
			{
				jButton1 = new JButton();
				jButton1.setText("Add Condition");
				jButton1.addActionListener(bhandler);
			}
			{
				jButton2 = new JButton();
				jButton2.setText("Add Twitter Event");
				jButton2.addActionListener(bhandler);
			}
			{
				jScrollPane1 = new JScrollPane();
				{
					eventsTextArea = new JTextArea();
					jScrollPane1.setViewportView(eventsTextArea);
					eventsTextArea.setText("");
					//eventsTextArea.enable(false);
				}
			}
			{
				jSeparator1 = new JSeparator();
			}
			{
				jLabel6 = new JLabel();
				jLabel6.setText("Events added so far:");
			}
			{
				jLabel5 = new JLabel();
				jLabel5.setText("Notification Medium:");
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
				keywordTestField = new JTextField();
			}
			{
				ComboBoxModel categoryListModel = 
					new DefaultComboBoxModel(
							new String[] { "Status", "Direct Message", "Any" });
				categoryList = new JComboBox();
				categoryList.setModel(categoryListModel);
				categoryList.addActionListener(bhandler);
			}
			{
				ComboBoxModel addTypeListModel = 
					new DefaultComboBoxModel(
							new String[] { "Has", "Does not have" });
				addTypeList = new JComboBox();
				addTypeList.setModel(addTypeListModel);
				addTypeList.addActionListener(bhandler);
			}
			thisLayout.setVerticalGroup(thisLayout.createSequentialGroup()
				.addContainerGap()
				.addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				.addGap(23)
				.addGroup(thisLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				    .addComponent(categoryList, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				    .addComponent(jLabel2, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(16)
				.addGroup(thisLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				    .addComponent(addTypeList, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				    .addComponent(jLabel3, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(19)
				.addGroup(thisLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				    .addComponent(keywordTestField, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				    .addComponent(jLabel4, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(27)
				.addComponent(jButton1, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				.addGap(18)
				.addGroup(thisLayout.createParallelGroup()
				    .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				        .addComponent(jLabel6, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
				        .addGap(45))
				    .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				        .addGap(0, 9, Short.MAX_VALUE)
				        .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)))
				.addComponent(jSeparator1, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				.addGap(0, 22, GroupLayout.PREFERRED_SIZE)
				.addGroup(thisLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				    .addComponent(notificationList, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				    .addComponent(jLabel5, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(19)
				.addComponent(jButton2, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				.addContainerGap(50, 50));
			thisLayout.setHorizontalGroup(thisLayout.createSequentialGroup()
				.addContainerGap()
				.addGroup(thisLayout.createParallelGroup()
				    .addGroup(thisLayout.createSequentialGroup()
				        .addGroup(thisLayout.createParallelGroup()
				            .addComponent(jLabel5, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
				            .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				                .addComponent(jLabel6, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
				                .addGap(12)))
				        .addGroup(thisLayout.createParallelGroup()
				            .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				                .addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
				                .addGap(0, 116, Short.MAX_VALUE))
				            .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				                .addComponent(jButton2, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
				                .addGap(0, 97, Short.MAX_VALUE))
				            .addGroup(thisLayout.createSequentialGroup()
				                .addGap(7)
				                .addGroup(thisLayout.createParallelGroup()
				                    .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				                        .addComponent(notificationList, GroupLayout.PREFERRED_SIZE, 169, GroupLayout.PREFERRED_SIZE)
				                        .addGap(0, 56, Short.MAX_VALUE))
				                    .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				                        .addComponent(keywordTestField, GroupLayout.PREFERRED_SIZE, 169, GroupLayout.PREFERRED_SIZE)
				                        .addGap(0, 56, Short.MAX_VALUE))
				                    .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				                        .addComponent(addTypeList, GroupLayout.PREFERRED_SIZE, 169, GroupLayout.PREFERRED_SIZE)
				                        .addGap(0, 56, Short.MAX_VALUE))
				                    .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				                        .addComponent(categoryList, GroupLayout.PREFERRED_SIZE, 169, GroupLayout.PREFERRED_SIZE)
				                        .addGap(0, 56, Short.MAX_VALUE))
				                    .addGroup(thisLayout.createSequentialGroup()
				                        .addGap(0, 57, Short.MAX_VALUE)
				                        .addGroup(thisLayout.createParallelGroup()
				                            .addComponent(jScrollPane1, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 168, GroupLayout.PREFERRED_SIZE)
				                            .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				                                .addComponent(jSeparator1, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				                                .addGap(168))))))))
				    .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				        .addGap(29)
				        .addGroup(thisLayout.createParallelGroup()
				            .addComponent(jLabel2, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
				            .addGroup(thisLayout.createSequentialGroup()
				                .addGap(7)
				                .addGroup(thisLayout.createParallelGroup()
				                    .addComponent(jLabel4, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
				                    .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				                        .addGap(17)
				                        .addComponent(jLabel3, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)))
				                .addGap(7)))
				        .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 184, GroupLayout.PREFERRED_SIZE)
				        .addGap(0, 70, Short.MAX_VALUE)))
				.addContainerGap(20, 20));

			pack();
			setSize(400, 450);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private class AddConditionBHandler implements ActionListener
	{
	    // process color and font selections
	    public void actionPerformed( ActionEvent event )
	    {
	    	if(event.getSource()==addTypeList)
	    	{
	    		if(addTypeList.getSelectedIndex()==0)
	    		{
		    		type="has";
		    		viewType="has";
	    		}
		    	else if(addTypeList.getSelectedIndex()==1)
		    	{
		    		type="hasnot";
		    		viewType="does not have";
		    	}
		    }
	    	else if(event.getSource()==categoryList)
	    	{
	    		if(categoryList.getSelectedIndex()==0)
		    		category="status";
		    	else if(categoryList.getSelectedIndex()==1)
		    		category="message";
		    	else if(categoryList.getSelectedIndex()==2)
	    			category="any";
    		}
	    	else if(event.getSource()==jButton1)
	    	{
	    		condition+="<"+category+","+type+","+keywordTestField.getText().trim()+">";
	    		conditionshow+=category+" "+type+" "+keywordTestField.getText().trim()+"\n";
	    		viewCondition+=category+" "+type+" "+keywordTestField.getText().trim()+" ";
	    		
	    		System.out.println("condition in : "+condition);
	    		eventsTextArea.setText(conditionshow);
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
	    	else if(event.getSource()==jButton2)
	    	{
	    		try
	    		{
	    			System.out.println("notification : "+notification);
	    			
	    			conn=DriverManager.getConnection("jdbc:mysql://localhost/db1?"+"user=root&password=munir");
	    			stmt=conn.createStatement();
	    			
	    			stmt.execute("insert into events(username,event_type,event_condition,notification) values(\'"+userName+"\',\'twitter\',\'"+condition+"\'"+","+"\'"+notification+"\')");
	    			stmt.execute("insert into viewevents(username,event_type,view_condition,event_condition,notification) values(\'"+userName+"\',\'twitter\',\'"+viewCondition+"\',\'"+condition+"\',\'"+notification+"\')");
					stmt.execute("commit");
					
					JOptionPane.showMessageDialog(null, "Event sucessfully added!");
					javax.swing.JFrame t = (JFrame) jButton2.getParent().getParent().getParent().getParent();
					t.dispose();
					
					conn.close();
	    		}
	    		
	    		catch(Exception e){
	    			
	    		}
	    	}
	    }
	}

}
