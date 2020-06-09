package kr.co.assemble.service;

import java.util.Random;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;
import javax.servlet.http.HttpServletRequest;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import kr.co.assemble.dao.MI_interface;
import kr.co.assemble.dto.MemberInfoDTO;


@Service
public class SendMailService {
	

	// 이메일 난수 만드는 메서드
	public int init() {
		Random ran = new Random();
		StringBuffer sb = new StringBuffer();
		int num = 0;

		num = ran.nextInt(900000)+100000;
		
		return num;
	}


	
}
