package projectManager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import applicationManager.AbstractDaoMySql;

public class ProjectDaoMySql extends AbstractDaoMySql implements IProjectDAO {

	private ArrayList<Project> projectList;
	
	public ProjectDaoMySql() {
	}
	
	// ------------------------------------------------------------------------
	
	/**
	 * creates a new project in the database
	 */
	
	@Override
	public void createProject(String name, String description, int projectmanagerID){
		try {
			openConnection();
			PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO project(name, description, projectmanagerID) VALUES (?,?,?)");
			preparedStatement.setString(1, name);
			preparedStatement.setString(2, description);
			preparedStatement.setInt(3, projectmanagerID);
			preparedStatement.executeUpdate();
			connection.commit();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * edit an existing project in the database
	 */
	
	@Override
	public void editProject(int projectID, String name, String description, int projectmanagerID){
		openConnection();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("UPDATE project SET name = ?, description = ?, projectmanagerID = ? WHERE projectID = ?");
			preparedStatement.setString(1, name);
			preparedStatement.setString(2, description);
			preparedStatement.setInt(3, projectmanagerID);
			preparedStatement.setInt(4, projectID);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * delete an existing project from the database
	 */
	
	@Override
	public void removeProject(int projectID){
		openConnection();
		try{
			PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM project WHERE projectID = ?");
			preparedStatement.setInt(1, projectID);
			preparedStatement.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	/**
	 * returns a List with all projects from the database
	 */
	
	@Override
	public ArrayList<Project> getProjectList(){
		this.projectList = new ArrayList<Project>();
		openConnection();
		try{
			Statement statement = connection.createStatement(); 
			ResultSet resultSet = statement.executeQuery("SELECT * FROM project");
			while(resultSet.next()){
				Project project = new Project();
				project.setProjectId(resultSet.getInt("projectID"));
				project.setProjectName(resultSet.getString("name"));
				project.setProjectDescription(resultSet.getString("description"));
				project.setProjectManager(resultSet.getInt("projectmanagerID"));
				this.projectList.add(project);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return this.projectList;
	}
	
	
	/**
	 * returns a existing project form the database
	 */
	
	@Override
	public Project getProject(int projectID){
		Project project = new Project();
		openConnection();
		try{
			PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM project WHERE projectID = ?");
			preparedStatement.setInt(1, projectID);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				project.setProjectId(resultSet.getInt("projectID"));
				project.setProjectName(resultSet.getString("name"));
				project.setProjectDescription(resultSet.getString("description"));
				project.setProjectManager(resultSet.getInt("projectmanagerID"));
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return project;
	}
	
}
