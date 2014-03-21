package loginManager;

public interface ILoginDao {
	public String[] getAccess(String user, String password);
	public String[] getUserData(String[] userPredata);
}
