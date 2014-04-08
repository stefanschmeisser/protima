package projectManager;

import java.util.ArrayList;
import java.util.Vector;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
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
	private Project selectedProject;
	
	//getAllProjects() List<int>
	public ProjectController(Shell shell){
		this.shell = shell;
		this.projectDAO = new ProjectDaoMySql();
		this.projectViewController = new ProjectViewController(shell);
		
		this.selectedProject = this.projectDAO.getProject(100);
		System.out.println("Projekt ID: " + this.selectedProject.getProjectId());
		System.out.println("Projektname: " + this.selectedProject.getProjectName());
		
		projectViewController.fillTableData(this.projectDAO.getProjectList());
	}
	
}
