import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.GroupLayout;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle;

import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
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
public class ViewEventsJFrame extends javax.swing.JFrame {
	private JScrollPane jScrollPane1;
	private JTable eventTable;
	private JLabel jLabel1;
	private String userName;
	
	private Connection conn=null;
	private Statement stmt;
	private ResultSet rs=null;
	private String events[][];
	
	/**
	* Auto-generated main method to display this JFrame
	*/
	/*public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				ViewEventsJFrame inst = new ViewEventsJFrame();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}*/
	
	public ViewEventsJFrame(String user) {
		super("View Events");
		userName=new String(user);
		initGUI();
	}
	
	private void initGUI() {
		try {
			GroupLayout thisLayout = new GroupLayout((JComponent)getContentPane());
			getContentPane().setLayout(thisLayout);
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			int count;
			
			try
			{
    			conn=DriverManager.getConnection("jdbc:mysql://localhost/db1?"+"user=root&password=munir");
    			stmt=conn.createStatement();
    			
    			stmt.execute("select event_type,view_condition,notification from viewevents where username=\'"+userName+"\'");
    			rs = stmt.getResultSet();
    			
    			count=0;
    			while(rs.next()){
    				count++;
    			}
    			
    			stmt.execute("select event_type,view_condition,notification from viewevents where username=\'"+userName+"\'");
    			rs = stmt.getResultSet();
    			events=new String[count][3];
    			count=0;
    			
    			while(rs.next()){
    				events[count][0]=rs.getString(1);
    				events[count][1]=rs.getString(2);
    				events[count][2]=rs.getString(3);
    				count++;
    			}
    			
				conn.close();
    		}
    		
    		catch(Exception e){
    			
    		}
    		
			{
				jScrollPane1 = new JScrollPane();
				{
					TableModel eventTableModel = 
						new DefaultTableModel(
								events,
								new String[] { "Type", "Condition", "Notification"});
					
					eventTable = new JTable();
					jScrollPane1.setViewportView(eventTable);
					eventTable.setModel(eventTableModel);
					eventTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
					
					int vColIndex,width;
					
					vColIndex= 0;
				    TableColumn col = eventTable.getColumnModel().getColumn(vColIndex);
				    width = 100;
				    col.setPreferredWidth(width);
				    
				    vColIndex= 1;
				    col = eventTable.getColumnModel().getColumn(vColIndex);
				    width = 500;
				    col.setPreferredWidth(width);
				    
				    vColIndex= 2;
				    col = eventTable.getColumnModel().getColumn(vColIndex);
				    width = 100;
				    col.setPreferredWidth(width);
				}
			}
			{
				jLabel1 = new JLabel();
				jLabel1.setText("View All Events");
				jLabel1.setFont(new java.awt.Font("Tahoma",1,11));
			}
			thisLayout.setVerticalGroup(thisLayout.createSequentialGroup()
				.addContainerGap(20, 20)
				.addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				.addGap(26)
				.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 338, GroupLayout.PREFERRED_SIZE)
				.addContainerGap(68, Short.MAX_VALUE));
			thisLayout.setHorizontalGroup(thisLayout.createSequentialGroup()
				.addContainerGap(33, 33)
				.addGroup(thisLayout.createParallelGroup()
				    .addGroup(thisLayout.createSequentialGroup()
				        .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 527, GroupLayout.PREFERRED_SIZE)
				        .addGap(0, 0, Short.MAX_VALUE))
				    .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				        .addGap(217)
				        .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 171, GroupLayout.PREFERRED_SIZE)
				        .addGap(0, 139, Short.MAX_VALUE)))
				.addContainerGap(32, 32));
			pack();
			setSize(600, 500);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
