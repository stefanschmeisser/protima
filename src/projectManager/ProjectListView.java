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

import userManager.ProjectManager;

public class ProjectListView implements IProjectState {

	private Shell shell;
	private Composite composite;
	private ProjectViewController projectViewController;
	private Button createButton, saveButton, cancelButton;
	private Label labelProjectID, labelProjectName, labelProjectDescription, labelProjectManager;
	private Text textProjectID, textProjectName, textProjectDescription;
	private Combo comboProjectManager;
	private ProjectManager projectManager;
	
	public ProjectListView(ProjectViewController projectViewController, Composite composite){
		this.projectViewController = projectViewController;
		this.composite = composite;
	}
	
	@Override
	public void show() {		

		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 3;
		composite.setLayout(gridLayout);
		
		createButton = new Button(composite, SWT.PUSH);
		Image imageCreateProject = new Image(Display.getCurrent(), "content/create.png");
        createButton.setImage(imageCreateProject);
        createButton.setLocation(0, 0);
        createButton.setLayoutData(new GridData(GridData.VERTICAL_ALIGN_BEGINNING));
        
        Table table = new Table(composite, SWT.RADIO | SWT.BORDER | SWT.V_SCROLL | SWT.H_SCROLL);
        table.setHeaderVisible(true);
        table.setSize(composite.getShell().getSize().x, composite.getShell().getSize().y);
        table.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
        String[] titles = {"Editieren", "Projekt ID", "Name"};

        for (int loopIndex = 0; loopIndex < titles.length; loopIndex++) {
          TableColumn column = new TableColumn(table, SWT.NULL);
          column.setText(titles[loopIndex]);
          column.setWidth(table.getSize().x/4);
        }

        for (int loopIndex = 0; loopIndex < 24; loopIndex++) {
          TableItem item = new TableItem(table, SWT.NONE);
          item.setText("Item " + loopIndex);
          Image imageEditProject = new Image(Display.getCurrent(), "content/edit.png");
          item.setImage(0, imageEditProject);
          item.setText(1, "Item " + loopIndex);
          item.setText(2, "Yes");
        }

        for (int loopIndex = 0; loopIndex < titles.length; loopIndex++) {
          table.getColumn(loopIndex).pack();
        }

//        table.setBounds(25, 25, 1000, 400);
       
        Composite rightColumn = new Composite(composite, SWT.NONE);
        rightColumn.setLayoutData(new GridData(GridData.FILL_HORIZONTAL | GridData.FILL_VERTICAL));
        
        GridLayout gridLayout2 = new GridLayout();
		gridLayout2.numColumns = 2;
		rightColumn.setLayout(gridLayout2);
		
		labelProjectID = new Label(rightColumn, SWT.NONE);
		labelProjectID.setText("Projekt ID: ");
		labelProjectID.setLayoutData(new GridData(GridData.BEGINNING));
		
		textProjectID = new Text(rightColumn, SWT.READ_ONLY | SWT.BORDER);
		textProjectID.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		
		labelProjectManager = new Label(rightColumn, SWT.NONE);
		labelProjectManager.setText("Projektmanager: ");
		labelProjectManager.setLayoutData(new GridData(GridData.BEGINNING));
		
		comboProjectManager = new Combo(rightColumn, SWT.NONE);
		comboProjectManager.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		
		labelProjectName = new Label(rightColumn, SWT.NONE);
		labelProjectName.setText("Name: ");
		labelProjectName.setLayoutData(new GridData(GridData.BEGINNING));
		
		textProjectName = new Text(rightColumn, SWT.NONE);
		textProjectName.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		
		labelProjectDescription = new Label(rightColumn, SWT.NONE);
		labelProjectDescription.setText("Beschreibung: ");
		labelProjectDescription.setLayoutData(new GridData(GridData.VERTICAL_ALIGN_BEGINNING));
		
		textProjectDescription = new Text(rightColumn, SWT.MULTI | SWT.WRAP);
		textProjectDescription.setLayoutData(new GridData(GridData.FILL_HORIZONTAL | GridData.FILL_VERTICAL));
		
		saveButton = new Button(rightColumn, SWT.PUSH);
		saveButton.setText("Speichern");
		saveButton.setLayoutData(new GridData(GridData.BEGINNING));
		
        cancelButton = new Button(rightColumn, SWT.PUSH);
        cancelButton.setText("Cancel");
        cancelButton.setLayoutData(new GridData(GridData.BEGINNING));
//        
//        editButton.addListener(SWT.Selection, this.projectViewController);
//        cancelButton.addListener(SWT.Selection, this.projectViewController);
	}
	

	public Button getEditButton(){
		return this.createButton;
	}
	
	public Button getCancelButton(){
		return this.cancelButton;
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
