package ticketManager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;

import com.mysql.jdbc.ResultSetMetaData;


public class TicketDaoMySql implements ITicketDao {

	private String _user, _password, _schema;
	private Connection connection;
	
	// ------------------------------------------------------------------------
	
	public TicketDaoMySql() {
		
		_user = "root";
		_password = "";
		
//		openConnection(_user, _password);
//		this.select("*", "ticket", "");
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
	
	// ------------------------------------------------------------------------
	
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
	
	// ------------------------------------------------------------------------

	public TicketTableModel selectTableModel(String column, String table, String condition) {

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
				ResultSetMetaData rsMetaData = (ResultSetMetaData) rs.getMetaData();
				
				// Get Column Names / Headers
				ArrayList<String> columnNames = new ArrayList<String>(); 
				for(int i = 1; i <= rsMetaData.getColumnCount(); i++){
					columnNames.add(rsMetaData.getColumnLabel(i)); 
				}				
				
				// Get Table Row Data
				ArrayList<Vector> rowVectors = new ArrayList<Vector>();
				
                while (rs.next()) {  
                	
                	Vector v = new Vector();
                	
                	// columnNames need plus 1 to iterate the whole array
                	for(int y = 1; y < columnNames.size()+1; y++){
                		v.add(rs.getString(y));
                	}
                	rowVectors.add(v);
//                	System.out.println("Vector: " + v.size());
                }
				
                return new TicketTableModel(columnNames, rowVectors);
					
			} catch (SQLException e) {
				e.printStackTrace();
			}	
		}
		return null;
	}

// ----------------------------------------------------------------------------

//	INSERT INTO table_name
//	VALUES (value1,value2,value3,...);

//	INSERT INTO `ticket`(`ticketID`, `title`, `description`, `startdate`, `enddate`, `priority`, `projectID`, `teamID`) 
//	VALUES ([value-1],[value-2],[value-3],[value-4],[value-5],[value-6],[value-7],[value-8])
	
	public void insertTicket(ArrayList<String> valuesList) {

		String values = "";
		
		for(int i = 0; i < valuesList.size(); i++){
			if(i < valuesList.size()-1){
				values += "'" + valuesList.get(i).toString() + "', ";
			}
			else{
				values += "'"+ valuesList.get(i).toString() + "'";
			}
		}
		
		String insertStmt = "INSERT INTO `ticket`(`title`, `description`, `startdate`, `enddate`, `priority`, `projectID`, `teamID`) VALUES ";
		String qryStr = insertStmt + "(" + values + ")";
		
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(qryStr);
			preparedStatement.executeUpdate();
			connection.commit();
		} catch (SQLException e1) {
			
			e1.printStackTrace();
		}
	}
	
	// ------------------------------------------------------------------------


}
