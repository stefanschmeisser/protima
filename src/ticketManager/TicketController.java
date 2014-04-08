package ticketManager;

import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.*;
import frontController.IContentState;


public class TicketController implements IContentState {
	
	private TicketViewController tvc;
	private ITicketDao ticketDao;
	
	public TicketController(Shell shell){
		
		// creates a mySQL Dao Object and forwards it to the appropriate Ticket view controllers
		this.ticketDao = new TicketDaoMySql();
		
		// forward the shell parent object to the current/default TicketViewController
		tvc = new TicketViewController(shell, this.ticketDao);
		
	}

	public void setComposite(Composite comp) {	
		// get the composite from the current TicketViewController
		this.tvc.setComposite(comp);
	}
	
	
//	public void createTicket(){
//		
//	}
//	
//	public void editTicket(){
//		
//	}
//	
//	public void removeTicket(){
//		
//	}
//	
//	public void readTicket(){
//		
//	}
	
}
