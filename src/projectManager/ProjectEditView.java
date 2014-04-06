package projectManager;

import org.eclipse.swt.widgets.Shell;

public class ProjectEditView implements IProjectState {

	private ProjectViewController projectViewController;
	private Shell shell;
	
	public ProjectEditView(ProjectViewController projectViewController, Shell shell){
		this.projectViewController = projectViewController;
		this.shell = shell;
	}
	
	@Override
	public void show() {
		// TODO Auto-generated method stub

	}

}
