package loginManager;

public class LoginViewController {
	
	private LoginController papa;
	private LoginView lv;
	
	public LoginViewController(LoginController papa) {
		//TODO: implementieren
		this.papa = papa;
	}

	public void show() {
		this.lv = new LoginView(this);
	}
	
	public boolean checkUserCredentials(String user, String password) {
		return this.papa.checkUserCredentials(user, password);
	}

}
