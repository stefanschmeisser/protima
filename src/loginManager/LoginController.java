package loginManager;

import frontController.FrontController;
import userManager.User;
import applicationManager.Application;
import applicationManager.IApplicationState;

public class LoginController implements IApplicationState {

	private LoginViewController lvc;
	private ILoginDaoMySql datenWerk;
	private Application app;
	
	public LoginController(Application app) {
		this.datenWerk = new ILoginDaoMySql();
		this.app = app;
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		this.lvc = new LoginViewController(this);
		this.lvc.show();
	}
	
	public boolean checkUserCredentials(String user, String password) {
//		System.out.println("User: " + user + "\nPasswort: " + password);
		String[] userPreData = this.datenWerk.getAccess(user, password);
//		System.out.println(userPreData);
		if (userPreData[0] != null) {
			//TODO: User anlegen und in Application currentUser setzen!
			// Minimum ID & Name
			//FIXME: AccessLevel (Editor, TeamLeader etc) auch notwendig!! 
			//TODO: Und davon abhängig den korrekten Benutzer anlegen!
			String[] userTemp = this.datenWerk.getUserData(userPreData);
			
			app.setCurrentUser(new User(Integer.parseInt(userTemp[0]), userTemp[1]));
			//FIXME: ist das so korrekt?!
			app.switchToFcState();
//			app.setCurrentState(new FrontController());
			
			return true;
		}
		else 
			return false;
	}
	
	public void switchToFcState() {
		app.switchToFcState();
	}
}
