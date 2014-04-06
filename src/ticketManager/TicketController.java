package ticketManager;

import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;


import org.eclipse.swt.widgets.*;

import frontController.IContentState;


public class TicketController implements IContentState {

	private TicketListViewController tlvc;
	private TicketDetailViewController tdvc;
	private TicketEditViewController tevc;
	private TicketCreateViewController tcvc;
	
	private TicketDaoMySql mysqlDao;
	
	
	
	public TicketController(Shell shell){
		
		// forward the shell parent object to the current/default TicketViewController
//		tlvc = new TicketListViewController(shell);
//		tdvc = new TicketDetailViewController(shell);
//		tevc = new TicketEditViewController(shell);
		tcvc = new TicketCreateViewController(shell);
		
		this.mysqlDao = new TicketDaoMySql();
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
//		this.tlvc.setComposite(comp);
//		this.tdvc.setComposite(comp);
//		this.tevc.setComposite(comp);
		this.tdvc.setComposite(comp);
	}

	@Override
	public Composite getComposite() {
		
		// get the composite from the current TicketViewController
//		return this.tlvc.getComposite();
//		return this.tdvc.getComposite();
//		return this.tevc.getComposite();
		return this.tcvc.getComposite();
		
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
