package ticketManager;

import org.eclipse.swt.widgets.*;

public class TicketCreateViewController implements ITicketState {

	private TicketCreateView tcv;
	private Shell shell;
	private Listener listener;
	
	// ------------------------------------------------------------------------
	
	public TicketCreateViewController(Shell shell){
		
		this.shell = shell;
		
		this.listener = new Listener() {
			public void handleEvent(Event event) {
//				if (event.widget == tcv.btnStart) {
//					System.out.println("Button Start auf TicketCreateView (nur zum TEST)");
//				}
			}
		};
	}

	// ------------------------------------------------------------------------
	
	@Override
	public void show() {
		// TODO Auto-generated method stub
		tcv = new TicketCreateView(this.shell, listener);
		this.shell.layout();
	}
	
	// ------------------------------------------------------------------------
	
	public Composite getComposite() {
		return this.tcv.getComposite();
	}
}
