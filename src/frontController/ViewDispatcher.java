package frontController;
import org.eclipse.swt.*;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.*;


public class ViewDispatcher {
	
	private FrontController frontController;
	private Composite menu;
	private Label label;
	private Shell shell;
	public Button btnStart, btnProject, btnTicket, btnTeam, btnUser;
	
	public ViewDispatcher(FrontController pFC, Shell parent){
		this.frontController = pFC;
		this.menu = new Composite(parent, SWT.NONE);
	}
	
	public void show(Display disp){
		
		
        // content.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GridLayout gridLayout = new GridLayout(1, false);
        gridLayout.numColumns = 6;
		gridLayout.marginWidth = 5;
		gridLayout.marginHeight = 5;
		gridLayout.verticalSpacing = 0;
		gridLayout.horizontalSpacing = 0;
		menu.setLayout(gridLayout);
		
		
		// menu = new JPanel();
		// menu.setLayout(new BoxLayout(menu, BoxLayout.PAGE_AXIS));
		
		label = new Label(menu, SWT.NONE);
		label.setText("ProTiMa");
		label.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		
        btnStart = new Button(menu, SWT.PUSH);
        btnStart.setText("Start");
        btnStart.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
        
        btnUser = new Button(menu,SWT.PUSH);
        btnUser.setText("User");
        btnUser.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
        
        btnProject = new Button(menu, SWT.PUSH);
        btnProject.setText("Project");
        btnProject.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
        
        btnTicket = new Button(menu, SWT.PUSH);
        btnTicket.setText("Ticket");
        btnTicket.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
        
        btnTeam = new Button(menu, SWT.PUSH);
        btnTeam.setText("Team");
        btnTeam.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
        
	    btnStart.addListener(SWT.Selection, this.frontController.getListener());
	    btnUser.addListener(SWT.Selection, this.frontController.getListener());
	    btnProject.addListener(SWT.Selection, this.frontController.getListener());
	    btnTicket.addListener(SWT.Selection, this.frontController.getListener());
	    btnTeam.addListener(SWT.Selection, this.frontController.getListener());
        
//        shell.pack();
//        shell.open();
        
//        setContentPane(contentPane);
//        menu.add(contentPane);
//        menu.setVisible(true);
	}

	public Composite getContentPanel() {
		return this.menu;
	}
	
}
