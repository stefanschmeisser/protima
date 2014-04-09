package ticketManager;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;

import frontController.IContentState;

public class TicketViewController implements IContentState {

	private TicketListViewController tlvc;
	private TicketDetailViewController tdvc;
	private TicketEditViewController tevc;
	private TicketCreateViewController tcvc;
	private ITicketDao ticketDao;


	public TicketViewController(Shell shell, ITicketDao ticketDao){

		this.ticketDao = ticketDao;
		
		//this.tlvc = new TicketListViewController(shell, ticketDao);


		// forward the TVC Instance, the shell parent object to the current/default TicketViewController and the TicketDao
		tlvc = new TicketListViewController(this, shell, this.ticketDao);
//		tdvc = new TicketDetailViewController(shell);
//		tevc = new TicketEditViewController(shell);
//		tcvc = new TicketCreateViewController(shell);

	}


	public void setComposite(Composite comp) {

		// get the composite from the current TicketViewController
		this.tlvc.setComposite(comp);
//		this.tdvc.setComposite(comp);
//		this.tevc.setComposite(comp);
//		this.tcvc.setComposite(comp);
	}

//	@Override
	public Composite getComposite() {

		// get the composite from the current TicketViewController
		return this.tlvc.getComposite();
//		return this.tdvc.getComposite();
//		return this.tevc.getComposite();
//		return this.tcvc.getComposite();
	}
	
	

}
