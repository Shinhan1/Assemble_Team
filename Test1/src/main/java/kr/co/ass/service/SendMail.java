package kr.co.ass.service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class SendMail {
	
	@Autowired
	private JavaMailSender mailSender;
	
	public boolean sendEmail(String sendEmail, String receiveEmail, String title, String contents, int ran) {
		
		try {
			MimeMessage message = mailSender.createMimeMessage();
			MimeMessageHelper msghelper = new MimeMessageHelper(message, true, "UTF-8");
			
			// MimeMessageHelper에 set하기 위함
			msghelper.setFrom(sendEmail);		// 보내는 사람 이메일
			msghelper.setTo(receiveEmail);		// 받는 사람 이메일
			msghelper.setSubject(title);		// 제목
			msghelper.setText(contents);		// 내용
			
			mailSender.send(message);
			
			return true;
			
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
}
