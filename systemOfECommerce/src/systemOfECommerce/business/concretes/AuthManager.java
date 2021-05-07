package systemOfECommerce.business.concretes;

import java.util.Scanner;
import java.util.regex.Pattern;

import systemOfECommerce.business.abstracts.AuthService;
import systemOfECommerce.business.abstracts.UserService;
import systemOfECommerce.core.adapters.AuthServiceAdapter;
import systemOfECommerce.core.emailVerification.EmailService;
import systemOfECommerce.entities.concretes.User;

public class AuthManager implements AuthService {
	private UserService userService;
	private AuthServiceAdapter authServiceAdapter;
	private EmailService emailService;

	public AuthManager(UserService userService, AuthServiceAdapter authServiceAdapter, EmailService emailService) {
		this.userService = userService;
		this.authServiceAdapter = authServiceAdapter;
		this.emailService = emailService;
	}

	@Override
	public void register(int id, String firstName, String lastName, String email, String password) {
		User registerUser = new User(id, firstName, lastName, email, password);

		if (!fillAllInformation(registerUser.getFirstName(), registerUser.getLastName(), registerUser.getEmail(),
				registerUser.getPassword())) {
			return;
		}
		if (!nameLengthValid(registerUser.getFirstName(), registerUser.getLastName())) {
			return;
		} else if (!checkEmailFormat(registerUser.getEmail())) {
			return;
		} else if (!exsistEmail(registerUser.getEmail())) {
			return;
		} else if (!passwordLengthValid(registerUser.getPassword())) {
			return;
		} else {
			this.emailService.sendVerificationMail(registerUser.getEmail());

			Scanner scanner = new Scanner(System.in);
			System.out.println("E-mail adresinizi 'DO�RULA' yazarak do�rulayabilirsiniz.");
			String option = scanner.nextLine();

			if (this.emailService.isVerified(option)) {
				this.userService.add(registerUser);
			} else {
				System.out.println("Kay�t i�lemi ba�ar�s�z!");
			}
		}
	}

	@Override
	public void login(String email, String password) {
		User loginUser = userService.getUserByEmail(email);
		if (loginUser == null) {
			System.out.println("Kullan�c�  bulunamad�!");
		} else if (loginUser.getEmail() == email && loginUser.getPassword() == password) {
			System.out.println(
					"Sisteme ba�ar�yla giri� yap�ld�: " + loginUser.getFirstName() + " " + loginUser.getLastName());
		} else if (loginUser.getEmail() != email) {
			System.out.println("E-mail hatal�!");
		} else {
			System.out.println("�ifre hatal�!");
		}
	}

	@Override
	public void loginWithGoogle(String email) {
		authServiceAdapter.login(email);

	}

	public boolean nameLengthValid(String firstName, String lastName) {
		if (firstName.length() >= 2 && lastName.length() >= 2) {
			return true;
		}
		System.out.println("Ad ve soyad�n�z en az 2 karakter olmal�");
		return false;
	}

	public boolean checkEmailFormat(String email) {
		String regex = "^[A-Za-z0-9+_.-]+@(.+)$";
		Pattern pattern = Pattern.compile(regex);

		if (pattern.matcher(email).matches()) {
			return true;
		}
		System.out.println("Mail adresi ge�ersiz!");
		return false;
	}

	public boolean exsistEmail(String mail) {
		if (userService.getUserByEmail(mail) == null) {
			return true;
		}
		System.out.println("Bu mail adresi daha �nce kullan�lm��!");
		return false;
	}

	public boolean passwordLengthValid(String password) {
		if (password.length() >= 6) {
			return true;
		}
		System.out.println("�ifreniz en az 6 karakter olmal�d�r.");
		return false;
	}

	public boolean fillAllInformation(String firstName, String lastName, String email, String password) {
		if (firstName.length() > 0 && lastName.length() > 0 && email.length() > 0 && password.length() > 0) {
			return true;
		}
		System.out.println("T�m alanlar doldurulmal�d�r!");
		return false;
	}

}
