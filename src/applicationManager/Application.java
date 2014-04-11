package applicationManager;

import org.eclipse.swt.widgets.Display;

import loginManager.LoginController;
import userRights.User;
import frontController.FrontController;

public class Application {
	
	//TODO: alle TODOs / FIXMEs durchgehen
	//TODO: unn�tige Prints am Ende l�schen
	
	private User currentUser;
	private IApplicationState currentState;
	private  Display disp;
	
	private static Application appInstance = null;
	   
	  
	protected Application(){
		disp = new Display();
		setCurrentState(new LoginController(this, disp));
	}

	public void setCurrentState(IApplicationState state) {
		this.currentState = state;
	}
	
	public void setCurrentUser(User user) {
		this.currentUser = user;
	}
	
	public void switchToFcState() {
		setCurrentState(new FrontController(this.disp));
	}
	
	public int getCurrentUserID(){
		return this.currentUser.getUserID();
	}
	
	public static void main(String[] args){
		new Application();
	}

	
}
