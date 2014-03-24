package projectManager;
import java.util.List;

public interface IProjectDAO {
	public List<Project> getProjectList();
	public Project getProject();
}
