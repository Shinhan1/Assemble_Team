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
	

	// 이메일 난수 만드는 메소드
	public int init() {
		Random ran = new Random();
		StringBuffer sb = new StringBuffer();
		int num = 0;

		num = ran.nextInt(900000)+100000;
		
		return num;
	}
	
	// 난수 암호화하기 encoding X
	public String encodeInit(String ran) {
		int length = ran.length()*4;
		Random r = new Random();
//		int num1 = r.nextInt(26)+65;
//		int num2 = r.nextInt(26)+97;
//		int num3 = r.nextInt(10)+48;
		String encode = "";
		char ch;
		for(int i = 0; i < length; i++) {
			int num[] = {r.nextInt(26)+65, r.nextInt(26)+97, r.nextInt(10)+48};
			int n = r.nextInt(3);
			ch = (char) num[n];
			encode += ch;
		}
		System.out.println(encode);
		
		return encode;
	}


	
}
