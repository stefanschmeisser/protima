package userManager;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;


public class UserAddNewView implements IUserState{

	private Composite composite;
	private UserController uc;
	private Label userIDLabel;
	private Text userIDInput;
	private Composite compgrid;
	private Label userNameLabel;
	private Text userNameInput;
	private Label userPasswordLabel;
	private Text userPasswordInput;
	private Button btnAdd;
	private Button btnCancel;
	
	
	public UserAddNewView(final Composite parentComposite,final UserViewController parent){
		
		
		this.composite = new Composite(parentComposite, SWT.NONE);
		GridLayout layout = new GridLayout();
		layout.numColumns = 4;
	    layout.makeColumnsEqualWidth = true;
	    composite.setLayout(layout);
	    
		
		Listener buttonListener = new Listener() {
		
		public void handleEvent(Event event) {
				if (event.widget == btnAdd) {
					UserDaoMySql userDao = new UserDaoMySql();
					userDao.addNewUserInDB(userNameInput.getText().trim(),userPasswordInput.getText());
					composite.dispose();
					parent.setCurrentView(new UserListView(parentComposite, parent));
					
				}
				if(event.widget == btnCancel){
					composite.dispose();
					parent.setCurrentView(new UserListView(parentComposite, parent));
				}
			}
		};
		
		
		/*****************************************************************************************/
					
			
			    /* ID LABEL + BUTTON */
			    GridData data = new GridData(GridData.FILL_HORIZONTAL);
			    this.userIDLabel = new Label(this.composite, SWT.RIGHT);
			    this.userIDLabel.setText("Benutzer ID");
			    this.userIDLabel.setLayoutData(data);
			    
			    data = new GridData(GridData.FILL_HORIZONTAL);
			    this.userIDInput = new Text(this.composite, SWT.READ_ONLY | SWT.LEFT | SWT.BORDER);
			    this.userIDInput.setEnabled(false);
			    this.userIDInput.setEditable(false);
			    this.userIDInput.setLayoutData(data);
			    
			    /* FREIRAUM F�R BESSERE ANORDNUNG*/
			    data = new GridData(GridData.FILL_HORIZONTAL);
			    data.horizontalSpan = 2;
			    this.compgrid = new Composite(this.composite, SWT.NONE);
			    this.compgrid.setLayoutData(data);
			    
			    
			    /* NAME LABEL + BUTTON */
			    data = new GridData(GridData.FILL_HORIZONTAL);
			    this.userNameLabel = new Label(this.composite, SWT.RIGHT);
			    this.userNameLabel.setText("User Name");
			    this.userNameLabel.setLayoutData(data);
			    
			    data = new GridData(GridData.FILL_HORIZONTAL);
			    data.horizontalSpan = 3;
			    this.userNameInput = new Text(this.composite, SWT.LEFT | SWT.BORDER);
			    this.userNameInput.setEnabled(true);
			    this.userNameInput.setLayoutData(data);
			    
			    /* PASSWORD LABEL + BUTTON */
			    data = new GridData(GridData.FILL_HORIZONTAL);
			    this.userPasswordLabel = new Label(this.composite, SWT.RIGHT);
			    this.userPasswordLabel.setText("Passwort");
			    this.userPasswordLabel.setLayoutData(data);
			    
			    data = new GridData(GridData.FILL_HORIZONTAL);
			    data.horizontalSpan = 3;
			    this.userPasswordInput = new Text(this.composite,   SWT.MULTI | SWT.BORDER | SWT.WRAP | SWT.V_SCROLL);
			    this.userPasswordInput.setEnabled(true);
			    this.userPasswordInput.setLayoutData(data);
			    
			    /* FREIRAUM F�R BESSERE ANORDNUNG DER BUTTONS*/
			    data = new GridData(GridData.FILL_HORIZONTAL);
			    data.horizontalSpan = 2;
			    this.compgrid = new Composite(this.composite, SWT.NONE);
			    this.compgrid.setLayoutData(data);
			   
			    // BUTTONS	    
			    data = new GridData(GridData.FILL_HORIZONTAL);
			    this.btnAdd = new Button(this.composite, SWT.PUSH);
			    this.btnAdd.setText("Hinzufügen");
			    this.btnAdd.addListener(SWT.Selection, buttonListener);
			    this.btnAdd.setLayoutData(data);
			    
			    data = new GridData(GridData.FILL_HORIZONTAL);
			    this.btnCancel = new Button(this.composite, SWT.PUSH);
			    this.btnCancel.setText("Cancel");
			    this.btnCancel.addListener(SWT.Selection, buttonListener);
			    this.btnCancel.setLayoutData(data);
			    
			    parentComposite.layout();	
	}
	/*
	public void setComposite(Composite comp) {
		
		// get the composite from the current UserController
		//this.tlvc.composite = comp;
		this.uc.setComposite(comp);
	}

*/
	public Composite getComposite() {
		
		// get the composite from the current TicketViewController
		return this.composite;
	}
	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}

}
