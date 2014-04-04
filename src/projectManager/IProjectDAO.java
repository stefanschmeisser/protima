package projectManager;
import java.util.List;

public interface IProjectDAO {
	public void createProject(String name, String description, int projectmanagerID);
	public void editProject(int projectID, String name, String description, int projectmanagerID);
	public void removeProject(int projectID);
	public List<Project> getProjectList();
	public Project getProject(int projectID);
}
