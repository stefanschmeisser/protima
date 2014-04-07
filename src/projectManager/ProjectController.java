package projectManager;

import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;

import frontController.IContentState;

public class ProjectController implements IContentState {
	
	private Shell shell;
	private Composite composite;
	private IProjectDAO projectDAO;
	private ProjectViewController projectViewController;
	
	//getAllProjects() List<int>
	public ProjectController(Shell shell){
		this.shell = shell;
		this.projectDAO = new ProjectDaoMySql();
		this.projectViewController = new ProjectViewController(shell);
	}


//	@Override
//	public void setCurrentView(IContentState currentState) {
//		this.currentState = currentState;
//	}


//	@Override
//	public void setComposite(Composite composite) {
//		this.composite = composite;
//		this.projectViewController.setComposite(composite);
//	}

}
