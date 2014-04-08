package ticketManager;

import org.eclipse.swt.widgets.*;

public class TicketEditViewController implements ITicketState  {

	private TicketEditView tev;
	
	public TicketEditViewController(Shell shell){
		
		tev = new TicketEditView(shell);
	}

//	public void setComposite(Composite comp) {
//		this.tev.setComposite(comp);
//	}

	public Composite getComposite() {
		return this.tev.getComposite();
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
	
	}	
}