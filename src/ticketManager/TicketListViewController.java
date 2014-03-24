package ticketManager;

//import org.eclipse.swt.SWT;
//import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Composite;
//import org.eclipse.swt.widgets.Display;
//import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

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
