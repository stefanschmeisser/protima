package teamManager;

import java.util.ArrayList;
import java.util.List;

public interface ITeamDAO {
	
    public void createTeam(String teamName, int teamLeader);
    public void editTeam(int teamID, String TeamName, int teamLeader, List<int[]> teamMembers);
    public void removeTeam(int teamID);
    public ArrayList<Team> getTeamList();
    public Team getTeam(int teamID);
}



