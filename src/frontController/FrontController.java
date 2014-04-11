package frontController;

import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.*;

import applicationManager.IApplicationState;
import teamManager.TeamController;
import ticketManager.TicketController;
import projectManager.ProjectController;
import userManager.UserController;

public class FrontController implements IApplicationState, Listener {
	
	public Display disp;
	private Shell shell;
	private Composite composite;
	private IContentState currentState;
	private ViewDispatcher viewDispatcher;
	private IContentState startViewController;
	private IContentState projectController;
	private IContentState ticketController;
	private IContentState userController;
	private IContentState teamController;
	public Listener listener;
	
	public FrontController(Display disp){
		this.disp = disp;

		this.shell = new Shell(this.disp);
		this.shell.setText("ProTiMa");
		Image imageApplicationIcon = new Image(Display.getCurrent(), "content/icon.png");
        this.shell.setImage(imageApplicationIcon);
        this.shell.setLayout(new GridLayout());
        
        viewDispatcher = new ViewDispatcher(this, this.shell);
        this.composite = viewDispatcher.getComposite();
		this.startViewController = new StartViewController(this.composite);
		setCurrentView(this.startViewController);
		
		shell.pack();
		shell.setBounds(Display.getDefault().getPrimaryMonitor().getBounds());
		shell.setMaximized(true);
		shell.open();
		
        while (!shell.isDisposed()) {
         if (!this.disp.readAndDispatch())
          this.disp.sleep();
        }
		shell.dispose();
	}
	
	public void handleEvent(Event event) {
		
		if (event.widget == viewDispatcher.btnStart) {
			disposeCompositeChildren(this.composite);
			this.startViewController = new StartViewController(this.composite);
			setCurrentView(startViewController);
		}
		if (event.widget == viewDispatcher.btnProject) {
			disposeCompositeChildren(this.composite);
			this.projectController = new ProjectController(this.composite);
			setCurrentView(projectController);
		}
		if (event.widget == viewDispatcher.btnTicket) {
			disposeCompositeChildren(this.composite);
			this.ticketController = new TicketController(this.composite);
			setCurrentView(ticketController);
		}
		if(event.widget == viewDispatcher.btnUser){
			disposeCompositeChildren(this.composite);
			this.userController = new UserController(this.composite);
			setCurrentView(userController);
		}
		if (event.widget == viewDispatcher.btnTeam) {
			disposeCompositeChildren(this.composite);
			this.teamController = new TeamController(this.composite);
			setCurrentView(teamController);
		}
		
	}
	

	public void setCurrentView(IContentState currentState){
		this.currentState = currentState;
	}
	
	public Listener getListener() {
		return this.listener;
	}
	
	 public void disposeCompositeChildren(Composite currentComposite){
	    Control[] children = currentComposite.getChildren();
	      for (int i = 0; i < children.length; i++)
	      {
	          if (children[i] instanceof Composite)
	          {
	              children[i].dispose();
	          }
	      }
	  }

}
