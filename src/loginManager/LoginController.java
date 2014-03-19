package loginManager;

import applicationManager.IApplicationState;

public class LoginController implements IApplicationState {

	private LoginViewController lvc;
	private ILoginDaoMySql datenWerk;
	
	public LoginController() {
		//TODO: implementieren
		this.datenWerk = new ILoginDaoMySql();
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		this.lvc = new LoginViewController(this);
		this.lvc.show();
	}
	
	public boolean checkUserCredentials(String user, String password) {
		System.out.println("User: " + user + "\nPasswort: " + password);
		//TODO: Daten übers DAO in der DB abfragen
		String[] userPreData = this.datenWerk.getAccess(user, password);
		if (userPreData != null) {
			//TODO: User anlegen und in Application currentUser setzen!
			//TODO: Benutzerrechte beachten & entsprechend die Rolle anlegen!
			this.datenWerk.getUserData();
			return true;
		}
		else 
			return false;
		
	}
}
