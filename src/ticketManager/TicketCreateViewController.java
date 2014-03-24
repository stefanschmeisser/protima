package ticketManager;

import org.eclipse.swt.widgets.*;

public class TicketCreateViewController implements ITicketState {

	private TicketCreateView tcv;
	private Listener listener;
	
	public TicketCreateViewController(Shell shell){
		
		listener = new Listener() {
			public void handleEvent(Event event) {
				if (event.widget == tcv.btnStart) {
					System.out.println("Button Start auf TicketCreateView (nur zum TEST)");
				}
			}
		};
		
		tcv = new TicketCreateView(shell, listener);
	}

	public void setComposite(Composite comp) {
		this.tcv.setComposite(comp);
	}

	public Composite getComposite() {
		return this.tcv.getComposite();
	}
	

}
