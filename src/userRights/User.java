package userRights;

public abstract class User {
	
	private int id;
	private String name;
	//FIXME: muss unter Umständen angepasst werden
	private Object[] teams;
	//FIXME: not sure how to roll that bitch
	private enum accesslevel {
		EDITOR, TEAMLEADER, PROJECTMANAGER
	}

	protected User(int id, String name) {
		this.id = id;
		this.name = name;
		//TODO: implementieren
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
	
	public int getUserID(){
		return this.id;
	}
}
