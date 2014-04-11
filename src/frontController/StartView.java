package frontController;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;

public class StartView {

	private Composite composite, content;
	
	public StartView(Composite composite, StartViewController startViewController){
		
		this.content = composite;
		
		this.composite = new Composite(this.content, SWT.NONE);
		GridLayout layout = new GridLayout();
		layout.numColumns = 12;
	    layout.makeColumnsEqualWidth = true;
	    this.composite.setLayout(layout);
	    
	    Canvas canvas = new Canvas(this.content, SWT.NULL);
	    final Image logo = new Image(Display.getCurrent(), "content/logo.png");
	    
	    
	    
	    Label ticket = new Label(this.composite, SWT.NONE);
	    ticket.setText("Start View");
		
	}
	
}
