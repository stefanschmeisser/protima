package ticketManager;

import org.eclipse.swt.widgets.*;

public class TicketCreateViewController implements ITicketState {

	private TicketCreateView tcv;
	
	public TicketCreateViewController(Shell shell){
		
		tcv = new TicketCreateView(shell);
	}

	public void setComposite(Composite comp) {
		this.tcv.setComposite(comp);
	}

	public Composite getComposite() {
		return this.tcv.getComposite();
	}
	

}
