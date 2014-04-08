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
		tcvc = new TicketCreateViewController(this, shell, this.ticketDao);
		
		this.setCurrentView(tlvc);
	}
	
	// ------------------------------------------------------------------------
	
	public void setCurrentView(ITicketState currentState){
		
		System.out.println("Input CurrentState: " + this.currentView);
		
		if(this.currentView != null){
			this.currentView.getComposite().dispose();
		}
		
//		if(this.currentView == this.tlvc){
//			this.tcvc.getComposite().dispose();
//		}
		
		this.currentView = currentState;
		this.currentView.show();
		
//		if(this.currentView == this.tlvc){
//			this.tcvc.show();
//		}
//		this.shell.setLayout(new GridLayout());
		
		System.out.println("Output CurrentState: " + this.currentView);
	}
	
	
//	public void setCurrentView(IProjectState currentState){
//		if(this.currentState != null){
//			this.currentState.getComposite().dispose();
//		}
//		if(this.currentState == this.projectListView){
//			this.projectDetailView.getComposite().dispose();
//		}
//		this.currentState = currentState;
//		this.currentState.show();
//		if(this.currentState == this.projectListView){
//			this.fillTableData(this.projectController.getTableListData());
//			this.projectDetailView.show();
//		}
//		this.shell.layout();
//	}
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
