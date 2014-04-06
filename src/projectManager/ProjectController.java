package projectManager;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;

import frontController.IContentState;

public class ProjectController implements IContentState {
	
	private Shell shell;
	private IProjectDAO projectDAO;
	private ProjectViewController projectViewController;
	
	//getAllProjects() List<int>
	public ProjectController(Shell shell){
		this.shell = shell;
		this.projectDAO = new ProjectDaoMySql();
		this.projectViewController = new ProjectViewController(this.shell);	
	}
	
	
	public void show(){
		System.out.println("ProjectController show()");
	}


	@Override
	public void setCurrentView(IContentState pCurrentState) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void setComposite(Composite composite) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public Composite getComposite() {
		// TODO Auto-generated method stub
		return null;
	}

}
