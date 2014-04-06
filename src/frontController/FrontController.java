package frontController;

import org.eclipse.swt.*;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.*;

import applicationManager.IApplicationState;
import ticketManager.TicketController;

public class FrontController implements IApplicationState {
	
	private Display disp;
	private Shell shell;
	private IContentState currentState;
	private ViewDispatcher vd;
	private StartViewController svc;
	private ProjectViewController pvc;
	private TicketController tc;
	//private UserViewController uvc;
	
	public Listener listener;
	
	public FrontController(Display disp){
		
		this.disp = disp;
		shell = new Shell(this.disp);
		
		svc = new StartViewController();
		pvc = new ProjectViewController();
		tc = new TicketController(this.shell);
//		tvc = new TeamViewController();

		Composite blankComp = this.tc.getComposite();//new Composite(shell, SWT.NONE);
		GridLayout blankCompLayout = new GridLayout();
		blankComp.setLayout(blankCompLayout);
		
		//TODO: untere Composite (blankComp) kontextsensitiv aendern
		listener = new Listener() {
			public void handleEvent(Event event) {
				if (event.widget == vd.btnStart) {
					System.out.println("Btn Start");
					svc.setComposite(vd.getContentPanel());
					setCurrentView(svc);
				}
				if (event.widget == vd.btnProject) {
					System.out.println("Btn Project");
					pvc.setComposite(vd.getContentPanel());
					setCurrentView(pvc);
				}
				if (event.widget == vd.btnTicket) {
					System.out.println("Btn Ticket");
					tc.setComposite(vd.getContentPanel());
					setCurrentView(tc);
				}
//				if (event.widget == vd.btnTeam) {
//					System.out.println("Btn Team");
//					tvc.setContentPane(vd.getContentPanel());
//					setCurrentView(tvc);
//				}
				
//				if (event.widget == vd.btnUser) {
//					System.out.println("Btn User");
//					uvc.setContentPane(vd.getContentPanel());
//					setCurrentView(uvc);
//				}
			}
		};
		
		//Label blankLabel = new Label(blankComp, SWT.NONE);
		//blankLabel.setText("Mystery");
//		blankLabel.setBounds(0, 0, 200, 200);
		
		//Color red = new Color (Display.getCurrent(), 255, 0, 0);
		//blankLabel.setBackground(red);
		//blankComp.setBackground(red);
		
//		shell.pack();
		
		
		
		GridLayout uberLayout = new GridLayout(1, false);
		shell.setLayout(uberLayout);
		
		this.vd = new ViewDispatcher(this, shell);
		vd.show(null);
		
		blankComp.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		vd.getContentPanel().setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		
//		vd.getContentPanel().setLayout(gridlayout);
//		blankComp.setLayout(gridlayout);
		
		
		blankComp.moveBelow(vd.getContentPanel());
		
		shell.pack();
		shell.open();
		

        while (!shell.isDisposed()) {
         if (!this.disp.readAndDispatch())
          this.disp.sleep();
        }
		shell.dispose();
	}
	

//	public void actionPerformed(ActionEvent e) {
//		
//		if(e.getActionCommand().equalsIgnoreCase("start")){
//			//System.out.println("Start gedr√ºckt");
//			svc.setContentPane(this.vd.getContentPanel());
//			setCurrentView(this.svc);
//		}
//		
//		if(e.getActionCommand().equalsIgnoreCase("project")){
//			this.pvc = new ProjectViewController();
//			pvc.setContentPane(this.vd.getContentPanel());
//			setCurrentView(this.pvc);
//		}
//		
//		if(e.getActionCommand().equalsIgnoreCase("ticket")){
//			this.tc = new TicketController();
//			tc.setContentPane(this.vd.getContentPanel());
//			setCurrentView(this.tc);
//		}
//		
//	}
//
	public void setCurrentView(IContentState pCurrentState){
		this.currentState = pCurrentState;
		this.zeigma();
	}
	
	public void zeigma(){
		this.currentState.show();
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}
	
	public Listener getListener() {
		return this.listener;
	}

  // irgendwas blödes


}
