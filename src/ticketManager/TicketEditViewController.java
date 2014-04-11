package ticketManager;

import java.util.ArrayList;

import org.eclipse.swt.widgets.*;

import sun.awt.SunHints.Value;

public class TicketEditViewController implements ITicketState  {
	
	private TicketEditView tev;
	private TicketViewController tvc;
	private Composite composite;
	private ITicketDao ticketDao;
	private Listener btnListener;
	
	// ------------------------------------------------------------------------
	
	public TicketEditViewController(TicketViewController tvc, Composite composite, ITicketDao ticketDao){
		
		this.tvc = tvc;
		this.composite = composite;
		this.ticketDao = ticketDao;
	}

	// ------------------------------------------------------------------------
	
	@Override
	public void show() {
		
		this.btnListener = new Listener() {
			public void handleEvent(Event event) {
				if (event.widget == tev.btnSave) {
					System.out.println("Save");
					tvc.getTicketController().updateTicket(getEditViewValues());
				}
				if (event.widget == tev.btnUndo) {
					System.out.println("Undo");
				}
				if (event.widget == tev.btnCancel) {
					System.out.println("Cancel");
					tvc.getTicketListViewController().getComposite().dispose();
					tvc.setCurrentView(tvc.getTicketListViewController(), false);
				}
			}
		};
		
		tev = new TicketEditView(this.composite, btnListener);
	}	
	
	// ------------------------------------------------------------------------
	
	public Composite getComposite() {
		return this.tev.getComposite();
	}
	
	// ------------------------------------------------------------------------
	
	public void setValues(ArrayList<String> values){
	
		this.tev.setTicketId(values.get(0));
		this.tev.setTicketTitle(values.get(1));
		this.tev.setTicketDescription(values.get(2));

		String[] start = values.get(3).split("-");
		ArrayList<Integer> startDate = new ArrayList<Integer>();
		startDate.add(Integer.parseInt(start[0]));
		startDate.add(Integer.parseInt(start[1]));
		startDate.add(Integer.parseInt(start[2]));
		this.tev.setTicketStartDate(startDate);
		
		
		String[] end = values.get(4).split("-");
		ArrayList<Integer> endDate = new ArrayList<Integer>();
		endDate.add(Integer.parseInt(end[0]));
		endDate.add(Integer.parseInt(end[1]));
		endDate.add(Integer.parseInt(end[2]));
		this.tev.setTicketEndDate(endDate);

		
		this.tev.setTicketPriorityLeven(values.get(5));
		this.tev.setTicketProjectId(values.get(6));
		this.tev.setTicketAssignedTeam(values.get(7));
		this.tev.setTicketCurrentEditor(values.get(8));
	}
	
	// ------------------------------------------------------------------------
	
	public ArrayList<String> getEditViewValues(){
		
		ArrayList<String> values = new ArrayList<String>();
		
		values.add(this.tev.getTicketId());
		values.add(this.tev.getTicketTitle());
		values.add(this.tev.getTicketDescription());
		values.add(this.tev.getTicketStartDate());
		values.add(this.tev.getTicketEndDate());
		values.add(this.tev.getTicketPriorityLevel());
		values.add(this.tev.getTicketProjectId());
		values.add(this.tev.getTicketAssignedTeam());
		values.add(this.tev.getTicketCurrentEditorUid());
		values.add(this.tev.getTicketProcessStatus());
		
		return values;
	}
}

