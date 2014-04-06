package projectManager;

import java.util.Vector;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;

public class ProjectViewController implements Listener {

	private Shell shell;
	private Composite composite;
	private IProjectState currentState;
	private IProjectState projectListView;
	private IProjectState projectDetailView;
	private IProjectState projectEditView;
	private IProjectState projectCreateView;
	
	
	public ProjectViewController(Composite composite){
		this.composite = composite;
		projectListView = new ProjectListView(this, this.composite);
		projectDetailView = new ProjectDetailView(this, this.composite);
		projectEditView = new ProjectEditView(this, this.composite);
		projectCreateView = new ProjectCreateView(this, this.composite);
		setCurrentView(projectListView);
	}
	
	public void setCurrentView(IProjectState currentState){
		this.currentState = currentState;
		this.currentState.show();
		
	}
	
	public void setComposite(Composite composite){
		this.composite = composite;
	}
	
	public Composite getComposite(){
		return this.composite;
	}
	
	public void handleEvent(Event event) {
		if(event.widget == projectListView.getEditButton()){
			System.out.println("HIER");
		}
		
		if(event.widget == projectListView.getCancelButton()){
			System.out.println("Cancel gedrückt");
		}
	}
	
}
