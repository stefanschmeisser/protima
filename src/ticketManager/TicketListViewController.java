package ticketManager;

import java.util.ArrayList;
import java.util.Vector;

import org.eclipse.swt.*;
import org.eclipse.swt.widgets.*;

public class TicketListViewController implements ITicketState, ITicketObserver {

	private Shell shell;
	private TicketListView tlv;
	private TicketViewController tvc;
	private ITicketDao ticketDao;
	private Listener listener;
	
	public TicketListViewController(TicketViewController ticketViewController, Shell shell, ITicketDao ticketDao){
		
		this.tvc = ticketViewController;
		this.shell = shell;
		
		this.listener = new Listener() {
			public void handleEvent(Event event) {
				if (event.widget == tlv.btnRefresh) {
					System.out.println("Refresh");
					fillTableData();
				}
				if (event.widget == tlv.btnCreate) {
					System.out.println("Create");
					tvc.setCurrentView(tvc.getTicketCreateViewController());
				}
				if (event.widget == tlv.btnEdit) {
					System.out.println("Edit");
				}
				if (event.widget == tlv.btnDelete) {
					System.out.println("Delete");
				}
				// Table Listener
				if(event.widget == tlv.getTable()){
					getSelectedTableItem();
				}	
			}
		};
		
		// get the TicketDao (Type of Interface ITicketDao)
		this.ticketDao = ticketDao;
	}
	
	// ------------------------------------------------------------------------
	@Override
	public void show() {
		// TODO Auto-generated method stub
		tlv = new TicketListView(this.shell, this.listener);
		this.fillTableData();
		this.shell.layout();
	}

	// ------------------------------------------------------------------------
	
	@Override
	public Composite getComposite() {
		// TODO Auto-generated method stub
		return this.tlv.getComposite();
	}

	// ------------------------------------------------------------------------
	
	public void fillTableData(){
		
		tlv.getTable().setItemCount(0);
		
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
	
	public void getSelectedTableItem(){
		
		TableItem[] ti = tlv.getTable().getSelection();
		
		String str = "";
		for(int i = 0; i < tlv.getTable().getColumnCount(); i++){
			str = str + ti[0].getText(i) + ", ";
			
		}
		System.out.println(str);
	}
}
