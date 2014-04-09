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
	private ProjectController projectController; 
	private IProjectState currentState;
	private IProjectState projectListView;
	private IProjectState projectDetailView;
	private IProjectState projectEditView;
	private IProjectState projectCreateView;
	private ArrayList<Project> projectListData;
	
	public ProjectViewController(Shell shell, ProjectController projectController){
		this.shell = shell;
		this.projectController = projectController;
		projectListView = new ProjectListView(this, this.shell);
		projectDetailView = new ProjectDetailView(this, this.shell);
		setCurrentView(projectListView);
	}
	
	public void setCurrentView(IProjectState currentState){
		if(this.currentState != null){
			this.currentState.getComposite().dispose();
		}
		if(this.currentState == this.projectListView){
			this.projectDetailView.getComposite().dispose();
		}
		this.currentState = currentState;
		this.currentState.show();
		if(this.currentState == this.projectListView){
			this.fillTableData(this.projectController.getTableListData());
			this.projectDetailView.show();
		}
		this.shell.layout();
	}
	
	public void fillTableData(ArrayList<Project> projectListData){
		this.projectListData = projectListData;
		if(this.projectListData != null){
			for(int i=0; i < this.projectListData.size(); i++){
				TableColumn tableColumn = new TableColumn(this.projectListView.getTable(), SWT.LEFT);
				if(i == 0) {tableColumn.setText("Project ID");}
				if(i == 1) {tableColumn.setText("Name");}
				if(i == 2) {tableColumn.setText("Description");}
				if(i == 3) {tableColumn.setText("Projectmanager");}
			}
			for(int j=0; j < this.projectListData.size(); j++){
				System.out.println(j);
				TableItem tableItem = new TableItem(this.projectListView.getTable(), SWT.NONE);
				tableItem.setText(0, Integer.toString(projectListData.get(j).getProjectId()));
				tableItem.setText(1, projectListData.get(j).getProjectName());
				tableItem.setText(2, projectListData.get(j).getProjectDescription());
				tableItem.setText(3, Integer.toString(projectListData.get(j).getProjectManager()));
				this.projectListView.getTable().getColumn(j).pack();
			}
		}
	}
	
	public void handleEvent(Event event) {
		 
		if(event.widget == ProjectListView.createButton){
			System.out.println("Create Button");
			this.projectCreateView = new ProjectCreateView(this, this.shell);
			setCurrentView(this.projectCreateView);
		}
		
		if(event.widget == ProjectListView.editButton){
			System.out.println("EDIT Button");
			this.projectEditView = new ProjectEditView(this, this.shell);
			setCurrentView(this.projectEditView);
		}
		
		if(event.widget == ProjectListView.deleteButton){
			
		}
		
		if(event.widget == ProjectCreateView.createButton){
			System.out.println("create");
			int projectManagerID;
			if(ProjectCreateView.comboProjectManager.getSelectionIndex() != -1){
				projectManagerID = ProjectCreateView.comboProjectManager.getSelectionIndex();
			}else{
				projectManagerID = 10;
			}
			
			this.projectController.setProject(ProjectCreateView.textProjectName.getText(), ProjectCreateView.textProjectDescription.getText(), projectManagerID);
			this.projectListView = new ProjectListView(this, this.shell);
			this.projectDetailView = new ProjectDetailView(this, this.shell);
			setCurrentView(this.projectListView);
		}
		
		if(event.widget == ProjectEditView.cancelButton || event.widget == ProjectCreateView.cancelButton ){
			this.projectListView = new ProjectListView(this, this.shell);
			this.projectDetailView = new ProjectDetailView(this, this.shell);
			setCurrentView(this.projectListView);
		}
		
		if(event.widget == projectListView.getTable()){
			System.out.println(projectListView.getTable().getSelectionIndices());
			TableItem[] selection = projectListView.getTable().getSelection();

			for(int i=0; i < this.projectListData.size(); i++){
				if(Integer.parseInt(selection[0].getText()) == this.projectListData.get(i).getProjectId()){
					
				}
			}
			
		}
		
//		if(event.widget == projectListView.getCancelButton()){
//			System.out.println("Cancel gedrückt");
//		}
		
	}
	
}
