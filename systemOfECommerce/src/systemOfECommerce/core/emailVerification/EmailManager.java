package systemOfECommerce.core.emailVerification;

public class EmailManager implements EmailService {

	@Override
	public void sendVerificationMail(String email) {
		System.out.println(email + " e-mail adresine doğrulama postası gönderildi");
	}

	@Override
	public boolean isVerified(String option) {
		if (option.equals("DOĞRULA")) {
			System.out.println("E-mail adresiniz doğrulandı.");
			return true;
		}
		System.out.println("E-mail adresiniz doğrulanamadı!");
		return false;
	}

}
