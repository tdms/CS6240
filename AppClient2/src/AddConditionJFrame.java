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

import java.awt.*;


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
public class AddConditionJFrame extends javax.swing.JFrame {
	private JLabel jLabel1;
	private JLabel jLabel2;
	private JLabel jLabel3;
	private JComboBox eventTypeList;
	private JTextField keywordTextField;
	private JButton okButton;
	
	private OKBHandler bhandler;
	public static String type, keyword, condition;
	
	/**
	* Auto-generated main method to display this JFrame
	*/
	/*public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				AddConditionJFrame inst = new AddConditionJFrame();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}*/
	
	public AddConditionJFrame() {
		super("Add Condition");
		
		type=new String("");
		keyword=new String("");
		condition=new String("");
		
		initGUI();
	}
	
	private void initGUI() {
		try {
			GroupLayout thisLayout = new GroupLayout((JComponent)getContentPane());
			getContentPane().setLayout(thisLayout);
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			
			bhandler=new OKBHandler();
			
			{
				jLabel1 = new JLabel();
				jLabel1.setText("Add Conditions");
				jLabel1.setFont(new java.awt.Font("Segoe UI",1,12));
			}
			{
				jLabel2 = new JLabel();
				jLabel2.setText("Add Type:");
			}
			{
				jLabel3 = new JLabel();
				jLabel3.setText("Keyword:");
			}
			{
				okButton = new JButton();
				okButton.setText("OK");
				okButton.addActionListener(bhandler);
				
			}
			{
				keywordTextField = new JTextField();
			}
			{
				ComboBoxModel eventTypeListModel = 
					new DefaultComboBoxModel(
							new String[] { "Has", "Has not" });
				eventTypeList = new JComboBox();
				eventTypeList.setModel(eventTypeListModel);
				eventTypeList.addActionListener(bhandler);
				
			}
			
			thisLayout.setVerticalGroup(thisLayout.createSequentialGroup()
				.addContainerGap(19, 19)
				.addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
				.addGap(0, 25, Short.MAX_VALUE)
				.addGroup(thisLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				    .addComponent(eventTypeList, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				    .addComponent(jLabel2, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(18)
				.addGroup(thisLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				    .addComponent(keywordTextField, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				    .addComponent(jLabel3, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(53)
				.addComponent(okButton, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				.addContainerGap(61, 61));
			thisLayout.setHorizontalGroup(thisLayout.createSequentialGroup()
				.addContainerGap(47, 47)
				.addGroup(thisLayout.createParallelGroup()
				    .addComponent(jLabel2, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
				    .addGroup(thisLayout.createSequentialGroup()
				        .addGap(0, 0, Short.MAX_VALUE)
				        .addComponent(jLabel3, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)))
				.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
				.addGroup(thisLayout.createParallelGroup()
				    .addComponent(keywordTextField, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
				    .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				        .addComponent(eventTypeList, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE)
				        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED))
				    .addGroup(thisLayout.createSequentialGroup()
				        .addGap(23)
				        .addGroup(thisLayout.createParallelGroup()
				            .addComponent(jLabel1, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
				            .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				                .addGap(8)
				                .addComponent(okButton, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
				                .addGap(55)))
				        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)))
				.addContainerGap(100, 100));
			pack();
			setSize(400, 300);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		/*public String getConditionString()
		{
			return condition;
			//return (new String(condition));
		}*/
	}
	
	private class OKBHandler implements ActionListener
	{
	    // process color and font selections
	    public void actionPerformed( ActionEvent event )
	    {
	    	if(event.getSource()==eventTypeList)
	    	{
	    		if(eventTypeList.getSelectedIndex()==0)
	    			type="has";
	    		else if(eventTypeList.getSelectedIndex()==1)
	    			type="hasnot";
	    		
	    	}
	    	else if(event.getSource()==okButton)
	    	{
	    		condition="<"+type+", "+keywordTextField.getText().trim()+">";
	    		System.out.println("condition in : "+condition);
	    	}
	    }
	}
}
