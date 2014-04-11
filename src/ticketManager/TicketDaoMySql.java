package ticketManager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;
import applicationManager.AbstractDaoMySql;
import com.mysql.jdbc.ResultSetMetaData;


public class TicketDaoMySql extends AbstractDaoMySql implements ITicketDao {

	// ------------------------------------------------------------------------
	
	public TicketDaoMySql() {
//		openConnection(_user, _password);
//		this.select("*", "ticket", "");
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
				openConnection();
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
				openConnection();
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
		
		String insertStmt = "INSERT INTO `ticket`(`title`, `description`, `startdate`, `enddate`, " +
							"`priority`, `projectID`, `teamID`, `editorID`, `processStatus`) VALUES ";
		String qryStr = insertStmt + "(" + values + ")";
		
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(qryStr);
			preparedStatement.executeUpdate();
			connection.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// ------------------------------------------------------------------------
	
	public void updateTicket(ArrayList<String> values) {
		
		String updateStmt = "UPDATE ticket SET title = ?, description = ?, startdate = ?, enddate = ?, priority = ?, projectID = ?, teamID = ?, editorID = ?, processStatus = ? WHERE ticketID = ?";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(updateStmt);
			preparedStatement.setString(1, values.get(1).toString());
			preparedStatement.setString(2, values.get(2).toString());
			preparedStatement.setString(3, values.get(3).toString());
			preparedStatement.setString(4, values.get(4).toString());
			preparedStatement.setString(5, values.get(5).toString());
			preparedStatement.setString(6, values.get(6).toString());
			preparedStatement.setString(7, values.get(7).toString());
			preparedStatement.setString(8, values.get(8).toString());
			preparedStatement.setString(9, values.get(9).toString());
			preparedStatement.setString(10, values.get(0).toString());
			preparedStatement.executeUpdate();
			connection.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// ------------------------------------------------------------------------
	
	public void insertTicket(Ticket ticket) {

		String values = "";
		values += "'" + ticket.getTicketTitle() + "', ";
		values += "'" + ticket.getTicketDescription() + "', ";
		values += "'" + ticket.getTicketStartDate() + "', ";
		values += "'" + ticket.getTicketEndDate() + "', ";
		values += "'" + ticket.getTicketPriorityLevel() + "', ";
		values += "'" + ticket.getTicketProjectId() + "', ";
		values += "'" + ticket.getTicketAssignedTeam() + "', ";
		values += "'" + ticket.getTicketCurrentEditor() + "', ";
		values += "'" + ticket.getTicketProcessStatus() + "'";
		
		String insertStmt = "INSERT INTO `ticket`(`title`, `description`, `startdate`, `enddate`, " +
							"`priority`, `projectID`, `teamID`, `editorID`, `processStatus`) VALUES ";
		String qryStr = insertStmt + "(" + values + ")";
		
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(qryStr);
			preparedStatement.executeUpdate();
			connection.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// ------------------------------------------------------------------------

	public void deleteTicket(String ticketId){
		
		String deleteStmt = "DELETE FROM `ticket` WHERE `ticket`.`ticketID` = "+ ticketId +";";

//		System.out.println(deleteStmt);
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(deleteStmt);
			preparedStatement.executeUpdate();
			connection.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
}
