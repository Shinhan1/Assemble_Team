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
	
	private final String LIST = "ai_list";
	private final String SIGNUP = "signup";
	private final String LOGIN = "login";
	private final String RE = "redirect:/";
	private final String ASSEMBLELOGIN = "assembleLogin";
	private final String MAIN = "main";
	private final String INVITE = "invite";
	private final String INVITEOK = "inviteOk";
	
	public void setDao(MI_interface dao) {
		this.dao = dao;
	}
	
	
	@RequestMapping(value = "/ai")
	public String list(Model model) {
		List<MemberInfoDTO> list = dao.selectAll();
		
		model.addAttribute("list", list);
//		System.out.println(list);
//		System.out.println(list.get(0));
		
		return LIST;
	}
	
	@RequestMapping(value = "/login")
	public String login() {
		
		return LOGIN;
	}
	
	@RequestMapping(value = "/assembleLogin")
	public String assembleLogin(@ModelAttribute MemberInfoDTO dto, HttpServletRequest req) {
		String mi_name = dao.selectAssembleName(dto.getMi_assembleName());
		int mi_memNo = dto.getMi_memberNo();

//		System.out.println(mi_name);
//		System.out.println(dto.getMi_assembleName());
		if(mi_name == null) {
			return LOGIN;
		}
		HttpSession session = req.getSession(true);
		
		session.setAttribute("mi_assembleName", mi_name);
		
		return ASSEMBLELOGIN;
	}
	
	@RequestMapping(value = "/main")
	public String mainPage(@ModelAttribute IdCheckDTO dto1, HttpSession session) {
		String mi_assembleName = (String) session.getAttribute("mi_assembleName");
//		System.out.println(mi_assembleName);
		dto1.setmi_assembleName(mi_assembleName);
		
		
		IdCheckDTO check = dao.selectId(dto1);
		boolean passMatch = passEncoder.matches(dto1.getmi_memPw(), check.getmi_memPw());
		
		int mi_memNo = check.getMi_memberNo();
//		System.out.println(check.getMi_memberNo());
		session.setAttribute("mi_memberNo", mi_memNo);
		
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
		
		return MAIN;
	}
	
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
		
		return RE+"ai";
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
	@RequestMapping(value="/invite")
	public String invite() {
		return INVITE;
	}
	
	@RequestMapping(value="/inviteOk")
	public String invite(@RequestParam String invite, HttpServletRequest req, HttpSession session) {
		
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
			msghelper.setTo(invite);		// 받는 사람 이메일
			msghelper.setSubject(title);		// 제목
			msghelper.setText(contents, true);		// 내용
			
			mailSender.send(message);
			
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return INVITEOK;
	}
	
	

	
}
