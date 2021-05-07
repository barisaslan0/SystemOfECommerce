package systemOfECommerce.core.emailVerification;

public class EmailManager implements EmailService {

	@Override
	public void sendVerificationMail(String email) {
		System.out.println(email + " e-mail adresine doðrulama postasý gönderildi");
	}

	@Override
	public boolean isVerified(String option) {
		if (option.equals("DOÐRULA")) {
			System.out.println("E-mail adresiniz doðrulandý.");
			return true;
		}
		System.out.println("E-mail adresiniz doðrulanamadý!");
		return false;
	}

}
