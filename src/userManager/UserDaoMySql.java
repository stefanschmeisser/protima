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
	
	
	// ------------------------------------------------------------------------
	
	public void editUserNameInDB(String newName, int id, String password) {
		
		
		String updateString = "UPDATE user SET name = '"+newName+"',password ='"+password+"' WHERE userID = '"+id+"'";
		//openConnection(_user, _password);
		
		try {
			Statement stmt = connection.createStatement();
			stmt.executeUpdate( updateString );
			connection.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

			
	}
	
	public void deleteUserFromDB(int id){
		String deleteString = "DELETE FROM user WHERE userID= '"+id+"'";
		
		try {
			Statement stmt = connection.createStatement();
			stmt.executeUpdate(deleteString );
			connection.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void addNewUserInDB(String name, String password){
		String insertString = "INSERT INTO user (name,password) VALUES('"+name+"','"+password+"')";
		//openConnection(_user, _password);
		
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
