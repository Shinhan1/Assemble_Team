package kr.co.assemble.dao;

import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import kr.co.assemble.dto.EmailDTO;

public interface SendMail {
	public void sendEmail(EmailDTO emaildto) throws UnsupportedEncodingException, MessagingException ;
	public void send(EmailDTO emaildto);
}
