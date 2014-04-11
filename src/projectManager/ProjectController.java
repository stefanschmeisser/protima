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
import userRights.ProjectManager;
import frontController.IContentState;

public class ProjectController implements IContentState {
	
	private Shell shell;
	private Composite composite;
	private IProjectDAO projectDAO;
	private ProjectViewController projectViewController;
	
	public ProjectController(Composite composite){
		this.composite = composite;
		this.projectDAO = new ProjectDaoMySql();
		this.projectViewController = new ProjectViewController(this.composite, this);
	}
	
	public ArrayList<Project> getTableListData(){
		return this.projectDAO.getProjectList();
	}
	
	public Project getProject(int projectID){
		return this.projectDAO.getProject(projectID);
	}
	
	public void setProject(String projectname, String projectDescription, int projectManager){
		this.projectDAO.createProject(projectname, projectDescription, projectManager);
	}
	
	public ArrayList<ProjectManager> getProjectManagers(){
		return this.projectDAO.getProjectManagers();
	}
	
}
