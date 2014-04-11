package frontController;

import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.*;

import applicationManager.IApplicationState;
import ticketManager.TicketController;
import projectManager.ProjectController;
import userManager.UserController;

public class FrontController implements IApplicationState, Listener {
	
	public Display disp;
	private Shell shell;
	private Composite composite;
	private IContentState currentState;
	private ViewDispatcher vd;
	private StartViewController svc;
	private IContentState pc;
	private TicketController tc;
	private UserController uc;
	public Listener listener;
	
	public FrontController(Display disp){
		this.disp = disp;

		this.shell = new Shell(this.disp);
		this.shell.setText("ProTiMa");
		Image imageApplicationIcon = new Image(Display.getCurrent(), "content/icon.png");
        this.shell.setImage(imageApplicationIcon);
        this.shell.setLayout(new GridLayout());
        
        vd = new ViewDispatcher(this, this.shell);
        this.composite = vd.getComposite();
		this.svc = new StartViewController(this.composite);
//		this.tvc = new TeamViewController();
//		this.uc  = new UserController(this.composite /*, this*/);
		setCurrentView(this.tc);
		
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
		
		if (event.widget == vd.btnStart) {
			System.out.println("Btn Start");
//			svc.setComposite(vd.getContentPanel());
			disposeCompositeChildren(this.composite);
			setCurrentView(svc);
		}
		if (event.widget == vd.btnProject) {
			System.out.println("Btn Project");
//			pc.setComposite(content);
			disposeCompositeChildren(this.composite);
			this.pc = new ProjectController(this.composite);
			setCurrentView(pc);
		}
		if (event.widget == vd.btnTicket) {
			System.out.println("Btn Ticket");
//			tc.setComposite(vd.getContentPanel());
			disposeCompositeChildren(this.composite);
			this.tc = new TicketController(this.composite);
			setCurrentView(tc);
		}
		if(event.widget == vd.btnUser){
			System.out.println("Btn User");
			if(uc==null){
				this.uc = new UserController(this.composite/*, this*/);
				setCurrentView(uc);
			}
			else{
				setCurrentView(uc);
			}
		}
//		if (event.widget == vd.btnTeam) {
//			System.out.println("Btn Team");
//			tvc.setContentPane(vd.getContentPanel());
//			setCurrentView(tvc);
//		}
		
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
