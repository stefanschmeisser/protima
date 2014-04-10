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
	private  Display disp;
	
	private static Application appInstance = null;
	   
	  
	protected Application(){
		disp = new Display();
		// Standardwert f�r den Start
		//FIXME: So kommt leider "GUI" Kram in den Controller, aber ohne gemeinsames Display (mainThread f�r die GUI) leider nahe zu unm�glich die Shells zu wechseln!
		
		setCurrentState(new FrontController(disp));
//		setCurrentState(new LoginController(this, disp));
	}
	/*
	public static Application getInstance() {
	      if(appInstance == null) {
	    	  
	         appInstance = new Application();
	         
	      }
	      return appInstance;
	}
	*/
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
