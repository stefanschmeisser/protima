package userManager;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

import userRights.Editor;



public class UserEditView implements IUserState{

	private final Composite composite;
	private UserController uc;
	private Editor user;
	
	public UserEditView(Shell shell,final UserViewController parent, int id){
		
		composite = new Composite(shell, SWT.NONE);
	
		GridLayout myLayout = new GridLayout();
		myLayout.numColumns = 2;
		myLayout.makeColumnsEqualWidth = true;
	    composite.setLayout(myLayout);
	    
	    GridData data = new GridData(GridData.FILL_HORIZONTAL);
		
		Label blankLabel = new Label(composite, SWT.NONE);
		blankLabel.setText("UserEditView");
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
