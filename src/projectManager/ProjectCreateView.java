package projectManager;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
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
import org.eclipse.swt.widgets.Text;

public class ProjectCreateView implements IProjectState {

	private ProjectViewController projectViewController;
	private Shell shell;
	private Composite composite;
	private Label labelProjectID, labelProjectName, labelProjectDescription, labelProjectManager;
	private Text textProjectID, textProjectName, textProjectDescription;
	private Combo comboProjectManager;
	public static Button createButton, cancelButton;
	
	public ProjectCreateView(ProjectViewController projectViewController, Shell shell){
		this.projectViewController = projectViewController;
		this.shell = shell;
		this.composite = new Composite(this.shell, SWT.NONE);
	}
	
	@Override
	public void show() {
		
this.composite.setLayout(new GridLayout());
	    
	    Composite header = new Composite(this.composite, SWT.NONE);
	    
		GridLayout layout = new GridLayout();
		layout.numColumns = 12;
	    layout.makeColumnsEqualWidth = true;
	    header.setLayout(layout);

	    Label projectEditHeader = new Label(header, SWT.NONE);
	    projectEditHeader.setText("Detail View");
	    FontData[] fD = projectEditHeader.getFont().getFontData();
	    fD[0].setHeight(16);
	    projectEditHeader.setFont( new Font(Display.getCurrent(),fD[0]));

		Composite content = new Composite(this.composite, SWT.NONE);
	    content.setLayout(new GridLayout(2, true));
		
	    labelProjectID = new Label(content, SWT.NONE);
		labelProjectID.setText("Projekt ID: ");
		labelProjectID.setLayoutData(new GridData(GridData.BEGINNING));
		
		textProjectID = new Text(content, SWT.READ_ONLY | SWT.BORDER);
		textProjectID.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		
		labelProjectManager = new Label(content, SWT.NONE);
		labelProjectManager.setText("Projektmanager: ");
		labelProjectManager.setLayoutData(new GridData(GridData.BEGINNING));
		
		comboProjectManager = new Combo(content, SWT.NONE);
		comboProjectManager.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		
		labelProjectName = new Label(content, SWT.NONE);
		labelProjectName.setText("Name: ");
		labelProjectName.setLayoutData(new GridData(GridData.BEGINNING));
		
		textProjectName = new Text(content, SWT.NONE);
		textProjectName.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		
		labelProjectDescription = new Label(content, SWT.NONE);
		labelProjectDescription.setText("Beschreibung: ");
		labelProjectDescription.setLayoutData(new GridData(GridData.VERTICAL_ALIGN_BEGINNING));
		
		textProjectDescription = new Text(content, SWT.MULTI | SWT.WRAP);
		textProjectDescription.setLayoutData(new GridData(GridData.FILL_HORIZONTAL | GridData.FILL_VERTICAL));
		
		Composite buttons = new Composite(this.composite, SWT.NONE);
	    buttons.setLayout(new GridLayout(2, true));
		
	    createButton = new Button(buttons, SWT.PUSH);
	    createButton.setText("Projekt erstellen");
	    createButton.setLayoutData(new GridData(GridData.BEGINNING));
		
		cancelButton = new Button(buttons, SWT.PUSH);
		cancelButton.setText("Abbrechen");
		cancelButton.setLayoutData(new GridData(GridData.BEGINNING));
	}

	@Override
	public Composite getComposite(){
		return this.composite;
	}

	@Override
	public Table getTable() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setComposite(Composite composite) {
		// TODO Auto-generated method stub
		
	}

}
