package systemOfECommerce.core.adapters;

import systemOfECommerce.googleAuth.GoogleAuthManager;

public class GoogleAuthManagerAdapter implements AuthServiceAdapter {
	
	@Override
	public void login(String email) {
		GoogleAuthManager googleAuthManager = new GoogleAuthManager();
		googleAuthManager.login(email);
	}
}
