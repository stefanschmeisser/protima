package ticketManager;

import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;
import org.eclipse.swt.*;
import org.eclipse.swt.events.*;
import org.eclipse.swt.widgets.*;

public class TicketListViewController implements ITicketState {

	private Composite composite;
	private Shell msgBoxShell;
	private TicketListView tlv;
	private TicketViewController tvc;
	private ITicketDao ticketDao;
	private Listener listener;
	private Vector observers;
	private String ticketId, ticketTitle, ticketDescription, ticketStartDate, ticketEndeDate, ticketPriorityLevel, ticketProjectId, ticketTeamId, ticketProcessStatus, ticketEditorId;
	

	public TicketListViewController(TicketViewController ticketViewController, Composite composite, ITicketDao ticketDao){
		
		this.tvc = ticketViewController;
		this.composite = composite;
		this.ticketDao = ticketDao;
		
		observers = new Vector();
	}
	
	// ------------------------------------------------------------------------
	
	@Override
	public void show() {

		this.listener = new Listener() {
			public void handleEvent(Event event) {
				if (event.widget == tlv.btnRefresh) {
//					System.out.println("Refresh");
					fillTableData();
				}
				if (event.widget == tlv.btnCreate) {
//					System.out.println("Create");
					tvc.setCurrentView(tvc.getTicketCreateViewController());
				}
				if (event.widget == tlv.btnEdit) {
					System.out.println("Edit");
					tvc.setCurrentView(tvc.getTicketEditViewController());
				}
				if (event.widget == tlv.btnDelete) {
//					System.out.println("Delete");
					deleteTicket();
					fillTableData();
				}
				// Table Listener
				if(event.widget == tlv.getTable()){
					getSelectedTableItem();
				}	
			}
		};
		
		tlv = new TicketListView(this.composite, this.listener);
		this.fillTableData();
		this.composite.layout();
	}

	// ------------------------------------------------------------------------
	
	@Override
	public Composite getComposite() {
		// TODO Auto-generated method stub
		return this.tlv.getComposite();
	}
	
	// ------------------------------------------------------------------------
	
	private void refreshTableData(){
		
		tlv.getTable().setRedraw( false );
		
		while ( tlv.getTable().getColumnCount() > 0 ) {
			tlv.getTable().getColumns()[ 0 ].dispose();
		}
		
		tlv.getTable().setItemCount(0);
		tlv.getTable().setRedraw( true );
	}
	
	// ------------------------------------------------------------------------
	
	public void fillTableData(){

		this.refreshTableData();
		
		TicketTableModel tableModel = this.ticketDao.selectTableModel("*", "ticket", "");
		
		if(tableModel != null){
			
			ArrayList<String> columnNames = tableModel.getColumnNames();
			ArrayList<Vector> rows = tableModel.getRows();

			// set column header names
			for(int i = 0; i < columnNames.size(); i++){
				TableColumn tc = new TableColumn(tlv.getTable(), SWT.LEFT);
				tc.setText(columnNames.get(i).toString());
				//tc.setWidth(100);
			}

			//set row data
			for(int i = 0; i < rows.size(); i++){

				Vector v = new Vector();
				v = rows.get(i);

				TableItem ti = new TableItem(tlv.getTable(), SWT.NONE);

				for(int j = 0; j < v.size(); j++){
					ti.setText(j, v.get(j).toString());
				}
			}

			// set column width automatically
			for (int i=0; i<columnNames.size(); i++) {
				tlv.getTable().getColumn(i).pack ();
			}	
		}
	}
	
	// ------------------------------------------------------------------------
	
	private void deleteTicket(){

		boolean isSelected = false;
		
		for(int i = 0; i < tlv.getTable().getItemCount(); i++){
			if(tlv.getTable().isSelected(i)){
				isSelected = true;
			}
		}
		
		if(isSelected){
			
			MessageBox dialog = new MessageBox(this.msgBoxShell, SWT.APPLICATION_MODAL | SWT.OK| SWT.CANCEL);
			dialog.setText("Delete Ticket");
			dialog.setMessage("Are you sure?");

			// open dialog and await user selection
			int returnCode = dialog.open();
				
			if(returnCode == 32){
				TableItem[] ti = tlv.getTable().getSelection();
				this.ticketDao.deleteTicket(ti[0].getText(0));
				isSelected = false;
			}
			else{
				System.out.println("Aborted by user.");
			}
		}
	}

	// ------------------------------------------------------------------------
	
	public void getSelectedTableItem(){
		
		TableItem[] ti = tlv.getTable().getSelection();
		
		String str = "";
//		for(int i = 0; i < tlv.getTable().getColumnCount(); i++){
//			str = str + ti[0].getText(i) + ", ";
//			
//			this.ticketId = ti[0].getText(i);
//		}
		
		this.ticketId = ti[0].getText(0);
		this.ticketTitle = ti[0].getText(1);
		this.ticketDescription = ti[0].getText(2);
		this.ticketStartDate = ti[0].getText(3);
		this.ticketEndeDate = ti[0].getText(4);
		this.ticketPriorityLevel = ti[0].getText(5);
		this.ticketProjectId = ti[0].getText(6);
		this.ticketTeamId = ti[0].getText(7);
		this.ticketEditorId = ti[0].getText(8);
		this.ticketProcessStatus = ti[0].getText(9);
		
	
		this.notifyObserver();
	}
	

	// ------------------------------------------------------------------------
	
	public void notifyObserver(){
		for (int i=0; i< observers.size(); i++) {
			((ITicketObserver)(observers.elementAt(i))).update();
		}
	}
	
	// ------------------------------------------------------------------------
	
	public void attachObserver(ITicketObserver obs){
		observers.addElement(obs);
		System.out.println("Observer registration");
	}
	
	// ------------------------------------------------------------------------
	
	public void detachObserver(ITicketObserver obs){
		observers.removeElement(obs);
		System.out.println("Observer deregistration");
	}
	
	// ------------------------------------------------------------------------
	
	// GETTERS

	public String getTicketId(){
		return this.ticketId;
	}
	
	public String getTicketTitle(){
		return this.ticketTitle;
	}

	public String getTicketDescription(){
		return this.ticketDescription;
	}

	public String getTicketPriorityLevel(){
		return this.ticketPriorityLevel;
	}

	public String getTicketProcessStatus(){
		return this.ticketProcessStatus;
	}

	public String getTicketProjectId(){
		return this.ticketProjectId;
	}

	public String getTicketCurrentEditorUid(){
		return this.ticketEditorId;
	}

	public String getTicketAssignedTeam(){
		return this.ticketTeamId;
	}

	public ArrayList<Integer> getTicketStartDate(){
		
		String[] singleStrings =  this.ticketStartDate.split("-");
		// cast string to int and add it to the arraylist
		ArrayList<Integer> date = new ArrayList<Integer>();
		date.add(Integer.parseInt(singleStrings[0]));
		date.add(Integer.parseInt(singleStrings[1]));
		date.add(Integer.parseInt(singleStrings[2]));
		return date;
	}

	public  ArrayList<Integer> getTicketEndDate(){
		String[] singleStrings =  this.ticketStartDate.split("-");
		// cast string to int and add it to the arraylist
		ArrayList<Integer> date = new ArrayList<Integer>();
		date.add(Integer.parseInt(singleStrings[0]));
		date.add(Integer.parseInt(singleStrings[1]));
		date.add(Integer.parseInt(singleStrings[2]));
		return date;
	}
}
