package kr.co.ass.controller;

import java.util.List;
import java.util.Random;

import javax.inject.Inject;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import kr.co.ass.dao.AI_interface;
import kr.co.ass.dto.AssembleInfoDTO;
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
	private final String SIGNUPOK = "signupOk";
	private final String RE = "redirect:/";
	private final String SEND = "sendMail";
	
	public void setDao(AI_interface dao) {
		this.dao = dao;
	}
	
	@RequestMapping(value = "/ai")
	public String list(Model model) {
		List<AssembleInfoDTO> list = dao.selectAll();
		
		model.addAttribute("list", list);
		
		return LIST;
	}
	
	@RequestMapping(value = "/signup")
	public ModelAndView signup() {
		ModelAndView mv = new ModelAndView();
		int ran = new Random().nextInt(9999);
		mv.setViewName(SIGNUP);
		mv.addObject("random", ran);
		return mv;
	}
	
	@RequestMapping(value = "/signupOk")
	public String signupOk(@ModelAttribute AssembleInfoDTO dto) {
		dao.insertOne(dto);
		
		return RE+"ai";
	}
	
	@RequestMapping(value = "/sendMail")
	@ResponseBody
	public boolean sendMail(@RequestParam String ai_memEmail, @RequestParam int random, HttpServletRequest req) {
		SendMailService sms = new SendMailService();
		SendMail sm = new SendMail();
		int ranNum = sms.init();
		String aiName = req.getParameter("ai_assembleName");
		HttpSession session = req.getSession(true);
		String authCode = String.valueOf(ranNum);
		session.setAttribute("authCode", authCode);
		session.setAttribute("random", random);
		
		String sendEmail = "tlsgks8668@gmail.com";
//		String receiveEmail = req.getParameter("ai_memEmail");
		String title = "Assemble 인증 코드입니다.";
		String contents = "Assemble\n" + "어셈블명은 " + aiName + "입니다.\n"
				+ "당신의 인증번호는 " + ranNum + "입니다.\n"
				+ "인증번호를 입력해주세요!\n"
				+ "이용해주셔서 감사합니다.";
		
		System.out.println(aiName);
		System.out.println(ai_memEmail);
		
		
		return sm.sendEmail(sendEmail, ai_memEmail, title, contents, ranNum);
	}
	
}
