package teamManager;

import java.awt.Color;

import org.eclipse.swt.*;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;

public class TeamListView implements ITeamState {
	
	private Shell shell;
	private Composite composite, content;
	private TeamViewController teamViewController;
	public static Button createButton, saveButton, cancelButton, editButton, deleteButton;
	private Label labelTeamID, labelTeamName, labelTeamLeader;
	private Label TeamHeader;
	private Text textTeamId, textTeamName, textTeamLeader;
	private Table table;
	
	
	public TeamListView(TeamViewController teamViewController, Composite content){
		this.teamViewController = teamViewController;
		this.content = content;
		this.composite = new Composite(this.content, SWT.NONE);
	}
	
	@Override
	public void show() {		
	
		GridLayout layout = new GridLayout();
		layout.numColumns = 12;
	    layout.makeColumnsEqualWidth = true;
	    this.composite.setLayout(layout);
	    
	    GridData header = new GridData(GridData.FILL_HORIZONTAL);
	//    header = new GridData(GridData.HORIZONTAL_ALIGN_BEGINNING);
	    Label ticket = new Label(this.composite, SWT.NONE);
	    ticket.setText("Team Overview");
	    
	    Composite compgrid = new Composite(this.composite, SWT.NONE);
	    GridData data = new GridData(GridData.FILL_BOTH);
	    data.horizontalSpan = 3;
	    data.widthHint = this.composite.getSize().x;
	    compgrid.setLayoutData(data);
	    layout = new GridLayout();
	    layout.numColumns = 12;
	    layout.marginHeight = 15;
	    compgrid.setLayout(layout);
	    
	    data = new GridData();
	    data.grabExcessHorizontalSpace = true;
	    data.horizontalAlignment = GridData.END;
	    
	    data = new GridData(GridData.HORIZONTAL_ALIGN_END);
		createButton = new Button(compgrid, SWT.PUSH);
		Image imageCreateProject = new Image(Display.getCurrent(), "content/addItemToList.png");
	    createButton.setImage(imageCreateProject);
	    createButton.setSize(34,34);
	    createButton.setLayoutData(data);
	    createButton.addListener(SWT.Selection, this.teamViewController);
	    
	    data = new GridData(GridData.HORIZONTAL_ALIGN_END);
	    editButton = new Button(compgrid, SWT.PUSH);
	    Image imageEditProject = new Image(Display.getCurrent(), "content/editListItem.png");
	    editButton.setImage(imageEditProject);
	    editButton.setSize(34,34);
	    editButton.setLayoutData(data);
	    editButton.addListener(SWT.Selection, this.teamViewController);    
	    
	    data = new GridData(GridData.HORIZONTAL_ALIGN_END);
		deleteButton = new Button(compgrid, SWT.PUSH);
		Image imageDeleteProject = new Image(Display.getCurrent(), "content/deleteFromList.png");
		deleteButton.setImage(imageDeleteProject);
		deleteButton.setSize(34,34);
		deleteButton.setLayoutData(data);
		deleteButton.addListener(SWT.Selection, this.teamViewController);
	
		data = new GridData();
	    data.horizontalAlignment = GridData.FILL;
	    data.grabExcessHorizontalSpace = true;
	    data.horizontalSpan = 12;
	    data.heightHint = 100;
	    
	    Composite tableComposite = new Composite(this.composite, SWT.NONE);
	    GridData tableGrid = new GridData(GridData.FILL_HORIZONTAL);
	    tableGrid.horizontalSpan = 12;
	    tableGrid.widthHint = this.composite.getSize().x;
	    tableGrid.minimumWidth = this.composite.getSize().y;
	//    tableGrid.grabExcessHorizontalSpace = true;
	    data.widthHint = this.composite.getParent().getSize().x;
	    tableComposite.setLayoutData(tableGrid);
	    tableComposite.setLayout(layout);
	    
	    this.table = new Table(tableComposite, SWT.BORDER);
	    this.table.setSize(tableComposite.getSize().x, tableComposite.getSize().y);
	    this.table.setLayoutData(tableGrid);	    
	    this.table.setHeaderVisible(true);
	    this.table.addListener(SWT.Selection, this.teamViewController);
	
	    data = new GridData();
	    data.horizontalAlignment = GridData.FILL;
	    data.grabExcessHorizontalSpace = true;
	    data.horizontalSpan = 5;
	    data.heightHint = 200;
	    
	    Composite compdetail = new Composite(this.composite, SWT.NONE);
	    compdetail.setLayoutData(data);
	
	}

	public Table getTable(){
		return this.table;
	}
	
	public Composite getComposite(){
		return this.composite;
	}
	
	public Button getCancelButton(){
		return this.cancelButton;
	}
	
	public int getTeamId(){
		return Integer.parseInt(this.textTeamId.getText());
	}
	
	public String getTeamName(){
		return this.textTeamName.getText();
	}
	
	public void setTeamName(String teamName){
		this.textTeamName.setText(teamName);
	}

	@Override
	public void setComposite(Composite composite) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Combo getCombobox() {
		// TODO Auto-generated method stub
		return null;
	}
}
