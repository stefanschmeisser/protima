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
		
		openConnection(_user, _password);
		
	}
	
	private void openConnection(String user, String password) {
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
				openConnection(_user, _password);
				Statement stmt = connection.createStatement();
				ResultSet rs = stmt.executeQuery(qryStr);
				
				// sollte genau einen Benutzer zurückgeben!
				while (rs.next()) {
					// Name
//					System.out.println(rs.getString(1));
					userPreData[0] = rs.getString(1);
					// PW
//					System.out.println(rs.getString(2));
					userPreData[1] = rs.getString(2);
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return userPreData;
		}
		return null;
	}
	
	public String[] getUserData(String[] userPredata) {
		//TODO: die Methode muss noch bissi aufgeblasen werden, damit die Benutzerrolle korrekt gesetzt werden kann!
//		[0] = name
//		[1] = pw
		
		// nur das erste Array übernehmen, da ja auch nur ein Benutzer da sein sollte == ein Datensatz (Rest sollte eh leer sein)
		String[] rsArr = select("*", "user", "name='"+ userPredata[0] +"' AND password='"+ userPredata[1] +"'")[0];
		
		for (int i = 0; i < rsArr.length; i++) {
			System.out.println("Wert["+i+"]: " + rsArr[i]);
		}
		return rsArr;
	}
	
	public String[][] select(String column, String table, String condition) {
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
				openConnection(_user, _password);
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
