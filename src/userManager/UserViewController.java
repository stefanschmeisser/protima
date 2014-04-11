package userManager;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;

import projectManager.IProjectState;



public class UserViewController {
	
	private Composite composite;
	private UserController parent;
	private UserListView ulv;
	private UserDetailView udv;
	private IUserState currentState;
	private String[][] users;
	
	//private final Button ulvButton, uevButton, uanButton;
	
	public UserViewController(Composite parentComposite, UserController parent){
		this.composite = parentComposite;
		this.parent = parent;	
		ulv = new  UserListView(parentComposite, this);		
	}

	
	public UserListView getListView(){
		return ulv;
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
	}

	public UserController getParent() {
		
		return this.parent;
	}

	public Composite getComposite() {
		//System.out.println(composite.toString());
		return composite;
	}

}
