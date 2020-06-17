package kr.co.assemble.controller;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Random;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import kr.co.assemble.dao.MI_interface;
import kr.co.assemble.dao.MS_interface;
import kr.co.assemble.dao.SendMailImple;
import kr.co.assemble.dto.EmailDTO;
import kr.co.assemble.dto.MemberInfoDTO;
import kr.co.assemble.dto.MemberSubDTO;
import kr.co.assemble.dto.testDTO;
import kr.co.assemble.service.SendMailService;

@Controller
public class SignupController {
	
	@Autowired
	MI_interface mi_dao;
	
	@Autowired
	MS_interface ms_dao;
	
	@Autowired
	SendMailImple smi;
	
	@Autowired
	BCryptPasswordEncoder passEncoder;
	
	private final String SIGNUP = "admin_signup";
	private final String MAIN = "main";
	private final String RE = "redirect:/";
	private final String PROFILE = "new_profile";
	
	// 회원가입 폼
	@RequestMapping(value = "/signup")
	public ModelAndView signup() {
		ModelAndView mv = new ModelAndView();
		int ran = new Random().nextInt(900000)+100000;
		mv.setViewName(SIGNUP);
		mv.addObject("ran", ran);
		return mv;
	}
	
	// 회원가입 OK
	@RequestMapping(value = "/signupOk")
	public String signupOk(@ModelAttribute MemberInfoDTO dto, HttpSession session) {
		String password = dto.getMi_mempw();
		String Pw = passEncoder.encode(password);
		dto.setMi_mempw(Pw);
		System.out.println(Pw);
		mi_dao.insertOne(dto);
		session.removeAttribute("ms_memberno");
		int memberno = mi_dao.selectMemberNo(dto);
		session.setAttribute("ms_memberno", memberno);
//		System.out.println(memberno);
		
		return PROFILE;
	}
	
	// 회원가입 -> 세부 내용 작성
	@RequestMapping(value = "/signup/new_profile")
	public String new_profile(@ModelAttribute MemberSubDTO dto, 
			HttpSession session,
			MultipartHttpServletRequest request) {
		dto.setMs_memberno((int) session.getAttribute("ms_memberno"));
		MultipartFile mf = request.getFile("ms_memprofileimg");
		
		String root_filePath = request.getSession().getServletContext().getRealPath("/");
        String attach_path = "resources/memprofileimg/";
		String originalFileName = mf.getOriginalFilename();
		String path = root_filePath + attach_path;
		String time = Long.toString(System.currentTimeMillis());
	    String safeFile = root_filePath + attach_path + time + originalFileName;

		
		
		
		File file = new File(path); 
		if(file.exists() == false){ 
			file.mkdirs(); 
		}

		try {
            mf.transferTo(new File(safeFile));
 
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
		
		dto.setMs_memprofileImg(safeFile);
//		System.out.println(dto.getMs_memprofileimg());
//		System.out.println(safeFile);
		
		ms_dao.updateMemberSub(dto);
		session.removeAttribute("ms_memberno");
		
		return RE+MAIN;
	}
	
	// ?
	@RequestMapping(value = "/editprofile")
	public String editProfile() {
		return "editProfile";
	}
	
	// 메일 보내기 
	@RequestMapping(value = "/sendMail")
	@ResponseBody
	public void sendMail(@RequestParam String mi_mememail, @RequestParam int ran, HttpServletRequest req,
			EmailDTO emaildto) {
		SendMailService sms = new SendMailService();
		int ranNum = sms.init();
//		String aiName = req.getParameter("mi_assembleName");
		HttpSession session = req.getSession(true);
		String authCode = String.valueOf(ranNum);
		session.setAttribute("authCode", authCode);
		session.setAttribute("ran", ran);
		
		String sendEmail = "tlsgks8668@gmail.com";
		String receiveEmail = mi_mememail;
		String title = "Assemble 인증 코드입니다.";
		String contents = "<h1>안녕하세요! Assemble입니다.</h1>\r\n" + 
				"	<h3>인증코드를 확인하시려면 <a href=\"http://13.209.244.152:8080/signupemail\">여기</a>를 눌러주세요!</h3>\r\n" + 
				"	<hr />\r\n" + 
				"	<div class=\"form-group\">\r\n" + 
				"		<p>본 메일은 발신 전용이며, 문의에 대한 회신은 처리되지 않습니다.</p>\r\n" + 
				"	</div>";
		emaildto.setSendemail(sendEmail);
		emaildto.setReceiveemail(receiveEmail);
		emaildto.setTitle(title);
		emaildto.setContents(contents);
//		System.out.println(aiName);
		System.out.println(mi_mememail);
		
//		smi.send(emaildto);
		
		try {
			smi.sendEmail(emaildto);
		} catch (UnsupportedEncodingException | MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}
	
	// 회원가입 인증코드 인증
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
	
	
	// 어셈블 개설 -> 인증코드
	@RequestMapping(value="/signupemail")
	public String signupemail() {
		return "admin_email";
	}
	
	// 멤버 초대
	@RequestMapping(value="/invitedemail")
	public String invitedemail() {
		
		
		return "mem_email";
	}
	
	// 이메일로 어셈블 찾기 후 이메일 발송 폼, 즉 이메일로 온 jsp
	@RequestMapping(value="/findemail")
	public String findemail(HttpSession session, Model model) {
		String mi_memEmail = (String) session.getAttribute("mi_mememail");
		System.out.println(mi_memEmail);
		List<testDTO> assembleName = mi_dao.findAssembleName(mi_memEmail);
		model.addAttribute("attendList", assembleName);
		System.out.println(assembleName);
		session.removeAttribute("mi_mememail");
		
		return "find_email";
	}
	
	// 초대받은 회원의 회원가입 창
	@RequestMapping(value="/membersignup")
	public String memberSignup(
			HttpServletRequest req,
			@ModelAttribute MemberInfoDTO dto, HttpSession session) {
		String password = dto.getMi_mempw();
		String Pw = passEncoder.encode(password);
		dto.setMi_assemblename(req.getParameter("mi_assemblename"));
		dto.setMi_mempw(Pw);
		dto.setMi_mememail(req.getParameter("mi_mememail"));
		System.out.println(dto.getMi_mememail());
		System.out.println(Pw);
		
		mi_dao.insertMember(dto);
		
		session.removeAttribute("ms_memberno");
		int memberno = mi_dao.selectMemberNo(dto);
		session.setAttribute("ms_memberno", memberno);
		System.out.println(memberno);
		
		return PROFILE;
	}
	
	
	// 아이디 중복체크 (mem_signup에 ajax로 데이터 넘김)
	@RequestMapping(value="/assemble.io/{mi_assemblename}/login/{ran}/duplicateId")
	@ResponseBody
	public int duplicateId(
			@PathVariable("mi_assemblename") String assembleName,
			@ModelAttribute MemberInfoDTO dto) {
		int result = mi_dao.duplicationId(dto);
		System.out.println("duplicateId"+assembleName);
		System.out.println("dto : " + dto.getMi_assemblename());
		System.out.println(result);
		
		return result;
	}
	
	// 어셈블 중복체크 (admin_signup에 ajax로 데이터 넘김)
	@RequestMapping(value="/duplicateAssembleName")
	@ResponseBody
	public int duplicateAssembleName(@ModelAttribute MemberInfoDTO dto) {
		int result = mi_dao.duplicationAssembleName(dto.getMi_assemblename());
		
		
		return result;
	}
	
	
	
}
