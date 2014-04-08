package ticketManager;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;

public class TicketDetailViewController implements ITicketState, ITicketObserver {

	private TicketDetailView tdv;
	
	public TicketDetailViewController(Shell shell){
		
		tdv = new TicketDetailView(shell);
	}
	
	public void setComposite(Composite comp) {
		this.tdv.setComposite(comp);
	}

	public Composite getComposite() {
		return this.tdv.getComposite();
	}
	
}