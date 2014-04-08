package userManager;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

import userRights.User;



public class UserDetailView implements IUserState{

	private Composite composite;
	private UserController uc;
	private User user;
	private Shell shell;
	
	public UserDetailView(Shell shell, final UserViewController parent, User user){
		this.shell = shell;
		this.user = user;
		composite = new Composite(shell, SWT.NONE);
		composite.setBackground(new Color(Display.getCurrent(),255,123,34));
		Label blankLabel = new Label(composite, SWT.NONE);
		blankLabel.setText("UserDetailView");
		blankLabel.setBounds(0, 0, 200, 200);
		System.out.print("hallo ich bin doch da");
		Color red = new Color (Display.getCurrent(), 255, 230, 0);
		blankLabel.setBackground(red);
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
