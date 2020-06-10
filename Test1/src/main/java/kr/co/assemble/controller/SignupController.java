package kr.co.assemble.controller;

import java.util.Random;

import javax.inject.Inject;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import kr.co.assemble.dao.MI_interface;
import kr.co.assemble.dto.MemberInfoDTO;
import kr.co.assemble.service.SendMail;
import kr.co.assemble.service.SendMailService;

@Controller
public class SignupController {
	
	@Inject
	MI_interface dao;
	
	@Autowired
	private JavaMailSender mailSender;
	
	@Autowired
	BCryptPasswordEncoder passEncoder;
	
	private final String SIGNUP = "admin_signup";
	private final String MAIN = "main";
	private final String RE = "redirect:/";
	
	
	@RequestMapping(value = "/signup")
	public ModelAndView signup() {
		ModelAndView mv = new ModelAndView();
		int ran = new Random().nextInt(900000)+100000;
		mv.setViewName(SIGNUP);
		mv.addObject("ran", ran);
		return mv;
	}
	
	
	@RequestMapping(value = "/signupOk")
	public String signupOk(@ModelAttribute MemberInfoDTO dto) {
		String password = dto.getMi_memPw();
		String Pw = passEncoder.encode(password);
		dto.setMi_memPw(Pw);
		
		dao.insertOne(dto);
		
		return RE+MAIN;
	}
	
	@RequestMapping(value = "/sendMail")
	@ResponseBody
	public void sendMail(@RequestParam String mi_memEmail, @RequestParam int ran, HttpServletRequest req) {
		SendMailService sms = new SendMailService();
		SendMail sm = new SendMail();
		int ranNum = sms.init();
//		String aiName = req.getParameter("mi_assembleName");
		HttpSession session = req.getSession(true);
		String authCode = String.valueOf(ranNum);
		session.setAttribute("authCode", authCode);
		session.setAttribute("ran", ran);
		
		String sendEmail = "tlsgks8668@gmail.com";
//		String receiveEmail = req.getParameter("mi_memEmail");
		String title = "Assemble 인증 코드입니다.";
		String contents = "<div class=\"container\">\r\n" + 
				"	<div class=\"row\">\r\n" + 
				"		<div class=\"col-sm-10 col-md-8 col-lg-6 mx-auto\">\r\n" + 
				"			<div class=\"card card-signin my-5\">\r\n" + 
				"				<div class=\"card-body\">\r\n" + 
				"					<div class=\"form\">\r\n" + 
				"					\r\n" + 
				"						<div class=\"form-group\">\r\n" + 
				"							<img src=\"/resources/info/images/assemble.png\" alt=\"assemble\" />\r\n" + 
				"						</div>\r\n" + 
				"						\r\n" + 
				"						<div class=\"form-group\">\r\n" + 
				"							<h1 class=\"card-title\">이메일 인증코드</h1>\r\n" + 
				"							<p>어셈블에 가입하신것을 환영합니다. 아래의 인증코드를 입력하시면 가입이 정상적으로 완료됩니다.</p>\r\n" + 
				"						</div>\r\n" + 
				"						\r\n" + 
				"						<div class=\"form-group\">						\r\n" + 
											ranNum	+
//				"							<input type=\"text\" name=\"\" class=\"form-control\" id=\"code\" value=\"인증코드\" readonly/>\r\n" + 
				"						</div>\r\n" + 
				"						\r\n" + 
				"						<hr />\r\n" + 
				"						<div class=\"form-group\">\r\n" + 
				"							<p>본 메일은 발신 전용이며, 문의에 대한 회신은 처리되지 않습니다.</p>\r\n" + 
				"						</div>\r\n" + 
				"					</div>\r\n" + 
				"					\r\n" + 
				"				</div>\r\n" + 
				"			</div>\r\n" + 
				"			\r\n" + 
				"		</div>\r\n" + 
				"	</div>\r\n" + 
				"</div>";
		
//		System.out.println(aiName);
		System.out.println(mi_memEmail);
		
		MimeMessage message = mailSender.createMimeMessage();
		MimeMessageHelper msghelper;
		try {
			msghelper = new MimeMessageHelper(message, true, "UTF-8");
			// MimeMessageHelper에 set하기 위함
			msghelper.setFrom(sendEmail);		// 보내는 사람 이메일
			msghelper.setTo(mi_memEmail);		// 받는 사람 이메일
			msghelper.setSubject(title);		// 제목
			msghelper.setText(contents, true);		// 내용
			
			mailSender.send(message);
			
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		sm.sendEmail(sendEmail, receiveEmail, title, contents, ranNum);
		
	}
	
	@RequestMapping(value="/emailAuth")
	@ResponseBody
	public ResponseEntity<String> emailAuth(@RequestParam String authCode, @RequestParam String ran, HttpSession session){
		String EmailCode = (String) session.getAttribute("authCode");
		String certificate = Integer.toString((Integer) session.getAttribute("ran"));
		if(EmailCode.equals(authCode) && certificate.equals(ran))
		return new ResponseEntity<String>("complete", HttpStatus.OK);
		else return new ResponseEntity<String>("false", HttpStatus.OK);
	}
}
