package projectManager;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

public class ProjectCreateView implements IProjectState {

	private ProjectViewController projectViewController;
	private Shell shell;
	private Composite composite;
	public static Button createButton;
	
	public ProjectCreateView(ProjectViewController projectViewController, Shell shell){
		this.projectViewController = projectViewController;
		this.shell = shell;
		this.composite = new Composite(this.shell, SWT.NONE);
	}
	
	@Override
	public void show() {
		
		GridLayout subMenuLayout = new GridLayout();
		subMenuLayout.numColumns = 3;
		composite.setLayout(subMenuLayout);
	    
		createButton = new Button(composite, SWT.PUSH);
		Image imageCreateProject = new Image(Display.getCurrent(), "content/create.png");
        createButton.setImage(imageCreateProject);
        createButton.setLocation(0, 0);
        createButton.setLayoutData(new GridData(GridData.BEGINNING));
        
        this.shell.layout();
	}

	@Override
	public Composite getComposite(){
		return this.composite;
	}

}
