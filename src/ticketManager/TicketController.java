package ticketManager;

import org.eclipse.swt.widgets.*;
import frontController.IContentState;


public class TicketController implements IContentState {
	
	private Shell shell;
	private Composite composite;
	private ITicketDao ticketDao;
	private TicketViewController tvc;
	
	public TicketController(Shell shell){
		
		this.shell = shell;
		this.ticketDao = new TicketDaoMySql();
		this.tvc = new TicketViewController(shell, this.ticketDao);	
	}
	
}
