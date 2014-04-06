package applicationManager;

import java.util.Vector;

import org.eclipse.swt.widgets.Display;

import loginManager.LoginController;
import userManager.User;
import frontController.FrontController;

public class Application {
	
	//TODO: alle TODOs / FIXMEs durchgehen
	//TODO: in welchem Package das AbstractDAO unterbringen?
	//TODO: Wie Composite Pattern umsetzen?
	//TODO: Wie bekomm ich die Abhängigkeit des Benutzers vom aktuellen Projekt raus?!
	//TODO: unnötige Prints am Ende löschen
	
	private User currentUser;
	//FIXME: wozu brauch ich den Vector?
	private Vector<IApplicationState> states;
	private IApplicationState currentState;
	private Display disp;
	
	public Application(){
		//TODO: LoginController (state-abhängig) aufrufen - siehe show()
		// Standardwert für den Start
		//FIXME: So kommt leider "GUI" Kram in den Controller, aber ohne gemeinsames Display (mainThread für die GUI) leider nahe zu unmöglich die Shells zu wechseln!
		disp = new Display();
//		setCurrentState(new LoginController(this, disp));
		setCurrentState(new FrontController(disp));
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
