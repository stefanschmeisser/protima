package applicationManager;

import frontController.IContentState;


public interface IApplicationState {
	public void setCurrentView(IContentState currentState);
}