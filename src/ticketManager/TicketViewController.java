package ticketManager;

import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Shell;

public class TicketViewController {

	private ITicketState currentState;
	private Shell shell;
	
	private ITicketState tlvc;
	private ITicketState tdvc;
	private ITicketState tevc;
	private ITicketState tcvc;
	private ITicketDao ticketDao;

	// ------------------------------------------------------------------------
	
	public TicketViewController(Shell shell, ITicketDao ticketDao){

		this.shell = shell;
		this.ticketDao = ticketDao;
		
		tlvc = new TicketListViewController(this, shell, this.ticketDao);
//		tdvc = new TicketDetailViewController(shell);
//		tevc = new TicketEditViewController(shell);
		tcvc = new TicketCreateViewController(shell);
		this.setCurrentView(tlvc);
	}
	
	// ------------------------------------------------------------------------
	
	public void setCurrentView(ITicketState currentState){
		
		System.out.println("Input CurrentState: " + this.currentState);
		
		if(this.currentState != null){
			this.currentState.getComposite().dispose();
		}
		this.currentState = currentState;
		this.currentState.show();
		this.shell.setLayout(new GridLayout());
		
		System.out.println("Output CurrentState: " + this.currentState);
	}
	
	// ------------------------------------------------------------------------
	
	public ITicketState getTicketListViewController(){
		return this.tlvc;
	}
	
	public ITicketState getTicketDetailViewController(){
		return this.tdvc;
	}
	
	public ITicketState getTicketEditViewController(){
		return this.tevc;
	}
	
	public ITicketState getTicketCreateViewController(){
		return this.tcvc;
	}
}
