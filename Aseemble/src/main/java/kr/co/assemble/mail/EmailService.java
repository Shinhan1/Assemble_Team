package kr.co.assemble.mail;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import kr.co.assemble.dao.mailDAO;
import kr.co.assemble.dto.EmailDTO;

@Service
public class EmailService {
	
	@Autowired(required = true)
	private mailDAO dao;
	
	@Autowired(required = true)
	private JavaMailSender mailSender;

	public void regist(EmailDTO dto) throws Exception {
        
        System.out.println("서비스레지스");
        String key = new RandomKey().getKey(30, true);  // 인증키 생성
        dto.setRandomkey(key);
        System.out.println("key : " + key);
        
        //DB에 가입정보등록
        dao.signUp(dto);
        
        //메일 전송
        EmailHandler sendMail = new EmailHandler(mailSender);
        sendMail.setSubject("서비스 이메일 인증");
        sendMail.setText(
                new StringBuffer()
                .append("<h1>메일인증</h1>")
                .append("<a href='http://localhost:8080/email_test/emailConfirm?authKey=")
                .append(key)
                .append("' target='_blank'>이메일 인증 확인</a>")
                .toString());
        
        sendMail.setFrom("서비스ID@gmail.com", "서비스 이름");
        sendMail.setTo(dto.getReceiveEmail());
        sendMail.send();
     
    }

	//이메일 인증 키 검증
    public EmailDTO userAuth(String authkey) throws Exception {
    	EmailDTO member = new EmailDTO();
        member = dao.chkAuth(authkey);
   
        if(member!=null){
            try{
                dao.successAuthkey(member);
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
        return member;
    }



}
