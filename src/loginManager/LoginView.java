package loginManager;
import org.eclipse.swt.*;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.widgets.*;

public class LoginView {
	
	// noch alles andere als schön, aber läuft schon mal
	//TODO: hoffentlich mit Layout erledigt: schöne Abstände um alles
	//TODO: Werteweitergabe an Controller
	//TODO: EventListener für die Buttons -> bei Cancel Programm beenden
	//FIXME: was hats mit response auf sich? Brauch ich das?
	
	public LoginView(LoginViewController parent, final Display disp){
		final LoginViewController papa = parent;
		//FIXME: wird das Ding eigentlich je irgendwo gebraucht/benutzt?!
		final boolean[] response = new boolean[1];
		response[0] = false;
		
//		final Display disp = new Display();
		// kann minimiert & geschlossen werden, aber nicht vergrößert/verkleinert
		Shell shell = new Shell(disp, SWT.CLOSE | SWT.TITLE | SWT.MIN);
		shell.setText("Login");
		
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
		//FIXME: debug richtiger Benutzer!
		textUser.setText("marius");
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
		//FIXME: debug falsches PW!
		textPassword.setText("marius");
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
					if (!papa.checkUserCredentials(textUser.getText(), textPassword.getText())) {
						// FIXME: wo soll das später sonst ausgegeben werden?!
						System.out.println("falsche Benutzerangaben");
						textPassword.setText("");
						return;
					}
					disp.dispose();
				}
			}
		};

		Listener buttonListener = new Listener() {
			public void handleEvent(Event event) {
				if (event.widget == btn_ok) {
					response[0] = true;
					if (!papa.checkUserCredentials(textUser.getText(), textPassword.getText())) {
						// FIXME: wo soll das später sonst ausgegeben werden?!
						System.out.println("falsche Benutzerangaben");
						textPassword.setText("");
						return;
					}
				} else {
					response[0] = false;
				}
				disp.dispose();
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
		
		parent.switchToFcState();
	}
	
}
