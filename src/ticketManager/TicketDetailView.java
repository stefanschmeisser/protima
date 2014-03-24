package ticketManager;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

public class TicketDetailView {

	private Composite composite;
	
	public TicketDetailView(Shell shell){

		composite = new Composite(shell, SWT.NONE);

		Label blankLabel = new Label(composite, SWT.NONE);
		blankLabel.setText("TicketDetailView");
//		blankLabel.setBounds(0, 0, 200, 200);
		
		Color col = new Color (Display.getCurrent(), 128, 128, 255);
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
