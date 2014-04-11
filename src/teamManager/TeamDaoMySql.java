package teamManager;

import java.util.ArrayList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import applicationManager.AbstractDaoMySql;


public class TeamDaoMySql extends AbstractDaoMySql implements ITeamDAO {
	
	private ArrayList<Team> teamList;
	
	/**
	 * returns a List with all teams from the database
	 */
	@Override
	public ArrayList<Team> getTeamList(){
		this.teamList = new ArrayList<Team>();
		openConnection();
		try{
			Statement statement = connection.createStatement(); 
			ResultSet resultSet = statement.executeQuery("SELECT * FROM team");
			while(resultSet.next()){
				Team team = new Team();
				team.setTeamId(resultSet.getInt("teamID"));
				team.setTeamName(resultSet.getString("name"));
				team.setTeamLeader(resultSet.getInt("teamleaderID"));
				this.teamList.add(team);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return this.teamList;
	}
	
	
	/**
	 * returns a existing team form the database
	 */
	@Override
	public Team getTeam(int teamId){
		Team team = new Team();
		openConnection();
		try{
			PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM team WHERE teamID = ?");
			preparedStatement.setInt(1, teamId);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				team.setTeamId(resultSet.getInt("teamId"));
				team.setTeamName(resultSet.getString("name"));
				team.setTeamLeader(resultSet.getInt("teamLeader"));
				//team.setTeamMembers(resultSet.getList<int[]>("teamMembers"));
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return team;
	}

	@Override
	public void createTeam(String teamName, int teamLeader) {
		try {
			System.out.println("Teamname: " + teamName);
			System.out.println("Teamleader: " + teamLeader);
			openConnection();
			PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO team(name, teamleaderID) VALUES (?,?)");
			preparedStatement.setString(1, teamName);
			preparedStatement.setInt(2, teamLeader);
			preparedStatement.executeUpdate();
			connection.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
		
	@Override
	public void editTeam(int teamID,String teamName, int teamLeader, List <int[]> teamMembers) {
		openConnection();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("UPDATE team SET teamName = ?, teamLeader = ?, teamMembers = ? WHERE teamID = ?");
			preparedStatement.setString(1, teamName);
			preparedStatement.setInt(2, teamLeader);
			//preparedStatement.setList(3, teamMember);
			preparedStatement.setInt(4, teamID);
			preparedStatement.executeUpdate();
			connection.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void removeTeam(int teamID) {
		// TODO Auto-generated method stub
		
	}

}
