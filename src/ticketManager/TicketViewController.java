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
		tdvc = new TicketDetailViewController(this, shell, this.ticketDao);
//		tevc = new TicketEditViewController(shell);
		tcvc = new TicketCreateViewController(this, shell, this.ticketDao);
		
		this.setCurrentView(tlvc);
	}
	
	// ------------------------------------------------------------------------
	
	public void setCurrentView(ITicketState currentState){
		
		if(this.currentView != null){
			this.currentView.getComposite().dispose();
		}
		
		if(this.currentView == this.tlvc){
			this.tdvc.getComposite().dispose();
		}
		
		this.currentView = currentState;
		this.currentView.show();
		
		if(this.currentView == this.tlvc){
			this.tdvc.show();
		}
//		this.shell.setLayout(new GridLayout());	
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
