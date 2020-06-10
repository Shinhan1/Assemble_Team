package kr.co.assemble.controller;

import java.util.List;
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
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import kr.co.assemble.dao.MI_interface;
import kr.co.assemble.dto.IdCheckDTO;
import kr.co.assemble.dto.MemberInfoDTO;
import kr.co.assemble.service.SendMail;
import kr.co.assemble.service.SendMailService;

// AssembleInfo_controller

@Controller
public class AI_controller {
	
	@Inject
	MI_interface dao;
	
	@Autowired
	private JavaMailSender mailSender; 
	
	@Autowired
	BCryptPasswordEncoder passEncoder;
	
	private final String MAIN = "main";
//	private final String SIGNUP = "admin_signup";
	private final String ASSEMBLELOGIN = "assembleLogin";
//	private final String RE = "redirect:/";
	private final String LOGIN = "login";
	private final String LOGINOK = "loginOk";
	private final String INVITED = "invited";
	private final String INVITEDOK = "invitedOk";
	private final String FIND = "find_assemble";
	private final String TERMS = "terms";
	
	public void setDao(MI_interface dao) {
		this.dao = dao;
	}
	
	
	@RequestMapping(value = "/main")
	public String list(Model model) {
		List<MemberInfoDTO> list = dao.selectAll();
		
		model.addAttribute("list", list);
//		System.out.println(list);
//		System.out.println(list.get(0));
		
		return MAIN;
	}
	
	@RequestMapping(value = "/assembleLogin")
	public String assembleLogin() {
		
		return ASSEMBLELOGIN;
	}
	
	@RequestMapping(value = "/login")
	public String login(@ModelAttribute MemberInfoDTO dto, HttpServletRequest req) {
		String mi_name = dao.selectAssembleName(dto.getMi_assembleName());
		int mi_memNo = dto.getMi_memberNo();

//		System.out.println(mi_name);
//		System.out.println(dto.getMi_assembleName());
		if(mi_name == null) {
			return ASSEMBLELOGIN;
		}
		HttpSession session = req.getSession(true);
		
		session.setAttribute("mi_assembleName", mi_name);
		
		return LOGIN;
	}
	
