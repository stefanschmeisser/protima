package userManager;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;

import projectManager.IProjectState;



public class UserViewController {
	
	private Shell shell;
	private UserController parent;
	private UserListView ulv;
	private IUserState currentState;
	private String[][] users;
	private Composite composite;
	
	
	public UserViewController(Shell shell, UserController parent){
		this.shell = shell;
		this.parent = parent;
		
		ulv = new  UserListView(this.shell, this);
		
	}
	
	public void setCurrentView(IUserState currentState){
		if(this.currentState != null){
			this.currentState.getComposite().dispose();
		}
		if(this.currentState == this.ulv){
			this.ulv.getComposite().dispose();
		}
		this.currentState = currentState;
		this.currentState.show();
//		if(this.currentState == this.ulv){
//			//
//		}
		this.shell.layout();
	}

	public UserController getParent() {
		
		return this.parent;
	}

	public Composite getComposite() {
		//System.out.println(composite.toString());
		return composite;
	}

}
