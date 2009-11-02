import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
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
public class AddNewsJFrame extends javax.swing.JFrame {
	private JLabel jLabel1;
	private JLabel jLabel2;
	private JLabel jLabel3;
	private JComboBox eventTypeList;
	private JLabel jLabel5;
	private JLabel jLabel4;
	private JTextField keywordTextField;
	private JButton addNewsButton;
	private JButton addConditionButton;
	private JComboBox notificationList;
	private JComboBox newsWebsiteList;

	private AddConditionBHandler bhandler1;
	private AddConditionJFrame addCondition;
	private String condition, type;
	
	/**
	* Auto-generated main method to display this JFrame
	*/
	/*public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				AddNewsJFrame inst = new AddNewsJFrame();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}*/
	
	public AddNewsJFrame() {
		super("Add Event Description for News Notification");
		condition=new String("");
		
		initGUI();
	}
	
	private void initGUI() {
		try {
			GroupLayout thisLayout = new GroupLayout((JComponent)getContentPane());
			getContentPane().setLayout(thisLayout);
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			{
				jLabel1 = new JLabel();
				jLabel1.setText("Add Event Description for News Notification");
				jLabel1.setFont(new java.awt.Font("Segoe UI",1,12));
			}
			{
				jLabel2 = new JLabel();
				jLabel2.setText("Website:");
			}
			{
				jLabel3 = new JLabel();
				jLabel3.setText("Notification medium: ");
			}
			{
				ComboBoxModel newsWebsiteListModel = 
					new DefaultComboBoxModel(
							new String[] { "www.cnn.com", "www.cnbc.com", "www.bbc.co.uk" });
				newsWebsiteList = new JComboBox();
				newsWebsiteList.setModel(newsWebsiteListModel);
			}
			{
				ComboBoxModel notificationListModel = 
					new DefaultComboBoxModel(
							new String[] { "Pop-up Window", "Call at Cell phone", "Message to Cell phone", "Text to Speech Converter" });
				
				notificationList = new JComboBox();
				notificationList.setModel(notificationListModel);
			}
			{
				addConditionButton = new JButton();
				addConditionButton.setText("Add Conditions");
				bhandler1=new AddConditionBHandler();
				addConditionButton.addActionListener(bhandler1);
			}
			{
				addNewsButton = new JButton();
				addNewsButton.setText("Finish adding News Notification Event");
			}
			{
				ComboBoxModel eventTypeListModel = 
					new DefaultComboBoxModel(
							new String[] { "Has", "Has Not" });
				eventTypeList = new JComboBox();
				eventTypeList.setModel(eventTypeListModel);
				eventTypeList.addActionListener(bhandler1);
			}
			{
				keywordTextField = new JTextField();
			}
			{
				jLabel4 = new JLabel();
				jLabel4.setText("Keyword:");
			}
			{
				jLabel5 = new JLabel();
				jLabel5.setText("Add Type:");
			}
			thisLayout.setVerticalGroup(thisLayout.createSequentialGroup()
				.addContainerGap(24, 24)
				.addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				.addGap(26)
				.addGroup(thisLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				    .addComponent(newsWebsiteList, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				    .addComponent(jLabel2, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
				.addGroup(thisLayout.createParallelGroup()
				    .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				        .addComponent(jLabel3, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
				        .addGap(7))
				    .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
				        .addComponent(notificationList, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)))
				.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
				.addGroup(thisLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				    .addComponent(eventTypeList, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				    .addComponent(jLabel5, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
				.addGroup(thisLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				    .addComponent(keywordTextField, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
				    .addComponent(jLabel4, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(62)
				.addComponent(addConditionButton, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				.addGap(27)
				.addComponent(addNewsButton, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
				.addContainerGap(35, Short.MAX_VALUE));
			thisLayout.setHorizontalGroup(thisLayout.createSequentialGroup()
				.addGap(6)
				.addGroup(thisLayout.createParallelGroup()
				    .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				        .addComponent(jLabel3, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
				        .addGap(17)
				        .addGroup(thisLayout.createParallelGroup()
				            .addGroup(thisLayout.createSequentialGroup()
				                .addComponent(keywordTextField, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE))
				            .addGroup(thisLayout.createSequentialGroup()
				                .addComponent(eventTypeList, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE))
				            .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				                .addComponent(notificationList, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
				            .addGroup(thisLayout.createSequentialGroup()
				                .addComponent(newsWebsiteList, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE)))
				        .addGap(0, 23, Short.MAX_VALUE))
				    .addGroup(thisLayout.createSequentialGroup()
				        .addGap(52)
				        .addGroup(thisLayout.createParallelGroup()
				            .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				                .addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
				                .addGap(14)
				                .addComponent(addConditionButton, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE)
				                .addGap(0, 66, Short.MAX_VALUE))
				            .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				                .addGap(0, 0, Short.MAX_VALUE)
				                .addComponent(jLabel4, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
				                .addGap(197))
				            .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				                .addGap(0, 0, Short.MAX_VALUE)
				                .addComponent(jLabel5, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
				                .addGap(197))
				            .addGroup(thisLayout.createSequentialGroup()
				                .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 269, GroupLayout.PREFERRED_SIZE)
				                .addGap(0, 0, Short.MAX_VALUE))
				            .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				                .addComponent(addNewsButton, 0, 262, Short.MAX_VALUE)
				                .addGap(7)))))
				.addContainerGap(57, 57));
			pack();
			setSize(400, 400);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private class AddConditionBHandler implements ActionListener
	{
	    // process color and font selections
	    public void actionPerformed( ActionEvent event )
	    {
	    	if(event.getSource()==eventTypeList)
	    	{
	    		/*addCondition = new AddConditionJFrame();
		    	addCondition.setLocationRelativeTo(null);
		    	addCondition.setVisible(true);*/
	    		
	    		if(event.getSource()==eventTypeList)
		    	{
		    		if(eventTypeList.getSelectedIndex()==0)
		    			type="has";
		    		else if(eventTypeList.getSelectedIndex()==1)
		    			type="hasnot";
		    		
		    	}
		    }
	    	else if(event.getSource()==addConditionButton)
	    	{
	    		condition+="<"+type+", "+keywordTextField.getText().trim()+">";
	    		System.out.println("condition in : "+condition);
	    	}
	    	else if(event.getSource()==addNewsButton)
	    	{
	    		
	    	}
	    }
	}
	 
}
