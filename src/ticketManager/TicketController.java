package ticketManager;

import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;

import frontController.IContentState;


public class TicketController implements IContentState {

	private Composite composite;
	
	@Override
	public void setCurrentView(IContentState pCurrentState) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}

	public void setComposite(Composite comp) {
		this.composite = comp;
		Color blue = new Color (Display.getCurrent(), 0, 0, 255);
		this.composite.setBackground(blue);
		
	}

	@Override
	public Composite getComposite() {
		// TODO Auto-generated method stub
		return this.composite;
	}

}
