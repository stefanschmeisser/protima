package ticketManager;

import org.eclipse.swt.widgets.*;

import frontController.IContentState;


public class TicketController implements IContentState {

	private TicketListViewController tlvc;
	private TicketDetailViewController tdvc;
	private TicketEditViewController tevc;
	private TicketCreateViewController tcvc;
	
	private ITicketDao ticketDao;
	
	
	
	public TicketController(Shell shell){
		
		// creates a mySQL Dao Object and forwards it to the appropriate Ticket view controllers
		this.ticketDao = new TicketDaoMySql();
		
		// forward the shell parent object to the current/default TicketViewController
		tlvc = new TicketListViewController(shell, this.ticketDao);
//		tdvc = new TicketDetailViewController(shell);
//		tevc = new TicketEditViewController(shell);
//		tcvc = new TicketCreateViewController(shell);
		
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
		this.tlvc.setComposite(comp);
//		this.tdvc.setComposite(comp);
//		this.tevc.setComposite(comp);
//		this.tdvc.setComposite(comp);
	}

	@Override
	public Composite getComposite() {
		
		// get the composite from the current TicketViewController
		return this.tlvc.getComposite();
//		return this.tdvc.getComposite();
//		return this.tevc.getComposite();
//		return this.tcvc.getComposite();
		
	}
	
	
	public void createTicket(){
		
	}
	
	public void editTicket(){
		
	}
	
	public void removeTicket(){
		
	}
	
	public void readTicket(){
		
	}
	
	
}
