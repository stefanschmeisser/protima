package applicationManager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class AbstractDaoMySql {

	protected Connection connection;
	
	public AbstractDaoMySql() {
		
		openConnection();
		
	}
	
	protected void openConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(Protima.host, Protima.user, Protima.password);
			connection.setAutoCommit(false);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	protected String[][] selectMultiValues(String column, String table, String condition) {
		String qryStr = "";
		int firstDim = 0, secondDim = 0;
		String[][] rsArr = null;
		//FIXME: Parameterauswertung ausreichend? NO!
		if (column != null && column != "" && table != null && table != "") {
			qryStr = "SELECT "+ column +" FROM " + table;
			if (condition != null && condition != "") {
				qryStr += " WHERE "+ condition;
			}
			try {
				openConnection();
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
		return rsArr;
	}
	
	protected String[] selectSingleValue(String column, String table, String condition) {
		String qryStr = "";
		int dimension = 0;
		String[] rsArr = null;
		//FIXME: Parameterauswertung ausreichend? NO!
		if (column != null && column != "" && table != null && table != "") {
			qryStr = "SELECT "+ column +" FROM " + table;
			if (condition != null && condition != "") {
				qryStr += " WHERE "+ condition;
			}
			qryStr += " LIMIT 0,1";
//			System.out.println("abstract: " + qryStr);
			try {
				openConnection();
				Statement stmt = connection.createStatement();
				ResultSet rs = stmt.executeQuery(qryStr);

				if (column.equals("*")) {
					dimension = rs.getMetaData().getColumnCount();
				}
				else {
					dimension = column.split(",").length;
				}
				rsArr = new String[dimension];
				if (rs.next()) {
					for (int i=0; i < dimension; i++) {
						rsArr[i] = rs.getString(i+1);
					}
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		else {
			//TODO: Fehler über unzureichende Parameter zurück geben
		}
		return rsArr;
	}
	
}
