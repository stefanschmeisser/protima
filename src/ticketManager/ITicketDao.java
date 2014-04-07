package ticketManager;

import java.sql.ResultSet;

import org.eclipse.swt.widgets.*;

public interface ITicketDao {

	public ResultSet select(String column, String table, String condition);
//	public void selectTable(String column, String table, String condition, Table outputTable);
	public TicketTableModel selectTableModel(String column, String table, String condition);
}
