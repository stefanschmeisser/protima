package userManager;

import java.util.ArrayList;
import applicationManager.AbstractDaoMySql;

public class UserDaoMySql extends AbstractDaoMySql implements IUserDAO{
	
	private int[] userListID;
	
	@Override
	public void getUser(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String[][] getUserList() {
		// TODO Auto-generated method stub
		String userList[][] = selectMultiValues("userID, name", "user", "");
		for(int i = 0; i < userList.length; i++){
			
			for(int k = 0; k < userList[i].length; k++ ){
				
				System.out.println(userList[i][k]);
				
			}
			
		}
		return userList;
	}

	@Override
	public void getUsersByProject(String projectName) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getUsersByTeam(String teamName) {
		// TODO Auto-generated method stub
		
	}

}
