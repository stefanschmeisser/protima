package projectManager;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.Text;

import userRights.ProjectManager;

public class ProjectDetailView implements IProjectState {
	
	private ProjectViewController projectViewController;
	private Shell shell;
	private Composite composite;
	private Button createButton, saveButton, cancelButton;
	private Label labelProjectID, labelProjectName, labelProjectDescription, labelProjectManager;
	private Text textProjectID, textProjectName, textProjectDescription;
	private Combo comboProjectManager;
	private ProjectManager projectManager;

	public ProjectDetailView(ProjectViewController projectViewController, Shell shell){
		this.projectViewController = projectViewController;
		this.shell = shell;
		this.composite = new Composite(this.shell, SWT.NONE);
		this.composite.setLocation(0,0);
	}
	
	@Override
	public void show() {
		
		Composite header = new Composite(this.composite, SWT.NONE);
		
		GridLayout layout = new GridLayout();
		layout.numColumns = 12;
	    layout.makeColumnsEqualWidth = true;
	    header.setLayout(layout);
	    
//	    GridData header = new GridData(GridData.FILL_HORIZONTAL);
//	    GridData header = new GridData(GridData.HORIZONTAL_ALIGN_BEGINNING);
	    Label projectDetailHeader = new Label(header, SWT.NONE);
	    projectDetailHeader.setText("Detail View");
	    
	    
		
//		Composite rightColumn = new Composite(composite, SWT.NONE);
//        rightColumn.setLayoutData(new GridData(GridData.FILL_HORIZONTAL | GridData.FILL_VERTICAL));
//        
//        GridLayout gridLayout2 = new GridLayout();
//		gridLayout2.numColumns = 2;
//		rightColumn.setLayout(gridLayout2);
//		
//		Composite content = new Composite(this.composite, SWT.NONE);
//	    
//	    labelProjectID = new Label(content, SWT.NONE);
//		labelProjectID.setText("Projekt ID: ");
//		labelProjectID.setLayoutData(new GridData(GridData.BEGINNING));
//		
//		textProjectID = new Text(content, SWT.READ_ONLY | SWT.BORDER);
//		textProjectID.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
//		
//		labelProjectManager = new Label(rightColumn, SWT.NONE);
//		labelProjectManager.setText("Projektmanager: ");
//		labelProjectManager.setLayoutData(new GridData(GridData.BEGINNING));
//		
//		comboProjectManager = new Combo(rightColumn, SWT.NONE);
//		comboProjectManager.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
//		
//		labelProjectName = new Label(rightColumn, SWT.NONE);
//		labelProjectName.setText("Name: ");
//		labelProjectName.setLayoutData(new GridData(GridData.BEGINNING));
//		
//		textProjectName = new Text(rightColumn, SWT.NONE);
//		textProjectName.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
//		
//		labelProjectDescription = new Label(rightColumn, SWT.NONE);
//		labelProjectDescription.setText("Beschreibung: ");
//		labelProjectDescription.setLayoutData(new GridData(GridData.VERTICAL_ALIGN_BEGINNING));
//		
//		textProjectDescription = new Text(rightColumn, SWT.MULTI | SWT.WRAP);
//		textProjectDescription.setLayoutData(new GridData(GridData.FILL_HORIZONTAL | GridData.FILL_VERTICAL));
//		
//		saveButton = new Button(rightColumn, SWT.PUSH);
//		saveButton.setText("Speichern");
//		saveButton.setLayoutData(new GridData(GridData.BEGINNING));
//		
//        cancelButton = new Button(rightColumn, SWT.PUSH);
//        cancelButton.setText("Cancel");
//        cancelButton.setLayoutData(new GridData(GridData.BEGINNING));
	}

	@Override
	public Composite getComposite(){
		return this.composite;
	}

	@Override
	public void setComposite(Composite composite){
		this.composite = composite;
	}
	
	@Override
	public Table getTable() {
		// TODO Auto-generated method stub
		return null;
	}


}
