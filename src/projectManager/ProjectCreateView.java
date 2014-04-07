package projectManager;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;

public class ProjectCreateView implements IProjectState {

	private ProjectViewController projectViewController;
	private Shell shell;
	private Composite composite;
	
	public ProjectCreateView(ProjectViewController projectViewController, Shell shell){
		this.projectViewController = projectViewController;
		this.shell = shell;
		this.composite = new Composite(this.shell, SWT.NONE);
	}
	
	@Override
	public void show() {

	}

	@Override
	public Composite getComposite(){
		return this.composite;
	}

}
