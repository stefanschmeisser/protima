package userManager;



public interface IUserDAO {
	
	public void getUser(int id);
	
	public int[] getUserList();
	
	public void getUsersByProject(String projectName);
	
	public void getUsersByTeam(String teamName);

}
