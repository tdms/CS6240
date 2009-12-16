import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.StringTokenizer;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
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
public class NotifyEmailJFrame extends javax.swing.JFrame {
	private JLabel jLabel1;
	private JLabel jLabel4;
	private JLabel jLabel5;
	private JButton speak;
	private JTextArea bodyTextArea;
	private JScrollPane jScrollPane1;
	private JTextField dateTextField;
	private JTextField subjectTextField;
	private JLabel jLabel3;
	private JTextField fromTextField;
	private JLabel jLabel2;
	private ButtonHandler bhandler;
	
	 private String userid;
	 private String emailFrom;
	 private String emailSubject;
	 private String emailDate;
	 private String emailBody;
	 private String str, totalMsg;
	 
	/**
	* Auto-generated main method to display this JFrame
	*/
	/*public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				NotifyEmailJFrame inst = new NotifyEmailJFrame();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}*/
	
	public NotifyEmailJFrame(String str1) {
		super("Email Alert!");
		
		System.out.println("In NotifyEmailJFrame");
		
		str=new String(str1);
		totalMsg=new String();
		bhandler=new ButtonHandler();
		initGUI();
	}
	
	private void initGUI() {
		try {
			GroupLayout thisLayout = new GroupLayout((JComponent)getContentPane());
			getContentPane().setLayout(thisLayout);
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			
			ParseString(str);
			
			{
				jLabel1 = new JLabel();
				jLabel1.setText("Mail Notificaion");
			}
			{
				speak = new JButton();
				speak.setText("Speak");
				speak.addActionListener(bhandler);
			}
			{
				jScrollPane1 = new JScrollPane();
				{
					bodyTextArea = new JTextArea();
					jScrollPane1.setViewportView(bodyTextArea);
					bodyTextArea.setText(emailBody);
				}
			}
			{
				jLabel2 = new JLabel();
				jLabel2.setText("From:");
			}
			{
				fromTextField = new JTextField();
				fromTextField.setText(emailFrom);
			}
			{
				jLabel3 = new JLabel();
				jLabel3.setText("Subject:");
			}
			{
				subjectTextField = new JTextField();
				subjectTextField.setText(emailSubject);
			}
			{
				jLabel4 = new JLabel();
				jLabel4.setText("Date");
			}
			{
				dateTextField = new JTextField();
				dateTextField.setText(emailDate);
			}
			{
				jLabel5 = new JLabel();
				jLabel5.setText("Body:");
			}
			thisLayout.setVerticalGroup(thisLayout.createSequentialGroup()
				.addContainerGap()
				.addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
				.addGroup(thisLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				    .addComponent(fromTextField, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				    .addComponent(jLabel2, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
				.addGroup(thisLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				    .addComponent(subjectTextField, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				    .addComponent(jLabel3, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
				.addGroup(thisLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				    .addComponent(dateTextField, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				    .addComponent(jLabel4, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(22)
				.addGroup(thisLayout.createParallelGroup()
				    .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				        .addComponent(jLabel5, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				        .addGap(209))
				    .addComponent(jScrollPane1, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 223, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
				.addComponent(speak, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
				.addContainerGap(16, Short.MAX_VALUE));
			thisLayout.setHorizontalGroup(thisLayout.createSequentialGroup()
				.addContainerGap(68, 68)
				.addGroup(thisLayout.createParallelGroup()
				    .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				        .addComponent(jLabel5, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
				        .addGap(43))
				    .addComponent(jLabel4, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
				    .addComponent(jLabel3, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
				    .addComponent(jLabel2, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE))
				.addGroup(thisLayout.createParallelGroup()
				    .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				        .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
				        .addGap(0, 175, Short.MAX_VALUE))
				    .addGroup(thisLayout.createSequentialGroup()
				        .addPreferredGap(jLabel1, jScrollPane1, LayoutStyle.ComponentPlacement.INDENT)
				        .addGroup(thisLayout.createParallelGroup()
				            .addComponent(jScrollPane1, GroupLayout.Alignment.LEADING, 0, 264, Short.MAX_VALUE)
				            .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				                .addComponent(dateTextField, GroupLayout.PREFERRED_SIZE, 226, GroupLayout.PREFERRED_SIZE)
				                .addGap(0, 38, Short.MAX_VALUE))
				            .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				                .addComponent(subjectTextField, GroupLayout.PREFERRED_SIZE, 226, GroupLayout.PREFERRED_SIZE)
				                .addGap(0, 38, Short.MAX_VALUE))
				            .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				                .addComponent(fromTextField, GroupLayout.PREFERRED_SIZE, 226, GroupLayout.PREFERRED_SIZE)
				                .addGap(0, 38, Short.MAX_VALUE))
				            .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				                .addPreferredGap(jScrollPane1, speak, LayoutStyle.ComponentPlacement.INDENT)
				                .addComponent(speak, 0, 99, Short.MAX_VALUE)
				                .addGap(153)))))
				.addContainerGap(21, 21));
			pack();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void ParseString(String str)
	{
		//System.out.println(condition);
		StringTokenizer st = new StringTokenizer(str,">");
		String temp,temp1, temp2,temp3="";
		String definedString;
			
		definedString = "clientName";
		temp = st.nextToken();
		temp1 = temp.substring(1,definedString.length()+1);
		temp2 = temp.substring(definedString.length()+2, temp.length());
		if(temp1.compareTo(definedString)!=0)
			System.out.println("Invalid condition. Expected: " + definedString +", Received: " + temp1 );
		//System.out.println("type: " + temp1 + ",value: " + temp2);
		this.userid = temp2;
			
		definedString = "from";
		temp = st.nextToken();
		temp1 = temp.substring(1,definedString.length()+1);
		temp2 = temp.substring(definedString.length()+2, temp.length());
		if(temp1.compareTo(definedString)!=0)
			System.out.println("Invalid condition. Expected: " + definedString +", Received: " + temp1 );
		//System.out.println("type: " + temp1 + ",value: " + temp2);
		this.emailFrom = temp2+">";
		 	
		definedString = "subject";
		temp = st.nextToken();
		temp1 = temp.substring(1,definedString.length()+1);
		temp2 = temp.substring(definedString.length()+2, temp.length());
		if(temp1.compareTo(definedString)!=0)
			System.out.println("Invalid condition. Expected: " + definedString +", Received: " + temp1 );
		//System.out.println("type: " + temp1 + ",value: " + temp2);
		this.emailSubject = temp2;
		
		definedString = "date";
		temp = st.nextToken();
		temp1 = temp.substring(1,definedString.length()+1);
		temp2 = temp.substring(definedString.length()+2, temp.length());
		if(temp1.compareTo(definedString)!=0)
			System.out.println("Invalid condition. Expected: " + definedString +", Received: " + temp1 );
		//System.out.println("type: " + temp1 + ",value: " + temp2);
		this.emailDate = temp2;
		
		definedString = "body";
		temp = st.nextToken();
		temp1 = temp.substring(1,definedString.length()+1);
		temp2 = temp.substring(definedString.length()+2, temp.length());
		if(temp1.compareTo(definedString)!=0)
			System.out.println("Invalid condition. Expected: " + definedString +", Received: " + temp1 );
		//System.out.println("type: " + temp1 + ",value: " + temp2);
		this.emailBody = temp2;
		
		while(st.hasMoreTokens())
		{
			String toktemp=st.nextToken();
			System.out.println("Token: "+toktemp);
			
			StringTokenizer st2=new StringTokenizer(toktemp,",");
			if(st2.nextToken().equals("<notificationType"))
				;
			else 
				this.emailBody+=toktemp;
		}
			
		System.out.println("userid: "+userid);
		System.out.println("from: "+emailFrom);
		System.out.println("subject: "+emailSubject);
		System.out.println("date: "+emailDate);
		System.out.println("body: "+emailBody);
		
		totalMsg="From: "+emailFrom+".\nSubject: "+emailSubject+".\nBody: "+emailBody;
	}
	
	private class ButtonHandler implements ActionListener{
		
		public void actionPerformed( ActionEvent event )
		{
			System.out.println("Speak!");
			
			T2SConverter t2s=new T2SConverter();
			t2s.speak(totalMsg);
			t2s.clean();
		}
	}
}
