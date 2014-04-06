package projectManager;

import org.eclipse.swt.widgets.Shell;

public class ProjectCreateView implements IProjectState {

	private ProjectViewController projectViewController;
	private Shell shell;
	
	public ProjectCreateView(ProjectViewController projectViewController, Shell shell){
		this.projectViewController = projectViewController;
		this.shell = shell;
	}
	
	@Override
	public void show() {
		// TODO Auto-generated method stub

	}

}
