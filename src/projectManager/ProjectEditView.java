package projectManager;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;

public class ProjectEditView implements IProjectState {

	private ProjectViewController projectViewController;
	private Composite composite;
	
	public ProjectEditView(ProjectViewController projectViewController, Composite composite){
		this.projectViewController = projectViewController;
		this.composite = composite;
	}
	
	@Override
	public void show() {
		// TODO Auto-generated method stub

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
