package in.authenticationSystem.Authify.Service;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmailService {
	
	private final JavaMailSender mailSender;
	
	
	private String fromEmail = "devathisanthosh67@gmail.com";
	
	public void sendWelcomeEmail(String toEmail,String name) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom(fromEmail);
		message.setTo(toEmail);
		message.setSubject("Welcome to our Platform");
		message.setText("Hello " + name + ", \n\nThanks for registering with us!\n\nRegards,\nAuthify Team");
		mailSender.send(message);
	}
	
	public void sendResetOtpEmail(String toEmail,String otp) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom(fromEmail);
		message.setTo(toEmail);
		message.setSubject("Password reset OTP");
		message.setText("Your OTP for resetting your password is " + otp + ". Use it OTP to proceed with resetting your password."
				+ "It is valid for 15 minutes only.");
		mailSender.send(message);
	}
	
	public void sendOtpEmail(String toEmail,String otp) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom(fromEmail);
		message.setTo(toEmail);
		message.setSubject("Acount verification OTP");
		message.setText("Your account verification OTP is " + otp + ". Verify your account using this otp.");
		mailSender.send(message);
	}

}
