package userManager;

import userRights.User;



public interface IUserDAO {
	//void
	public void getUser(int id);
	
	public String[][] getUserList();
	
	public void getUsersByProject(String projectName);
	
	public void getUsersByTeam(String teamName);
	
	

}
