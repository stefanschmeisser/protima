package teamManager;

import java.util.List;

public interface ITeamDAO {
	
    public List<Team> getTeamList();
    public void createTeam();
    public void editTeam();
    public void removeTeam();
}