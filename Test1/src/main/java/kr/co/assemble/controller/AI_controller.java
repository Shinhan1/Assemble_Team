package kr.co.assemble.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Random;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
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
import kr.co.assemble.dao.SendMailImple;
import kr.co.assemble.dto.EmailDTO;
import kr.co.assemble.dto.IdCheckDTO;
import kr.co.assemble.dto.MemberInfoDTO;
import kr.co.assemble.service.SendMailService;

// AssembleInfo_controller

@Controller
public class AI_controller {
	
	@Autowired
	MI_interface mi_dao;
	
	@Autowired
	SendMailImple smi;
	
	@Autowired
	BCryptPasswordEncoder passEncoder;
	
	private final String MAIN = "main";
//	private final String SIGNUP = "admin_signup";
	private final String ASSEMBLELOGIN = "assembleLogin";
//	private final String RE = "redirect:/";
	private final String LOGIN = "login";
	private final String LOGINOK = "loginOk";
	private final String INVITED = "invited";
	private final String FIND = "find_assemble";
	private final String TERMS = "terms";
	private final String MEMSIGNUP = "mem_signup";
	private final String EMAILPASS = "emailpassword";
	
	public void setmi_dao(MI_interface mi_dao) {
		this.mi_dao = mi_dao;
	}
	
	// 첫 화면
	@RequestMapping(value = "/main", method = { RequestMethod.GET, RequestMethod.POST })
	public String list(Model model) {
		List<MemberInfoDTO> list = mi_dao.selectAll();
		
		model.addAttribute("list", list);
//		System.out.println(list);
//		System.out.println(list.get(0));
		
		return MAIN;
	}
	
	// 어셈블 로그인 창
	@RequestMapping(value = "/assembleLogin")
	public String assembleLogin() {
		
		return ASSEMBLELOGIN;
	}
	
	// 어셈블 로그인 후 아이디 로그인 창
	@RequestMapping(value = "/login")
	public String login(@ModelAttribute MemberInfoDTO dto, HttpServletRequest req) {
		String mi_name = mi_dao.selectAssembleName(dto.getMi_assemblename());
		
		System.out.println(mi_name);
		if(mi_name == null) {
			return "assembleloginfail";
		}
		HttpSession session = req.getSession(true);
		
		session.setAttribute("mi_assemblename", mi_name);
		
		return LOGIN;
	}
	
	// 로그인 OK!
	@RequestMapping(value = "/loginOk")
	public String mainPage(@ModelAttribute IdCheckDTO dto1, HttpSession session) {
		String mi_assembleName = (String) session.getAttribute("mi_assemblename");
//		System.out.println(mi_assembleName);
		dto1.setMi_assemblename(mi_assembleName);
//		System.out.println("dao 들어가기 전" +mi_assembleName);
//		System.out.println("loginOK : "+mi_assembleName);
		IdCheckDTO check = mi_dao.selectId(dto1);
//		System.out.println(check.getMi_memid());
		if(check.getMi_memid() == "0") {
			return "loginfail";
		}
		
//		System.out.println("if 후 : " + check.getMi_memid());
		
		boolean passMatch = passEncoder.matches(dto1.getMi_mempw(), check.getMi_mempw());
//		System.out.println("passMatch : " + passMatch);
		int mi_memNo = check.getMi_memberno();
//		System.out.println(check.getMi_memberNo());
//		session.setAttribute("mi_memberNo", mi_memNo);
		session.setAttribute("memberno", mi_memNo);
		session.setAttribute("mi_memname", check.getMi_memname());
		if(passMatch) {
			session.setAttribute("mi_memid", check.getMi_memid());
			
		}else {
			return "loginfail";
		}
		
		return LOGINOK;
	}
	
	@RequestMapping(value="/emailck")
	@ResponseBody
	public int emailck(@ModelAttribute MemberInfoDTO dto, HttpSession session) {
		System.out.println("emailck : " + dto);
		dto.setMi_assemblename((String)session.getAttribute("mi_assemblename"));
		
		int result = mi_dao.emailck(dto);
		System.out.println(dto.getMi_assemblename());
		System.out.println("email : "+dto.getMi_mememail());
		System.out.println(result);
		
		return result;
	}
	
	// 초대하기
	@RequestMapping(value="/invited")
	public ModelAndView invited() {
		ModelAndView mv = new ModelAndView();
		int ran = new Random().nextInt(9000000)+1000000;
		System.out.println("invited ran : " + ran);
		mv.setViewName(INVITED);
		mv.addObject("ran", ran);
		return mv;
	}
	
