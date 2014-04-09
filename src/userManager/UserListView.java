package userManager;

import org.eclipse.swt.layout.*;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;

import userRights.*;



public class UserListView implements IUserState{

	private final Composite composite;
	//private User user;
	private Editor user;
	private Shell shell;
	private Label userListLabel;
	private Composite subMenuComposite;
	public UserListView(final Shell shell, final UserViewController parentUVC){
		
		this.shell = shell;
		
		subMenuComposite = new Composite(shell,SWT.NONE);
		GridData datasubMenu = new GridData(GridData.FILL_HORIZONTAL);
	    datasubMenu.widthHint = shell.getSize().x;
	    datasubMenu.heightHint = 30;
	    this.subMenuComposite.setLayoutData(datasubMenu);
	    this.subMenuComposite.setLayout(new GridLayout(6, true));
		this.subMenuComposite.setBackground(shell.getDisplay().getSystemColor(SWT.COLOR_DARK_GRAY));
		
		composite = new Composite(shell, SWT.NONE);
		GridLayout myLayout = new GridLayout();
		myLayout.numColumns = 2;
		myLayout.makeColumnsEqualWidth = true;
	    composite.setLayout(myLayout);
	     
	    GridData data = new GridData(GridData.FILL_HORIZONTAL);
	    
		
		final Button ulvButton = new Button(subMenuComposite, SWT.NONE);
		ulvButton.setText("UserListView");

		Listener buttonListener = new Listener() {
			
			public void handleEvent(Event event) {
				if (event.widget == ulvButton) {
					
					//System.out.println("ja mann");
					Color red = new Color (Display.getCurrent(), 255, 230, 39);
					
					composite.dispose();
					parentUVC.setCurrentView(new UserEditView(shell,parentUVC));
				}
			}
		};
		    
	    //FIXME: dispose() Aufruf sauber und in Ordnung?
	    
		ulvButton.addListener(SWT.Selection, buttonListener);
		String[][] userList = parentUVC.getParent().getAllUsers();
		System.out.println("userlist: "+userList[0][0]);
		
		//Table: 
		//shell.setLayout(new GridLayout());
		final Table table = new Table (shell, SWT.MULTI | SWT.BORDER | SWT.FULL_SELECTION);
		table.setLinesVisible (true);
		table.setHeaderVisible (true);
		//GridData data = new GridData(SWT.FILL, SWT.FILL, true, true);
		data.heightHint = 200;
		table.setLayoutData(data);
		String[] titles = {" ID ", "Name"};
		for (int i=0; i<titles.length; i++) {
			TableColumn column = new TableColumn (table, SWT.NONE);
			column.setText (titles [i]);
		}	
		
		for (int i=0; i<userList.length; i++) {
			TableItem item = new TableItem (table, SWT.NONE);
			item.setText (0, userList[i][0]);
			item.setText (1, userList[i][1]);
			
		}
		for (int i=0; i<titles.length; i++) {
			table.getColumn (i).pack ();
		}
		table.addListener (SWT.Selection, new Listener () {
			@Override
			public void handleEvent (Event event) {
				// hole die ID aus der Tabelle und gebe diese weiter fŸr Detailansicht
				TableItem[] tableItems = table.getItems();
				String string =  event.detail == SWT.CHECK ? "Checked" : tableItems[event.index].getText(0);
				user = new Editor (Integer.parseInt(tableItems[event.index].getText(0)),tableItems[event.index].getText(1) );
				parentUVC.setCurrentView(new UserDetailView(shell, parentUVC, user));
				
				//composite.dispose();
				System.out.println (event.item + " " + string);
				//.setCurrentView(new U);
			}
		});
		this.userListLabel = new Label(this.composite, SWT.RIGHT);
	    this.userListLabel.setText("Aktive Benutzer");
	    this.userListLabel.setLayoutData(data);
		shell.pack ();
			    
	}

	
	public void setComposite(Composite comp) {
		
		// get the composite from the current UserController
		
		//this.uc.setComposite(comp);
	}


	public Composite getComposite() {
		
		return this.composite;
	}
	@Override
	public void show() {
		// TODO Auto-generated method stub
		this.shell.layout();
	}
	

}
