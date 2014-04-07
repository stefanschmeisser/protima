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
		this.shell = shell;
		projectListView = new ProjectListView(this, this.shell);
		projectDetailView = new ProjectDetailView(this, this.shell);
		projectEditView = new ProjectEditView(this, this.shell);
		setCurrentView(projectListView);
	}
	
	public void setCurrentView(IProjectState currentState){
		this.currentState.getComposite().dispose();
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
		 
		if(event.widget == ProjectListView.createButton){
			System.out.println("create");
			projectCreateView = new ProjectCreateView(this, this.shell);
			setCurrentView(projectCreateView);
		}
		
//		if(event.widget == projectListView.getCancelButton()){
//			System.out.println("Cancel gedrückt");
//		}
		
	}
	
}
