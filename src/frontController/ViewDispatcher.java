package frontController;

import java.awt.Color;

import org.eclipse.swt.*;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.*;


public class ViewDispatcher {
	
	private FrontController frontController;
	private Shell shell;
	private Composite menu;
	private Label label;
	public Button btnStart, btnProject, btnTicket, btnTeam, btnUser;
	Menu menuBar, fileMenu, projectMenu, teamMenu, ticketMenu, helpMenu, userMenu;
	MenuItem fileMenuHeader, projectMenuHeader, teamMenuHeader, ticketMenuHeader, helpMenuHeader, userMenuHeader;
	MenuItem fileExitItem, fileSaveItem;
	MenuItem userEditItem, userAddNewUserItem;
	MenuItem projectCreateItem, projectEditItem, projectDeleteItem;
	MenuItem teamCreateItem, teamEditItem, teamDeleteItem;
	MenuItem ticketCreateItem, ticketEditItem, ticketDeleteItem;
	MenuItem helpGetHelpItem;
	
	public ViewDispatcher(FrontController frontController, Shell shell){
		this.frontController = frontController;
		this.shell = shell;
		this.menuBar = new Menu(this.shell, SWT.BAR);
		this.menu = new Composite(this.shell, SWT.NONE);
		GridData data = new GridData(GridData.FILL_HORIZONTAL);
	    data.widthHint = shell.getSize().x;
	    data.heightHint = 70;
	    this.menu.setLayoutData(data);
	    this.menu.setLayout(new GridLayout(12, true));
		this.menu.setBackground(frontController.disp.getSystemColor(SWT.COLOR_DARK_GRAY));
		
		// ProMiTa Menü
	    fileMenuHeader = new MenuItem(this.menuBar, SWT.CASCADE);
	    fileMenuHeader.setText("&ProMiTa");	    
	    fileMenu = new Menu(this.shell, SWT.DROP_DOWN);
	    fileMenuHeader.setMenu(fileMenu);
	    fileSaveItem = new MenuItem(fileMenu, SWT.PUSH);
	    fileSaveItem.setText("&Speichern");
	    fileExitItem = new MenuItem(fileMenu, SWT.PUSH);
	    fileExitItem.setText("&Beenden");
	    
	    // User Menu
	    userMenuHeader = new MenuItem(this.menuBar,SWT.CASCADE);
	    userMenuHeader.setText("User");
	    userMenu = new Menu(this.shell,SWT.DROP_DOWN);
	    userMenuHeader.setMenu(userMenu);
	    userEditItem = new MenuItem(userMenu,SWT.PUSH);
	    userEditItem.setText("Benutzer Editieren");
	    userAddNewUserItem = new MenuItem(userMenu,SWT.PUSH);
	    userAddNewUserItem.setText("Benutzer hinzufŸgen");

	    // Projekt Menü
	    projectMenuHeader = new MenuItem(this.menuBar, SWT.CASCADE);
	    projectMenuHeader.setText("&Projekt");
	    projectMenu = new Menu(this.shell, SWT.DROP_DOWN);
	    projectMenuHeader.setMenu(projectMenu);
	    projectCreateItem = new MenuItem(projectMenu, SWT.PUSH);
	    projectCreateItem.setText("Neues Projekt");
	    projectEditItem = new MenuItem(projectMenu, SWT.PUSH);
	    projectEditItem.setText("Projekt editieren");
	    projectDeleteItem = new MenuItem(projectMenu, SWT.PUSH);
	    projectDeleteItem.setText("Projekt löschen");

	    // Team Menü
	    teamMenuHeader = new MenuItem(this.menuBar, SWT.CASCADE);
	    teamMenuHeader.setText("&Team");
	    teamMenu = new Menu(this.shell, SWT.DROP_DOWN);
	    teamMenuHeader.setMenu(teamMenu);
	    teamCreateItem = new MenuItem(teamMenu, SWT.PUSH);
	    teamCreateItem.setText("Neues Team");
	    teamEditItem = new MenuItem(teamMenu, SWT.PUSH);
	    teamEditItem.setText("Team editieren");
	    teamDeleteItem = new MenuItem(teamMenu, SWT.PUSH);
	    teamDeleteItem.setText("Team löschen");

	    // Ticket Menü
	    ticketMenuHeader = new MenuItem(this.menuBar, SWT.CASCADE);
	    ticketMenuHeader.setText("&Ticket");
	    ticketMenu = new Menu(this.shell, SWT.DROP_DOWN);
	    ticketMenuHeader.setMenu(ticketMenu);
	    ticketCreateItem = new MenuItem(ticketMenu, SWT.PUSH);
	    ticketCreateItem.setText("Neues Ticket");
	    ticketEditItem = new MenuItem(ticketMenu, SWT.PUSH);
	    ticketEditItem.setText("Ticket editieren");
	    ticketDeleteItem = new MenuItem(ticketMenu, SWT.PUSH);
	    ticketDeleteItem.setText("Ticket löschen");

	    // Hilfe Menü
	    helpMenuHeader = new MenuItem(this.menuBar, SWT.CASCADE);
	    helpMenuHeader.setText("&Hilfe");
	    helpMenu = new Menu(this.shell, SWT.DROP_DOWN);
	    helpMenuHeader.setMenu(helpMenu);
	    helpGetHelpItem = new MenuItem(helpMenu, SWT.PUSH);
	    helpGetHelpItem.setText("&Info");

//	    fileExitItem.addSelectionListener(new fileExitItemListener());
//	    fileSaveItem.addSelectionListener(new fileSaveItemListener());
//	    helpGetHelpItem.addSelectionListener(new helpGetHelpItemListener());
		
	    this.shell.setMenuBar(this.menuBar);
	    
        this.btnStart = new Button(this.menu, SWT.PUSH);
//        this.btnStart.setText("Start");
        Image imageStart = new Image(Display.getCurrent(), "content/menu.png");
        btnStart.setImage(imageStart);
        btnStart.setSize(50, 50);
        this.btnStart.setLayoutData(new GridData(GridData.BEGINNING));
        
        btnUser = new Button(this.menu, SWT.PUSH);
        //btnUser.setImage(imageProject);
        btnUser.setSize(50, 50);
        btnUser.setLayoutData(new GridData(GridData.BEGINNING));
        
        btnProject = new Button(this.menu, SWT.PUSH);
//        btnProject.setText("Project");
        Image imageProject = new Image(Display.getCurrent(), "content/project.png");
        btnProject.setImage(imageProject);
        btnProject.setSize(50, 50);
        btnProject.setLayoutData(new GridData(GridData.BEGINNING));
        
        btnTicket = new Button(this.menu, SWT.PUSH);
//        btnTicket.setText("Ticket");
        Image imageTicket = new Image(Display.getCurrent(), "content/ticket.png");
        btnTicket.setImage(imageTicket);
        btnTicket.setSize(50, 50);
        btnTicket.setLayoutData(new GridData(GridData.BEGINNING));
        
        btnTeam = new Button(this.menu, SWT.PUSH);
//        btnTeam.setText("Team");
        Image imageTeam = new Image(Display.getCurrent(), "content/team.png");
        btnTeam.setImage(imageTeam);
        btnTeam.setSize(50,50);
        btnTeam.setLayoutData(new GridData(GridData.BEGINNING));
       
        // add Event Handler
	    btnStart.addListener(SWT.Selection, this.frontController);
	    btnUser.addListener(SWT.Selection, this.frontController);
	    btnProject.addListener(SWT.Selection, this.frontController);
	    btnTicket.addListener(SWT.Selection, this.frontController);
	    btnTeam.addListener(SWT.Selection, this.frontController);

	}
	public Composite getComposite(){
		return menu;
	}

}
