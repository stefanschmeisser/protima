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
import frontController.IContentState;

public class ProjectController implements IContentState {
	
	private Shell shell;
	private Composite composite;
	private IProjectDAO projectDAO;
	private ProjectViewController projectViewController;
	
	public ProjectController(Shell shell){
		this.shell = shell;
		this.projectDAO = new ProjectDaoMySql();
		this.projectViewController = new ProjectViewController(shell, this);
	}
	
	public ArrayList<Project> getTableListData(){
		return this.projectDAO.getProjectList();
	}
	
	public Project getProject(int projectID){
		return this.projectDAO.getProject(projectID);
	}
	
	public void setProject(Project project){
		this.projectDAO.createProject(project.getProjectName(), project.getProjectDescription(), project.getProjectManager());
	}
	
}
