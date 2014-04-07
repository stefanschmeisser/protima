package applicationManager;

import java.util.Vector;

import org.eclipse.swt.widgets.Display;

import loginManager.LoginController;
import userRights.User;
import frontController.FrontController;

public class Application {
	
	//TODO: alle TODOs / FIXMEs durchgehen
	//TODO: unn�tige Prints am Ende l�schen
	
	private User currentUser;
	private IApplicationState currentState;
	private Display disp;
	
	public Application(){
		// Standardwert f�r den Start
		//FIXME: So kommt leider "GUI" Kram in den Controller, aber ohne gemeinsames Display (mainThread f�r die GUI) leider nahe zu unm�glich die Shells zu wechseln!
		disp = new Display();

		setCurrentState(new FrontController(disp));
		setCurrentState(new LoginController(this, disp));

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
		setCurrentState(new FrontController(this.disp));
	}
	
	
	public static void main(String[] args){
		new Application();
	}
	
}
