package ticketManager;

import java.util.ArrayList;
import java.util.Date;

public class Ticket {
	
//	private int ticketId;
	private String ticketTitle;
	private String ticketDesc;
	private String ticketStartDate;
	private String ticketEndDate;
	private String ticketPriorityLevel;
	private String ticketProjectId;
	private String ticketProcessStatus;
	private String currentEditorUID;
	private String assignedTeamID;
	
	
	private Ticket(){
		// empty
	}
	
	// -------------------------------- NESTED CLASS ------------------------------------------
	
	public static class TicketBuilder {
		
		private Ticket ticket;
		private ArrayList<String> values;
		
		
		public TicketBuilder(ArrayList<String> valuesArray){
			
			this.values = valuesArray;
			
			// create ticket
			ticket = new Ticket();
			
			// assign ticket attributes to ticket
//			ticket.ticketId = 1;
			ticket.ticketTitle = this.values.get(0).toString();
			ticket.ticketDesc = this.values.get(1).toString();
			ticket.ticketStartDate = this.values.get(2).toString();
			ticket.ticketEndDate = this.values.get(3).toString();
			ticket.ticketPriorityLevel = this.values.get(4).toString();
			ticket.ticketProjectId = this.values.get(5).toString();
			ticket.assignedTeamID = this.values.get(6).toString();
			ticket.currentEditorUID = this.values.get(7).toString();
			ticket.ticketProcessStatus = this.values.get(8).toString();
			
		}
		
		// build Ticket
		public Ticket buildTicket(){
			return this.ticket;
		}
	}
	
	// -------------------------------- NESTED CLASS END --------------------------------------
	
	// TICKET GETTERS
	
	public String getTicketTitle(){
		return this.ticketTitle;
	}
	
	public String getTicketDescription(){
		return this.ticketDesc;
	}
	
	public String getTicketStartDate(){
		return this.ticketStartDate;
	}
	
	public String getTicketEndDate(){
		return this.ticketEndDate;
	}
	
	public String getTicketPriorityLevel(){
		return this.ticketPriorityLevel;
	}
	
	public String getTicketProjectId(){
		return this.ticketProjectId;
	}
	
	public String getTicketAssignedTeam(){
		return this.assignedTeamID;
	}
	
	public String getTicketCurrentEditor(){
		return this.currentEditorUID;
	}
	
	public String getTicketProcessStatus(){
		return this.ticketProcessStatus;
	}
}


