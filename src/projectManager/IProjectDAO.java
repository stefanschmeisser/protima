package projectManager;
import java.util.List;

public interface IProjectDAO {
	public void createProject();
	public void editProject(int id);
	public void removeProject(int id);
	public List<Project> getProjectList();
	public Project getProject();
}
