package ticketManager;

import java.util.ArrayList;
import java.util.Vector;

public class TicketTableModel {

	private ArrayList<String> columnNames = new ArrayList<String>(); 
	private ArrayList<Vector> rows = new ArrayList<Vector>();
	
	public TicketTableModel(ArrayList<String> columnNames, ArrayList<Vector> rows){
		
		this.columnNames = columnNames;
		this.rows = rows;
	}
	
	// ------------------------------------------------------------------------
	
	public ArrayList<String> getColumnNames(){
		return this.columnNames;
	}
	
	// ------------------------------------------------------------------------
	
	public ArrayList<Vector> getRows(){
		return this.rows;
	}
}
