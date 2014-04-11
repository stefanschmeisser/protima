package teamManager;

import java.util.ArrayList;
import java.util.Vector;
import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;

import ticketManager.TicketTableModel;
import frontController.IContentState;

public class TeamController implements IContentState {
	
	private Shell shell;
	private Composite composite;
	private ITeamDAO iTeamDAO;
	private TeamViewController teamViewController;
	private Team selectedTeam;
    private ArrayList<int[]> allTeamsList;

	public TeamController(Composite composite){
		this.composite = composite;
		this.iTeamDAO = new TeamDaoMySql();
		this.teamViewController = new TeamViewController(this.composite, this);
//		teamViewController.fillTableData(this.iTeamDAO.getTeamList());
	}
    
    
	public void show() {
		
	}

	public ArrayList<Team> getTableListData(){
		return this.iTeamDAO.getTeamList();
	}
	
	
	public Team getTeam(int teamID){
		return this.iTeamDAO.getTeam(teamID);
	}
	
	public void setTeam(String teamName, int teamLeader){
		this.iTeamDAO.createTeam(teamName, teamLeader);
	}
		
}
	
