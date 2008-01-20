package client;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.EventObject;
import java.util.Hashtable;

import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.event.CellEditorListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;

/**
 * @version 1.1 09/09/99
 */
public class EachRowEditorExample extends JFrame {
  public EachRowEditorExample() {
    super("EachRow Editor Example");

    DefaultTableModel dm = new DefaultTableModel();
    dm.setDataVector(new Object[][] { { "Name", "MyName" },
        { "Gender", "Male" } }, new Object[] { "Nume", "ID" });

    JTable table = new JTable(dm);
/*    JComboBox comboBox = new JComboBox();
    comboBox.addItem("Male");
    comboBox.addItem("Female");
    comboBox.addComponentListener(new ComponentAdapter() {
      public void componentShown(ComponentEvent e) {
        final JComponent c = (JComponent) e.getSource();
        SwingUtilities.invokeLater(new Runnable() {
          public void run() {
            c.requestFocus();
            System.out.println(c);
            if (c instanceof JComboBox) {
              System.out.println("a");
            }
          }
        });
      }
    });
*/
    //table.selectAll();
    table.setRowSelectionInterval(0, 0);
    
    table.setCellSelectionEnabled(true);
    RowEditor rowEditor = new RowEditor(table);

    /*rowEditor.setEditorAt(1, new DefaultCellEditor(comboBox));
    table.getColumn("Column2").setCellEditor(rowEditor);
*/
    JScrollPane scroll = new JScrollPane(table);
    table.getColumn("Nume").setCellEditor(rowEditor);
    table.getColumn("ID").setCellEditor(rowEditor);
    getContentPane().add(scroll, BorderLayout.CENTER);
    setSize(400, 100);
    setVisible(true);
  }
}

/**
 * each row TableCellEditor
 * 
 * @version 1.1 09/09/99
 * @author Nobuo Tamemasa
 */

class RowEditor implements TableCellEditor {
  protected ArrayList<String> celuleModificate;
  protected Hashtable editors;
  protected TableCellEditor defaultEditor;
  private boolean isEditable = true;
  JTable table;

  /**
   * Constructs a EachRowEditor. create default editor
   * 
   * @see TableCellEditor
   * @see DefaultCellEditor
   */
  public RowEditor(JTable table) {
    this.table = table;
    
    editors = new Hashtable();
    celuleModificate = new ArrayList<String>();
    JTextField field = new JTextField();
    field.addKeyListener(new KeyListener()
    {
    	public void keyPressed(KeyEvent e) {
    		// TODO Auto-generated method stub
    		if(e.getKeyCode() == KeyEvent.VK_ENTER)
    		{
    			addToCollection();
    		}
    	}
    	public void keyReleased(KeyEvent e) {
    		// TODO Auto-generated method stub
    	}
    	public void keyTyped(KeyEvent e) {
    		// TODO Auto-generated method stub
    	}
    	
    });
    defaultEditor = new DefaultCellEditor(field);
    table.addKeyListener(new KeyListener()
    {
    	public void keyPressed(KeyEvent e) {
    		// TODO Auto-generated method stub
    		ignoreTyping();
    	}
    	public void keyReleased(KeyEvent e) {
    		// TODO Auto-generated method stub
    		if (e.getKeyChar() == KeyEvent.VK_ENTER) {
    			//stopCellEditing();
    		}
    	}
    	
    	public void keyTyped(KeyEvent e) {
    		// TODO Auto-generated method stub
    		
    	}
    });
  }

  /**
   * @param row
   *            table row
   * @param editor
   *            table cell editor
   */
  public void setEditorAt(int row, TableCellEditor editor) {
    editors.put(new Integer(row), editor);
  }

  public Component getTableCellEditorComponent(JTable table, Object value,
      boolean isSelected, int row, int column) {
    //editor = (TableCellEditor)editors.get(new Integer(row));
    //if (editor == null) {
    //  editor = defaultEditor;
    //}
    return  defaultEditor.getTableCellEditorComponent(table, value, isSelected, row, column);//editor.getTableCellEditorComponent(table, value, isSelected,   row, column);
  }

  public Object getCellEditorValue() {
	
    return defaultEditor.getCellEditorValue();
  }

  public boolean stopCellEditing() 
  {
	//validare nume
	  addToCollection();
	 
    return defaultEditor.stopCellEditing();
  }

  public void cancelCellEditing() {
    defaultEditor.cancelCellEditing();
  }

  public boolean isCellEditable(EventObject anEvent) 
  {
	  if(!isEditable)
		  return false;
	  try
      {
		  MouseEvent e = (MouseEvent) anEvent;
		  int row = table.rowAtPoint(e.getPoint());
		  int column = table.columnAtPoint(e.getPoint());
		  if(table.getColumnName(column).equalsIgnoreCase("Nume"))
		  {
			  return defaultEditor.isCellEditable(anEvent);
		  }
		  else
		  {
			  return false;
		  }
	  }
	  catch (Exception e) 
	  {
		// TODO: handle exception
		  return false;
	}

  
    //;
  }

  public void addCellEditorListener(CellEditorListener l) {
    defaultEditor.addCellEditorListener(l);
  }

  public void removeCellEditorListener(CellEditorListener l) {
    defaultEditor.removeCellEditorListener(l);
  }

  public boolean shouldSelectCell(EventObject anEvent) {
/*    selectEditor((MouseEvent) anEvent);
    return defaultEditor.shouldSelectCell(anEvent);*/
	  return true;
  }

  protected boolean selectEditor(MouseEvent e) {
    int row,column;
    column = table.getSelectedColumn();

    if (e == null) {

      row = table.getSelectionModel().getAnchorSelectionIndex();
    } else {
      row = table.rowAtPoint(e.getPoint());
    }
    defaultEditor = (TableCellEditor) editors.get(new Integer(row));
    if (defaultEditor == null) 
    {
      defaultEditor = defaultEditor;
    }
   try
   {
    if(((String)(table.getColumnModel().getColumn(column).getHeaderValue())).equalsIgnoreCase("Nume"))
    {
    	return true;
    }
    else
    {
    	   return false;
    }
   }
   catch (Exception exc) {
	   return false;
	// TODO: handle exception
   }

  }
  
  public void addToCollection()
  {
	  String comanda = table.getSelectedRow() + " '" + ((JTextField)table.getEditorComponent()).getText() + "'";
	  System.out.println(comanda);
	  celuleModificate.add(comanda);
  }
  
  public void ignoreTyping()
  {
	  try
	  {
		int row = table.getSelectedRow();
		int column = table.getColumn("ID").getModelIndex();
		table.setValueAt(table.getValueAt(row, column), row, column);
	  }
	  catch (Exception e) {
		// TODO: handle exception
	}
  }
  
  public void isEditable(boolean value)
  {
	  this.isEditable = value;
  }
  
  public ArrayList<String> getCeluleModificate() 
  {
	  for(String s: celuleModificate)
	  {
		  System.out.println(s);
	  }
	return celuleModificate;
  }
}

