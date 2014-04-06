package projectManager;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;

public class ProjectDetailView implements IProjectState {
	
	private ProjectViewController projectViewController;
	private Composite composite;

	public ProjectDetailView(ProjectViewController projectViewController, Composite composite){
		this.projectViewController = projectViewController;
		this.composite = composite;
	}
	
	@Override
	public void show() {
		
	}

	@Override
	public Composite getComposite() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Button getEditButton() {
		// TODO Auto-generated method stub
		return null;
	}

}
