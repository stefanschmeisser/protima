package projectManager;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;

public interface IProjectState {
	
	public void show();
	public Button getEditButton();
	public Button getCancelButton();
}
