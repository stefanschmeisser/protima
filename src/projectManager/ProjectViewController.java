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
	private ArrayList<Project> projectListData;
	
	public ProjectViewController(Shell shell){
		this.shell = shell;
		projectListView = new ProjectListView(this, this.shell);
		projectDetailView = new ProjectDetailView(this, this.shell);
		projectEditView = new ProjectEditView(this, this.shell);
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
			this.projectDetailView.show();
		}
		this.shell.layout();
	}
	
	public void fillTableData(ArrayList<Project> projectListData){
		
		this.projectListData = projectListData;
		
		if(projectListData != null){
			for(int i=0; i < 3; i++){
				TableColumn tableColumn = new TableColumn(this.projectListView.getTable(), SWT.LEFT);
				if(i == 0) {tableColumn.setText("Project ID");}
				if(i == 1) {tableColumn.setText("Name");}
				if(i == 2) {tableColumn.setText("Description");}
//				if(i == 3) {tableColumn.setText("Projectmanager");}
			}
			for(int i=0; i < projectListData.size(); i++){
				TableItem tableItem = new TableItem(this.projectListView.getTable(), SWT.NONE);
				tableItem.setText(0, Integer.toString(projectListData.get(i).getProjectId()));
				tableItem.setText(1, projectListData.get(i).getProjectName());
				tableItem.setText(2, "hallo");
				this.projectListView.getTable().getColumn(i).pack();
			}
		}
	}
	
	public void handleEvent(Event event) {
		 
		if(event.widget == ProjectListView.createButton){
			setCurrentView(this.projectEditView);
		}
		
		if(event.widget == projectListView.getTable()){
			System.out.println(projectListView.getTable().getSelectionIndices());
			TableItem[] selection = projectListView.getTable().getSelection();

			for(int i=0; i < this.projectListData.size(); i++){
				if(Integer.parseInt(selection[0].getText()) == this.projectListData.get(i).getProjectId()){
					System.out.println("HIER BIN ICH" + this.projectListData.get(i).getProjectId());
				}
			}
			
		}
		
//		if(event.widget == projectListView.getCancelButton()){
//			System.out.println("Cancel gedrückt");
//		}
		
	}
	
}
