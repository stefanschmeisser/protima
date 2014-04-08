package projectManager;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;

public class ProjectEditView implements IProjectState {

	private ProjectViewController projectViewController;
	private Shell shell;
	private Composite composite;
	
	public ProjectEditView(ProjectViewController projectViewController, Shell shell){
		this.projectViewController = projectViewController;
		this.shell = shell;
		this.composite = new Composite(this.shell, SWT.NONE);
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
	    ticket.setText("Detail View");
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

}
