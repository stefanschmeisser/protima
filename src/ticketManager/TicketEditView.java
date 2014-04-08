package ticketManager;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.*;

public class TicketEditView {

	private Composite composite;
	
	public TicketEditView(Shell shell){
		
		composite = new Composite(shell, SWT.NONE);

		Label blankLabel = new Label(composite, SWT.NONE);
		blankLabel.setText("Ticket Edit View");
//		blankLabel.setBounds(0, 0, 200, 200);
		
		Color col = new Color (Display.getCurrent(), 0, 255, 0);
		blankLabel.setBackground(col);	
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
