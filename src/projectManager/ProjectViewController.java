package projectManager;

import java.util.ArrayList;
import java.util.Vector;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;

import ticketManager.TicketTableModel;

public class ProjectViewController implements Listener {

	private Shell shell;
	private IProjectState currentState;
	private IProjectState projectListView;
	private IProjectState projectDetailView;
	private IProjectState projectEditView;
	private IProjectState projectCreateView;
	
	public ProjectViewController(Shell shell){
		this.shell = shell;
		projectListView = new ProjectListView(this, this.shell);
		projectDetailView = new ProjectDetailView(this, this.shell);
		projectEditView = new ProjectEditView(this, this.shell);
		setCurrentView(projectListView);
	}
	
	public void setCurrentView(IProjectState currentState){
		System.out.println(this.currentState);
		if(this.currentState != null){
			this.currentState.getComposite().dispose();
		}
		this.currentState = currentState;
		this.currentState.show();
		this.shell.setLayout(new GridLayout());
	}
	
	public void fillTableData(ArrayList<Project> projectListData){
		if(projectListData != null){
			for(int i=0; i < 3; i++){
				TableColumn tableColumn = new TableColumn(this.projectListView.getTable(), SWT.LEFT);
				if(i == 0) {tableColumn.setText("Project ID");}
				if(i == 1) {tableColumn.setText("Name");}
				if(i == 2) {tableColumn.setText("Description");}
//				if(i == 3) {tableColumn.setText("Projectmanager");}
				System.out.println("tableColumn" + i);
			}
			for(int i=0; i < projectListData.size(); i++){
				TableItem tableItem = new TableItem(this.projectListView.getTable(), SWT.NONE);
				tableItem.setText(0, Integer.toString(projectListData.get(i).getProjectId()));
				tableItem.setText(1, projectListData.get(i).getProjectName());
				tableItem.setText(2, "hallo");
				System.out.println("projectListData");
				this.projectListView.getTable().getColumn(i).pack();
			}
		}
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
