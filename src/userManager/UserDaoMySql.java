package userManager;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;

import ticketManager.TicketTableModel;

import com.mysql.jdbc.ResultSetMetaData;

import applicationManager.AbstractDaoMySql;

public class UserDaoMySql extends AbstractDaoMySql implements IUserDAO{
	
	private int[] userListID;
	
	@Override
	public void getUser(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String[][] getUserList() {
		// TODO Auto-generated method stub
		String userList[][] = selectMultiValues("userID, name, password", "user", "");
		for(int i = 0; i < userList.length; i++){
			
			for(int k = 0; k < userList[i].length; k++ ){
				
				System.out.println(userList[i][k]);
				
			}
			
		}
		return userList;
	}

	@Override
	public void getUsersByProject(String projectName) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getUsersByTeam(String teamName) {
		// TODO Auto-generated method stub
		
	}
	
	public UserDaoMySql() {
		
		_user = "sag";
		_password = "Jr22HhUSLMz9Nu3m";
		
//		openConnection(_user, _password);
//		this.select("*", "ticket", "");
	}
	
	// ------------------------------------------------------------------------
	
	protected void openConnection(String user, String password) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String conString = "jdbc:mysql://games.thm.de/sag";
			connection = DriverManager.getConnection(conString, _user, _password);
			connection.setAutoCommit(false);
		} catch (ClassNotFoundException e) {
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// ------------------------------------------------------------------------
	/*
	public ResultSet select(String column, String table, String condition) {
		
		String qryStr = "";
		
		if (column != null && column != "" && table != null && table != "") {
			
			qryStr = "SELECT "+ column +" FROM " + table;
			if (condition != null && condition != "") {
				qryStr += " WHERE "+ condition;
			}
			
			try {
				openConnection(_user, _password);
				Statement stmt = connection.createStatement();
				ResultSet rs = stmt.executeQuery(qryStr);
				//rs.last();
				return rs;
				
			} catch (SQLException e) {
				e.printStackTrace();
			}	
		}
		return null;
	}
	*/
	// ------------------------------------------------------------------------
	
	public void editUserNameInDB(String newName, int id, String password) {
		
		
		String updateString = "UPDATE user SET name = '"+newName+"',password ='"+password+"' WHERE userID = '"+id+"'";
		openConnection(_user, _password);
		
		try {
			Statement stmt = connection.createStatement();
			stmt.executeUpdate( updateString );
			connection.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

			
	}
	
	public void addNewUserInDB(String name, String password){
		String insertString = "INSERT INTO user (name,password) VALUES('"+name+"','"+password+"')";
		openConnection(_user, _password);
		
		try {
			Statement stmt = connection.createStatement();
			stmt.executeUpdate( insertString );
			connection.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
