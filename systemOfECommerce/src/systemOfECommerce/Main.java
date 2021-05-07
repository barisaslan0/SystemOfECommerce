package systemOfECommerce;

import systemOfECommerce.business.abstracts.AuthService;
import systemOfECommerce.business.concretes.AuthManager;
import systemOfECommerce.business.concretes.UserManager;
import systemOfECommerce.core.adapters.GoogleAuthManagerAdapter;
import systemOfECommerce.core.emailVerification.EmailManager;
import systemOfECommerce.dataAccess.concretes.InMemoryUserDao;
import systemOfECommerce.entities.concretes.User;

public class Main {

	public static void main(String[] args) {
		AuthService authService = new AuthManager(new UserManager(new InMemoryUserDao()),
				new GoogleAuthManagerAdapter(), new EmailManager());

		System.out.println("---------- E-T�CARET S�STEM� ----------\n");

		System.out.println("---- Google Hesab�yla Giri� Yapma -----");
		String googleAccount = "baris_aslan100@gmail.com";
		authService.loginWithGoogle(googleAccount);

		System.out.println("\n---- Sisteme Kay�t Olma -----");
		authService.register(1, "Bar��", "Aslan", "baris@baris.com", "123456789");

		System.out.println("\n---- Sisteme Giri� Yapma -----");
		authService.login("baris@baris.com", "123456789");
	}
}
