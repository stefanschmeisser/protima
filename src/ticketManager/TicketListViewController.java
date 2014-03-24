package ticketManager;

import org.eclipse.swt.widgets.*;

public class TicketListViewController implements ITicketState, ITicketObserver {

	private TicketListView tlv;
	//private Composite composite;
	
	public TicketListViewController(Shell shell){
		
		tlv = new TicketListView(shell);
		
		//composite = new Composite(shell, SWT.NONE);
	}

	public void setComposite(Composite comp) {
		this.tlv.setComposite(comp);
	}

	public Composite getComposite() {
		return this.tlv.getComposite();
	}
	
}
