package projectManager;

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

import userRights.ProjectManager;

public class ProjectListView implements IProjectState {

	private Shell shell;
	private Composite composite, content;
	private ProjectViewController projectViewController;
	public static Button createButton, saveButton, cancelButton, editButton, deleteButton;
	private Label labelProjectID, labelProjectName, labelProjectDescription, labelProjectManager;
	private Label projectHeader;
	private Text textProjectID, textProjectName, textProjectDescription;
	private Combo comboProjectManager;
	private ProjectManager projectManager;
	private Table table;
	
	public ProjectListView(ProjectViewController projectViewController, Composite content){
		this.projectViewController = projectViewController;
		this.content = content;
		this.composite = new Composite(this.content, SWT.NONE);
	}
	
	@Override
	public void show() {		
		
		GridLayout layout = new GridLayout();
		layout.numColumns = 12;
	    layout.makeColumnsEqualWidth = true;
	    this.composite.setLayout(layout);
	    
//	    GridData header = new GridData(GridData.FILL_HORIZONTAL);
	    GridData header = new GridData(GridData.HORIZONTAL_ALIGN_BEGINNING);
	    Label ticket = new Label(this.composite, SWT.NONE);
	    ticket.setText("Ticket Overview");
	    
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
        createButton.addListener(SWT.Selection, this.projectViewController);
        
        /**
         * noch im Listener chekcne ob der button ausgewählt wurde
         */
        data = new GridData(GridData.HORIZONTAL_ALIGN_END);
        editButton = new Button(compgrid, SWT.PUSH);
        Image imageEditProject = new Image(Display.getCurrent(), "content/editListItem.png");
        editButton.setImage(imageEditProject);
        editButton.setSize(34,34);
        editButton.setLayoutData(data);
        editButton.addListener(SWT.Selection, this.projectViewController);  
        
        data = new GridData(GridData.HORIZONTAL_ALIGN_END);
		deleteButton = new Button(compgrid, SWT.PUSH);
		Image imageDeleteProject = new Image(Display.getCurrent(), "content/deleteFromList.png");
		deleteButton.setImage(imageDeleteProject);
		deleteButton.setSize(34,34);
		deleteButton.setLayoutData(data);
		deleteButton.addListener(SWT.Selection, this.projectViewController);
	
		data = new GridData();
	    data.horizontalAlignment = GridData.FILL;
	    data.grabExcessHorizontalSpace = true;
	    data.horizontalSpan = 12;
	    data.heightHint = 100;
	    
	    Composite tableComposite = new Composite(this.composite, SWT.NONE);
	    GridData tableGrid = new GridData(GridData.FILL_HORIZONTAL);
	    tableGrid.horizontalSpan = 12;
	    tableGrid.widthHint = shell.getSize().x;
	    tableGrid.grabExcessHorizontalSpace = true;
	    tableComposite.setLayoutData(tableGrid);
	    tableComposite.setLayout(new GridLayout(12, true));
	    
	    this.table = new Table(tableComposite, SWT.BORDER);
	    this.table.setSize(this.shell.getSize().x, this.shell.getSize().y);
	    this.table.setLayoutData(tableGrid);	    
	    this.table.setHeaderVisible(true);
	    this.table.addListener(SWT.Selection, this.projectViewController);
	}
	
	public Table getTable(){
		return this.table;
	}
	
	@Override
	public Composite getComposite(){
		return this.composite;
	}
	
	@Override
	public void setComposite(Composite composite){
		this.composite = composite;
	}
	
	public int getProjectID(){
		return Integer.parseInt(this.textProjectID.getText());
	}
	
	public void setProjectID(int projectID){
		this.textProjectID.setText(Integer.toString(projectID));
	}
	
	public String getProjectName(){
		return this.textProjectName.getText();
	}
	
	public void setProjectName(String projectName){
		this.textProjectName.setText(projectName);
	}
	
	public String getProjectDescription(){
		return this.textProjectDescription.getText();
	}
	
	public void setProjectDescription(String projectDescription){
		this.textProjectDescription.setText(projectDescription);
	}
	
	public Object getProjectManager(){
		return this.comboProjectManager.getData();
	}
	
	public void setProjectManager(ProjectManager projectManager){
		this.projectManager = projectManager;
	}
	
}
