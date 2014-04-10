package userManager;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;

import userRights.User;



public class UserDetailView implements IUserState{

	private Composite composite, menuComposite;
	private UserController uc;
	private User user;
	private Shell shell;
	private final Button uevButton;
	
	public UserDetailView(final Shell shell, final UserViewController parent, User user, String userName, final int id){
		this.shell = shell;
		this.user = user;
		
		composite = new Composite(shell, SWT.NONE);
		composite.setBackground(new Color(Display.getCurrent(),255,123,34));
		GridLayout myLayout = new GridLayout();
		myLayout.numColumns = 2;
		myLayout.makeColumnsEqualWidth = true;
	    composite.setLayout(myLayout);
		
	    uevButton = new Button(composite, SWT.PUSH);
	    
		Label blankLabel = new Label(composite, SWT.NONE);
		Label userLabel = new Label(composite,SWT.NONE);
		
		blankLabel.setText("UserDetailView");
		blankLabel.setBounds(0, 0, 200, 200);
		Color red = new Color (Display.getCurrent(), 255, 230, 0);
		blankLabel.setBackground(red);
		
		userLabel.setText("Benutzer: " + userName + " | " + user.toString());
		userLabel.setBounds(0, 50, 200, 200);
		Listener buttonListener = new Listener() {
			
		public void handleEvent(Event event) {
				if (event.widget == uevButton) {
					composite.dispose();
					parent.setCurrentView(new UserEditView(shell, parent, id));
	
				}
			}
		};
		
		uevButton.addListener(SWT.Selection, buttonListener);
		
		
		//this.shell.layout();
	}
	
	public void setComposite(Composite comp) {
		
		// get the composite from the current UserController
		//this.tlvc.composite = comp;
		//this.uc.setComposite(comp);
		
	}


	public Composite getComposite() {
		
		// get the composite from the current TicketViewController
		return this.composite;
	}
	@Override
	public void show() {
		// TODO Auto-generated method stub
		//this.shell.layout();
	}

}
