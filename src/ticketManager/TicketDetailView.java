package ticketManager;

import java.util.ArrayList;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.*;

public class TicketDetailView {

	private Composite composite, compgrid;
	private Label ticketIDLabel, ticketTitleLabel, ticketDescLabel, ticketStartDateLabel, ticketEndDateLabel, projectIDLabel;
	private Label ticketPriorityLevelLabel, ticketProcessStatusLabel, currentEditorUIDLabel, assignedTeamIDLabel;
	private Text ticketIDInput, ticketTitleInput, ticketDescInput;
	private Combo ticketPriorityLevelInput, ticketProcessStatusInput, projectIDInput, currentEditorUIDInput, assignedTeamIDInput;
	private DateTime ticketStartDateInput, ticketEndDateInput;
	public Button btnEdit, btnCancel;
	private Listener btnListener;
	private Shell shell;
	
	private TicketPriorityLevel ticketPriorityLevel;
	private TicketProcessStatus ticketProcessStatus;

	
	public TicketDetailView(Shell shell, Listener btnListener){
		
		this.shell = shell;
		
		this.composite = new Composite(shell, SWT.NONE);
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
	    this.ticketTitleInput = new Text(this.composite, SWT.READ_ONLY | SWT.LEFT | SWT.BORDER);
	    this.ticketTitleInput.setEnabled(false);
	    this.ticketTitleInput.setLayoutData(data);
	    
	    data = new GridData(GridData.FILL_HORIZONTAL);
	    this.ticketDescLabel = new Label(this.composite, SWT.RIGHT);
	    this.ticketDescLabel.setText("Ticket Beschreibung");
	    this.ticketDescLabel.setLayoutData(data);
	    
	    data = new GridData(GridData.FILL_HORIZONTAL);
	    data.heightHint = 70;
	    data.widthHint = 505;
	    data.horizontalSpan = 3;
	    this.ticketDescInput = new Text(this.composite,  SWT.READ_ONLY | SWT.MULTI | SWT.BORDER | SWT.WRAP | SWT.V_SCROLL);
	    this.ticketDescInput.setEnabled(false);
	    this.ticketDescInput.setLayoutData(data);
	    
	    data = new GridData(GridData.FILL_HORIZONTAL);
	    this.ticketStartDateLabel = new Label(this.composite, SWT.RIGHT);
	    this.ticketStartDateLabel.setText("Ticket Date");
	    this.ticketStartDateLabel.setLayoutData(data);
	    
	    data = new GridData(GridData.FILL_HORIZONTAL);
	    this.ticketStartDateInput = new DateTime(this.composite, SWT.DATE);
	    this.ticketStartDateInput.setEnabled(false);
	    this.ticketStartDateInput.setLayoutData(data);
	    
	    data = new GridData(GridData.FILL_HORIZONTAL);
	    this.ticketEndDateLabel = new Label(this.composite, SWT.RIGHT);
	    this.ticketEndDateLabel.setText("Ticket End-Date");
	    this.ticketEndDateLabel.setLayoutData(data);
	    
	    data = new GridData(GridData.FILL_HORIZONTAL);
	    this.ticketEndDateInput = new DateTime(this.composite, SWT.DATE);
	    this.ticketEndDateInput.setEnabled(false);
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
	    this.ticketPriorityLevelInput.setText("IN_TIME");
	    this.ticketPriorityLevelInput.setEnabled(false);
//	    this.ticketPriorityLevelInput.add(TicketPriorityLevel.IN_TIME.toString());
//	    this.ticketPriorityLevelInput.add(TicketPriorityLevel.URGENT.toString());
//	    this.ticketPriorityLevelInput.add(TicketPriorityLevel.CRITICAL.toString());
	    this.ticketPriorityLevelInput.setLayoutData(data);
	    
	    data = new GridData(GridData.FILL_HORIZONTAL);
	    this.ticketProcessStatusLabel = new Label(this.composite, SWT.RIGHT);
	    this.ticketProcessStatusLabel.setText("Process Status");
	    this.ticketProcessStatusLabel.setLayoutData(data);
	    
	    data = new GridData(GridData.FILL_HORIZONTAL);
	    this.ticketProcessStatusInput = new Combo(this.composite, SWT.DROP_DOWN);
	    this.ticketProcessStatusInput.setText("SUSPENDED");
	    this.ticketProcessStatusInput.setEnabled(false);
//	    this.ticketProcessStatusInput.add(TicketProcessStatus.OPEN.toString());
//	    this.ticketProcessStatusInput.add(TicketProcessStatus.IN_PROGRESS.toString());
//	    this.ticketProcessStatusInput.add(TicketProcessStatus.WAITING.toString());
//	    this.ticketProcessStatusInput.add(TicketProcessStatus.SUSPENDED.toString());
//	    this.ticketProcessStatusInput.add(TicketProcessStatus.DONE.toString());
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
	    this.currentEditorUIDInput.setText("00022"); // Anzeige des Inhalts
	    this.currentEditorUIDInput.setEnabled(false);
	    this.currentEditorUIDInput.setLayoutData(data);
	    
	    data = new GridData(GridData.FILL_HORIZONTAL);
	    this.assignedTeamIDLabel = new Label(this.composite, SWT.RIGHT);
	    this.assignedTeamIDLabel.setText("Team ID");
	    this.assignedTeamIDLabel.setLayoutData(data);
	    
	    data = new GridData(GridData.FILL_HORIZONTAL);
	    this.assignedTeamIDInput = new Combo(this.composite, SWT.DROP_DOWN);
	    this.assignedTeamIDInput.setText("00001"); // Anzeige des Inhalts
	    this.assignedTeamIDInput.setEnabled(false);
	    this.assignedTeamIDInput.setLayoutData(data);
	    
	    data = new GridData(GridData.FILL_HORIZONTAL);
	    this.projectIDLabel = new Label(this.composite, SWT.RIGHT);
	    this.projectIDLabel.setText("Project ID");
	    this.projectIDLabel.setLayoutData(data);
	    
	    data = new GridData(GridData.FILL_HORIZONTAL);
	    this.projectIDInput = new Combo(this.composite, SWT.DROP_DOWN);
	    this.projectIDInput.setText("00012"); // Anzeige des Inhalts
	    this.projectIDInput.setEnabled(false);
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
	    
	    // BUTTONS	    
	    data = new GridData(GridData.FILL_HORIZONTAL);
	    this.btnEdit = new Button(this.composite, SWT.PUSH);
	    this.btnEdit.setText("Edit");
	    this.btnEdit.addListener(SWT.Selection, btnListener);
	    this.btnEdit.setLayoutData(data);
	    
	    data = new GridData(GridData.FILL_HORIZONTAL);
	    this.btnCancel = new Button(this.composite, SWT.PUSH);
	    this.btnCancel.setText("Cancel");
	    this.btnCancel.addListener(SWT.Selection, btnListener);
	    this.btnCancel.setLayoutData(data);
	    
	    this.shell.layout();

//		composite = new Composite(shell, SWT.NONE);
//
//		Label blankLabel = new Label(composite, SWT.NONE);
//		blankLabel.setText("TicketDetailView");
//		blankLabel.setBounds(0, 0, 200, 200);
//		
//		Color col = new Color (Display.getCurrent(), 128, 128, 255);
//		blankLabel.setBackground(col);	
//		shell.pack();
	}
	
	
	public void setComposite(Composite comp) {
		this.composite = comp;
		Color blue = new Color (Display.getCurrent(), 0, 0, 255);
		this.composite.setBackground(blue);
		
	}

