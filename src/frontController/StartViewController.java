package frontController;

import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.*;

public class StartViewController implements IContentState {

	private Composite composite;
	
	public StartViewController(){
		
	}
	
	
//	@Override
	public void setCurrentView(IContentState pCurrentState) {
		// TODO Auto-generated method stub
		
	}

//	@Override
//	public void show() {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void setComposite(Composite comp) {
//		this.composite = comp;
//		Color red = new Color (Display.getCurrent(), 255, 0, 0);
//		composite.setBackground(red);
//		
//	}

//	@Override
	public Composite getComposite() {
		// TODO Auto-generated method stub
		return this.composite;
	}
	
	

}
