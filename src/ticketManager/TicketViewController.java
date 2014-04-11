package ticketManager;

import org.eclipse.swt.widgets.*;

public class TicketViewController {

	private TicketController tc;
	private ITicketState currentView;
	private Composite composite;
	private ITicketState tlvc;
	private ITicketState tdvc;
	private ITicketState tevc;
	private ITicketState tcvc;
	private ITicketDao ticketDao;
	public String currentTicket;

	// ------------------------------------------------------------------------
	
	public TicketViewController(TicketController tc, Composite composite, ITicketDao ticketDao){

		this.tc = tc;
		this.composite = composite;
		this.ticketDao = ticketDao;
		
		tlvc = new TicketListViewController(this, this.composite, this.ticketDao);
		tdvc = new TicketDetailViewController(this, this.composite, this.ticketDao);
		tevc = new TicketEditViewController(this, this.composite, this.ticketDao);
		tcvc = new TicketCreateViewController(this, this.composite, this.ticketDao);
		
		this.setCurrentView(tlvc, false);
	}
	
	// ------------------------------------------------------------------------
	
	public void setCurrentView(ITicketState currentState, boolean switchToEditView){
		
		if(!switchToEditView){
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
		}
		else{
			this.tdvc.getComposite().dispose();
			this.currentView = currentState;
			this.currentView.show();
		}
			
	}
	
	// ------------------------------------------------------------------------
	
	public TicketController getTicketController(){
		return this.tc;
	}
	
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
