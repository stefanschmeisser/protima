package teamManager;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.Text;

//import userRights.teamManager;

public class TeamDetailView implements ITeamState {
	
	private TeamViewController teamViewController;
	private Shell shell;
	private Composite composite;
	private Button createButton, saveButton, cancelButton;
	private Label labelTeamID, labelTeamName, labelTeamLeader;
	private Text textTeamID, textTeamName;

	
	public TeamDetailView(TeamViewController teamViewController, Shell shell){
		this.teamViewController = teamViewController;
		this.shell = shell;
		this.composite = new Composite(this.shell, SWT.NONE);
		this.composite.setLocation(0,0);
	}
	
	@Override
	public void show() {
       Composite header = new Composite(this.composite, SWT.NONE);
		
		GridLayout layout = new GridLayout();
		layout.numColumns = 12;
	    layout.makeColumnsEqualWidth = true;
	    header.setLayout(layout);
	    
	    Label teamDetailHeader = new Label(header, SWT.NONE);
	    teamDetailHeader.setText("Detail View");
	    FontData[] fD = teamDetailHeader.getFont().getFontData();
	    fD[0].setHeight(16);
	    teamDetailHeader.setFont( new Font(Display.getCurrent(),fD[0]));
	}

	@Override
	public Composite getComposite(){
		return this.composite;
	}
	
	@Override
	public void setComposite(Composite composite){
		this.composite = composite;
	}
	
	
	@Override
	public Table getTable() {
		// TODO Auto-generated method stub
		return null;
	}


}
