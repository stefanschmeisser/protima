package userManager;

import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;

import frontController.IContentState;
import userRights.User;

import java.util.ArrayList;
import java.util.List;

public class UserController implements IContentState {
	
	private IUserDAO userDAO;
	private userViewController uvc;
	private Composite composite;
	private User user; 
	private int[] userIDs;
	
	public void getAllUsers(){
		userIDs = userDAO.getUserList();
	}
	

}
