package teamManager;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.graphics.Image;
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

public class TeamCreateView implements ITeamState {
	
	private TeamViewController teamViewController;
	private Composite composite, content;
	private Label labelTeamID, labelTeamName, labelTeamLeader, labelTeamDescription;
	public static Text textTeamID, textTeamName, textTeamLeader, textTeamDescription;
	public static Combo comboTeamLeader;
	public static Button createButton, cancelButton;
	
	public TeamCreateView(TeamViewController teamViewController, Composite content){
		this.teamViewController = teamViewController;
		this.content = content;
		this.composite = new Composite(this.content, SWT.NONE);
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
		labelTeamID.setText("Team ID: ");
		labelTeamID.setLayoutData(new GridData(GridData.BEGINNING));
		
		textTeamID = new Text(content, SWT.READ_ONLY | SWT.BORDER);
		textTeamID.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		
		labelTeamName = new Label(content, SWT.NONE);
		labelTeamName.setText("Name: ");
		labelTeamName.setLayoutData(new GridData(GridData.BEGINNING));
		
		textTeamName = new Text(content, SWT.NONE);
		textTeamName.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
//		
//		labelTeamDescription= new Label(content, SWT.NONE);
//		labelTeamDescription.setText("Beschreibung: ");
//		labelTeamDescription.setLayoutData(new GridData(GridData.VERTICAL_ALIGN_BEGINNING));
//		
//		textTeamDescription = new Text(content, SWT.MULTI | SWT.WRAP);
//		textTeamDescription.setLayoutData(new GridData(GridData.FILL_HORIZONTAL | GridData.FILL_VERTICAL));
//		
		Composite buttons = new Composite(this.composite, SWT.NONE);
	    buttons.setLayout(new GridLayout(2, true));
		
	    labelTeamLeader = new Label(content, SWT.NONE);
	    labelTeamLeader.setText("Teamleiter: ");
	    labelTeamLeader.setLayoutData(new GridData(GridData.VERTICAL_ALIGN_BEGINNING));
	    
	    comboTeamLeader = new Combo(content, SWT.NONE);
	    comboTeamLeader.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
	    
	    createButton = new Button(buttons, SWT.PUSH);
	    createButton.setText("Team erstellen");
	    createButton.setLayoutData(new GridData(GridData.BEGINNING));
	    createButton.addListener(SWT.Selection, this.teamViewController);
		
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
		// TODO Auto-generated method stub
	}

}


