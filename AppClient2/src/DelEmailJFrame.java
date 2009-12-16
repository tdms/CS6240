import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.DefaultCellEditor;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle;
import javax.swing.UIManager;

import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;
import javax.swing.SwingUtilities;

import javax.swing.table.*;
import java.util.*;

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
public class DelEmailJFrame extends javax.swing.JFrame {
	private JScrollPane jScrollPane1;
	private JButton jButton1;
	private JLabel jLabel1;
	private JTable emailTable;
	private static String userName;

	private Connection conn=null;
	private Statement stmt;
	private ResultSet rs=null,rs1=null;
	private Object events[][];
	private int rowToDel;
	
	/**
	* Auto-generated main method to display this JFrame
	*/
	/*public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				DelEmailJFrame inst = new DelEmailJFrame();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}*/
	
	public DelEmailJFrame(int row) {
		rowToDel=row;
	}
	
	
	public DelEmailJFrame(String username) {
		super("Delete Event");
		userName=new String(username);
		initGUI();
	}
	
	private void initGUI() {
		int count;
		
		try {
			GroupLayout thisLayout = new GroupLayout((JComponent)getContentPane());
			getContentPane().setLayout(thisLayout);
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			try
			{
    			conn=DriverManager.getConnection("jdbc:mysql://localhost/db1?"+"user=root&password=munir");
    			stmt=conn.createStatement();
    			
    			stmt.execute("select event_type,event_condition,notification from viewevents where username=\'"+userName+"\'");
    			rs = stmt.getResultSet();
    			
    			count=0;
    			while(rs.next()){
    				count++;
    			}
    			
    			stmt.execute("select event_type,view_condition,notification from viewevents where username=\'"+userName+"\'");
    			
    			rs = stmt.getResultSet();
    			    			
    			events=new String[count][4];
    			count=0;
    			
    			while(rs.next()){
    				events[count][0]="Delete Event "+count;
    				events[count][1]=rs.getString(1);
    				events[count][2]=rs.getString(2);
    				events[count][3]=rs.getString(3);
    				count++;
    			}
    			
				conn.close();
    		}
    		
    		catch(Exception e){
    			
    		}
			{
				jScrollPane1 = new JScrollPane();
				{
					TableModel emailTableModel = 
						new DefaultTableModel(
								events,
								new String[] { "Delete","Type","Condition", "Notification"});
					
					emailTable = new JTable();
					jScrollPane1.setViewportView(emailTable);
					emailTable.setModel(emailTableModel);
					emailTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
					
					int vColIndex = 0;
				    TableColumn col = emailTable.getColumnModel().getColumn(vColIndex);
				    int width = 150;
				    col.setPreferredWidth(width);
				    
				    vColIndex = 1;
				    col = emailTable.getColumnModel().getColumn(vColIndex);
				    width = 50;
				    col.setPreferredWidth(width);
				    
				    vColIndex = 2;
				    col = emailTable.getColumnModel().getColumn(vColIndex);
				    width = 500;
				    col.setPreferredWidth(width);
				    
				    
				    emailTable.getColumn("Delete").setCellRenderer(new ButtonRenderer());
				    emailTable.getColumn("Delete").setCellEditor(
				        new ButtonEditor(new JCheckBox()));
				}
			}
			{
				jButton1 = new JButton();
				jButton1.setText("jButton1");
				jButton1.setVisible(false);
			}
			{
				jLabel1 = new JLabel();
				jLabel1.setText("Delete Events");
			}
			thisLayout.setVerticalGroup(thisLayout.createSequentialGroup()
				.addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
				.addGap(12)
				.addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				.addGap(18)
				.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 231, GroupLayout.PREFERRED_SIZE)
				.addContainerGap(191, Short.MAX_VALUE));
			thisLayout.setHorizontalGroup(thisLayout.createSequentialGroup()
				.addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
				.addGap(30)
				.addGroup(thisLayout.createParallelGroup()
				    .addGroup(thisLayout.createSequentialGroup()
				        .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 394, GroupLayout.PREFERRED_SIZE)
				        .addGap(0, 0, Short.MAX_VALUE))
				    .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				        .addGap(153)
				        .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
				        .addGap(0, 113, Short.MAX_VALUE)))
				.addContainerGap(18, 18));
			pack();
			setSize(450, 500);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void DeleteRow(int row)
	{
		Connection conn1=null;
		Statement stmt1;
		ResultSet rs1=null;
		
		System.out.println("username: "+userName);
		System.out.println("here: row: "+rowToDel);
		int count;
		String stringToDel=null;
		
		try
			{
				//conn.close();
    			conn1=DriverManager.getConnection("jdbc:mysql://localhost/db1?"+"user=root&password=munir");
    			stmt1=conn1.createStatement();
    			
    			stmt1.execute("select event_type,event_condition from viewevents where username=\'"+userName+"\'");
    			rs1 = stmt1.getResultSet();
    			   			
    			System.out.println("here");
    			
    			count=0;
    			
    			while(rs1.next()){
    				//System.out.println("Stringtodel:1 "+rs1.getString(2));
    				if(row==count)
    				{
    					//System.out.println("Stringtodel:1 "+rs1.getString(2));
    					stringToDel=new String(rs1.getString(2));
    					break;
    				}
    				count++;
    			}
    			
    			//System.out.println("count: "+count);
    			
    			//System.out.println("Stringtodel:2 "+stringToDel);
    			stmt1.execute("delete from viewevents where event_condition=\'"+stringToDel+"\'");
    			stmt1.execute("delete from events where event_condition=\'"+stringToDel+"\'");
    			   			
    			JOptionPane.showMessageDialog(null, "Event sucessfully Deleted");
    			
    			/*Reload the table*/
    			
    			stmt1.execute("select event_type,event_condition,notification from viewevents where username=\'"+userName+"\'");
    			rs1 = stmt1.getResultSet();
    			
    			count=0;
    			while(rs1.next()){
    				count++;
    			}
    			
    			System.out.println("here: "+count);
    			stmt1.execute("select event_type,view_condition,notification from viewevents where username=\'"+userName+"\'");
    			
    			rs1 = stmt1.getResultSet();
    			    			
    			events=new String[count][4];
    			count=0;
    			
    			while(rs1.next()){
    				events[count][0]="Delete Event "+count;
    				events[count][1]=rs1.getString(1);
    				events[count][2]=rs1.getString(2);
    				events[count][3]=rs1.getString(3);
    				count++;
    			}
    			
    			System.out.println("here: "+count);
    			
    			TableModel emailTableModel = 
					new DefaultTableModel(
							events,
							new String[] { "Delete","Type","Condition", "Notification"});
				
    			System.out.println("here: "+count);
    			
    			emailTable = new JTable();
    			jScrollPane1 = new JScrollPane();
				jScrollPane1.setViewportView(emailTable);
				emailTable.setModel(emailTableModel);
				emailTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
				
				System.out.println("here: "+count);
				
				int vColIndex = 0;
			    TableColumn col = emailTable.getColumnModel().getColumn(vColIndex);
			    int width = 150;
			    col.setPreferredWidth(width);
			    
			    vColIndex = 1;
			    col = emailTable.getColumnModel().getColumn(vColIndex);
			    width = 50;
			    col.setPreferredWidth(width);
			    
			    vColIndex = 2;
			    col = emailTable.getColumnModel().getColumn(vColIndex);
			    width = 500;
			    col.setPreferredWidth(width);
			    
			    System.out.println("here: "+count);
			    
			    emailTable.getColumn("Delete").setCellRenderer(new ButtonRenderer());
			    emailTable.getColumn("Delete").setCellEditor(
			    new ButtonEditor(new JCheckBox()));
			    
			    
			    conn1.close();
    		}
    		
    		catch(Exception e){
    			
    			System.out.println("Exception: "+e);
		}
	}
}



