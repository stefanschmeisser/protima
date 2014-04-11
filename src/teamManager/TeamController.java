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

	public void show() {
		
	}
	
	
		
		public ArrayList<Team> getTableListData(){
			return this.iTeamDAO.getTeamList();
		}
		
		
		public Team getTeam(int teamID){
			return this.iTeamDAO.getTeam(teamID);
		}
	
		
		public void setTeam(int TeamID, String teamName, int teamLeader){
			this.iTeamDAO.createTeam(TeamID, teamName,teamLeader);
		}
		
	//getAllTeams() List<int[]>
		public TeamController(Shell shell){
			this.shell = shell;
			this.iTeamDAO = new TeamDaoMySql();
			this.teamViewController = new TeamViewController(shell, this);
			
			this.selectedTeam = this.iTeamDAO.getTeam(100);
			System.out.println("Team ID: " + this.selectedTeam.getTeamID());
			System.out.println("TeamName: " + this.selectedTeam.getTeamName());
			
			teamViewController.fillTableData(this.iTeamDAO.getTeamList());
		}
		

}
	
