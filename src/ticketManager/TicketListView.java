package ticketManager;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.*;



public class TicketListView {

	private Composite composite;
	public Button btnStart;
	
	public TicketListView(Shell shell, Listener listener){
		
		composite = new Composite(shell, SWT.NONE);

		Label blankLabel = new Label(composite, SWT.NONE);
		blankLabel.setText("ticketListViewcontroller");
//		blankLabel.setBounds(0, 0, 200, 200);
		
		Color red = new Color (Display.getCurrent(), 255, 0, 0);
		blankLabel.setBackground(red);	
		//shell.pack();
	}
	
	
	public void setComposite(Composite comp) {
		this.composite = comp;
		Color blue = new Color (Display.getCurrent(), 0, 0, 255);
		this.composite.setBackground(blue);
		
	}

	public Composite getComposite() {
		
		return this.composite;
	}
}