class ButtonRenderer extends JButton implements TableCellRenderer 
{
	public ButtonRenderer() 
	{
		setOpaque(true);
	}

	public Component getTableCellRendererComponent(JTable table, Object value,boolean isSelected, boolean hasFocus, int row, int column) 
	{
	    if (isSelected) 
	    {
	      setForeground(table.getSelectionForeground());
	      setBackground(table.getSelectionBackground());
	    } 
	    else 
	    {
	      setForeground(table.getForeground());
	      setBackground(UIManager.getColor("Button.background"));
	    }
	    setText((value == null) ? "" : value.toString());
	    return this;
	}
}

class ButtonEditor extends DefaultCellEditor 
{
	 private DelEmailJFrame temp;
	 protected JButton button;
	 private String label;
	 private boolean isPushed;

	  public ButtonEditor(JCheckBox checkBox) 
	  {
		  super(checkBox);
		  button = new JButton();
		  button.setOpaque(true);
		  
		  button.addActionListener(new ActionListener() 
		  {
			  public void actionPerformed(ActionEvent e) {
				  fireEditingStopped();
			  }
		  });
	  }

	  public Component getTableCellEditorComponent(JTable table, Object value,boolean isSelected, int row, int column) 
	  {
		  if (isSelected) 
		  {
			  button.setForeground(table.getSelectionForeground());
			  button.setBackground(table.getSelectionBackground());
	      } 
		  else {
			  button.setForeground(table.getForeground());
			  button.setBackground(table.getBackground());
		  }
		  
		  label = (value == null) ? "" : value.toString();
		  button.setText(label);
		  isPushed = true;
		  
		  return button;
	  }

	  public Object getCellEditorValue() 
	  {
		  if (isPushed) 
		  {		       
		      //JOptionPane.showMessageDialog(button, label + ": Ouch!");
		      System.out.println("Level: "+label);
		      String str=label;
		      StringTokenizer tok=new StringTokenizer(str,"Delete Event");
		      int row=Integer.parseInt(tok.nextToken().trim());
		      System.out.println("Level: "+row);
		      temp=new DelEmailJFrame(row);
		      temp.DeleteRow(row);
		  }
		  isPushed = false;
		  
		  return new String(label);
	  }

	  public boolean stopCellEditing() 
	  {
		  isPushed = false;
		  return super.stopCellEditing();
	  }

	  protected void fireEditingStopped() 
	  {
		  super.fireEditingStopped();
	  }
}
