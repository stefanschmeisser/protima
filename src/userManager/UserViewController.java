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
	
	private Shell shell;
	private UserController parent;
	private UserListView ulv;
	private UserDetailView udv;
	private IUserState currentState;
	private String[][] users;
	private Composite composite, userSubMenuComposite;
	
	//private final Button ulvButton, uevButton, uanButton;
	
	public UserViewController(final Shell shell, UserController parent){
		this.shell = shell;
		this.parent = parent;
		final UserViewController uvc = this;
		userSubMenuComposite = new Composite(shell,SWT.NONE);
		GridData datasubMenu = new GridData(GridData.FILL_HORIZONTAL);
	    datasubMenu.widthHint = shell.getSize().x;
	    datasubMenu.heightHint = 30;
	    this.userSubMenuComposite.setLayoutData(datasubMenu);
	    this.userSubMenuComposite.setLayout(new GridLayout(10, true));
		//this.userSubMenuComposite.setBackground(shell.getDisplay().getSystemColor(SWT.COLOR_DARK_GRAY));
		Color blue = new Color (Display.getCurrent(), 0, 200, 255);
		this.userSubMenuComposite.setBackground(blue);
		ulv = new  UserListView(this.shell, this);
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
		
		shell.setMaximized(true);
	}
	
	
	public Composite getSubMenuComposite(){	
		return userSubMenuComposite;
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
		shell.setMaximized(true);
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
