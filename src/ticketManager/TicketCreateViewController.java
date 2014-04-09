package ticketManager;

import java.util.ArrayList;
import java.util.Vector;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.*;

public class TicketCreateViewController implements ITicketState {

	private TicketViewController tvc;
	private TicketCreateView tcv;
	private Shell shell;
	private Listener btnListener;
	private ITicketDao ticketDao;
	
	// ------------------------------------------------------------------------
	
	public TicketCreateViewController(TicketViewController ticketViewController, Shell shell, ITicketDao ticketDao){
		
		this.shell = shell;
		this.tvc = ticketViewController;
		this.ticketDao = ticketDao;
	}

	// ------------------------------------------------------------------------
	
	@Override
	public void show() {
		
		this.btnListener = new Listener() {
			public void handleEvent(Event event) {
				if (event.widget == tcv.btnClear) {
					System.out.println("Clear");
				}
				if (event.widget == tcv.btnCreate) {
					System.out.println("Create");
					createTicket();
					tvc.setCurrentView(tvc.getTicketListViewController());
				}
				if (event.widget == tcv.btnCancel) {
					System.out.println("Cancel");
					tvc.setCurrentView(tvc.getTicketListViewController());
				}
			}
		};

		tcv = new TicketCreateView(this.shell, this.btnListener);
		
		this.setTeamCombobox();
		
		this.shell.layout();
	}
	
	// ------------------------------------------------------------------------
	
	public Composite getComposite() {
		return this.tcv.getComposite();
	}
	
	// ------------------------------------------------------------------------
	
	private void setTeamCombobox(){
	
		TicketTableModel tableModel = this.ticketDao.selectTableModel("*", "team", "");
		ArrayList<String> str = new ArrayList<String>();
	
		if(tableModel != null){
			ArrayList<Vector> rows = tableModel.getRows();

			for(int i = 0; i < rows.size(); i++){
				Vector v = new Vector();
				str.add(v.get(0).toString());
//				System.out.println("test: " + v.get(0).toString());
			}
		}
		System.out.println(str);
//		this.tcv.setTicketAssignedTeam(str);
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
		
		this.ticketDao.insertTicket(values);
	}
}
