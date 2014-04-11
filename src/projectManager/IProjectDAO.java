package projectManager;
import java.util.ArrayList;

import userRights.ProjectManager;

public interface IProjectDAO {
	public void createProject(String name, String description, int projectmanagerID);
	public void editProject(int projectID, String name, String description, int projectmanagerID);
	public void removeProject(int projectID);
	public ArrayList<Project> getProjectList();
	public Project getProject(int projectID);
	public ArrayList<ProjectManager> getProjectManagers();
}
