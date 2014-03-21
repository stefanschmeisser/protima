package applicationManager;

import java.util.Vector;

import loginManager.LoginController;
import userManager.User;
import frontController.FrontController;

public class Application {
	
	//TODO: alle TODOs / FIXMEs durchgehen
	//TODO: in welchem Package das AbstractDAO unterbringen?
	//TODO: Wie Composite Pattern umsetzen?
	//TODO: Wie bekomm ich die Abh�ngigkeit des Benutzers vom aktuellen Projekt raus?!
	//TODO: unn�tige Prints am Ende l�schen
	
	private User currentUser;
	//FIXME: wozu brauch ich den Vector?
	private Vector<IApplicationState> states;
	private IApplicationState currentState;
	
	public Application(){
		//TODO: LoginController (state-abh�ngig) aufrufen - siehe show()
		// Standardwert f�r den Start
		setCurrentState(new LoginController(this));
//		setCurrentState(new FrontController());
		this.show();
	}
	
	public void show() {
		currentState.show();
	}
	
	public void setCurrentState(IApplicationState state) {
		this.currentState = state;
	}
	
	public void setCurrentUser(User user) {
		this.currentUser = user;
	}
	
	public void switchToFcState() {
		setCurrentState(new FrontController());
	}
	
	
	public static void main(String[] args){
		new Application();
	}
	
}
