package visual;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

import logical.SoftwareCompany;

public class Render extends DefaultTableCellRenderer {
	
	
	private int columna;
	
	public Render(int columna) {
		this.columna=columna;
	}

	@Override
	public Component getTableCellRendererComponent (JTable table, Object value, boolean selected, boolean focused, int row, int column) {        
	    setBackground(Color.white);
	    table.setForeground(Color.black);
	    super.getTableCellRendererComponent(table, value, selected, focused, row, column);
	    if(table.getValueAt(row,columna).equals("Prorrogado")){
	        this.setBackground(new Color(  251, 88, 74  ));
	    }else if(table.getValueAt(row,columna).equals("Terminado")) {
	    	this.setBackground(new Color(156, 252, 131));
	    	
	    }else if(table.getValueAt(row,columna).equals("En Proceso")) {
	    	this.setBackground(new Color( 250, 209, 40 ));
	    	
	    }
	    return this;
	  }
	
	

	

}
