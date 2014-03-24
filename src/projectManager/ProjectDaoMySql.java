package projectManager;

import java.util.ArrayList;
import java.util.List;
import applicationManager.AbstractDaoMySql;

public class ProjectDaoMySql extends AbstractDaoMySql implements IProjectDAO {

	private Project project;
	private List<Project> projectList;
	
	/**
	 * creates a new project in the database
	 */
	@Override
	public void createProject(){
		
	}
	
	/**
	 * edit an existing project in the database
	 */
	@Override
	public void editProject(){
		
	}
	
	/**
	 * delete an existing project from the database
	 */
	@Override
	public void removeProject(){
		
	}
	
	/**
	 * returns a List with all projects from the database
	 */
	@Override
	public List<Project> getProjectList(){
		this.projectList = new ArrayList<Project>();
		
		
		return this.projectList;
	}
	
	
	/**
	 * returns a existing project form the database
	 */
	@Override
	public Project getProject(){
		this.project = new Project();
		
		return this.project;
	}	
}
