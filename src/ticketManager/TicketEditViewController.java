package ticketManager;

import org.eclipse.swt.widgets.*;

public class TicketEditViewController implements ITicketState  {
	
	private TicketEditView tev;
	private TicketViewController tvc;
	private Shell shell;
	private ITicketDao ticketDao;
	private Listener btnListener;
	
	// ------------------------------------------------------------------------
	
	public TicketEditViewController(TicketViewController tvc, Shell shell, ITicketDao ticketDao){
		
		this.tvc = tvc;
		this.shell = shell;
		this.ticketDao = ticketDao;
	}

	// ------------------------------------------------------------------------
	
	@Override
	public void show() {
		
		this.btnListener = new Listener() {
			public void handleEvent(Event event) {
				if (event.widget == tev.btnSave) {
					System.out.println("Save");
				}
				if (event.widget == tev.btnUndo) {
					System.out.println("Create");
				}
				if (event.widget == tev.btnCancel) {
					System.out.println("Cancel");
					tvc.setCurrentView(tvc.getTicketListViewController());
				}
			}
		};
		
		
		tev = new TicketEditView(shell, btnListener);
	}	
	
	// ------------------------------------------------------------------------
	
	public Composite getComposite() {
		return this.tev.getComposite();
	}
	
	// ------------------------------------------------------------------------
}