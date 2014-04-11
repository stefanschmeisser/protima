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


public class TeamDaoMySql implements ITeamDAO {
	
	private String _user, _password, _schema;
	private Connection connection;
	private ArrayList<Team> teamList;
	
	public TeamDaoMySql() {
		_user = "root";
		_password = "";
	}
	
	// ------------------------------------------------------------------------
	

	private void openConnection(String user, String password) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String conString = "jdbc:mysql://localhost/sag";
			connection = DriverManager.getConnection(conString, _user, _password);
			connection.setAutoCommit(false);
		} catch (ClassNotFoundException e) {
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	
	/**
	 * returns a List with all teams from the database
	 */
	@Override
	public ArrayList<Team> getTeamList(){
		this.teamList = new ArrayList<Team>();
		openConnection(_user,_password);
		try{
			Statement statement = connection.createStatement(); 
			ResultSet resultSet = statement.executeQuery("SELECT * FROM project");
			while(resultSet.next()){
				Team team = new Team();
				team.setTeamId(resultSet.getInt("teamID"));
				team.setTeamName(resultSet.getString("teamName"));
				team.setTeamLeader(resultSet.getInt("teamLeader"));
			//	team.setTeamMembers(resultSet.getList<int[]>("teamMembers"));
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
		openConnection(_user,_password);
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
	public void createTeam(int teamID,String teamName, int teamLeader) {
		try {
			openConnection(_user, _password);
//			Statement stmt = connection.createStatement();
//			ResultSet rs = stmt.executeQuery("INSERT INTO team(teamID, name, teamLeader, teamMembers) VALUES ()");
			PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO team(teamID,teamName, teamLeader) VALUES (?,?,?)");
			preparedStatement.setString(1, teamName);
			preparedStatement.setInt(2, teamID);
			preparedStatement.setInt(3, teamLeader);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
		
	

	@Override
	public void editTeam(int teamID,String teamName, int teamLeader, List <int[]> teamMembers) {
		openConnection(_user, _password);
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("UPDATE team SET teamName = ?, teamLeader = ?, teamMembers = ? WHERE teamID = ?");
			preparedStatement.setString(1, teamName);
			preparedStatement.setInt(2, teamLeader);
			//preparedStatement.setList(3, teamMember);
			preparedStatement.setInt(4, teamID);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
		
	

	@Override
	public void removeTeam(int teamID) {
		// TODO Auto-generated method stub
		
	}	
}