	// 초대 OK
	@RequestMapping(value="/invitedOk")
	public String invitedOk(@RequestParam String invited, 
			@RequestParam String ran, HttpServletRequest req, 
			HttpSession session, EmailDTO emaildto) {
		String memid = (String) session.getAttribute("mi_memid");
		String mi_assembleName = (String) session.getAttribute("mi_assemblename");
		SendMailService sms = new SendMailService();
		System.out.println("invitedOk ran : " + ran);
		String encodeRan = sms.encodeInit(ran);
//		String encodeRan = passEncoder.encode(ran);
		session.setAttribute("ran", encodeRan);
		String sendEmail = "tlsgks8668@gmail.com";
		session.setAttribute("mi_mememail", invited);
		String title = "[Assemble]"+ memid +"님이 "+ mi_assembleName + " 어셈블에 초대하셨습니다.";
		String contents = "<h1>" + mi_assembleName + "</h1>\r\n" +
				"<h1> 어셈블에 초대되셨습니다. </h1>" +
				"<h3>[Assemble]"+ memid +"님이 "+ mi_assembleName +" 어셈블에 초대하셨습니다.</h>\r\n" +
				"	<h3>초대 링크를 보시려면 "+ 
				"<a href=\"http://13.209.244.152:8080/invitedemail?mi_assemblename="+mi_assembleName+"&ran="+encodeRan+"&mi_mememail="+invited+"\">"  + 
				"여기</a>를 눌러주세요!</h3>\r\n" + 
				"	<hr />\r\n" + 
				"	<div class=\"form-group\">\r\n" + 
				"		<p>본 메일은 발신 전용이며, 문의에 대한 회신은 처리되지 않습니다.</p>\r\n" + 
				"	</div>";
		emaildto.setSendemail(sendEmail);
		emaildto.setReceiveemail(invited);
		emaildto.setTitle(title);
		emaildto.setContents(contents);

//		System.out.println(aiName);
//		System.out.println(mi_mememail);
		
//		smi.send(emaildto);
		
		try {
			smi.sendEmail(emaildto);
		} catch (UnsupportedEncodingException | MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "home";
	}
	
	// 이메일 -> 초대 받은 멤버 회원가입
	@RequestMapping(value="/assemble.io/{mi_assemblename}/login/{ran}/a", method = { RequestMethod.GET, RequestMethod.POST })
	public String memLogin(
			@PathVariable("mi_assemblename") String assembleName,
			@PathVariable("ran") String ran) {
		System.out.println(ran);
		
		return MEMSIGNUP;
		
	}
	
	// 이메일로 어셈블 찾기
	@RequestMapping(value="/find_assemble")
	public String find_assemble() {
		
		return FIND;
	}
	
	// 어셈블 찾기 이메일 발송
	@RequestMapping(value="/send_findassemble")
	public String find_email(@RequestParam String mi_mememail,
			HttpSession session, EmailDTO emaildto) {
		session.setAttribute("mi_mememail", mi_mememail);
//		System.out.println(list);
		String sendEmail = "tlsgks8668@gmail.com";
		String title = "[Assemble] 참여 중인 어셈블 목록";
		String contents = "<h1>참여 중인 어셈블 목록</h1>\r\n" + 
				"	<h3>계정으로  참여 중인 어셈블 목록을 보시려면 <a href=\"http://13.209.244.152:8080/findemail\">여기</a>를 눌러주세요!</h3>\r\n" + 
				"	<hr />\r\n" + 
				"	<div class=\"form-group\">\r\n" + 
				"		<p>본 메일은 발신 전용이며, 문의에 대한 회신은 처리되지 않습니다.</p>\r\n" + 
				"	</div>";
		emaildto.setSendemail(sendEmail);
		emaildto.setReceiveemail(mi_mememail);
		emaildto.setTitle(title);
		emaildto.setContents(contents);
		
//		smi.send(emaildto);

		try {
			smi.sendEmail(emaildto);
		} catch (UnsupportedEncodingException | MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		return "main";
	}

	// 이용약관 (회원가입 폼)
	@RequestMapping(value="/terms")
	public String terms() {
		return TERMS;
	}
	
	@RequestMapping(value="/find_password")
	public String find_password() {
		return "find_password";
	}
	
	@RequestMapping(value="/emailpassfind")
	public String emailpassfind(@RequestParam String mi_mememail,
			@RequestParam String mi_assemblename,
			EmailDTO emaildto) {
//		System.out.println(list);
		String sendEmail = "tlsgks8668@gmail.com";
		String title = "[Assemble] 비밀번호 변경";
		String contents = "<h1>비밀번호 변경</h1>\r\n" + 
				"	<h3>비밀번호 변경을 하시려면 "+ 
				"<a href=\"http://13.209.244.152:8080/emailpassword?mi_assemblename="+mi_assemblename+"&mi_mememail="+mi_mememail+"\">여기</a>를 눌러주세요!</h3>\r\n" + 
				"	<hr />\r\n" + 
				"	<div class=\"form-group\">\r\n" + 
				"		<p>본 메일은 발신 전용이며, 문의에 대한 회신은 처리되지 않습니다.</p>\r\n" + 
				"	</div>";
		emaildto.setSendemail(sendEmail);
		emaildto.setReceiveemail(mi_mememail);
		emaildto.setTitle(title);
		emaildto.setContents(contents);
		
//		smi.send(emaildto);

		try {
			smi.sendEmail(emaildto);
		} catch (UnsupportedEncodingException | MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return MAIN;
	}
	
	@RequestMapping(value="/emailpassword")
	public String emailpassword() {
		
		return EMAILPASS;
	}
	
	@RequestMapping(value="/changepassword")
	public String changepassword() {
		
		return "newPassword";
	}
	
	@RequestMapping(value="/changesuccess")
	public String changesuccess(@ModelAttribute MemberInfoDTO dto,
			HttpServletRequest req) {
		
		String password = dto.getMi_mempw();
		String Pw = passEncoder.encode(password);
		
		dto.setMi_mempw(Pw);
		dto.setMi_assemblename(req.getParameter("mi_assemblename"));
		dto.setMi_mememail(req.getParameter("mi_mememail"));
		
		
		mi_dao.updatePasswordOne(dto);
		
		return MAIN;
	}
	
	

	
}
