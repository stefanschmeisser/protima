package projectManager;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
		try {
			openConnection(_user, _password);
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("INSERT INTO project(projectID, name, description, projectmanagerID) VALUES ()");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * edit an existing project in the database
	 */
	@Override
	public void editProject(int id){
		
	}
	
	/**
	 * delete an existing project from the database
	 */
	@Override
	public void removeProject(int id){
		
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
