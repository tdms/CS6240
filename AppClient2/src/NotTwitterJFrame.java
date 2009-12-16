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
public class NotTwitterJFrame extends javax.swing.JFrame {
	private JLabel jLabel1;
	private JLabel jLabel2;
	private JLabel jLabel3;
	private JLabel jLabel4;
	private JButton speak;
	private JScrollPane jScrollPane1;
	private JTextArea bodyTwitterTextArea;
	private JTextField typeTwitterTextField;
	private JTextField fromTwitterTextField;
	private ButtonHandler bhandler;
	
	private String str;
	private String clientName;
	private String from;
	private String type;
	private String content;
	private String totalMsg;
	
	/**
	* Auto-generated main method to display this JFrame
	*/
	/*public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				NotTwitterJFrame inst = new NotTwitterJFrame();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}*/
	
	public NotTwitterJFrame(String str1) {
		super("Twitter Alert!");
		str=new String(str1);
		totalMsg=new String();
		
		bhandler=new ButtonHandler();
		System.out.println("In NotifyTwitterJFrame");
		
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
				jLabel1.setText("Notification from Twitter");
				jLabel1.setFont(new java.awt.Font("Tahoma",1,11));
			}
			{
				speak = new JButton();
				speak.setText("Speak");
				speak.setSize(99, 25);
				speak.addActionListener(bhandler);
			}
			{
				jLabel2 = new JLabel();
				jLabel2.setText("From: ");
			}
			{
				jLabel3 = new JLabel();
				jLabel3.setText("Type: ");
			}
			{
				jLabel4 = new JLabel();
				jLabel4.setText("Update/Content:");
			}
			{
				fromTwitterTextField = new JTextField();
				fromTwitterTextField.setText(from);
			}
			{
				typeTwitterTextField = new JTextField();
				typeTwitterTextField.setText(type);
			}
			{
				jScrollPane1 = new JScrollPane();
				{
					bodyTwitterTextArea = new JTextArea();
					jScrollPane1.setViewportView(bodyTwitterTextArea);
					bodyTwitterTextArea.setText(content);
				}
			}
			thisLayout.setVerticalGroup(thisLayout.createSequentialGroup()
				.addContainerGap(23, 23)
				.addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
				.addGroup(thisLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				    .addComponent(fromTwitterTextField, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				    .addComponent(jLabel2, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
				.addGroup(thisLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				    .addComponent(typeTwitterTextField, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				    .addComponent(jLabel3, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
				.addGroup(thisLayout.createParallelGroup()
				    .addComponent(jScrollPane1, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)
				    .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
				        .addComponent(jLabel4, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				        .addGap(99)))
				.addGap(19)
				.addComponent(speak, 0, 22, Short.MAX_VALUE)
				.addContainerGap(16, 16));
			thisLayout.setHorizontalGroup(thisLayout.createSequentialGroup()
				.addContainerGap(34, 34)
				.addGroup(thisLayout.createParallelGroup()
				    .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				        .addGap(0, 0, Short.MAX_VALUE)
				        .addComponent(jLabel4, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE))
				    .addGroup(thisLayout.createSequentialGroup()
				        .addGap(37)
				        .addGroup(thisLayout.createParallelGroup()
				            .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				                .addComponent(jLabel3, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
				                .addGap(0, 12, Short.MAX_VALUE))
				            .addGroup(thisLayout.createSequentialGroup()
				                .addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
				                .addGap(0, 0, Short.MAX_VALUE)))))
				.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
				.addGroup(thisLayout.createParallelGroup()
				    .addComponent(jScrollPane1, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 173, GroupLayout.PREFERRED_SIZE)
				    .addComponent(typeTwitterTextField, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 173, GroupLayout.PREFERRED_SIZE)
				    .addComponent(fromTwitterTextField, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 173, GroupLayout.PREFERRED_SIZE)
				    .addComponent(jLabel1, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 173, GroupLayout.PREFERRED_SIZE)
				    .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				        .addPreferredGap(jScrollPane1, speak, LayoutStyle.ComponentPlacement.INDENT)
				        .addComponent(speak, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
				        .addGap(68)))
				.addContainerGap(74, 74));
			pack();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void ParseString(String str)
	{
		//System.out.println(condition);
		StringTokenizer st = new StringTokenizer(str,">");
		String temp,temp1,temp2;
		String definedString;
			
		definedString = "clientName";
		temp = st.nextToken();
		temp1 = temp.substring(1,definedString.length()+1);
		temp2 = temp.substring(definedString.length()+2, temp.length());
		if(temp1.compareTo(definedString)!=0)
			System.out.println("Invalid condition. Expected: " + definedString +", Received: " + temp1 );
		//System.out.println("type: " + temp1 + ",value: " + temp2);
		this.clientName = temp2;
			
		String toktemp=st.nextToken();
		System.out.println("Token: "+toktemp);
		StringTokenizer st2=new StringTokenizer(toktemp,",");
		if(st2.nextToken().equals("<userName"))
		{
			this.type="Status";			
		}
		else this.type="Message";
		this.from=st2.nextToken();
		
		toktemp=st.nextToken();
		System.out.println("Token: "+toktemp);
		st2=new StringTokenizer(toktemp,",");
		st2.nextToken();
		this.content=st2.nextToken();
		
		while(st.hasMoreTokens())
		{
			toktemp=st.nextToken();
			System.out.println("Token: "+toktemp);
			
			st2=new StringTokenizer(toktemp,",");
			if(st2.nextToken().equals("<notificationType"))
				;
			else 
				this.content+=toktemp;
		}
			
		System.out.println("userid: "+clientName);
		System.out.println("from: "+from);
		System.out.println("type: "+type);
		System.out.println("content: "+content);
		
		totalMsg="From: "+from+".\nType: "+type+".\nContent: "+content;
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
