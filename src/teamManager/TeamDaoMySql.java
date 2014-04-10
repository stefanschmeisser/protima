package teamManager;

import java.util.ArrayList;
import java.util.List;

import applicationManager.AbstractDaoMySql;

public class TeamDaoMySql extends AbstractDaoMySql implements ITeamDAO {
	private List<Team> teamList;
	private Team team;

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
	
	public Team getTeam(){
		this.team=new Team();
		
		return this.team;
		}
}