	public Composite getComposite() {
		
		return this.composite;
	}
	
	// ------------------------------------------------------------------------
	
	// SETTERS

	public void setTicketId(String str){
		this.ticketIDInput.setText(str);
	}
	
	public void setTicketTitle(String str){
		this.ticketTitleInput.setText(str);
	}
	
	public void setTicketDescription(String str){
		this.ticketDescInput.setText(str);
	}
	
	public void setTicketPriorityLevel(String str){
		this.ticketPriorityLevelInput.setText(str);
	}

	public void setTicketProcessStatus(String str){
		this.ticketProcessStatusInput.setText(str);
	}
	
	public void setTicketProjectId(String str){
		this.projectIDInput.setText(str);
	}
	
	public void setTicketCurrentEditorUid(String str){
		this.currentEditorUIDInput.setText(str);
	}

	public void setTicketAssignedTeam(String str){
		this.assignedTeamIDInput.setText(str);
	}
	
	public void setTicketStartDate(ArrayList<Integer> dateYMD){
		int year = dateYMD.get(0);
		int month = dateYMD.get(1);
		int day = dateYMD.get(2);
		this.ticketStartDateInput.setDate(year, month, day);
	}
	
	public void setTicketEndDate(ArrayList<Integer> dateYMD){
		int year = dateYMD.get(0);
		int month = dateYMD.get(1);
		int day = dateYMD.get(2);
		this.ticketEndDateInput.setDate(year, month, day);
	}

}
