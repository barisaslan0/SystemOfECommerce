package systemOfECommerce.core.emailVerification;

public interface EmailService {
	void sendVerificationMail(String email);
	boolean isVerified(String option);
}
