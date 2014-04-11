package userManager;

import java.util.ArrayList;

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

	private Label userListLabel;
	private Composite subMenuComposite;
	private Boolean listBtnActivate = true;
	private ArrayList <String> pw;
	private final Button addNewUserBtn; 
	private Composite compgrid;
	
	
	public UserListView(final Composite parentComposite, final UserViewController parentUVC){

		composite = new Composite(parentComposite, SWT.NONE);
		GridLayout myLayout = new GridLayout();
		myLayout.numColumns = 2;
		myLayout.makeColumnsEqualWidth = true;
	    composite.setLayout(myLayout);
	    
	    this.userListLabel = new Label(this.composite, SWT.CENTER);
	    this.userListLabel.setText("Aktive Benutzer");
	    this.userListLabel.setLayoutData(new GridData(GridData.END));
	   
		
		GridData data = new GridData(GridData.FILL_HORIZONTAL);
	    data = new GridData(GridData.FILL_HORIZONTAL);
	    data.horizontalSpan = 0;
	    this.compgrid = new Composite(this.composite, SWT.NONE);
	    this.compgrid.setLayoutData(data);
	    
	   
		String[][] userList = parentUVC.getParent().getAllUsers();
		System.out.println("userlist: "+userList[0][0]);
		
		//Table: 
		//shell.setLayout(new GridLayout());
		data = new GridData(GridData.FILL_HORIZONTAL);
		final Table table = new Table (composite, SWT.MULTI | SWT.BORDER | SWT.FULL_SELECTION);
		table.setLinesVisible (true);
		table.setHeaderVisible (true);
		//GridData data = new GridData(SWT.FILL, SWT.FILL, true, true);
		data.heightHint = 200;
		table.setLayoutData(data);
		String[] titles = {" ID ", "Name", "Passwort"};
		for (int i=0; i<titles.length; i++) {
			TableColumn column = new TableColumn (table, SWT.NONE);
			column.setText (titles [i]);
		}	
		pw = new ArrayList<String>();
		for (int i=0; i<userList.length; i++) {
			TableItem item = new TableItem (table, SWT.NONE);
			item.setText (0, userList[i][0]); //id
			item.setText (1, userList[i][1]); //name
			item.setText (2, "***"); // pw

			pw.add(userList[i][2]);
		}
		
		for (int i=0; i<titles.length; i++) {
			table.getColumn (i).pack ();
		}
		table.addListener (SWT.Selection, new Listener () {
			@Override
			public void handleEvent (Event event) {
				// hole User aus der Tabelle und gebe diese weiter fŸr Detailansicht
				
				TableItem[] tableItems = table.getItems();
				String string =  event.detail == SWT.CHECK ? "Checked" : tableItems[event.index].getText(0);
				user = new Editor (Integer.parseInt(tableItems[event.index].getText(0)),tableItems[event.index].getText(1) );
				String name = tableItems[event.index].getText(1);
				System.out.println("event index: "+event.index);
				int id = Integer.parseInt(tableItems[event.index].getText(0));
				listBtnActivate = true;
			//	ulvButton.setEnabled(true);
				composite.dispose();
				parentUVC.setCurrentView(new UserDetailView(parentComposite, parentUVC,name,id,pw.get(event.index)));
				
				System.out.println (event.item + " " + string);
				//.setCurrentView(new U);
			}
		});
		
		data = new GridData(GridData.FILL_HORIZONTAL);
	    data = new GridData(GridData.FILL_HORIZONTAL);
	    data.horizontalSpan = 0;
	    this.compgrid = new Composite(this.composite, SWT.NONE);
	    this.compgrid.setLayoutData(data);
	    
	    addNewUserBtn = new Button(composite, SWT.PUSH);
	    addNewUserBtn.setText("Benutzer hinzufŸgen");
	    Listener buttonListener = new Listener() {
			
			public void handleEvent(Event event) {
				if (event.widget == addNewUserBtn) {
					composite.dispose();
					parentUVC.setCurrentView(new UserAddNewView(parentComposite, parentUVC));
					
				}
			}
		};
		addNewUserBtn.addListener(SWT.Selection, buttonListener);
		
		
			    
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
		//this.shell.layout();
		this.composite.layout();
	}
	

}
