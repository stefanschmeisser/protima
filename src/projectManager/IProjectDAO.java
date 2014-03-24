package projectManager;
import java.util.List;

public interface IProjectDAO {
	public void createProject();
	public void editProject();
	public void removeProject();
	public List<Project> getProjectList();
	public Project getProject();
}
