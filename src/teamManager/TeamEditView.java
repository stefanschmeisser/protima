package teamManager;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.layout.FillLayout;
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

public class TeamEditView implements ITeamState {
	
	private TeamViewController teamViewController;
	private Shell shell;
	private Composite composite;
	private Label labelTeamID, labelTeamName, labelTeamLeader;
	private Text textTeamID, textTeamName, textTeamLeader;
	public static Button saveButton, cancelButton;
	
	public TeamEditView(TeamViewController teamViewController, Shell shell){
		this.teamViewController = teamViewController;
		this.shell = shell;
		this.composite = new Composite(this.shell, SWT.NONE);
		this.composite.setLocation(0,0);
	}
	

	@Override
	public void show() {
		 this.composite.setLayout(new GridLayout());
		    
		    Composite header = new Composite(this.composite, SWT.NONE);
		    
			GridLayout layout = new GridLayout();
			layout.numColumns = 12;
		    layout.makeColumnsEqualWidth = true;
		    header.setLayout(layout);

		    Label teamEditHeader = new Label(header, SWT.NONE);
		    teamEditHeader.setText("Detail View");
		    FontData[] fD = teamEditHeader.getFont().getFontData();
		    fD[0].setHeight(16);
		    teamEditHeader.setFont( new Font(Display.getCurrent(),fD[0]));

			Composite content = new Composite(this.composite, SWT.NONE);
		    content.setLayout(new GridLayout(2, true));
			
		    labelTeamID = new Label(content, SWT.NONE);
			labelTeamID.setText("Projekt ID: ");
			labelTeamID.setLayoutData(new GridData(GridData.BEGINNING));
			
			textTeamID = new Text(content, SWT.READ_ONLY | SWT.BORDER);
			textTeamID.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
			
			
			labelTeamName = new Label(content, SWT.NONE);
			labelTeamName.setText("Name: ");
			labelTeamName.setLayoutData(new GridData(GridData.BEGINNING));
			
			textTeamName = new Text(content, SWT.NONE);
			textTeamName.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
			
			labelTeamLeader = new Label(content, SWT.NONE);
			labelTeamLeader.setText("Beschreibung: ");
			labelTeamLeader.setLayoutData(new GridData(GridData.VERTICAL_ALIGN_BEGINNING));
			
			textTeamLeader = new Text(content, SWT.MULTI | SWT.WRAP);
			textTeamLeader.setLayoutData(new GridData(GridData.FILL_HORIZONTAL | GridData.FILL_VERTICAL));
			
			Composite buttons = new Composite(this.composite, SWT.NONE);
		    buttons.setLayout(new GridLayout(2, true));
			
			saveButton = new Button(buttons, SWT.PUSH);
			saveButton.setText("Speichern");
			saveButton.setLayoutData(new GridData(GridData.BEGINNING));
			saveButton.addListener(SWT.Selection, this.teamViewController);
			
			cancelButton = new Button(buttons, SWT.PUSH);
			cancelButton.setText("Abbrechen");
			cancelButton.setLayoutData(new GridData(GridData.BEGINNING));
			cancelButton.addListener(SWT.Selection, this.teamViewController);
	}
	
	@Override
	public Composite getComposite(){
		return this.composite;
	}


	@Override
	public Table getTable() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void setComposite(Composite composite) {
		this.composite = composite;
		
	}

}







	
	
	

