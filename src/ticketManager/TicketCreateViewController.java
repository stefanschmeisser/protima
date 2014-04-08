package ticketManager;

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
					tvc.setCurrentView(tvc.getTicketListViewController());
				}
				if (event.widget == tcv.btnCancel) {
					System.out.println("Cancel");
					tvc.setCurrentView(tvc.getTicketListViewController());
				}
			}
		};

		tcv = new TicketCreateView(this.shell, this.btnListener);
		
		this.shell.layout();
	}
	
	// ------------------------------------------------------------------------
	
	public Composite getComposite() {
		return this.tcv.getComposite();
	}
}
