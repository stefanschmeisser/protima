package projectManager;

import java.util.Vector;

import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;

public class ProjectViewController implements Listener {

	private Shell shell;
	private IProjectState currentState;
//	private Vector<IProjectState> states;
	private ProjectListView projectListView;
	private ProjectDetailView projectDetailView;
	private ProjectEditView projectEditView;
	private ProjectCreateView projectCreateView;
	
	
	public ProjectViewController(Shell shell){
//		states = new Vector();
		this.shell = shell;
		projectListView = new ProjectListView(this, this.shell);
		projectDetailView = new ProjectDetailView(this, this.shell);
		projectEditView = new ProjectEditView(this, this.shell);
		projectCreateView = new ProjectCreateView(this, this.shell);
	}
	
	public void setCurrentView(IProjectState currentState){
		this.currentState = currentState;
	}
	
	public void handleEvent(Event event) {
		if (event.widget == projectListView.editButton) {
			System.console().writer().println("HIER");
		}
	}
	
}
