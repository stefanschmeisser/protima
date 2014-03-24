package ticketManager;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.*;

import frontController.IContentState;


public class TicketController implements IContentState {

	private TicketListViewController tlvc;
	
	public TicketController(Shell shell){
		
		// forward the shell parent object to the current/default TicketViewController
		tlvc = new TicketListViewController(shell);
		
	}
	
	@Override
	public void setCurrentView(IContentState pCurrentState) {
		// TODO Auto-generated method stub	
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
	}

	public void setComposite(Composite comp) {
		
		// get the composite from the current TicketViewController
		//this.tlvc.composite = comp;
		this.tlvc.setComposite(comp);
	}

	@Override
	public Composite getComposite() {
		
		// get the composite from the current TicketViewController
		return this.tlvc.getComposite();
	}

}
