
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
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
public class AddSocialJFrame extends javax.swing.JFrame {
	private JLabel jLabel1;
	private JLabel jLabel2;
	private JLabel jLabel3;
	private JLabel jLabel4;
	private JSeparator jSeparator2;
	private JSeparator jSeparator1;
	private JButton addSocialButton;
	private JPasswordField socialPasswordField;
	private JTextField socialUserTextField;
	private JComboBox socialNetworkList;
	private String userName;
	
	private AddSocialEventHandler handler;
	private AddTwitterJFrame addTwitter;
	
	/**
	* Auto-generated main method to display this JFrame
	*/
	/*public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				AddSocialJFrame inst = new AddSocialJFrame();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}*/
	
	public AddSocialJFrame(String uName) {
		super("Add Social Event Description");
		userName=new String(uName);
		initGUI();
	}
	
	private void initGUI() {
		try {
			GroupLayout thisLayout = new GroupLayout((JComponent)getContentPane());
			getContentPane().setLayout(thisLayout);
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			{
				jLabel1 = new JLabel();
				jLabel1.setText("Add Event Description for Social Networks");
				jLabel1.setFont(new java.awt.Font("Segoe UI",1,12));
			}
			{
				jLabel2 = new JLabel();
				jLabel2.setText("Select Network:");
			}
			{
				jLabel3 = new JLabel();
				jLabel3.setText("Login name:");
			}
			{
				jLabel4 = new JLabel();
				jLabel4.setText("Password:");
			}
			{
				ComboBoxModel socialNetworkListModel = 
					new DefaultComboBoxModel(
							new String[] {  "Facebook", "Twitter", "LinkedIn" });
				socialNetworkList = new JComboBox();
				socialNetworkList.setModel(socialNetworkListModel);
			}
			{
				socialUserTextField = new JTextField();
				socialUserTextField.setSize(178, 23);
			}
			{
				socialPasswordField = new JPasswordField();
			}
			{
				addSocialButton = new JButton();
				addSocialButton.setText("Add Social Event Description");
				handler=new AddSocialEventHandler();
				addSocialButton.addActionListener(handler);
			}
			{
				jSeparator1 = new JSeparator();
			}
			{
				jSeparator2 = new JSeparator();
			}
			thisLayout.setVerticalGroup(thisLayout.createSequentialGroup()
				.addContainerGap(22, 22)
				.addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				.addGap(29)
				.addGroup(thisLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				    .addComponent(socialNetworkList, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				    .addComponent(jLabel2, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
				.addGroup(thisLayout.createParallelGroup()
				    .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				        .addComponent(jSeparator1, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
				        .addComponent(jLabel3, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 0, Short.MAX_VALUE))
				    .addComponent(socialUserTextField, GroupLayout.Alignment.LEADING, 0, 23, Short.MAX_VALUE))
				.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
				.addGroup(thisLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				    .addComponent(socialPasswordField, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
				    .addComponent(jLabel4, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(72)
				.addComponent(jSeparator2, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
				.addComponent(addSocialButton, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				.addContainerGap(99, 99));
			thisLayout.setHorizontalGroup(thisLayout.createSequentialGroup()
				.addContainerGap()
				.addGroup(thisLayout.createParallelGroup()
				    .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				        .addGroup(thisLayout.createParallelGroup()
				            .addComponent(jLabel4, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
				            .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				                .addGap(25)
				                .addComponent(jSeparator1, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				                .addGap(70)))
				        .addGap(10)
				        .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 269, GroupLayout.PREFERRED_SIZE)
				        .addGap(0, 0, Short.MAX_VALUE))
				    .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				        .addGroup(thisLayout.createParallelGroup()
				            .addComponent(jLabel3, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
				            .addComponent(jLabel2, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE))
				        .addGroup(thisLayout.createParallelGroup()
				            .addComponent(addSocialButton, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 199, GroupLayout.PREFERRED_SIZE)
				            .addGroup(thisLayout.createSequentialGroup()
				                .addGap(21)
				                .addGroup(thisLayout.createParallelGroup()
				                    .addComponent(socialPasswordField, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 178, GroupLayout.PREFERRED_SIZE)
				                    .addComponent(socialUserTextField, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 178, GroupLayout.PREFERRED_SIZE)
				                    .addComponent(socialNetworkList, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 178, GroupLayout.PREFERRED_SIZE))))
				        .addComponent(jSeparator2, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				        .addGap(0, 50, Short.MAX_VALUE)))
				.addContainerGap(88, 88));
			pack();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private class AddSocialEventHandler implements ActionListener
	{
	    // process color and font selections
	    public void actionPerformed( ActionEvent event )
	    {
	    	addTwitter = new AddTwitterJFrame(userName, socialUserTextField.getText(), socialPasswordField.getText());
			addTwitter.setLocationRelativeTo(null);
			addTwitter.setVisible(true);
			
			javax.swing.JFrame t = (JFrame) addSocialButton.getParent().getParent().getParent().getParent();
			t.dispose();
	    }
	}

}
