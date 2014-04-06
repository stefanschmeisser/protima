package projectManager;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;

import frontController.IContentState;

public class ProjectController implements IContentState {
	
	private Shell shell;
	private Composite composite;
	private IProjectDAO projectDAO;
	private ProjectViewController projectViewController;
	
	//getAllProjects() List<int>
	public ProjectController(Composite composite){
		this.composite = composite;
		this.projectDAO = new ProjectDaoMySql();
		this.projectViewController = new ProjectViewController(composite);	
	}
	
	
	public void show(){

	}


	@Override
	public void setCurrentView(IContentState pCurrentState) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void setComposite(Composite composite) {
		this.composite = composite;
		this.projectViewController.setComposite(composite);
	}

	@Override
	public Composite getComposite() {
		
		return null;
	}

}
