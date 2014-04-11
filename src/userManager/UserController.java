package userManager;

import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import frontController.FrontController;
import frontController.IContentState;
import userRights.User;

import java.util.ArrayList;
import java.util.List;

public class UserController implements IContentState {
	
	private IUserDAO userDAO;
	private UserViewController uvc;
	private Composite composite;
	private User user; 
	private String[][] userIDs;
	private Shell shell;
	private FrontController parent;

	public UserController(Composite parentComposite){
		this.composite = parentComposite;
		this.userDAO = new UserDaoMySql();
		this.uvc = new UserViewController(parentComposite, this);
	}
	
//	@Override
	public void setCurrentView(IContentState pCurrentState) {
		System.out.println("setcompo");
		this.composite.layout();
	}

//	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}
/*
//	@Override
	public void setComposite(Composite composite) {
		this.composite = composite;
//		Color blue = new Color (Display.getCurrent(), 0, 200, 255);
//		this.composite.setBackground(blue);
		//parent.setBlankComposite(composite);
	}
*/
//	@Override
	public Composite getComposite() {
		// TODO Auto-generated method stub
		//System.out.println("habs geholt");
		return uvc.getComposite();
	}
	
	public String[][] getAllUsers(){
		userIDs = userDAO.getUserList();
		return userIDs;
	}
	
	
	

}
