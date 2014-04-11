package ticketManager;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.*;

public class TicketListView {

	private Composite content;
	private Composite composite;
	public Button btnRefresh, btnCreate, btnEdit, btnDelete;
	private Table table;
	
	public TicketListView(Composite comp, Listener listener){
		
		this.content = composite;
		composite = new Composite(this.content, SWT.NONE);
		
		GridLayout layout = new GridLayout();
		layout.numColumns = 3;
	    layout.makeColumnsEqualWidth = true;
	    composite.setLayout(layout);
	    
	    // OBERER TEIL GRIDLAYOUT
//	    GridData data = new GridData(GridData.FILL_BOTH);
//	    data.widthHint = 400;
//	    Button test = new Button(shell, SWT.PUSH);
//	    test.setText("test");
//	    test.setLayoutData(data);
	    
	    Composite compgrid = new Composite(composite, SWT.NONE);
	    GridData data = new GridData(GridData.FILL_BOTH);
	    data.horizontalSpan = 3;
//	    data.widthHint = 600;
	    compgrid.setLayoutData(data);
	    layout = new GridLayout();
	    layout.numColumns = 6;
	    layout.marginHeight = 15;
	    compgrid.setLayout(layout);
	    
	    data = new GridData(GridData.HORIZONTAL_ALIGN_BEGINNING);
	    Label ticket = new Label(compgrid, SWT.NONE);
	    ticket.setText("Ticket Overview");
	    
	    // BUTTONS for CREATE, EDIT, DELETE
	    data = new GridData();
	    data.grabExcessHorizontalSpace = true;
	    data.horizontalAlignment = GridData.END;
	    
	    this.btnRefresh = new Button(compgrid, SWT.PUSH);
	    this.btnRefresh.setText("Refresh");
	    this.btnRefresh.setLayoutData(data);
	    this.btnRefresh.addListener(SWT.Selection, listener);
	    
	    data = new GridData(GridData.HORIZONTAL_ALIGN_END);
	    this.btnCreate = new Button(compgrid, SWT.PUSH);
	    this.btnCreate.setText("Create");
	    this.btnCreate.setLayoutData(data);
	    this.btnCreate.addListener(SWT.Selection, listener);
	    
	    data = new GridData(GridData.HORIZONTAL_ALIGN_END);
	    this.btnEdit = new Button(compgrid, SWT.PUSH);
	    this.btnEdit.setText("Edit");
	    this.btnEdit.setLayoutData(data);
	    this.btnEdit.addListener(SWT.Selection, listener);
	    
	    data = new GridData(GridData.HORIZONTAL_ALIGN_END);
	    this.btnDelete = new Button(compgrid, SWT.PUSH);
	    this.btnDelete.setText("Delete");
	    this.btnDelete.setLayoutData(data);
	    this.btnDelete.addListener(SWT.Selection, listener);
	    
	    data = new GridData();
	    data.horizontalAlignment = GridData.FILL;
	    data.grabExcessHorizontalSpace = true;
	    data.horizontalSpan = 5;
	    data.heightHint = 100;
	    
	    // TABELLE für den LISTVIEW
	    this.table = new Table(compgrid, SWT.BORDER);
	    this.table.setSize(600, 200);
	    this.table.setLayoutData(data);	    
	    this.table.setHeaderVisible(true);
	    this.table.addListener(SWT.Selection, listener);

	    // DETAIL VIEW
//	    data = new GridData();
//	    data.horizontalAlignment = GridData.FILL;
//	    data.grabExcessHorizontalSpace = true;
//	    data.horizontalSpan = 5;
//	    data.heightHint = 200;
	    
//	    Composite compdetail = new Composite(shell, SWT.NONE);
//	    compdetail.setLayoutData(data);

	}

	// ------------------------------------------------------------------------
	
	public void setComposite(Composite comp) {
		this.composite = comp;
		Color blue = new Color (Display.getCurrent(), 0, 0, 255);
		this.composite.setBackground(blue);
		
	}

	// ------------------------------------------------------------------------
	
	public Composite getComposite() {
		
		return this.composite;
	}
	
	// ------------------------------------------------------------------------
	
	public Table getTable(){
		return this.table;
	}
	
	// ------------------------------------------------------------------------
	
	public void setTable(Table table){
		this.table = table;
	}
}
