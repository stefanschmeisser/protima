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

import userRights.User;



public class UserDetailView implements IUserState{

	private Composite composite, menuComposite;
	private UserController uc;
	private User user;
	
	//private final Button uevButton;
	private Label userIDLabel;
	private Text userIDInput;
	private Composite compgrid;
	private Label userNameLabel;
	private Text userNameInput;
	private Label userPasswordLabel;
	private Text userPasswordOutput;
	private Button btnEdit;
	private Button btnCancel;
	
	public UserDetailView(final Composite parentComposite, final UserViewController parent, final String userName, final int id, final String pw){
		//this.shell = shell;
		
		Listener buttonListener = new Listener() {
			
		public void handleEvent(Event event) {
				if (event.widget == btnEdit) {
					composite.dispose();
					parent.setCurrentView(new UserEditView(parentComposite, parent, id, userName, pw));
	
				}
				if(event.widget == btnCancel){
					composite.dispose();
					parent.setCurrentView(new UserListView(parentComposite, parent));
				}
			}
		};
		
		
		/*****************************************************************************************/
					
				this.composite = new Composite(parentComposite, SWT.NONE);
				GridLayout layout = new GridLayout();
				layout.numColumns = 4;
			    layout.makeColumnsEqualWidth = true;
			    composite.setLayout(layout);
			    
			    /* ID LABEL + BUTTON */
			    GridData data = new GridData(GridData.FILL_HORIZONTAL);
			    this.userIDLabel = new Label(this.composite, SWT.RIGHT);
			    this.userIDLabel.setText("Benutzer ID");
			    this.userIDLabel.setLayoutData(data);
			    
			    data = new GridData(GridData.FILL_HORIZONTAL);
			    this.userIDInput = new Text(this.composite, SWT.READ_ONLY | SWT.LEFT | SWT.BORDER);
			    this.userIDInput.setText(String.valueOf(id));
			    this.userIDInput.setEnabled(false);
			    this.userIDInput.setEditable(false);
			    this.userIDInput.setLayoutData(data);
			    
			    /* FREIRAUM F†R BESSERE ANORDNUNG*/
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
			    this.userNameInput = new Text(this.composite, SWT.READ_ONLY | SWT.LEFT | SWT.BORDER);
			    this.userNameInput.setText(userName);
			    this.userNameInput.setEnabled(false);
			    this.userNameInput.setLayoutData(data);
			    
			    /* PASSWORD LABEL + BUTTON */
			    data = new GridData(GridData.FILL_HORIZONTAL);
			    this.userPasswordLabel = new Label(this.composite, SWT.RIGHT);
			    this.userPasswordLabel.setText("Passwort");
			    this.userPasswordLabel.setLayoutData(data);
			    
			    data = new GridData(GridData.FILL_HORIZONTAL);
			    data.horizontalSpan = 3;
			    this.userPasswordOutput = new Text(this.composite,  SWT.READ_ONLY | SWT.MULTI | SWT.BORDER | SWT.WRAP | SWT.V_SCROLL);
			    this.userPasswordOutput.setText("***");
			    this.userPasswordOutput.setEnabled(false);
			    this.userPasswordOutput.setLayoutData(data);
			    
			    /* FREIRAUM F†R BESSERE ANORDNUNG DER BUTTONS*/
			    data = new GridData(GridData.FILL_HORIZONTAL);
			    data.horizontalSpan = 2;
			    this.compgrid = new Composite(this.composite, SWT.NONE);
			    this.compgrid.setLayoutData(data);
			   
			    // BUTTONS	    
			    data = new GridData(GridData.FILL_HORIZONTAL);
			    this.btnEdit = new Button(this.composite, SWT.PUSH);
			    this.btnEdit.setText("Edit");
			    this.btnEdit.addListener(SWT.Selection, buttonListener);
			    this.btnEdit.setLayoutData(data);
			    
			    data = new GridData(GridData.FILL_HORIZONTAL);
			    this.btnCancel = new Button(this.composite, SWT.PUSH);
			    this.btnCancel.setText("Cancel");
			    this.btnCancel.addListener(SWT.Selection, buttonListener);
			    this.btnCancel.setLayoutData(data);
			    
//			    this.shell.layout();
			    parentComposite.layout();

		
		/*****************************************************************************************/
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
