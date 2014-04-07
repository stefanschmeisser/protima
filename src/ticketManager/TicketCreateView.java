package ticketManager;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.*;

public class TicketCreateView {

	private Composite composite;
	public Button btnStart;
	
	public TicketCreateView(Shell shell, Listener listener){
		
		composite = new Composite(shell, SWT.NONE);
		
		GridLayout layout = new GridLayout();
		layout.numColumns = 2;
	    layout.makeColumnsEqualWidth = true;
	    composite.setLayout(layout);
	    
	    // TICKET ID
	    GridData data = new GridData(GridData.HORIZONTAL_ALIGN_BEGINNING);
	    data.widthHint = 300;
	    Label tickedIDLabel = new Label(composite, SWT.PUSH);
	    tickedIDLabel.setText("Ticket ID");
	    tickedIDLabel.setLayoutData(data);

	    data = new GridData(GridData.HORIZONTAL_ALIGN_END);
	    data.widthHint = 300;
	    Text tickedIDInput = new Text(composite, SWT.NONE);
	    tickedIDInput.setLayoutData(data);
	    
	    // TICKETTITEL
	    data = new GridData(GridData.FILL_BOTH);
	    data.widthHint = 300;
	    Label ticketTitleLabel = new Label(composite, SWT.PUSH);
	    ticketTitleLabel.setText("Titel");
	    ticketTitleLabel.setLayoutData(data);

	    data = new GridData(GridData.FILL_BOTH);
	    data.widthHint = 300;
	    Text ticketTitleInput = new Text(composite, SWT.NONE);
	    ticketTitleInput.setLayoutData(data);
	
	    
	    // TICKETBESCHREIBUNG
	    data = new GridData(GridData.FILL_BOTH);
	    data.widthHint = 300;
	    Label ticketDescLabel = new Label(composite, SWT.PUSH);
	    ticketDescLabel.setText("Beschreibung");
	    ticketDescLabel.setLayoutData(data);

	    data = new GridData(GridData.FILL_BOTH);
	    data.widthHint = 300;
	    Text ticketDescInput = new Text(composite, SWT.NONE);
	    ticketDescInput.setLayoutData(data);
	    
	    
	    // KALENDER STARTDATUM
	    data = new GridData(GridData.FILL_BOTH);
	    data.widthHint = 300;
	    Label ticketStartDateLabel = new Label(composite, SWT.PUSH);
	    ticketStartDateLabel.setText("Start-Datum");
	    ticketStartDateLabel.setLayoutData(data);
	    
	    data = new GridData(GridData.FILL_BOTH);
	    data.widthHint = 300;
	    DateTime ticketStartDateInput = new DateTime(composite, SWT.CALENDAR);
	    ticketStartDateInput.setLayoutData(data);
	    
	    
	    // KALENDER ENDDATUM
	    data = new GridData(GridData.FILL_BOTH);
	    data.widthHint = 300;
	    Label ticketEndDateLabel = new Label(composite, SWT.PUSH);
	    ticketEndDateLabel.setText("End-Datum");
	    ticketEndDateLabel.setLayoutData(data);
	    
	    data = new GridData(GridData.FILL_BOTH);
	    data.widthHint = 300;
	    DateTime ticketEndDateInput = new DateTime(composite, SWT.CALENDAR);
	    ticketEndDateInput.setLayoutData(data);
	    
	    
	    // PRIORITÄTEN-Level
	    data = new GridData(GridData.FILL_BOTH);
	    data.widthHint = 300;
	    Label ticketPriorityLevelLabel = new Label(composite, SWT.PUSH);
	    ticketPriorityLevelLabel.setText("Priorität");
	    ticketPriorityLevelLabel.setLayoutData(data);

	    data = new GridData(GridData.FILL_BOTH);
	    data.widthHint = 300;
	    Combo ticketPriorityLevelInput = new Combo(composite, SWT.DROP_DOWN);
	    ticketPriorityLevelInput.add(TicketPriorityLevel.IN_TIME.toString());
	    ticketPriorityLevelInput.add(TicketPriorityLevel.URGENT.toString());
	    ticketPriorityLevelInput.add(TicketPriorityLevel.CRITICAL.toString());
	    ticketPriorityLevelInput.setLayoutData(data);
	    
	    
	    // BEARBEITUNGS-Status
	    data = new GridData(GridData.FILL_BOTH);
	    data.widthHint = 300;
	    Label ticketProcessStatusLabel = new Label(composite, SWT.PUSH);
	    ticketProcessStatusLabel.setText("Beschreibung");
	    ticketProcessStatusLabel.setLayoutData(data);

	    data = new GridData(GridData.FILL_BOTH);
	    data.widthHint = 300;
	    Combo ticketProcessStatusInput = new Combo(composite, SWT.DROP_DOWN);
	    ticketProcessStatusInput.add(TicketProcessStatus.OPEN.toString());
	    ticketProcessStatusInput.add(TicketProcessStatus.IN_PROGRESS.toString());
	    ticketProcessStatusInput.add(TicketProcessStatus.WAITING.toString());
	    ticketProcessStatusInput.add(TicketProcessStatus.SUSPENDED.toString());
	    ticketProcessStatusInput.add(TicketProcessStatus.DONE.toString());
	    ticketProcessStatusInput.setLayoutData(data);
	    
	    
	    // ZUGEWIESENER USER
	    data = new GridData(GridData.FILL_BOTH);
	    data.widthHint = 300;
	    Label currentEditorUIDLabel = new Label(composite, SWT.PUSH);
	    currentEditorUIDLabel.setText("Bearbeiter ID");
	    currentEditorUIDLabel.setLayoutData(data);

	    data = new GridData(GridData.FILL_BOTH);
	    data.widthHint = 300;
	    Text currentEditorUIDInput = new Text(composite, SWT.NONE);
	    currentEditorUIDInput.setLayoutData(data);
	    
	    
	    // ZUGEWIESENES TEAM
	    data = new GridData(GridData.FILL_BOTH);
	    data.widthHint = 300;
	    Label assignedTeamIDLabel = new Label(composite, SWT.PUSH);
	    assignedTeamIDLabel.setText("Team ID");
	    assignedTeamIDLabel.setLayoutData(data);

	    data = new GridData(GridData.FILL_BOTH);
	    data.widthHint = 300;
	    Text assignedTeamIDInput = new Text(composite, SWT.NONE);
	    assignedTeamIDInput.setLayoutData(data);
	    
	    
//		composite = new Composite(shell, SWT.NONE);
//
//		Label blankLabel = new Label(composite, SWT.NONE);
//		blankLabel.setText("Ticket Create View");
//		
//		Color col = new Color (Display.getCurrent(), 0, 170, 170);
//		blankLabel.setBackground(col);	
//		
//		btnStart = new Button(composite, SWT.PUSH);
//      btnStart.setText("Start");
//      btnStart.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
//        
//      btnStart.addListener(SWT.Selection, listener);
	}
	
	
	public void setComposite(Composite comp) {
		this.composite = comp;
		Color blue = new Color (Display.getCurrent(), 0, 0, 0);
		this.composite.setBackground(blue);
		
	}

	public Composite getComposite() {
		
		return this.composite;
	}
}
