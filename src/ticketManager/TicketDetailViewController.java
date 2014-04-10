package ticketManager;

import org.eclipse.swt.widgets.*;

public class TicketDetailViewController implements ITicketState, ITicketObserver {

	private TicketDetailView tdv;
	private TicketListViewController tlvc;
	private Listener btnListener;
	private TicketViewController tvc;
	private ITicketDao ticketDao;
	private Shell shell;
	
	
	public TicketDetailViewController(TicketViewController tvc, Shell shell, ITicketDao ticketDao){

		this.tvc = tvc;
		this.shell = shell;
		this.ticketDao = ticketDao;
		
		// Observer Registration
		this.tlvc = (TicketListViewController)this.tvc.getTicketListViewController();
		tlvc.attachObserver(this);

		this.btnListener = new Listener() {
			public void handleEvent(Event event) {
				if (event.widget == tdv.btnEdit) {
					System.out.println("Edit");
				}
				if (event.widget == tdv.btnCancel) {
					System.out.println("Cancel");
				}
			}
		};

		
	}
	
	// ------------------------------------------------------------------------
	
	@Override
	public void show() {
		tdv = new TicketDetailView(shell, btnListener);
	}

	// ------------------------------------------------------------------------
	
	@Override
	public Composite getComposite() {
		return this.tdv.getComposite();
	}

	// ------------------------------------------------------------------------
	
	// OBSERVER UPDATE
	@Override
	public void update(){
		
		tdv.setTicketId(tlvc.getTicketId());
		tdv.setTicketTitle(tlvc.getTicketTitle());
		tdv.setTicketDescription(tlvc.getTicketDescription());
		tdv.setTicketStartDate(tlvc.getTicketStartDate());
		tdv.setTicketEndDate(tlvc.getTicketEndDate());
		tdv.setTicketPriorityLevel(tlvc.getTicketPriorityLevel());
		tdv.setTicketAssignedTeam(tlvc.getTicketAssignedTeam());
		tdv.setTicketProjectId(tlvc.getTicketProjectId());
		tdv.setTicketProcessStatus(tlvc.getTicketProcessStatus());
		tdv.setTicketCurrentEditorUid(tlvc.getTicketCurrentEditorUid());
		
	}
}