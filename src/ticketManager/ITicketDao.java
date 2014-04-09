package ticketManager;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Vector;

import org.eclipse.swt.widgets.*;

public interface ITicketDao {

	public ResultSet select(String column, String table, String condition);
	public TicketTableModel selectTableModel(String column, String table, String condition);
	public void insertTicket(ArrayList<String> values) ;
}
