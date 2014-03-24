package ticketManager;

import org.eclipse.swt.widgets.DateTime;




public class Ticket {
	
	private int ticketId;
	private String ticketTitle;
	private String ticketDesc;
	private DateTime ticketStartDate;
	private DateTime ticketEndDate;
	private enum ticketPriorityLevel { INTIME, URGENT, CRITICAL}
	private enum notifyStatus {}
	private enum ticketProcessStatus {}
	private int currentEditorUID;
	private int assignedTeamID;
	
}
/*
public class TicketBuilder{
	
}*/
