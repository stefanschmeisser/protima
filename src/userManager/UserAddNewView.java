package userManager;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;


public class UserAddNewView implements IUserState{

	private Composite composite;
	private UserController uc;
	
	public UserAddNewView(Shell shell,final UserViewController parent){
		
		composite = new Composite(shell, SWT.NONE);

		Label blankLabel = new Label(composite, SWT.NONE);
		blankLabel.setText("UserListView");
//		blankLabel.setBounds(0, 0, 200, 200);
		
		Color red = new Color (Display.getCurrent(), 255, 230, 0);
		blankLabel.setBackground(red);	
	}
	
	public void setComposite(Composite comp) {
		
		// get the composite from the current UserController
		//this.tlvc.composite = comp;
		this.uc.setComposite(comp);
	}


	public Composite getComposite() {
		
		// get the composite from the current TicketViewController
		return this.composite;
	}
	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}

}
