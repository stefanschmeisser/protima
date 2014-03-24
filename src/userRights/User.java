package userRights;

//FIXME: abstract Class macht Sinn an der Stelle, wie im Klassendiagramm darstellen?!
public class User {
	
	private int id;
	private String name;
	//FIXME: muss unter Umständen angepasst werden
	private Object[] teams;
	//FIXME: not sure how to roll that bitch
	private enum accesslevel {
		EDITOR, TEAMLEADER, PROJECTMANAGER
	}

	public User() {
		//TODO: implementieren
	}
	
	public User(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	//FIXME: wenn teams nen ObjectArray is.. warum gibts dann hier ne ID und kein Objekt?
	public void addUserToTeam(int teamId) {
		//TODO: implementieren
	}
	
	//FIXME: Rückgabewert?
	public void removeUserFromTeam(int teamId) {
		//TODO: implementieren
	}
	
	public int[] getTeamMemberships() {
		//TODO: implementieren
		return new int[0];
	}
	
	public int[] getProjectMemberships() {
		//TODO: implementieren
		return new int[0];
	}
}
