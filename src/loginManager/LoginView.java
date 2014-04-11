package loginManager;
import org.eclipse.swt.*;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.widgets.*;

public class LoginView {
	
	private Shell shell;
	
	// noch alles andere als schön, aber läuft schon mal
	//TODO: hoffentlich mit Layout erledigt: schöne Abstände um alles
	//TODO: Werteweitergabe an Controller
	//TODO: EventListener für die Buttons -> bei Cancel Programm beenden
	//FIXME: was hats mit response auf sich? Brauch ich das?
	
	public LoginView(LoginViewController parent, final Display disp){
		final LoginViewController papa = parent;
		final boolean[] _isLoggedIn = new boolean[1];
		_isLoggedIn[0] = false;
		
//		final Display disp = new Display();
		// kann minimiert & geschlossen werden, aber nicht vergrößert/verkleinert
		shell = new Shell(disp, SWT.CLOSE | SWT.TITLE | SWT.MIN);
		shell.setText("Login");
		Image imageApplicationIcon = new Image(Display.getCurrent(), "content/icon.png");
        shell.setImage(imageApplicationIcon);
		
		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 3;
		shell.setLayout(gridLayout);
		
		Label label_user = new Label(shell, SWT.NONE);
		label_user.setText("User:");
		label_user.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_END));
//		label_user.setBounds(10,10,60,20);
		
		final Text textUser = new Text(shell, SWT.BORDER);
//		text1.setText("");
//		text1.setBounds(70,10,200,20);
		textUser.setTextLimit(30);
		//FIXME: debug Benutzer!
//		textUser.setText("marius");
		GridData gd1 = new GridData(GridData.FILL_HORIZONTAL);
		gd1.widthHint = 150;
		gd1.horizontalSpan = 2;
		textUser.setLayoutData(gd1);
		
		Label label_pw = new Label(shell, SWT.NONE);
		label_pw.setText("Password:");
		label_pw.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_END));
//		label_pw.setBounds(10,50,60,20);
		
		final Text textPassword = new Text(shell, SWT.NONE);
		textPassword.setEchoChar('*');
		//FIXME: debug PW!
//		textPassword.setText("marius_pw");
//		text2.setBounds(70,50,200,20);
//		text2.setText("Password");
		GridData gd2 = new GridData(GridData.FILL_HORIZONTAL);
		gd2.widthHint = 150;
		gd2.horizontalSpan = 2;
		textPassword.setLayoutData(gd2);
		
		// dont look at me...
		// um ne leere Zelle zu generieren... immerhin sinds keine Leerzeichen ;)
		new Label(shell, SWT.NONE).setText(""); 
		
		final Button btn_ok = new Button(shell, SWT.PUSH);
		btn_ok.setText("Ok");
		btn_ok.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		
		Button btn_cancel = new Button(shell, SWT.PUSH);
		btn_cancel.setText("Cancel");
		
		btn_cancel.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		
		
		
		Listener enterListener = new Listener() {
			@Override
			public void handleEvent(Event event) {
				if (event.detail == SWT.TRAVERSE_RETURN) {
//					System.out.println("Enter pressed");
//					System.out.println("Benutzer: " + textUser.getText() +"\tPassword: "+ textPassword.getText());
					if (!papa.checkUserCredentials(textUser.getText(), textPassword.getText())) {
						errorBox();
						textUser.setText("");
						textPassword.setText("");
						return;
					}
					else {
						_isLoggedIn[0] = true;
						shell.dispose();
					}
				}
				
			}
		};

		Listener buttonListener = new Listener() {
			public void handleEvent(Event event) {
				if (event.widget == btn_ok) {
//					System.out.println("Benutzer: " + textUser.getText() +"\tPassword: "+ textPassword.getText());
					if (!papa.checkUserCredentials(textUser.getText(), textPassword.getText())) {
						errorBox();
						textUser.setText("");
						textPassword.setText("");
						return;
					}
					else {
						_isLoggedIn[0] = true;
					}
				}
				shell.dispose();
			}
		};
		    
	    //FIXME: dispose() Aufruf sauber und in Ordnung?
	    
	    btn_ok.addListener(SWT.Selection, buttonListener);
	    btn_cancel.addListener(SWT.Selection, buttonListener);
	    
	    textUser.addListener(SWT.Traverse, enterListener);
	    textPassword.addListener(SWT.Traverse, enterListener);

		shell.pack();
		shell.open();
		
		while (!shell.isDisposed()) {
			if (!disp.readAndDispatch())
				disp.sleep();
		}
		shell.dispose();
		
		if (_isLoggedIn[0]) {
			parent.switchToFcState();
		}
	}
	
	private void errorBox() {
		MessageBox dialog = new MessageBox(shell, SWT.APPLICATION_MODAL | SWT.OK | SWT.ICON_ERROR);
		dialog.setText("Falsche Benutzerangaben");
		dialog.setMessage("Falsche Benutzerangaben");
		dialog.open();
	}
	
}
