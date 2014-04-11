package frontController;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridData;
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
		
	    ImageData imgData = new ImageData("content/logo.png");
        Image logo = new Image(Display.getCurrent(), imgData );
        
        GridLayout layout = new GridLayout();
        layout.numColumns = 1;
        this.composite.setLayout(layout);
        
        GridData layoutData = new GridData(GridData.FILL_HORIZONTAL);
        layoutData.horizontalSpan = 1;
//        layoutData.heightHint = 400;
        this.composite.setLayoutData(layoutData);
 
        Label imgLabel = new Label(this.composite, SWT.NONE);
        imgLabel.setImage(logo);
        imgLabel.setSize( imgLabel.computeSize( SWT.DEFAULT, SWT.DEFAULT ));
		
	}
	
}
