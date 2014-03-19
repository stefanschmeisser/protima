package applicationManager;

import java.util.Vector;

import loginManager.LoginController;
import userManager.User;
import frontController.FrontController;

public class Application {
	
	private User currentUser;
	private Vector<IApplicationState> states;
	private IApplicationState currentState;
	
	public Application(){
		//TODO: LoginController (state-abhängig) aufrufen - siehe show()
		// Standardwert für den Start
//		setCurrentState(new LoginController());
		setCurrentState(new FrontController());
		this.show();
	}
	
	public void show() {
		currentState.show();
	}
	
	public void setCurrentState(IApplicationState state) {
		this.currentState = state;
	}
	
	
	public static void main(String[] args){
		new Application();
	}
	
}
