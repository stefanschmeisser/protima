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

import applicationManager.Application;
import userRights.Editor;



public class UserEditView implements IUserState{

	private final Composite composite;
	private UserController uc;
	private Editor user;
	private Label userIDLabel;
	private Text userIDInput;
	private Composite compgrid;
	private Label userNameLabel;
	private Text userNameOutput;
	private Label userProjektLabel;
	private Text userPasswordOutput;
	private Button btnOk;
	private Button btnCancel;
	
	private UserDaoMySql userDao;
	private int userID;
	private String newPassword;
	
	public UserEditView(final Composite parentComposite,final UserViewController parent, final int id, final String userName, String pw){
		
		/**********************************************************************************/
		
		
		this.composite = new Composite(parentComposite, SWT.NONE);
		userDao = new UserDaoMySql();
		newPassword = pw;
		GridLayout layout = new GridLayout();
		layout.numColumns = 4;
	    layout.makeColumnsEqualWidth = true;
	    composite.setLayout(layout);
	    
	   // Application app = Application.getInstance();
	    //userID = app.getCurrentUserID();
	   // userID = 
	    
	    
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
	    
	    data = new GridData(GridData.FILL_HORIZONTAL);
	    data.horizontalSpan = 2;
	    this.compgrid = new Composite(this.composite, SWT.NONE);
	    this.compgrid.setLayoutData(data);
	    
	    data = new GridData(GridData.FILL_HORIZONTAL);
	    this.userNameLabel = new Label(this.composite, SWT.RIGHT);
	    this.userNameLabel.setText("User Name");
	    this.userNameLabel.setLayoutData(data);
	    
	    data = new GridData(GridData.FILL_HORIZONTAL);
	    data.horizontalSpan = 3;
	    this.userNameOutput = new Text(this.composite, SWT.LEFT | SWT.BORDER);
	    this.userNameOutput.setText(userName);
	    this.userNameOutput.setEnabled(true);
	    this.userNameOutput.setLayoutData(data);
	    
	    
	   
	    
	    data = new GridData(GridData.FILL_HORIZONTAL);
	    this.userProjektLabel = new Label(this.composite, SWT.RIGHT);
	    this.userProjektLabel.setText("Projekte");
	    this.userProjektLabel.setLayoutData(data);
	    
	    data = new GridData(GridData.FILL_HORIZONTAL);
	    data.horizontalSpan = 3;
	    this.userPasswordOutput = new Text(this.composite, SWT.LEFT | SWT.BORDER);
	    this.userPasswordOutput.setText(pw);
	    this.userPasswordOutput.setEnabled(true);
	    this.userPasswordOutput.setLayoutData(data);
	     
	   
	    data = new GridData(GridData.FILL_HORIZONTAL);
	    data.horizontalSpan = 4;
	    data.heightHint = 10;
	    this.compgrid = new Composite(this.composite, SWT.NONE);
	    this.compgrid.setLayoutData(data);
	    
	    
	    data = new GridData(GridData.FILL_HORIZONTAL);
	    data.horizontalSpan = 4;
	    data.heightHint = 10;
	    this.compgrid = new Composite(this.composite, SWT.NONE);
	    this.compgrid.setLayoutData(data);
	    
	    
	    data = new GridData(GridData.FILL_HORIZONTAL);
	    data.horizontalSpan = 2;
	    data.heightHint = 5;
	    this.compgrid = new Composite(this.composite, SWT.NONE);
	    this.compgrid.setLayoutData(data);
	    
	    data = new GridData(GridData.FILL_HORIZONTAL);
	    data.horizontalSpan = 4;
	    data.heightHint = 10;
	    this.compgrid = new Composite(this.composite, SWT.NONE);
	    this.compgrid.setLayoutData(data);
	    
	    data = new GridData(GridData.FILL_HORIZONTAL);
	    data.heightHint = 5;
	    data.horizontalSpan = 2;
	    this.compgrid = new Composite(this.composite, SWT.NONE);
	    this.compgrid.setLayoutData(data);
	    
	    Listener buttonListener = new Listener() {
			
		public void handleEvent(Event event) {
				if (event.widget == btnOk) {
					//in die db = userNameOutput.getText();
					userDao.editUserNameInDB(userNameOutput.getText().trim(), id,userPasswordOutput.getText());
					composite.dispose();
					parent.setCurrentView(new UserListView(parentComposite, parent));
				}
				if(event.widget == btnCancel){
					composite.dispose();
					parent.setCurrentView(new UserDetailView(parentComposite, parent,userName,id,newPassword));
				}
			}
		};
	    
	    // BUTTONS	    
	    data = new GridData(GridData.FILL_HORIZONTAL);
	    this.btnOk = new Button(this.composite, SWT.PUSH);
	    this.btnOk.setText("Ok");
	    this.btnOk.addListener(SWT.Selection, buttonListener);
	    this.btnOk.setLayoutData(data);
	    
	    data = new GridData(GridData.FILL_HORIZONTAL);
	    this.btnCancel = new Button(this.composite, SWT.PUSH);
	    this.btnCancel.setText("Cancel");
	    this.btnCancel.addListener(SWT.Selection, buttonListener);
	    this.btnCancel.setLayoutData(data);

	   parentComposite.layout();		
		
		/***********************************************************************************/

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
