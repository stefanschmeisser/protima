package ticketManager;

import java.util.ArrayList;
import org.eclipse.swt.widgets.*;
import frontController.IContentState;

public class TicketController implements IContentState {
	
	private Composite composite;
	private ITicketDao ticketDao;
	private TicketViewController tvc;
	
	public TicketController(Composite composite){
		
		this.composite = composite;
		this.ticketDao = new TicketDaoMySql();
		this.tvc = new TicketViewController(this, this.composite, this.ticketDao);	
	}
	
	// ------------------------------------------------------------------------
	
	public void createTicket(ArrayList<String> values){
	
//		this.ticketDao.insertTicket(values); // the old way without TicketBuilder	
		Ticket ticket = new Ticket.TicketBuilder(values).buildTicket();
		this.ticketDao.insertTicket(ticket);	
	}
	
	// ------------------------------------------------------------------------
	
	public void updateTicket(ArrayList<String> values){
		this.ticketDao.updateTicket(values);
	}
	
	// ------------------------------------------------------------------------
	
	public void deleteTicket(String ticketId){

		this.ticketDao.deleteTicket(ticketId);
	}	
}
