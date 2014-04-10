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
	private Shell shell;
	//private final Button uevButton;
	private Label userIDLabel;
	private Text userIDInput;
	private Composite compgrid;
	private Label userNameLabel;
	private Text userTitleOutput;
	private Label userProjektLabel;
	private Text userDescOutput;
	private Button btnEdit;
	private Button btnCancel;
	
	public UserDetailView(final Shell shell, final UserViewController parent, final String userName, final int id){
		this.shell = shell;
		//this.user = user;
		/*
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
		*/
		Listener buttonListener = new Listener() {
			
		public void handleEvent(Event event) {
				if (event.widget == btnEdit) {
					composite.dispose();
					parent.setCurrentView(new UserEditView(shell, parent, id, userName));
	
				}
				if(event.widget == btnCancel){
					composite.dispose();
					parent.setCurrentView(new UserListView(shell, parent));
				}
			}
		};
		
		//uevButton.addListener(SWT.Selection, buttonListener);
		
		/*****************************************************************************************/
					
				this.composite = new Composite(shell, SWT.NONE);
				GridLayout layout = new GridLayout();
				layout.numColumns = 4;
			    layout.makeColumnsEqualWidth = true;
			    composite.setLayout(layout);
			    
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
			    this.userTitleOutput = new Text(this.composite, SWT.READ_ONLY | SWT.LEFT | SWT.BORDER);
			    this.userTitleOutput.setText(userName);
			    this.userTitleOutput.setEnabled(false);
			    this.userTitleOutput.setLayoutData(data);
			    
			    data = new GridData(GridData.FILL_HORIZONTAL);
			    this.userProjektLabel = new Label(this.composite, SWT.RIGHT);
			    this.userProjektLabel.setText("Projekte");
			    this.userProjektLabel.setLayoutData(data);
			    
			    data = new GridData(GridData.FILL_HORIZONTAL);
			    data.heightHint = 70;
			    data.widthHint = 505;
			    data.horizontalSpan = 3;
			    this.userDescOutput = new Text(this.composite,  SWT.READ_ONLY | SWT.MULTI | SWT.BORDER | SWT.WRAP | SWT.V_SCROLL);
			    this.userDescOutput.setEnabled(false);
			    this.userDescOutput.setLayoutData(data);
			    
			   
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
			    
			    this.shell.layout();

//				composite = new Composite(shell, SWT.NONE);
		//
//				Label blankLabel = new Label(composite, SWT.NONE);
//				blankLabel.setText("TicketDetailView");
//				blankLabel.setBounds(0, 0, 200, 200);
//				
//				Color col = new Color (Display.getCurrent(), 128, 128, 255);
//				blankLabel.setBackground(col);	
//				shell.pack();

		
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
