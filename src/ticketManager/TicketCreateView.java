package ticketManager;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.*;

public class TicketCreateView {

	private Composite composite;
	public Button btnStart;
	
	public TicketCreateView(Shell shell, Listener listener){
		
		composite = new Composite(shell, SWT.NONE);

		Label blankLabel = new Label(composite, SWT.NONE);
		blankLabel.setText("Ticket Create View");
		
		Color col = new Color (Display.getCurrent(), 0, 170, 170);
		blankLabel.setBackground(col);	
		
		btnStart = new Button(composite, SWT.PUSH);
        btnStart.setText("Start");
        btnStart.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
        
        btnStart.addListener(SWT.Selection, listener);
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
