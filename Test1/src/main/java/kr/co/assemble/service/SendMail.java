package kr.co.assemble.service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class SendMail implements SM_interface {
	
	@Autowired
	private JavaMailSender mailSender;
	
	
	public void setMailSender(JavaMailSender mailSender) {
		this.mailSender = mailSender;
	}

	@Override
	public void sendEmail(String sendEmail, String receiveEmail, String title, String contents, int ran) {
//		System.out.println(sendEmail);
//		System.out.println(receiveEmail);
//		System.out.println(title);
//		System.out.println(contents);
//		System.out.println(ran);
		System.out.println(mailSender);
		System.out.println("mimeMessge 전");
		MimeMessage message = mailSender.createMimeMessage();
		System.out.println(message);
		System.out.println("mimeMessage 후");
		
		try {
			
			MimeMessageHelper msghelper = new MimeMessageHelper(message, true, "UTF-8");
			// MimeMessageHelper에 set하기 위함
			msghelper.setFrom(sendEmail);		// 보내는 사람 이메일
			msghelper.setTo(receiveEmail);		// 받는 사람 이메일
			msghelper.setSubject(title);		// 제목
			msghelper.setText(contents);		// 내용
			
			mailSender.send(message);
			
//			return true;
			
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		return false;
	}
}
