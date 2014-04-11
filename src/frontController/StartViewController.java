package frontController;

import org.eclipse.swt.widgets.*;

public class StartViewController implements IContentState {

	private Composite content;
	private StartView startView;
	
	public StartViewController(Composite content){
		this.content = content;
		
		this.startView = new StartView(this.content, this);
	    
	}
}
