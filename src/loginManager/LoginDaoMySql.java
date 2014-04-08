package loginManager;


import applicationManager.AbstractDaoMySql;

public class LoginDaoMySql extends AbstractDaoMySql implements ILoginDao {
	
	public LoginDaoMySql() {
		super();
	}
	
	public String[] getAccess(String user, String password) {
//		System.out.println("getAccess");
		String column = "name, password";
		String table = "user";
		String condition = "name='"+ user +"' AND password='"+ password +"'";
		String[] userPreData = selectSingleValue(column, table, condition);
		
//		for (int i=0; i < userPreData.length; i++) {
//			System.out.println("userPreData["+i+"]: " + userPreData[i]);
//		}
		return userPreData;
	}
	
	public String[] getUserData(String[] userPredata) {
//		System.out.println("getUserData");
		//TODO: die Methode muss noch bissi aufgeblasen werden, damit die Benutzerrolle korrekt gesetzt werden kann!
		
		String[] userData = selectSingleValue("*", "user", "name='"+ userPredata[0] +"' AND password='"+ userPredata[1] +"'");
		
		for (int i = 0; i < userData.length; i++) {
//			System.out.println("userData["+i+"]: " + userData[i]);
		}
		return userData;
	}
	
}
