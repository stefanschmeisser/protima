package teamManager;

import java.util.ArrayList;
import java.util.List;

public class TeamDaoMySql implements ITeamDAO {
	private List<Team> teamList;

	public void createTeam(){
		
	}
	
	public void editTeam(){
		
		
	}
	
	public void removeTeam(){
		
		
	}
	@Override

	public List<Team> getTeamList(){
		this.teamList=new ArrayList<Team>();
		
		
		
		return this.teamList;
	}
	
}
