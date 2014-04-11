package teamManager;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;

public interface ITeamState {
	
	public void show();
	public Composite getComposite();
	public void setComposite(Composite composite);
	public Table getTable();

}


