package ticketManager;

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
		this.tvc.setComposite(comp);
	}

	@Override
	public Composite getComposite() {
		
		// get the composite from the current TicketViewController
		return this.tvc.getComposite();	
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