	@RequestMapping(value = "/loginOk")
	public String mainPage(@ModelAttribute IdCheckDTO dto1, HttpSession session) {
		String mi_assembleName = (String) session.getAttribute("mi_assembleName");
//		System.out.println(mi_assembleName);
		dto1.setmi_assembleName(mi_assembleName);
		
		
		IdCheckDTO check = dao.selectId(dto1);
		boolean passMatch = passEncoder.matches(dto1.getmi_memPw(), check.getmi_memPw());
		
		int mi_memNo = check.getMi_memberNo();
//		System.out.println(check.getMi_memberNo());
//		session.setAttribute("mi_memberNo", mi_memNo);
		session.setAttribute("memberno", mi_memNo);
		session.setAttribute("mi_memName", check.getMi_memName());
		if(check.getmi_memID() != null && passMatch) {
			session.setAttribute("mi_memID", check.getmi_memID());
			
		}else {
			session.setAttribute("mi_memID", null);
			return ASSEMBLELOGIN;
		}
		
		
//		System.out.println(dto1.getmi_memID());
//		System.out.println(dto1.getmi_memPw());
//		System.out.println(dto1.getmi_assembleName());
		
//		if(memID == null && memPw == null) {
//			return ASSEMBLELOGIN;
//		}
		
		return LOGINOK;
	}
	
//	@RequestMapping(value = "/signup")
//	public ModelAndView signup() {
//		ModelAndView mv = new ModelAndView();
//		int ran = new Random().nextInt(900000)+100000;
//		mv.setViewName(SIGNUP);
//		mv.addObject("ran", ran);
//		return mv;
//	}
//	
//	
//	@RequestMapping(value = "/signupOk")
//	public String signupOk(@ModelAttribute MemberInfoDTO dto) {
//		String password = dto.getMi_memPw();
//		String Pw = passEncoder.encode(password);
//		dto.setMi_memPw(Pw);
//		
//		dao.insertOne(dto);
//		
//		return RE+MAIN;
//	}
//	
//	@RequestMapping(value = "/sendMail")
//	@ResponseBody
//	public void sendMail(@RequestParam String mi_memEmail, @RequestParam int ran, HttpServletRequest req) {
//		SendMailService sms = new SendMailService();
//		SendMail sm = new SendMail();
//		int ranNum = sms.init();
////		String aiName = req.getParameter("mi_assembleName");
//		HttpSession session = req.getSession(true);
//		String authCode = String.valueOf(ranNum);
//		session.setAttribute("authCode", authCode);
//		session.setAttribute("ran", ran);
//		
//		String sendEmail = "tlsgks8668@gmail.com";
////		String receiveEmail = req.getParameter("mi_memEmail");
//		String title = "Assemble 인증 코드입니다.";
//		String contents = "<div class=\"container\">\r\n" + 
//				"	<div class=\"row\">\r\n" + 
//				"		<div class=\"col-sm-10 col-md-8 col-lg-6 mx-auto\">\r\n" + 
//				"			<div class=\"card card-signin my-5\">\r\n" + 
//				"				<div class=\"card-body\">\r\n" + 
//				"					<div class=\"form\">\r\n" + 
//				"					\r\n" + 
//				"						<div class=\"form-group\">\r\n" + 
//				"							<img src=\"/resources/info/images/assemble.png\" alt=\"assemble\" />\r\n" + 
//				"						</div>\r\n" + 
//				"						\r\n" + 
//				"						<div class=\"form-group\">\r\n" + 
//				"							<h1 class=\"card-title\">이메일 인증코드</h1>\r\n" + 
//				"							<p>어셈블에 가입하신것을 환영합니다. 아래의 인증코드를 입력하시면 가입이 정상적으로 완료됩니다.</p>\r\n" + 
//				"						</div>\r\n" + 
//				"						\r\n" + 
//				"						<div class=\"form-group\">						\r\n" + 
//											ranNum	+
////				"							<input type=\"text\" name=\"\" class=\"form-control\" id=\"code\" value=\"인증코드\" readonly/>\r\n" + 
//				"						</div>\r\n" + 
//				"						\r\n" + 
//				"						<hr />\r\n" + 
//				"						<div class=\"form-group\">\r\n" + 
//				"							<p>본 메일은 발신 전용이며, 문의에 대한 회신은 처리되지 않습니다.</p>\r\n" + 
//				"						</div>\r\n" + 
//				"					</div>\r\n" + 
//				"					\r\n" + 
//				"				</div>\r\n" + 
//				"			</div>\r\n" + 
//				"			\r\n" + 
//				"		</div>\r\n" + 
//				"	</div>\r\n" + 
//				"</div>";
//		
////		System.out.println(aiName);
//		System.out.println(mi_memEmail);
//		
//		MimeMessage message = mailSender.createMimeMessage();
//		MimeMessageHelper msghelper;
//		try {
//			msghelper = new MimeMessageHelper(message, true, "UTF-8");
//			// MimeMessageHelper에 set하기 위함
//			msghelper.setFrom(sendEmail);		// 보내는 사람 이메일
//			msghelper.setTo(mi_memEmail);		// 받는 사람 이메일
//			msghelper.setSubject(title);		// 제목
//			msghelper.setText(contents, true);		// 내용
//			
//			mailSender.send(message);
//			
//		} catch (MessagingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
////		sm.sendEmail(sendEmail, receiveEmail, title, contents, ranNum);
//		
//	}
//	
//	@RequestMapping(value="/emailAuth")
//	@ResponseBody
//	public ResponseEntity<String> emailAuth(@RequestParam String authCode, @RequestParam String ran, HttpSession session){
//		String EmailCode = (String) session.getAttribute("authCode");
//		String certificate = Integer.toString((Integer) session.getAttribute("ran"));
//		if(EmailCode.equals(authCode) && certificate.equals(ran))
//		return new ResponseEntity<String>("complete", HttpStatus.OK);
//		else return new ResponseEntity<String>("false", HttpStatus.OK);
//	}
	@RequestMapping(value="/invited")
	public String invited() {
		return INVITED;
	}
	
