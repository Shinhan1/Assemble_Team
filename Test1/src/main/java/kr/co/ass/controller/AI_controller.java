package kr.co.ass.controller;

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
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import kr.co.ass.dao.AI_interface;
import kr.co.ass.dto.AssembleInfoDTO;
import kr.co.ass.dto.IdCheckDTO;
import kr.co.ass.service.SendMail;
import kr.co.ass.service.SendMailService;



// AssembleInfo_controller

@Controller
public class AI_controller {
	
	@Inject
	AI_interface dao;
	
	@Autowired
	private JavaMailSender mailSender;
	
	private final String LIST = "ai_list";
	private final String SIGNUP = "signup";
	private final String LOGIN = "login";
	private final String RE = "redirect:/";
	private final String ASSEMBLELOGIN = "assembleLogin";
	private final String MAIN = "main";
	
	public void setDao(AI_interface dao) {
		this.dao = dao;
	}
	
	@RequestMapping(value = "/ai")
	public String list(Model model) {
		List<AssembleInfoDTO> list = dao.selectAll();
		
		model.addAttribute("list", list);
		System.out.println(list);
		System.out.println(list.get(0));
		
		return LIST;
	}
	
	@RequestMapping(value = "/login")
	public String login() {
		
		return LOGIN;
	}
	@RequestMapping(value = "/assembleLogin")
	public String assembleLogin(@ModelAttribute AssembleInfoDTO dto, HttpServletRequest req) {
		String ai_name = dao.selectAssembleName(dto.getAi_assembleName());
		
		if(ai_name == null) {
			return LOGIN;
		}
		HttpSession session = req.getSession(true);
		
		session.setAttribute("ai_assembleName", ai_name);
		
		return ASSEMBLELOGIN;
	}
	
	@RequestMapping(value = "/main")
	public String mainPage(@ModelAttribute IdCheckDTO dto1, HttpSession session) {
		String ai_assembleName = (String) session.getAttribute("ai_assembleName");
//		System.out.println(ai_assembleName);
		dto1.setAi_assembleName(ai_assembleName);
		
		String memID = dao.selectId(dto1);
		String memPw = dao.selectPw(dto1);
//		String ai_memPw = dao.selectPw(dto1);
		
		System.out.println(dto1.getAi_memID());
		System.out.println(dto1.getAi_memPw());
		System.out.println(dto1.getAi_assembleName());
//		System.out.println(ai_memID);
//		System.out.println(ai_memPw);
		
		if(memID == null && memPw == null) {
			return ASSEMBLELOGIN;
		}
//		
//		model.addAttribute("ai_memID", ai_memID);
//		model.addAttribute("ai_memPw", ai_memPw);
//		System.out.println(list.get(0));
//		System.out.println(list.size());
//		System.out.println(list.get(1));
//		System.out.println(list.get(2));
		
		
		
		
//		if(list.get(0) == null && list.get(1) == null) {
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
	public String signupOk(@ModelAttribute AssembleInfoDTO dto) {
		dao.insertOne(dto);
		
		return RE+"ai";
	}
	
	@RequestMapping(value = "/sendMail")
	@ResponseBody
	public void sendMail(@RequestParam String ai_memEmail, @RequestParam int ran, HttpServletRequest req) {
		SendMailService sms = new SendMailService();
		SendMail sm = new SendMail();
		int ranNum = sms.init();
//		String aiName = req.getParameter("ai_assembleName");
		HttpSession session = req.getSession(true);
		String authCode = String.valueOf(ranNum);
		session.setAttribute("authCode", authCode);
		session.setAttribute("ran", ran);
		
		String sendEmail = "tlsgks8668@gmail.com";
//		String receiveEmail = req.getParameter("ai_memEmail");
		String title = "Assemble 인증 코드입니다.";
		String contents = "Assemble\n"
				+ "당신의 인증번호는 " + ranNum + "입니다.\n"
				+ "인증번호를 입력해주세요!\n"
				+ "이용해주셔서 감사합니다.";
		
//		System.out.println(aiName);
		System.out.println(ai_memEmail);
		
		MimeMessage message = mailSender.createMimeMessage();
		MimeMessageHelper msghelper;
		try {
			msghelper = new MimeMessageHelper(message, true, "UTF-8");
			// MimeMessageHelper에 set하기 위함
			msghelper.setFrom(sendEmail);		// 보내는 사람 이메일
			msghelper.setTo(ai_memEmail);		// 받는 사람 이메일
			msghelper.setSubject(title);		// 제목
			msghelper.setText(contents);		// 내용
			
			mailSender.send(message);
			
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
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
