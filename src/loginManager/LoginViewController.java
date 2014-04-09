package loginManager;

import org.eclipse.swt.widgets.Display;

public class LoginViewController {
	
	private LoginController papa;
	private LoginView lv;
	private Display disp;
	
	public LoginViewController(LoginController papa, Display disp) {
		//TODO: implementieren
		this.papa = papa;
		this.disp = disp;
		this.lv = new LoginView(this, disp);
	}

	public void show() {
		
	}
	
	public boolean checkUserCredentials(String user, String password) {
		return this.papa.checkUserCredentials(user, password);
	}
	
	public void switchToFcState() {
		this.papa.switchToFcState();
	}

}
