package loginManager;

import org.eclipse.swt.widgets.Display;

import frontController.FrontController;
import frontController.IContentState;
import userRights.ProjectManager;
import userRights.User;
import applicationManager.Application;
import applicationManager.IApplicationState;

public class LoginController implements IApplicationState {

	private LoginViewController lvc;
	private LoginDaoMySql datenWerk;
	private Application app;
	private Display disp;
	
	
	public LoginController(Application app, Display disp) {
		this.datenWerk = new LoginDaoMySql();
		this.app = app;
		this.disp = disp;
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		this.lvc = new LoginViewController(this, disp);
		this.lvc.show();
	}
	
	public boolean checkUserCredentials(String user, String password) {
//		System.out.println("User: " + user + "\nPasswort: " + password);
		String[] userPreData = this.datenWerk.getAccess(user, password);
//		System.out.println(userPreData);
		if (userPreData[0] != null) {
//			for (int i=0; i < userPreData.length; i++)
//				System.out.println("Wert["+i+"]: " + userPreData[i]);
			//TODO: User anlegen und in Application currentUser setzen!
			// Minimum ID & Name
			//FIXME: AccessLevel (Editor, TeamLeader etc) auch notwendig!! 
			//TODO: Und davon abhängig den korrekten Benutzer anlegen!
			String[] userTemp = this.datenWerk.getUserData(userPreData);
			app.setCurrentUser(new ProjectManager(Integer.parseInt(userTemp[0]), userTemp[1]));
			
			return true;
		}
		else 
			return false;
	}
	
	public void switchToFcState() {
		app.switchToFcState();
	}

	@Override
	public void setCurrentView(IContentState currentState) {
		// TODO Auto-generated method stub
		
	}
}
