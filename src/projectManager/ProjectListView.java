package projectManager;

import org.eclipse.swt.*;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class ProjectListView implements IProjectState {

	private Shell shell;
	private Composite composite;
	private ProjectViewController projectViewController;
	public Button editButton;
	
	public ProjectListView(ProjectViewController projectViewController, Shell shell){
		this.projectViewController = projectViewController;
		this.shell = shell;
	}
	
	@Override
	public void show() {		
		composite = new Composite(this.shell, SWT.NONE);
		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 1;
		composite.setLayout(gridLayout);
		
		this.shell.setText("ProMiTa - Project");
		
		editButton = new Button(composite, SWT.PUSH);
        editButton.setText("Edit");
        editButton.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
        
        editButton.addListener(SWT.Selection, this.projectViewController);
        
	}

}
