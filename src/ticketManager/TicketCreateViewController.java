package ticketManager;

import java.util.ArrayList;
import java.util.Vector;
import org.eclipse.swt.widgets.*;

public class TicketCreateViewController implements ITicketState {

	private TicketViewController tvc;
	private TicketCreateView tcv;
	private Composite composite;
	private Listener btnListener;
	private ITicketDao ticketDao;
	
	// ------------------------------------------------------------------------
	
	public TicketCreateViewController(TicketViewController ticketViewController, Composite composite, ITicketDao ticketDao){
		
		this.composite = composite;
		this.tvc = ticketViewController;
		this.ticketDao = ticketDao;
	}

	// ------------------------------------------------------------------------
	
	@Override
	public void show() {
		
		this.btnListener = new Listener() {
			public void handleEvent(Event event) {
				if (event.widget == tcv.btnClear) {
//					System.out.println("Clear");
				}
				if (event.widget == tcv.btnCreate) {
//					System.out.println("Create");
					createTicket();
					tvc.setCurrentView(tvc.getTicketListViewController(), false);
				}
				if (event.widget == tcv.btnCancel) {
//					System.out.println("Cancel");
					tvc.setCurrentView(tvc.getTicketListViewController(), false);
				}
			}
		};

		tcv = new TicketCreateView(this.composite, this.btnListener);
		
		this.setCombobox("team");
		this.setCombobox("project");
		this.setCombobox("user");
		
		this.composite.layout();
	}
	
	// ------------------------------------------------------------------------
	
	public Composite getComposite() {
		return this.tcv.getComposite();
	}
	
	// ------------------------------------------------------------------------
	
	private void setCombobox(String table){
	
		TicketTableModel tableModel = this.ticketDao.selectTableModel("*", table, "");
		ArrayList<String> str = new ArrayList<String>();
		
		
		if(tableModel != null){
			ArrayList<Vector> rows = tableModel.getRows();

			for(int i = 0; i < rows.size(); i++){

				Vector v = new Vector();
				v = rows.get(i);
				str.add(v.get(0).toString());
			}

			if(table.equals("team")){
				this.tcv.setTicketAssignedTeam(str);
			}
			if(table.equals("project")){
				this.tcv.setTicketProjectId(str);
			}
			if(table.equals("user")){
				this.tcv.setCurrentEditorUIDInput(str);
			}
		}
	}
	
	// ------------------------------------------------------------------------
	
	private void createTicket(){
		
		ArrayList<String> values = new ArrayList<String>();
		
		values.add(tcv.getTicketTitle());
		values.add(tcv.getTicketDescription());
		values.add(tcv.getTicketStartDate());
		values.add(tcv.getTicketEndDate());
		values.add(tcv.getTicketPriorityLevel());
		values.add(tcv.getTicketProjectId());
		values.add(tcv.getTicketAssignedTeam());
		values.add(tcv.getTicketCurrentEditorUid());
		values.add(tcv.getTicketProcessStatus());
		
		this.tvc.getTicketController().createTicket(values);
//		this.ticketDao.insertTicket(values);
	}
}
