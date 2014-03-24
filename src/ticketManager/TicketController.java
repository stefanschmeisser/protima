package ticketManager;

import org.eclipse.swt.*;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

import frontController.IContentState;


public class TicketController implements IContentState {

	private TicketListViewController tlvc;
	private Composite composite;
	
	public TicketController(Shell shell){
		
		// forward the shell parent object to the current/default TicketViewController
		tlvc = new TicketListViewController(shell);
		
	}
	
	
	
	@Override
	public void setCurrentView(IContentState pCurrentState) {
		// TODO Auto-generated method stub	
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
	}

	public void setComposite(Composite comp) {
		
		// get the composite from the current TicketViewController
		this.tlvc.composite = comp;
		Color blue = new Color (Display.getCurrent(), 0, 0, 255);
		this.tlvc.composite.setBackground(blue);
		
	}

	@Override
	public Composite getComposite() {
		
		// get the composite from the current TicketViewController
		return this.tlvc.getComposite();
	}

}
