package ticketManager;

import java.util.Date;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.widgets.*;

public class TicketCreateView {

	private Composite composite, compgrid;
	private Label ticketIDLabel, ticketTitleLabel, ticketDescLabel, ticketStartDateLabel, ticketEndDateLabel, projectIDLabel;
	private Label ticketPriorityLevelLabel, ticketProcessStatusLabel, currentEditorUIDLabel, assignedTeamIDLabel;
	private Text ticketIDInput, ticketTitleInput, ticketDescInput;
	private Combo ticketPriorityLevelInput, ticketProcessStatusInput, projectIDInput, currentEditorUIDInput, assignedTeamIDInput;
	private DateTime ticketStartDateInput, ticketEndDateInput;
	public Button btnCreate, btnCancel, btnClear;
	private Listener numListener, btnListener;
	private Shell shell;
	
	private TicketPriorityLevel ticketPriorityLevel;
	private TicketProcessStatus ticketProcessStatus;
	
	public TicketCreateView(Shell shell, Listener btnListener){
		
		this.shell = shell;
		
		this.composite = new Composite(shell, SWT.NONE);
		GridLayout layout = new GridLayout();
		layout.numColumns = 4;
	    layout.makeColumnsEqualWidth = true;
	    composite.setLayout(layout);
//	    composite.setLayoutData(new GridData(SWT.CENTER, SWT.FILL, true, true));
	    
	    GridData data = new GridData(GridData.FILL_HORIZONTAL);
	    this.ticketIDLabel = new Label(composite, SWT.RIGHT);
	    this.ticketIDLabel.setText("Ticket ID");
	    this.ticketIDLabel.setLayoutData(data);
	    
	    data = new GridData(GridData.FILL_HORIZONTAL);
	    this.ticketIDInput = new Text(composite, SWT.READ_ONLY | SWT.LEFT | SWT.BORDER);
	    this.ticketIDInput.setLayoutData(data);
	    this.ticketIDInput.setText("automatisch");
	    this.ticketIDInput.setEnabled(false);
	    
	    data = new GridData(GridData.FILL_HORIZONTAL);
	    data.horizontalSpan = 2;
	    this.compgrid = new Composite(this.composite, SWT.NONE);
	    this.compgrid.setLayoutData(data);
	    
	    data = new GridData(GridData.FILL_HORIZONTAL);
	    this.ticketTitleLabel = new Label(composite, SWT.RIGHT);
	    this.ticketTitleLabel.setText("Ticket Title");
	    this.ticketTitleLabel.setLayoutData(data);
	    
	    data = new GridData(GridData.FILL_HORIZONTAL);
	    data.horizontalSpan = 3;
	    this.ticketTitleInput = new Text(composite, SWT.LEFT | SWT.BORDER);
	    this.ticketTitleInput.setLayoutData(data);
	    
	    data = new GridData(GridData.FILL_HORIZONTAL);
	    this.ticketDescLabel = new Label(composite, SWT.RIGHT);
	    this.ticketDescLabel.setText("Ticket Beschreibung");
	    this.ticketDescLabel.setLayoutData(data);
	    
	    data = new GridData(GridData.FILL_HORIZONTAL);
	    data.heightHint = 70;
	    data.horizontalSpan = 3;
	    this.ticketDescInput = new Text(this.composite,  SWT.MULTI | SWT.BORDER | SWT.WRAP | SWT.V_SCROLL);
	    this.ticketDescInput.setBounds(10, 10, 300, 200);
	    this.ticketDescInput.setLayoutData(data);
	    
	    data = new GridData(GridData.FILL_HORIZONTAL);
	    this.ticketStartDateLabel = new Label(composite, SWT.RIGHT);
	    this.ticketStartDateLabel.setText("Ticket Date");
	    this.ticketStartDateLabel.setLayoutData(data);
	    
	    data = new GridData(GridData.FILL_HORIZONTAL);
	    this.ticketStartDateInput = new DateTime(this.composite, SWT.CALENDAR);
	    this.ticketStartDateInput.setLayoutData(data);
	    
	    data = new GridData(GridData.FILL_HORIZONTAL);
	    this.ticketEndDateLabel = new Label(composite, SWT.RIGHT);
	    this.ticketEndDateLabel.setText("Ticket End-Date");
	    this.ticketEndDateLabel.setLayoutData(data);
	    
	    data = new GridData(GridData.FILL_HORIZONTAL);
	    this.ticketEndDateInput = new DateTime(this.composite, SWT.CALENDAR);
	    this.ticketEndDateInput.setLayoutData(data);
	    
	    data = new GridData(GridData.FILL_HORIZONTAL);
	    data.horizontalSpan = 4;
	    data.heightHint = 10;
	    this.compgrid = new Composite(this.composite, SWT.NONE);
	    this.compgrid.setLayoutData(data);
	    
	    data = new GridData(GridData.FILL_HORIZONTAL);
	    this.ticketPriorityLevelLabel = new Label(composite, SWT.RIGHT);
	    this.ticketPriorityLevelLabel.setText("Priority Level");
	    this.ticketPriorityLevelLabel.setLayoutData(data);
	    
	    data = new GridData(GridData.FILL_HORIZONTAL);
	    this.ticketPriorityLevelInput = new Combo(composite, SWT.DROP_DOWN);
	    this.ticketPriorityLevelInput.add(TicketPriorityLevel.IN_TIME.toString());
	    this.ticketPriorityLevelInput.add(TicketPriorityLevel.URGENT.toString());
	    this.ticketPriorityLevelInput.add(TicketPriorityLevel.CRITICAL.toString());
	    this.ticketPriorityLevelInput.setLayoutData(data);
	    
	    data = new GridData(GridData.FILL_HORIZONTAL);
	    this.ticketProcessStatusLabel = new Label(composite, SWT.RIGHT);
	    this.ticketProcessStatusLabel.setText("Process Status");
	    this.ticketProcessStatusLabel.setLayoutData(data);
	    
	    data = new GridData(GridData.FILL_HORIZONTAL);
	    this.ticketProcessStatusInput = new Combo(composite, SWT.DROP_DOWN);
	    this.ticketProcessStatusInput.add(TicketProcessStatus.OPEN.toString());
	    this.ticketProcessStatusInput.add(TicketProcessStatus.IN_PROGRESS.toString());
	    this.ticketProcessStatusInput.add(TicketProcessStatus.WAITING.toString());
	    this.ticketProcessStatusInput.add(TicketProcessStatus.SUSPENDED.toString());
	    this.ticketProcessStatusInput.add(TicketProcessStatus.DONE.toString());
	    this.ticketProcessStatusInput.setLayoutData(data);

	    
	    data = new GridData(GridData.FILL_HORIZONTAL);
	    data.horizontalSpan = 4;
	    data.heightHint = 10;
	    this.compgrid = new Composite(this.composite, SWT.NONE);
	    this.compgrid.setLayoutData(data);
	    
	    data = new GridData(GridData.FILL_HORIZONTAL);
	    this.currentEditorUIDLabel = new Label(composite, SWT.RIGHT);
	    this.currentEditorUIDLabel.setText("Editor ID");
	    this.currentEditorUIDLabel.setLayoutData(data);
	    
	    data = new GridData(GridData.FILL_HORIZONTAL);
	    this.currentEditorUIDInput = new Combo(composite, SWT.DROP_DOWN);
//	    this.currentEditorUIDInput.add("ITEM");
	    this.currentEditorUIDInput.setLayoutData(data);
	    
	    data = new GridData(GridData.FILL_HORIZONTAL);
	    this.assignedTeamIDLabel = new Label(composite, SWT.RIGHT);
	    this.assignedTeamIDLabel.setText("Team ID");
	    this.assignedTeamIDLabel.setLayoutData(data);
	    
	    data = new GridData(GridData.FILL_HORIZONTAL);
	    this.assignedTeamIDInput = new Combo(composite, SWT.DROP_DOWN);
//	    this.assignedTeamIDInput.add("ITEM");
	    this.assignedTeamIDInput.setLayoutData(data);
	    
	    data = new GridData(GridData.FILL_HORIZONTAL);
	    this.projectIDLabel = new Label(composite, SWT.RIGHT);
	    this.projectIDLabel.setText("Project ID");
	    this.projectIDLabel.setLayoutData(data);
	    
	    data = new GridData(GridData.FILL_HORIZONTAL);
	    this.projectIDInput = new Combo(composite, SWT.DROP_DOWN);
//	    this.projectIDInput.add("ITEM");
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
	    data.horizontalSpan = 2;
	    this.compgrid = new Composite(this.composite, SWT.NONE);
	    this.compgrid.setLayoutData(data);
	    
//	    data = new GridData(GridData.HORIZONTAL_ALIGN_CENTER);
//	    this.btnClear = new Button(composite, SWT.PUSH);
//	    this.btnClear.setText("Clear");
//	    this.btnClear.addListener(SWT.Selection, btnListener);
//	    this.btnClear.setLayoutData(data);
	    
	    data = new GridData(GridData.FILL_HORIZONTAL);
	    this.btnCreate = new Button(composite, SWT.PUSH);
	    this.btnCreate.setText("Create");
	    this.btnCreate.addListener(SWT.Selection, btnListener);
	    this.btnCreate.setLayoutData(data);
	    
	    data = new GridData(GridData.FILL_HORIZONTAL);
	    this.btnCancel = new Button(composite, SWT.PUSH);
	    this.btnCancel.setText("Cancel");
	    this.btnCancel.addListener(SWT.Selection, btnListener);
	    this.btnCancel.setLayoutData(data);
	    
	    this.shell.layout();
	    
//	    data = new GridData(GridData.FILL_HORIZONTAL);
//	    this.projectIDInput = new Text(composite, SWT.LEFT | SWT.BORDER);
//	    this.projectIDInput.addListener(SWT.Verify, numListener);
//	    this.projectIDInput.setLayoutData(data);
//	    
//		composite = new Composite(shell, SWT.NONE);
//
//		Label blankLabel = new Label(compgrid, SWT.NONE);
//		blankLabel.setText(Ticket Create View);
//		
//		Color col = new Color (Display.getCurrent(), 0, 170, 170);
//		blankLabel.setBackground(col);	
//		
//		btnStart = new Button(composite, SWT.PUSH);
//		btnStart.setText(Start);
//		btnStart.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
//        
//		btnStart.addListener(SWT.Selection, listener);
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
