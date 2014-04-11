package ticketManager;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.*;

public class TicketEditView {

	private Composite content, composite, compgrid;
	private Label ticketIDLabel, ticketTitleLabel, ticketDescLabel, ticketStartDateLabel, ticketEndDateLabel, projectIDLabel;
	private Label ticketPriorityLevelLabel, ticketProcessStatusLabel, currentEditorUIDLabel, assignedTeamIDLabel;
	private Text ticketIDInput, ticketTitleInput, ticketDescInput;
	private Combo ticketPriorityLevelInput, ticketProcessStatusInput, projectIDInput, currentEditorUIDInput, assignedTeamIDInput;
	private DateTime ticketStartDateInput, ticketEndDateInput;
	public Button btnSave, btnUndo, btnCancel;
	private Listener btnListener;
	
	public TicketEditView(Composite comp, Listener btnListener){
		
		this.content = comp;
		
		this.composite = new Composite(content, SWT.NONE);
		GridLayout layout = new GridLayout();
		layout.numColumns = 4;
	    layout.makeColumnsEqualWidth = true;
	    composite.setLayout(layout);
	    
	    GridData data = new GridData(GridData.FILL_HORIZONTAL);
	    this.ticketIDLabel = new Label(this.composite, SWT.RIGHT);
	    this.ticketIDLabel.setText("Ticket ID");
	    this.ticketIDLabel.setLayoutData(data);
	    
	    data = new GridData(GridData.FILL_HORIZONTAL);
	    this.ticketIDInput = new Text(this.composite, SWT.READ_ONLY | SWT.LEFT | SWT.BORDER);
	    this.ticketIDInput.setEnabled(false);
	    this.ticketIDInput.setEditable(false);
	    this.ticketIDInput.setLayoutData(data);
	    
	    data = new GridData(GridData.FILL_HORIZONTAL);
	    data.horizontalSpan = 2;
	    this.compgrid = new Composite(this.composite, SWT.NONE);
	    this.compgrid.setLayoutData(data);
	    
	    data = new GridData(GridData.FILL_HORIZONTAL);
	    this.ticketTitleLabel = new Label(this.composite, SWT.RIGHT);
	    this.ticketTitleLabel.setText("Ticket Title");
	    this.ticketTitleLabel.setLayoutData(data);
	    
	    data = new GridData(GridData.FILL_HORIZONTAL);
	    data.horizontalSpan = 3;
	    this.ticketTitleInput = new Text(this.composite, SWT.LEFT | SWT.BORDER);
	    this.ticketTitleInput.setEnabled(true);
	    this.ticketTitleInput.setText("Datenbank-Inhalt");
	    this.ticketTitleInput.setLayoutData(data);
	    
	    data = new GridData(GridData.FILL_HORIZONTAL);
	    this.ticketDescLabel = new Label(this.composite, SWT.RIGHT);
	    this.ticketDescLabel.setText("Ticket Beschreibung");
	    this.ticketDescLabel.setLayoutData(data);
	    
	    data = new GridData(GridData.FILL_HORIZONTAL);
	    data.heightHint = 70;
	    data.widthHint = 505;
	    data.horizontalSpan = 3;
	    this.ticketDescInput = new Text(this.composite, SWT.MULTI | SWT.BORDER | SWT.WRAP | SWT.V_SCROLL);
	    this.ticketDescInput.setEnabled(true);
	    this.ticketDescInput.setText("Datenbank-Inhalt");
	    this.ticketDescInput.setLayoutData(data);
	    
	    data = new GridData(GridData.FILL_HORIZONTAL);
	    this.ticketStartDateLabel = new Label(this.composite, SWT.RIGHT);
	    this.ticketStartDateLabel.setText("Ticket Date");
	    this.ticketStartDateLabel.setLayoutData(data);
	    
	    data = new GridData(GridData.FILL_HORIZONTAL);
	    this.ticketStartDateInput = new DateTime(this.composite, SWT.DATE);
	    this.ticketStartDateInput.setEnabled(true);
	    this.ticketStartDateInput.setLayoutData(data);
	    
	    data = new GridData(GridData.FILL_HORIZONTAL);
	    this.ticketEndDateLabel = new Label(this.composite, SWT.RIGHT);
	    this.ticketEndDateLabel.setText("Ticket End-Date");
	    this.ticketEndDateLabel.setLayoutData(data);
	    
	    data = new GridData(GridData.FILL_HORIZONTAL);
	    this.ticketEndDateInput = new DateTime(this.composite, SWT.DATE);
	    this.ticketEndDateInput.setEnabled(true);
	    this.ticketEndDateInput.setLayoutData(data);
	    
	    data = new GridData(GridData.FILL_HORIZONTAL);
	    data.horizontalSpan = 4;
	    data.heightHint = 10;
	    this.compgrid = new Composite(this.composite, SWT.NONE);
	    this.compgrid.setLayoutData(data);
	    
	    data = new GridData(GridData.FILL_HORIZONTAL);
	    this.ticketPriorityLevelLabel = new Label(this.composite, SWT.RIGHT);
	    this.ticketPriorityLevelLabel.setText("Priority Level");
	    this.ticketPriorityLevelLabel.setLayoutData(data);
	    
	    data = new GridData(GridData.FILL_HORIZONTAL);
	    this.ticketPriorityLevelInput = new Combo(this.composite, SWT.DROP_DOWN);
	    this.ticketPriorityLevelInput.setEnabled(true);
//	    this.ticketProcessStatusInput.setItem(index, string); // für den Inhalt durch die DB?!
	    this.ticketPriorityLevelInput.setLayoutData(data);
	    
	    data = new GridData(GridData.FILL_HORIZONTAL);
	    this.ticketProcessStatusLabel = new Label(this.composite, SWT.RIGHT);
	    this.ticketProcessStatusLabel.setText("Process Status");
	    this.ticketProcessStatusLabel.setLayoutData(data);
	    
	    data = new GridData(GridData.FILL_HORIZONTAL);
	    this.ticketProcessStatusInput = new Combo(this.composite, SWT.DROP_DOWN);
//	    this.ticketProcessStatusInput.setItem(index, string); // für den Inhalt durch die DB?!
	    this.ticketProcessStatusInput.setEnabled(true);
	    this.ticketProcessStatusInput.setLayoutData(data);

	    
	    data = new GridData(GridData.FILL_HORIZONTAL);
	    data.horizontalSpan = 4;
	    data.heightHint = 10;
	    this.compgrid = new Composite(this.composite, SWT.NONE);
	    this.compgrid.setLayoutData(data);
	    
	    data = new GridData(GridData.FILL_HORIZONTAL);
	    this.currentEditorUIDLabel = new Label(this.composite, SWT.RIGHT);
	    this.currentEditorUIDLabel.setText("Editor ID");
	    this.currentEditorUIDLabel.setLayoutData(data);
	    
	    data = new GridData(GridData.FILL_HORIZONTAL);
	    this.currentEditorUIDInput = new Combo(this.composite, SWT.DROP_DOWN);
	    this.currentEditorUIDInput.setEnabled(true);
	    this.currentEditorUIDInput.setLayoutData(data);
	    
	    data = new GridData(GridData.FILL_HORIZONTAL);
	    this.assignedTeamIDLabel = new Label(this.composite, SWT.RIGHT);
	    this.assignedTeamIDLabel.setText("Team ID");
	    this.assignedTeamIDLabel.setLayoutData(data);
	    
	    data = new GridData(GridData.FILL_HORIZONTAL);
	    this.assignedTeamIDInput = new Combo(this.composite, SWT.DROP_DOWN);
	    this.assignedTeamIDInput.setEnabled(true);
	    this.assignedTeamIDInput.setLayoutData(data);
	    
	    data = new GridData(GridData.FILL_HORIZONTAL);
	    this.projectIDLabel = new Label(this.composite, SWT.RIGHT);
	    this.projectIDLabel.setText("Project ID");
	    this.projectIDLabel.setLayoutData(data);
	    
	    data = new GridData(GridData.FILL_HORIZONTAL);
	    this.projectIDInput = new Combo(this.composite, SWT.DROP_DOWN);
	    this.projectIDInput.setEnabled(true);
	    this.projectIDInput.setLayoutData(data);
	    
	    data = new GridData(GridData.FILL_HORIZONTAL);
	    data.horizontalSpan = 2;
	    data.heightHint = 5;
	    this.compgrid = new Composite(this.composite, SWT.NONE);
	    this.compgrid.setLayoutData(data);
	    
	    data = new GridData(GridData.FILL_HORIZONTAL);
	    data.horizontalSpan = 4;
	    data.heightHint = 10;
	    this.compgrid = new Composite(this.composite, SWT.NONE);
	    this.compgrid.setLayoutData(data);
	    
	    data = new GridData(GridData.FILL_HORIZONTAL);
	    data.heightHint = 5;
	    //data.horizontalSpan = 2;
	    this.compgrid = new Composite(this.composite, SWT.NONE);
	    this.compgrid.setLayoutData(data);
	    
	    // BUTTONS	    
	    data = new GridData(GridData.FILL_HORIZONTAL);
	    this.btnSave = new Button(this.composite, SWT.PUSH);
	    this.btnSave.setText("Save");
	    this.btnSave.addListener(SWT.Selection, btnListener);
	    this.btnSave.setLayoutData(data);
	    
	    data = new GridData(GridData.FILL_HORIZONTAL);
	    this.btnUndo = new Button(this.composite, SWT.PUSH);
	    this.btnUndo.setText("Undo");
	    this.btnUndo.setEnabled(false);
	    this.btnUndo.addListener(SWT.Selection, btnListener);
	    this.btnUndo.setLayoutData(data);
	    
	    data = new GridData(GridData.FILL_HORIZONTAL);
	    this.btnCancel = new Button(this.composite, SWT.PUSH);
	    this.btnCancel.setText("Cancel");
	    this.btnCancel.addListener(SWT.Selection, btnListener);
	    this.btnCancel.setLayoutData(data);
	    
	    this.content.layout();

	}
	
	
	public void setComposite(Composite comp) {
		this.composite = comp;
		Color blue = new Color (Display.getCurrent(), 0, 0, 255);
		this.composite.setBackground(blue);
		
	}

	public Composite getComposite() {
		
		return this.composite;
	}
	
}
