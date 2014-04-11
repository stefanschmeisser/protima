package ticketManager;

import java.util.ArrayList;

import org.eclipse.swt.widgets.*;

public class TicketDetailViewController implements ITicketState, ITicketObserver {

	private TicketDetailView tdv;
	private TicketListViewController tlvc;
	private Listener btnListener;
	private TicketViewController tvc;
	private ITicketDao ticketDao;
	private Composite composite;
//	private TicketEditViewController tev;

	
	
	public TicketDetailViewController(TicketViewController ticketViewController, Composite composite, ITicketDao ticketDao){

		this.tvc = ticketViewController;
		this.composite = composite;
		this.ticketDao = ticketDao;
		
		// Observer Registration
		this.tlvc = (TicketListViewController)this.tvc.getTicketListViewController();
		tlvc.attachObserver(this);
		
		this.btnListener = new Listener() {
			public void handleEvent(Event event) {
				if (event.widget == tdv.btnEdit) {
//					System.out.println("Edit");
					switchToEditView();
				}
//				if (event.widget == tdv.btnCancel) {
//					System.out.println("Cancel");
//				}
			}
		};	
	}
	
	// ------------------------------------------------------------------------
	
	@Override
	public void show() {
		tdv = new TicketDetailView(this.composite, btnListener);
	}

	// ------------------------------------------------------------------------
	
	@Override
	public Composite getComposite() {
		return this.tdv.getComposite();
	}

	// ------------------------------------------------------------------------
	
	// OBSERVER UPDATE
	@Override
	public void update(){
		
		tdv.setTicketId(this.tlvc.getTicketId());
		tdv.setTicketTitle(this.tlvc.getTicketTitle());
		tdv.setTicketDescription(this.tlvc.getTicketDescription());
		tdv.setTicketStartDate(this.tlvc.getTicketStartDate());
		tdv.setTicketEndDate(this.tlvc.getTicketEndDate());
		tdv.setTicketPriorityLevel(this.tlvc.getTicketPriorityLevel());
		tdv.setTicketAssignedTeam(this.tlvc.getTicketAssignedTeam());
		tdv.setTicketProjectId(this.tlvc.getTicketProjectId());
		tdv.setTicketProcessStatus(this.tlvc.getTicketProcessStatus());
		tdv.setTicketCurrentEditorUid(this.tlvc.getTicketCurrentEditorUid());
	}
	
	// ------------------------------------------------------------------------
	
	public ArrayList<String> getTicketData(){
		
		ArrayList<String> values = new ArrayList<String>();
		
		values.add(this.tlvc.getTicketId());
		values.add(this.tlvc.getTicketTitle());
		values.add(this.tlvc.getTicketDescription());
		
		String startdate = tlvc.getTicketStartDate().get(0).toString() + "-" +tlvc.getTicketStartDate().get(1).toString() + "-"+ tlvc.getTicketStartDate().get(2).toString();
		String enddate = tlvc.getTicketEndDate().get(0).toString() + "-" +tlvc.getTicketEndDate().get(1).toString() + "-"+ tlvc.getTicketEndDate().get(2).toString();
		values.add(startdate);
		values.add(enddate);
		
		values.add(this.tlvc.getTicketPriorityLevel());
		values.add(this.tlvc.getTicketProjectId());
		values.add(this.tlvc.getTicketAssignedTeam());
		values.add(this.tlvc.getTicketCurrentEditorUid());
		values.add(this.tlvc.getTicketProcessStatus());

		return values;
	}
	
	// ------------------------------------------------------------------------
	
	private void switchToEditView(){
		
		boolean isSelected = false;

		for(int i = 0; i < this.tlvc.getTable().getItemCount(); i++){
			if(this.tlvc.getTable().isSelected(i)){
				isSelected = true;
			}
		}

		if(isSelected){
			this.tlvc.getTable().setEnabled(false);
			this.tlvc.getButtonCreate().setEnabled(false);
			this.tlvc.getButtonDelete().setEnabled(false);
			this.tlvc.getButtonEdit().setEnabled(false);
			this.tvc.setCurrentView(this.tvc.getTicketEditViewController(), true);
			TicketEditViewController tev = (TicketEditViewController)this.tvc.getTicketEditViewController();
			tev.setValues(this.getTicketData());
		}
	}
}