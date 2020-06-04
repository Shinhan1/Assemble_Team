package kr.co.ass.service;

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

import kr.co.ass.dao.AI_interface;
import kr.co.ass.dto.AssembleInfoDTO;


@Service
public class SendMailService {
	

	// 이메일 난수 만드는 메서드
	public int init() {
		Random ran = new Random();
		StringBuffer sb = new StringBuffer();
		int num = 0;

		num = ran.nextInt(9999);
		
		return num;
	}


//	// 회원가입 발송 이메일(인증키 발송)
//	public void mailSendWithUserKey(String e_mail, String user_id, HttpServletRequest request) {
//
//		String key = getKey(false, 20);
//		ai = sqlSession.getMapper(AI_interface.class);
//		ai.GetKey(user_id, key);
//		MimeMessage mail = mailSender.createMimeMessage();
//		String htmlStr = "<h2>안녕하세요 MS :p 민수르~ 입니다!</h2><br><br>" + "<h3>" + user_id + "님</h3>"
//				+ "<p>인증하기 버튼을 누르시면 로그인을 하실 수 있습니다 : " + "<a href='http://localhost:8080" + request.getContextPath()
//				+ "/user/key_alter?user_id=" + user_id + "&user_key=" + key + "'>인증하기</a></p>"
//				+ "(혹시 잘못 전달된 메일이라면 이 이메일을 무시하셔도 됩니다)";
//		try {
//			mail.setSubject("[본인인증] MS :p 민수르님의 인증메일입니다", "utf-8");
//			mail.setText(htmlStr, "utf-8", "html");
//			mail.addRecipient(RecipientType.TO, new InternetAddress(e_mail));
//			mailSender.send(mail);
//		} catch (MessagingException e) {
//			e.printStackTrace();
//		}
//	}
//
//	// 인증 확인 메서드 (Y 값으로 바꿔주는 메서드)
//	public int alter_userKey_service(String user_id, String key) {
//
//		int resultCnt = 0;
//
//		userDao = sqlSession.getMapper(UserDaoInterface.class);
//		resultCnt = userDao.alter_userKey(user_id, key);
//
//		return resultCnt;
//	}
	
}
