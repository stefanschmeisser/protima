package ticketManager;

import org.eclipse.swt.widgets.*;
import frontController.IContentState;


public class TicketController implements IContentState {
	
	private Composite composite;
	private ITicketDao ticketDao;
	private TicketViewController tvc;
	
	public TicketController(Composite composite){
		
		this.composite = composite;
		this.ticketDao = new TicketDaoMySql();
		this.tvc = new TicketViewController(composite, this.ticketDao);	
	}
	
}
