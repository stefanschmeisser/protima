package projectManager;

import org.eclipse.swt.widgets.Shell;

public class ProjectDetailView implements IProjectState {
	
	private ProjectViewController projectViewController;
	private Shell shell;

	public ProjectDetailView(ProjectViewController projectViewController, Shell shell){
		this.projectViewController = projectViewController;
		this.shell = shell;
	}
	
	@Override
	public void show() {
		
	}

}
