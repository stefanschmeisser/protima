package teamManager;

import java.util.List;

public class Team {
	
	private int teamID;
	private String teamName;
	private int teamLeader;
	private List<int[]> teamMembers;
	
	
	
	public int getTeamID() {
		return teamID;
	}
	
	public void setTeamId(int teamID) {
		this.teamID = teamID;
	}

	
	public int getTeamLeader() {
		return teamLeader;
	}
	
	
   public String getTeamName() {
		return teamName;
	}

	
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	
	
	public int getTeamLeader(int teamLeader){
		return teamLeader;
	}
	
	public void setTeamLeader(int teamLeader){
		this.teamLeader = teamLeader;
	}
	


	public List<int[]> getTeamMembers(List <int[]> teamMembers){
		return teamMembers;
		}
	
	public void setTeamMembers(List <int[]> teamMembers){
		this.teamMembers = teamMembers; 
	}
}
