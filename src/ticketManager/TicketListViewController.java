package ticketManager;

import org.eclipse.swt.widgets.*;

public class TicketListViewController implements ITicketState, ITicketObserver {

	private TicketListView tlv;
	public Listener listener;
	
	public TicketListViewController(Shell shell){
		
		listener = new Listener() {
			public void handleEvent(Event event) {
				if (event.widget == tlv.btnStart) {
					System.out.println("Btn Start auf TicketListView (nur zum TEST)");
					//svc.setComposite(vd.getContentPanel());
					//setCurrentView(svc);
				}
			}
		};
		
		tlv = new TicketListView(shell, this.listener);
		
	}

	public void setComposite(Composite comp) {
		this.tlv.setComposite(comp);
	}

	public Composite getComposite() {
		return this.tlv.getComposite();
	}
	
	public Listener getListener() {
		return this.listener;
	}
	
}
