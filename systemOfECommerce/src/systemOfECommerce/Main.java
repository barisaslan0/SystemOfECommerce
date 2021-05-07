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

		System.out.println("---------- E-TÝCARET SÝSTEMÝ ----------\n");

		System.out.println("---- Google Hesabýyla Giriþ Yapma -----");
		String googleAccount = "baris_aslan100@gmail.com";
		authService.loginWithGoogle(googleAccount);

		System.out.println("\n---- Sisteme Kayýt Olma -----");
		authService.register(1, "Barýþ", "Aslan", "baris@baris.com", "123456789");

		System.out.println("\n---- Sisteme Giriþ Yapma -----");
		authService.login("baris@baris.com", "123456789");
	}
}
