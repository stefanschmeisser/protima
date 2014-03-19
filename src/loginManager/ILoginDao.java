package loginManager;

public interface ILoginDao {
	public String[] getAccess(String user, String password);
	public void getUserData();
}
