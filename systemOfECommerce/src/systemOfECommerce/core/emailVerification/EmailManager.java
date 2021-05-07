package systemOfECommerce.core.emailVerification;

public class EmailManager implements EmailService {

	@Override
	public void sendVerificationMail(String email) {
		System.out.println(email + " e-mail adresine do�rulama postas� g�nderildi");
	}

	@Override
	public boolean isVerified(String option) {
		if (option.equals("DO�RULA")) {
			System.out.println("E-mail adresiniz do�ruland�.");
			return true;
		}
		System.out.println("E-mail adresiniz do�rulanamad�!");
		return false;
	}

}
