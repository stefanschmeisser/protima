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
	
	public UserViewController(/*final Shell shell*/ Composite parentComposite, UserController parent){
	
		
		this.parent = parent;
		final UserViewController uvc = this;
		/*
		GridData datasubMenu = new GridData(GridData.FILL_HORIZONTAL);
	    datasubMenu.widthHint = composite.getSize().x;
	    datasubMenu.heightHint = 30;
	   */
		//this.userSubMenuComposite.setBackground(shell.getDisplay().getSystemColor(SWT.COLOR_DARK_GRAY));
		Color blue = new Color (Display.getCurrent(), 0, 200, 255);
		
		ulv = new  UserListView(parentComposite, this);
		/*
		ulvButton = new Button(this.userSubMenuComposite, SWT.PUSH);
		uevButton = new Button(this.userSubMenuComposite, SWT.PUSH);
		uanButton = new Button(this.userSubMenuComposite, SWT.PUSH);
		
		ulvButton.setText("UserListView");
		uevButton.setText("User Edit View");
		uanButton.setText("Add New User View");
	
		Listener buttonListener = new Listener() {
			
			public void handleEvent(Event event) {
				if (event.widget == ulvButton) {
				
					if(currentState != ulv){
					ulv.getComposite().dispose();
					setCurrentView(new UserListView(shell,uvc));
					}
					
				}
			}
		};
		ulvButton.addListener(SWT.Selection, buttonListener);
		*/
		
		
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
		
//		if(this.currentState == this.ulv){
//			//
//		}
		this.composite.layout();
	}

	public UserController getParent() {
		
		return this.parent;
	}

	public Composite getComposite() {
		//System.out.println(composite.toString());
		return composite;
	}

}
