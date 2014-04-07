package frontController;

import java.awt.Dimension;
import java.awt.Toolkit;

import org.eclipse.swt.*;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.*;

import applicationManager.IApplicationState;
import ticketManager.TicketController;
import projectManager.ProjectController;

public class FrontController implements IApplicationState {
	
	private Display disp;
	private Shell shell;
	private Composite composite;
	private IContentState currentState;
	private ViewDispatcher vd;
	private StartViewController svc;
	private IContentState pc;
	private TicketController tc;
//	private Composite content;
	Menu menuBar, fileMenu, projectMenu, teamMenu, ticketMenu, helpMenu;
	MenuItem fileMenuHeader, projectMenuHeader, teamMenuHeader, ticketMenuHeader, helpMenuHeader;
	MenuItem fileExitItem, fileSaveItem;
	MenuItem projectCreateItem, projectEditItem, projectDeleteItem;
	MenuItem teamCreateItem, teamEditItem, teamDeleteItem;
	MenuItem ticketCreateItem, ticketEditItem, ticketDeleteItem;
	MenuItem helpGetHelpItem;
	
	public Listener listener;
	
	public FrontController(Display disp){
		
		this.disp = disp;
		shell = new Shell(this.disp);
		shell.setText("ProTiMa");
		Image imageApplicationIcon = new Image(Display.getCurrent(), "content/icon.png");
        shell.setImage(imageApplicationIcon);
//<>		this.content = new Composite(shell, SWT.NONE);  
		
		menuBar = new Menu(shell, SWT.BAR);
		
		// ProMiTa Menü
	    fileMenuHeader = new MenuItem(menuBar, SWT.CASCADE);
	    fileMenuHeader.setText("&ProMiTa");	    
	    fileMenu = new Menu(shell, SWT.DROP_DOWN);
	    fileMenuHeader.setMenu(fileMenu);
	    fileSaveItem = new MenuItem(fileMenu, SWT.PUSH);
	    fileSaveItem.setText("&Speichern");
	    fileExitItem = new MenuItem(fileMenu, SWT.PUSH);
	    fileExitItem.setText("&Beenden");

	    // Projekt Menü
	    projectMenuHeader = new MenuItem(menuBar, SWT.CASCADE);
	    projectMenuHeader.setText("&Projekt");
	    projectMenu = new Menu(shell, SWT.DROP_DOWN);
	    projectMenuHeader.setMenu(projectMenu);
	    projectCreateItem = new MenuItem(projectMenu, SWT.PUSH);
	    projectCreateItem.setText("Neues Projekt");
	    projectEditItem = new MenuItem(projectMenu, SWT.PUSH);
	    projectEditItem.setText("Projekt editieren");
	    projectDeleteItem = new MenuItem(projectMenu, SWT.PUSH);
	    projectDeleteItem.setText("Projekt löschen");

	    // Team Menü
	    teamMenuHeader = new MenuItem(menuBar, SWT.CASCADE);
	    teamMenuHeader.setText("&Team");
	    teamMenu = new Menu(shell, SWT.DROP_DOWN);
	    teamMenuHeader.setMenu(teamMenu);
	    teamCreateItem = new MenuItem(teamMenu, SWT.PUSH);
	    teamCreateItem.setText("Neues Team");
	    teamEditItem = new MenuItem(teamMenu, SWT.PUSH);
	    teamEditItem.setText("Team editieren");
	    teamDeleteItem = new MenuItem(teamMenu, SWT.PUSH);
	    teamDeleteItem.setText("Team löschen");

	    // Ticket Menü
	    ticketMenuHeader = new MenuItem(menuBar, SWT.CASCADE);
	    ticketMenuHeader.setText("&Ticket");
	    ticketMenu = new Menu(shell, SWT.DROP_DOWN);
	    ticketMenuHeader.setMenu(ticketMenu);
	    ticketCreateItem = new MenuItem(ticketMenu, SWT.PUSH);
	    ticketCreateItem.setText("Neues Ticket");
	    ticketEditItem = new MenuItem(ticketMenu, SWT.PUSH);
	    ticketEditItem.setText("Ticket editieren");
	    ticketDeleteItem = new MenuItem(ticketMenu, SWT.PUSH);
	    ticketDeleteItem.setText("Ticket löschen");

	    // Hilfe Menü
	    helpMenuHeader = new MenuItem(menuBar, SWT.CASCADE);
	    helpMenuHeader.setText("&Hilfe");
	    helpMenu = new Menu(shell, SWT.DROP_DOWN);
	    helpMenuHeader.setMenu(helpMenu);
	    helpGetHelpItem = new MenuItem(helpMenu, SWT.PUSH);
	    helpGetHelpItem.setText("&Info");

//	    fileExitItem.addSelectionListener(new fileExitItemListener());
//	    fileSaveItem.addSelectionListener(new fileSaveItemListener());
//	    helpGetHelpItem.addSelectionListener(new helpGetHelpItemListener());

	    shell.setMenuBar(menuBar);
		
		svc = new StartViewController();
		this.pc = new ProjectController(this.shell);
		tc = new TicketController(this.shell);
//		tvc = new TeamViewController();

		//TODO: untere Composite (blankComp) kontextsensitiv aendern
		listener = new Listener() {
			public void handleEvent(Event event) {
				if (event.widget == vd.btnStart) {
					System.out.println("Btn Start");
//					svc.setComposite(vd.getContentPanel());
					setCurrentView(svc);
				}
				if (event.widget == vd.btnProject) {
					System.out.println("Btn Project");
//					pc.setComposite(content);
					setCurrentView(pc);
				}
				if (event.widget == vd.btnTicket) {
					System.out.println("Btn Ticket");
//					tc.setComposite(vd.getContentPanel());
					setCurrentView(tc);
				}
//				if (event.widget == vd.btnTeam) {
//					System.out.println("Btn Team");
//					tvc.setContentPane(vd.getContentPanel());
//					setCurrentView(tvc);
//				}
			}
		};

		GridLayout uberLayout = new GridLayout(1, false);
		shell.setLayout(uberLayout);
		
		this.vd = new ViewDispatcher(this, shell);
		vd.show(null);
		
//		content.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
//		vd.getContentPanel().setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
//		content.moveBelow(vd.getContentPanel());
		
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
	
	public void setCurrentView(IContentState currentState){
		this.currentState = currentState;
	}
	
	public Listener getListener() {
		return this.listener;
	}

}
