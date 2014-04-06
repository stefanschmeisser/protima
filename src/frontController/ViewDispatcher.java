package frontController;
import org.eclipse.swt.*;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.*;


public class ViewDispatcher {
	
	private FrontController frontController;
	private Composite menu;
	private Label label;
	private Shell shell;
	public Button btnStart, btnProject, btnTicket, btnTeam;
	
	public ViewDispatcher(FrontController pFC, Shell parent){
		this.frontController = pFC;
		this.shell = parent;
		this.menu = new Composite(parent, SWT.NONE);
	}
	
	public void show(Display disp){
        GridLayout gridLayout = new GridLayout(1, false);
        gridLayout.numColumns = 4;
		gridLayout.marginWidth = 4;
		gridLayout.marginHeight = 4;
		gridLayout.verticalSpacing = 0;
		gridLayout.horizontalSpacing = 0;
		menu.setLayout(gridLayout);
		menu.setLocation(0, 0);
		
        btnStart = new Button(menu, SWT.PUSH);
//        btnStart.setText("Start");
        Image imageStart = new Image(Display.getCurrent(), "content/menu.png");
        btnStart.setImage(imageStart);
        btnStart.setLayoutData(new GridData(GridData.BEGINNING));
        
        btnProject = new Button(menu, SWT.PUSH);
//        btnProject.setText("Project");
        Image imageProject = new Image(Display.getCurrent(), "content/project.png");
        btnProject.setImage(imageProject);
        btnProject.setLayoutData(new GridData(GridData.BEGINNING));
        
        btnTicket = new Button(menu, SWT.PUSH);
//        btnTicket.setText("Ticket");
        Image imageTicket = new Image(Display.getCurrent(), "content/ticket.png");
        btnTicket.setImage(imageTicket);
        btnTicket.setLayoutData(new GridData(GridData.BEGINNING));
        
        btnTeam = new Button(menu, SWT.PUSH);
//        btnTeam.setText("Team");
        Image imageTeam = new Image(Display.getCurrent(), "content/team.png");
        btnTeam.setImage(imageTeam);
        btnTeam.setLayoutData(new GridData(GridData.BEGINNING));
        
	    btnStart.addListener(SWT.Selection, this.frontController.getListener());
	    btnProject.addListener(SWT.Selection, this.frontController.getListener());
	    btnTicket.addListener(SWT.Selection, this.frontController.getListener());
	    btnTeam.addListener(SWT.Selection, this.frontController.getListener());

	}

	public Composite getContentPanel() {
		return this.menu;
	}
	
}
