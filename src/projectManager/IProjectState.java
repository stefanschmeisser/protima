package projectManager;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;

public interface IProjectState {
	public void show();
	public Composite getComposite();
	public Table getTable();
}
