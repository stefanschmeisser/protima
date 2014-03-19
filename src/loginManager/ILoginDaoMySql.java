package loginManager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ILoginDaoMySql implements ILoginDao {
	
	private String _user, _password, _schema;
	private Connection connection;
	
	public ILoginDaoMySql() {
		
		_user = "sag";
		_password = "Jr22HhUSLMz9Nu3m";
		
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
	
	public String[] getAccess(String user, String password) {
		String column = "name, password";
		String table = "user";
		String condition = "name='"+ user +"' AND password='"+ password +"'";
		String qryStr = "";
		String[] userPreData = new String[2];
		if (column != null && column != "" && table != null && table != "") {
			qryStr = "SELECT "+ column +" FROM " + table;
			if (condition != null && condition != "") {
				qryStr += " WHERE "+ condition;
			}
			System.out.println(qryStr);
			try {
				Statement stmt = connection.createStatement();
				ResultSet rs = stmt.executeQuery(qryStr);
				
				while (rs.next()) {
					// Name
					System.out.println(rs.getString(1));
					// PW
					System.out.println(rs.getString(2));
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		// ??
		return new String[0];
		}
		return null;
	}
	
	public void getUserData() {
		
	}
	
	public String[][] select(String column, String table, String condition) {
		String qryStr = "";
		int firstDim = 0, secondDim = 0;
		String[][] rsArr = null;
		//FIXME: Parameterauswertung ausreichend? NO!
		if (column != null && column != "" && table != null && table != "") {
			qryStr = "SELECT "+ column +" FROM " + table;
			if (condition != null && condition != "") {
				qryStr += "WHERE "+ condition;
			}
			try {
				Statement stmt = connection.createStatement();
				ResultSet rs = stmt.executeQuery(qryStr);
				rs.last();
				// erste Dimension des Arrays festlegen
				firstDim = rs.getRow();
				rs.beforeFirst();
				
				if (column.equals("*")) {
					secondDim = rs.getMetaData().getColumnCount();
				}
				else {
					String[] colArr = column.split(",");
					secondDim = colArr.length;
				}
				//TODO: hier nen 2D Array konstruieren (mit Datensätzen als Zeilen)
				rsArr = new String[firstDim][secondDim];
				int i = 0;
				while (rs.next()) {
					int j = 0;
					while (j < secondDim) {
						rsArr[i][j] = rs.getString(j+1);
						j++;
					}
					i++;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		else {
			//TODO: Fehler über unzureichende Parameter zurück geben
		}
		//FIXME: sinnvoll ersetzen!
		return rsArr;
	}
}
