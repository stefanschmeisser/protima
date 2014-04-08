package ticketManager;

import java.util.Date;

import javax.xml.crypto.Data;

import org.eclipse.swt.widgets.*;

public class Ticket {
	
	//private enum NotifyStatus {???}
	
	private int ticketId;
	private String ticketTitle;
	private String ticketDesc;
	private Date ticketStartDate;
	private Date ticketEndDate;
	private TicketPriorityLevel ticketPriorityLevel;
	private TicketProcessStatus ticketProcessStatus;
	private int currentEditorUID;
	private int assignedTeamID;
	
	private Ticket(){
		
	}
	
	// -------------------------------- NESTED CLASS ------------------------------------------
	
	public static class TicketBuilder {
		
		private Ticket ticket;
		
		public TicketBuilder(){
			
			// create ticket
			ticket = new Ticket();
			
			// assign ticket attributes to ticket
			ticket.ticketId = 1;
			ticket.ticketTitle = "Ticket Betreff";
			ticket.ticketStartDate = new Date();
			ticket.ticketEndDate = new Date();
			ticket.ticketPriorityLevel = TicketPriorityLevel.IN_TIME;
			ticket.ticketProcessStatus = TicketProcessStatus.OPEN;
			ticket.currentEditorUID = 1;
			ticket.assignedTeamID = 1;
		}
		
		
		public Ticket buildTicket(){
			return this.ticket;
		}
	}
}


