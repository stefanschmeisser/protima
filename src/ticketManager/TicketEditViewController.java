package ticketManager;

import java.util.ArrayList;
import java.util.Vector;
import org.eclipse.swt.widgets.*;

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
//					System.out.println("Save");
					tvc.getTicketController().updateTicket(getEditViewValues());
					tvc.getTicketListViewController().getComposite().dispose();
					tvc.setCurrentView(tvc.getTicketListViewController(), false);
				}
				if (event.widget == tev.btnUndo) {
					System.out.println("Undo");
				}
				if (event.widget == tev.btnCancel) {
//					System.out.println("Cancel");
					tvc.getTicketListViewController().getComposite().dispose();
					tvc.setCurrentView(tvc.getTicketListViewController(), false);
				}
			}
		};
		
		tev = new TicketEditView(this.composite, btnListener);
		
		this.setCombobox("team");
		this.setCombobox("project");
		this.setCombobox("user");
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

		System.out.println("JJJJJ: " + values.get(5));
		
		this.tev.setTicketPriorityLevel(values.get(5));
		this.tev.setTicketProjectId(values.get(6));
		this.tev.setTicketAssignedTeam(values.get(7));
		this.tev.setTicketCurrentEditor(values.get(8));
		this.tev.setTicketProcessStatus(values.get(9));
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
	
	// ------------------------------------------------------------------------
	
	private void setCombobox(String table){
		
		TicketTableModel tableModel = this.ticketDao.selectTableModel("*", table, "");
		ArrayList<String> str = new ArrayList<String>();
		
		
		if(tableModel != null){
			ArrayList<Vector> rows = tableModel.getRows();

			for(int i = 0; i < rows.size(); i++){
				Vector v = new Vector();
				v = rows.get(i);
				str.add(v.get(0).toString());
			}

			if(table.equals("team")){
				this.tev.setTicketAssignedTeam(str);
			}
			if(table.equals("project")){
				this.tev.setTicketProjectId(str);
			}
			if(table.equals("user")){
				this.tev.setCurrentEditorUIDInput(str);
			}
		}
	}
}

