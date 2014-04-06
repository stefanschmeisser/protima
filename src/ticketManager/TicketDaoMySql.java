package ticketManager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TicketDaoMySql implements ITicketDao {

	private String _user, _password, _schema;
	private Connection connection;
	
	public TicketDaoMySql() {
		
		_user = "root";
		_password = "";
		
		openConnection(_user, _password);
	}
	
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
	
}
