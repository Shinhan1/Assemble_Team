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
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import kr.co.assemble.dao.MI_interface;
import kr.co.assemble.dto.MemberInfoDTO;
import kr.co.assemble.dto.testDTO;
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
		String contents = "<h1>안녕하세요! Assemble입니다.</h1>\r\n" + 
				"	<h3>인증코드를 확인하시려면 <a href=\"http://localhost:9090/signupemail\">여기</a>를 눌러주세요!</h3>\r\n" + 
				"	<hr />\r\n" + 
				"	<div class=\"form-group\">\r\n" + 
				"		<p>본 메일은 발신 전용이며, 문의에 대한 회신은 처리되지 않습니다.</p>\r\n" + 
				"	</div>";
		
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
		String y = "Y";
		if(EmailCode.equals(authCode) && certificate.equals(ran)) {
			session.removeAttribute("ran");
			session.setAttribute("ran", y);
			return new ResponseEntity<String>("complete", HttpStatus.OK);
		}
		else return new ResponseEntity<String>("false", HttpStatus.OK);
	}
	
	@RequestMapping(value="/signupemail")
	public String signupemail() {
		return "admin_email";
	}
	
	@RequestMapping(value="/invitedemail")
	public String invitedemail() {
		
		
		return "mem_email";
	}
	
	@RequestMapping(value="/findemail")
	public String findemail(HttpSession session, Model model) {
		String mi_memEmail = (String) session.getAttribute("mi_memEmail");
		System.out.println(mi_memEmail);
		List<testDTO> assembleName = dao.findAssembleName(mi_memEmail);
		model.addAttribute("attendList", assembleName);
		System.out.println(assembleName);
		session.removeAttribute("mi_memEmail");
		
		return "find_email";
	}
	
	
	@RequestMapping(value="/assemble.io/{mi_assembleName}/login/membersignup")
	public String memberSignup(
			@PathVariable("mi_assembleName") String assembleName,
			@ModelAttribute MemberInfoDTO dto, HttpSession session) {
		String password = dto.getMi_memPw();
		String Pw = passEncoder.encode(password);
		dto.setMi_assembleName((String) session.getAttribute("mi_assembleName"));
		dto.setMi_memPw(Pw);
		dto.setMi_memEmail((String) session.getAttribute("mi_memEmail"));
		System.out.println(dto.getMi_memID());
		System.out.println(Pw);
		
		dao.insertMember(dto);
		
		return MAIN;
	}
	
	@RequestMapping(value="/assemble.io/{mi_assembleName}/login/{ran}/duplicateId")
	@ResponseBody
	public int duplicateId(
			@PathVariable("mi_assembleName") String assembleName,
			@PathVariable("ran") String ran,
			@ModelAttribute MemberInfoDTO dto) {
		int result = dao.duplicationId(dto);
		System.out.println(dto.getMi_memID());
		System.out.println(result);
		
		return result;
	}
	
	@RequestMapping(value="/duplicateAssembleName")
	@ResponseBody
	public int duplicateAssembleName(@ModelAttribute MemberInfoDTO dto) {
		int result = dao.duplicationAssembleName(dto.getMi_assembleName());
		
		
		return result;
	}
	
}
