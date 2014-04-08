package ticketManager;

import java.awt.Color;

import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Shell;

public class TicketViewController {

	private ITicketState currentView;
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
		
		System.out.println("Input CurrentState: " + this.currentView);
		
		if(this.currentView != null){
			this.currentView.getComposite().dispose();
		}
		this.currentView = currentState;
		this.currentView.show();
		this.shell.setLayout(new GridLayout());
		
		System.out.println("Output CurrentState: " + this.currentView);
	}
	
	// ------------------------------------------------------------------------
	
	public ITicketState getcurrentView(){
		return this.currentView;
	}
	
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