	@RequestMapping(value="/invitedOk")
	public String invitedOk(@RequestParam String invited, HttpServletRequest req, HttpSession session) {
		
		String mi_assembleName = (String) session.getAttribute("mi_assembleName");
		String encodeAdd = passEncoder.encode(mi_assembleName);
		
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
				"							<img src=\"http://localhost:9090//resources/info/images/assemble.png\" alt=\"assemble\" />\r\n" + 
				"						</div>\r\n" + 
				"						\r\n" + 
				"						<div class=\"form-group\">\r\n" + 
				"							<h2 class=\"card-title\">Assemble Name</h2>\r\n" + 
				"							<h3>어셈블에 초대되셨습니다.</h3>\r\n" + 
				"							<p>이 초대를 수락하시려면 아래의 링크를 클릭해 어셈블 계정을 만들어주세요.</p>\r\n" + 
				"						</div>\r\n" + 
				"						\r\n" + 
				"						<div class=\"form-group\">						\r\n" + 
				"							<input type=\"text\" name=\"\" class=\"form-control\" id=\"code\" value=\"어셈블주소\" readonly/>\r\n" + 
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
		
		MimeMessage message = mailSender.createMimeMessage();
		MimeMessageHelper msghelper;
		try {
			msghelper = new MimeMessageHelper(message, true, "UTF-8");
			// MimeMessageHelper에 set하기 위함
			msghelper.setFrom(sendEmail);		// 보내는 사람 이메일
			msghelper.setTo(invited);		// 받는 사람 이메일
			msghelper.setSubject(title);		// 제목
			msghelper.setText(contents, true);		// 내용
			
			mailSender.send(message);
			
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "home";
	}
	
	@RequestMapping(value="/find_assemble")
	public String find_assemble() {
		
		return FIND;
	}
	
	@RequestMapping(value="/send_findassemble")
	public String find_email(@RequestParam String mi_memEmail) {
		List<String> AssembleName = dao.findAssembleName(mi_memEmail);
		
		String sendEmail = "tlsgks8668@gmail.com";
		String title = "Assemble 인증 코드입니다.";
		String contents ="<html>\r\n" + 
				"<link type=\"text/css\" rel=\"stylesheet\" href=\"/resources/info/css/admin_email.css\" />\r\n" + 
				"\r\n" + 
				"<link type=\"text/css\" rel=\"stylesheet\" href=\"/resources/info/css/bootstrap.min.css\" />\r\n" + 
				"<link type=\"text/css\" rel=\"stylesheet\" href=\"/resources/info/css/bootstrap.min.css\" />\r\n" + 
				"<script type=\"text/javascript\" src=\"/resources/info/js/bootstrap.bundle.min.js\"></script>\r\n" + 
				"<script type=\"text/javascript\" src=\"/resources/info/js/jquery.slim.min.js\"></script> \r\n" + 
				"<head>\r\n" + 
				"<meta charset=\"UTF-8\">\r\n" + 
				"<title>find_email</title>\r\n" + 
				"</head>\r\n" + 
				"<body>\r\n" + 
				"<div class=\"container\">\r\n" + 
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
				"							<h1 class=\"card-title\">참여 중인 어셈블 목록</h1>\r\n" + 
				"							<p> <!-- 이메일주소 --> 계정으로 참여 중인 아지트 목록입니다.</p>\r\n" + 
				"						</div>\r\n" + 
				"						\r\n" + 
				"						<!-- 어셈블 목록 -->\r\n" + 
				"						\r\n" + 
				"											\r\n" + 
				"						<div class=\"form-group\">	\r\n" + 
				"							<div class=\"form-group-row\" style=\"text-align: center\">\r\n" +
				"								<h3>"+AssembleName+"</h3>\r\n" + 
				"							</div>\r\n" + 
				"						</div>\r\n" + 
				"						\r\n" + 
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
				"</div>\r\n" + 
				"\r\n" + 
				"</body>\r\n" + 
				"</html>";
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
		return MAIN;
	}
	
	@RequestMapping(value="/terms")
	public String terms() {
		return TERMS;
	}
	
	

	
}
