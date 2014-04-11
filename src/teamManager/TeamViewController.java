package teamManager;


import java.util.ArrayList;
import java.util.Vector;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;

import ticketManager.TicketTableModel;


import teamManager.TeamCreateView;
import teamManager.TeamListView;
//import teamManager.TeamTableModel;

public class TeamViewController implements Listener {
	
	private Shell shell;
	private TeamController teamController;
	private ITeamState currentState;
	private ITeamState teamListView;
	private ITeamState teamDetailView;
	private ITeamState teamEditView;
	private ITeamState teamCreateView;
	private ArrayList<Team> teamListData;
	

	public TeamViewController(Shell shell, TeamController teamController){
		this.shell = shell;
	   	this.teamController=teamController;
    	 teamListView = new TeamListView(this, this.shell);
		 teamDetailView = new TeamDetailView(this, this.shell);
		 teamEditView = new TeamEditView(this, this.shell);
		 setCurrentView(teamListView);
	}
	
	
	public void setCurrentView(ITeamState currentState){
		if(this.currentState != null){
			this.currentState.getComposite().dispose();
		}
		if(this.currentState == this.teamListView){
			this.teamDetailView.getComposite().dispose();
		}
		this.currentState = currentState;
		this.currentState.show();
		if(this.currentState == this.teamListView){
			this.fillTableData(this.teamController.getTableListData());
			this.teamDetailView.show();
		}
		this.shell.layout();
	}
	
	
		public void fillTableData(ArrayList<Team> teamListData){
			this.teamListData = teamListData;
			if(this.teamListData != null){
				for(int i=0; i < this.teamListData.size(); i++){
					TableColumn tableColumn = new TableColumn(this.teamListView.getTable(), SWT.LEFT);
					if(i == 0) {tableColumn.setText("Team ID");}
					if(i == 1) {tableColumn.setText("TeamName");}
					if(i == 2) {tableColumn.setText("TeamLeader");}
					
				}
				for(int j=0; j < this.teamListData.size(); j++){
					System.out.println(j);
					TableItem tableItem = new TableItem(this.teamListView.getTable(), SWT.NONE);
					tableItem.setText(0, Integer.toString(teamListData.get(j).getTeamID()));
					tableItem.setText(1, teamListData.get(j).getTeamName());
					tableItem.setText(2, Integer.toString(teamListData.get(j).getTeamLeader()));
					this.teamListView.getTable().getColumn(j).pack();
				}
			}
		}
		
		public void handleEvent(Event event) {
			 
			if(event.widget == TeamListView.createButton){
				System.out.println("Create Button");
				this.teamCreateView = new TeamCreateView(this, this.shell);
				setCurrentView(this.teamCreateView);
			}
			
			if(event.widget == TeamListView.editButton){
				System.out.println("EDIT Button");
				this.teamEditView = new TeamEditView(this, this.shell);
				setCurrentView(this.teamEditView);
			}
			
			if(event.widget == TeamListView.deleteButton){
				
			}
			
			//if(event.widget == TeamCreateView.createButton){
				//System.out.println("create");
				//int teamLeader;
				//if(TeamCreateView.comboTeamLeader.getSelectionIndex() != -1){
				//	teamLeaderID = TeamCreateView.comboTeamLeader.getSelectionIndex();
			//	}else{
				//	teamLeader = 10;
				//}
				
				this.teamController.setTeam(Integer.parseInt(TeamCreateView.textTeamID.getText()),TeamCreateView.textTeamName.getText(), Integer.parseInt(TeamCreateView.textTeamLeader.getText()));
				this.teamListView = new TeamListView(this, this.shell);
				this.teamDetailView = new TeamDetailView(this, this.shell);
				setCurrentView(this.teamListView);
			
			
			if(event.widget == TeamEditView.cancelButton || event.widget == TeamCreateView.cancelButton ){
				this.teamListView = new TeamListView(this, this.shell);
				this.teamDetailView = new TeamDetailView(this, this.shell);
				setCurrentView(this.teamListView);
			}
			
			if(event.widget == teamListView.getTable()){
				System.out.println(teamListView.getTable().getSelectionIndices());
				TableItem[] selection = teamListView.getTable().getSelection();

				for(int i=0; i < this.teamListData.size(); i++){
					if(Integer.parseInt(selection[0].getText()) == this.teamListData.get(i).getTeamID()){
						
					}
				}
				
			}
			
//			if(event.widget == projectListView.getCancelButton()){
//				System.out.println("Cancel gedrückt");
//			}
			
		}
		
	}






		
		








	
	
	
		
		
		
		
		
		
		
	
	

	
	

	

	
	