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
	
	public ProjectController(Shell shell){
		this.shell = shell;
		this.projectDAO = new ProjectDaoMySql();
		this.projectViewController = new ProjectViewController(shell);
		this.selectedProject = this.projectDAO.getProject(100);
		projectViewController.fillTableData(this.projectDAO.getProjectList());
	}
	
}
