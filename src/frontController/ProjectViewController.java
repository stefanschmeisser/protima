package frontController;

import org.eclipse.swt.*;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;


public class ProjectViewController implements IContentState {

	private Composite composite;
	
	public ProjectViewController(){
		
	}
	
	public void setComposite(Composite contentPane) {
		this.composite = contentPane;
		Color green = new Color (Display.getCurrent(), 0, 255, 0);
		contentPane.setBackground(green);
		
	}

	
	@Override
	public void setCurrentView(IContentState pCurrentState) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Composite getComposite() {
		// TODO Auto-generated method stub
		return this.composite;
	}


}
