package ticketManager;

import org.eclipse.swt.widgets.*;

public class TicketDetailViewController implements ITicketState, ITicketObserver {

	private TicketDetailView tdv;
	private Listener btnListener;
	private TicketViewController tvc;
	private ITicketDao ticketDao;
	private Shell shell;
	
	public TicketDetailViewController(TicketViewController tvc, Shell shell, ITicketDao ticketDao){

		this.tvc = tvc;
		this.shell = shell;
		this.ticketDao = ticketDao;

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
	
	@Override
	public void show() {
		
		tdv = new TicketDetailView(shell, btnListener);
	}

	public Composite getComposite() {
		return this.tdv.getComposite();
	}


	
}