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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import kr.co.assemble.dao.MI_interface;
import kr.co.assemble.dto.IdCheckDTO;
import kr.co.assemble.dto.MemberInfoDTO;
import kr.co.assemble.dto.testDTO;
import kr.co.assemble.service.SendMail;
import kr.co.assemble.service.SendMailService;

// AssembleInfo_controller

@Controller
public class AI_controller {
	
	@Autowired
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
	private final String MEMSIGNUP = "mem_signup";
	
	public void setDao(MI_interface dao) {
		this.dao = dao;
	}
	
	
	@RequestMapping(value = "/main", method = { RequestMethod.GET, RequestMethod.POST })
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
		String mi_name = dao.selectAssembleName(dto.getMi_assemblename());
		
		System.out.println(mi_name);
		if(mi_name == null) {
			return ASSEMBLELOGIN;
		}
		HttpSession session = req.getSession(true);
		
		session.setAttribute("mi_assemblename", mi_name);
		
		return LOGIN;
	}
	
	@RequestMapping(value = "/loginOk")
	public String mainPage(@ModelAttribute IdCheckDTO dto1, HttpSession session) {
		String mi_assembleName = (String) session.getAttribute("mi_assemblename");
//		System.out.println(mi_assembleName);
		dto1.setMi_assemblename(mi_assembleName);
		
//		System.out.println("loginOK : "+mi_assembleName);
		IdCheckDTO check = dao.selectId(dto1);
		boolean passMatch = passEncoder.matches(dto1.getMi_mempw(), check.getMi_mempw());
		
		int mi_memNo = check.getMi_memberno();
//		System.out.println(check.getMi_memberNo());
//		session.setAttribute("mi_memberNo", mi_memNo);
		session.setAttribute("memberno", mi_memNo);
		session.setAttribute("mi_memname", check.getMi_memname());
		if(check.getMi_memid() != null && passMatch) {
			session.setAttribute("mi_memid", check.getMi_memid());
			
		}else {
			session.setAttribute("mi_memid", null);
			return ASSEMBLELOGIN;
		}
		
		return LOGINOK;
	}
	

	@RequestMapping(value="/invited")
	public ModelAndView invited() {
		ModelAndView mv = new ModelAndView();
		int ran = new Random().nextInt(9000000)+1000000;
//		String strRan = Integer.toString(ran);
//		String encodeRan = passEncoder.encode(strRan);
//		System.out.println(encodeRan);
		System.out.println("invited ran : " + ran);
		mv.setViewName(INVITED);
		mv.addObject("ran", ran);
		return mv;
	}
	
	@RequestMapping(value="/invitedOk")
	public String invitedOk(@RequestParam String invited, @RequestParam String ran, HttpServletRequest req, HttpSession session) {
		String memid = (String) session.getAttribute("mi_memid");
		String mi_assembleName = (String) session.getAttribute("mi_assemblename");
		SendMailService sms = new SendMailService();
		System.out.println("invitedOk ran : " + ran);
		String encodeRan = sms.encodeInit(ran);
//		String encodeRan = passEncoder.encode(ran);
		session.setAttribute("ran", encodeRan);
		String sendEmail = "tlsgks8668@gmail.com";
		session.setAttribute("mi_mememail", invited);
//		String receiveEmail = req.getParameter("mi_memEmail");
		String title = "[Assemble]"+ memid +"님이 "+ mi_assembleName + " 어셈블에 초대하셨습니다.";
		String contents = "<h1>" + mi_assembleName + "</h1>\r\n" +
				"<h1> 어셈블에 초대되셨습니다. </h1>" +
				"<h3>[Assemble]"+ memid +"님이 "+ mi_assembleName +" 어셈블에 초대하셨습니다.</h>\r\n" +
				"	<h3>초대 링크를 보시려면 <a href=\"http://localhost:9090/invitedemail\">여기</a>를 눌러주세요!</h3>\r\n" + 
				"	<hr />\r\n" + 
				"	<div class=\"form-group\">\r\n" + 
				"		<p>본 메일은 발신 전용이며, 문의에 대한 회신은 처리되지 않습니다.</p>\r\n" + 
				"	</div>";
		
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
	
	@RequestMapping(value="/assemble.io/{mi_assemblename}/login/{ran}/a", method = { RequestMethod.GET, RequestMethod.POST })
	public String memLogin(
			@PathVariable("mi_assemblename") String assembleName,
			@PathVariable("ran") String ran) {
		System.out.println(ran);
		
		return MEMSIGNUP;
		
	}
	
	@RequestMapping(value="/find_assemble")
	public String find_assemble() {
		
		return FIND;
	}
	
	@RequestMapping(value="/send_findassemble")
	public String find_email(@RequestParam String mi_mememail, HttpSession session) {
		session.setAttribute("mi_mememail", mi_mememail);
//		System.out.println(list);
		String sendEmail = "tlsgks8668@gmail.com";
		String title = "[Assemble] 참여 중인 어셈블 목록";
		String contents = "<h1>참여 중인 어셈블 목록</h1>\r\n" + 
				"	<h3>계정으로  참여 중인 어셈블 목록을 보시려면 <a href=\"http://localhost:9090/findemail\">여기</a>를 눌러주세요!</h3>\r\n" + 
				"	<hr />\r\n" + 
				"	<div class=\"form-group\">\r\n" + 
				"		<p>본 메일은 발신 전용이며, 문의에 대한 회신은 처리되지 않습니다.</p>\r\n" + 
				"	</div>";
		MimeMessage message = mailSender.createMimeMessage();
		MimeMessageHelper msghelper;
		try {
			msghelper = new MimeMessageHelper(message, true, "UTF-8");
			// MimeMessageHelper에 set하기 위함
			msghelper.setFrom(sendEmail);		// 보내는 사람 이메일
			msghelper.setTo(mi_mememail);		// 받는 사람 이메일
			msghelper.setSubject(title);		// 제목
			msghelper.setText(contents, true);		// 내용
			
			mailSender.send(message);
			
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "main";
	}

	@RequestMapping(value="/terms")
	public String terms() {
		return TERMS;
	}
	
	

	
}
