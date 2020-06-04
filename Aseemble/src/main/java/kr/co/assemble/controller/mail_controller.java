package kr.co.assemble.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.co.assemble.dto.EmailDTO;
import kr.co.assemble.mail.EmailService;

@Controller
public class mail_controller {
	private final String HOME = "redirect:/";
	private final String SIGN_UP_VIEW = "sign/sign-up";
	private final String EMAIL_CONFIRM_VIEW = "sign/emailConfirm";

	@Autowired
	private EmailService memberSvc;

	@RequestMapping(value = "/sign", method = RequestMethod.GET)
	public String regist() throws Exception {
		return SIGN_UP_VIEW;
	}

	@RequestMapping(value = "/sign-up", method = RequestMethod.POST)
	public String regist(EmailDTO user, RedirectAttributes rttr) throws Exception {

		System.out.println("regesterPost 진입 ");
		memberSvc.regist(user);
		rttr.addFlashAttribute("msg", "가입시 사용한 이메일로 인증해주세요");
		return HOME;
	}

	// confirm email authKey
	@RequestMapping(value = "/emailConfirm", method = RequestMethod.GET)
	public String emailConfirm(@RequestParam("authKey") String authkey, Model model, RedirectAttributes rttr)
			throws Exception {

		if (authkey == null) {
			rttr.addFlashAttribute("msg", "인증키가 잘못되었습니다. 다시 인증해 주세요");
			return HOME;
		}

		EmailDTO member = memberSvc.userAuth(authkey);
		if (member == null) {
			rttr.addFlashAttribute("msg", "잘못된 접근 입니다. 다시 인증해 주세요");
			return HOME;
		}
		model.addAttribute("user", member.getSenderName());
		return EMAIL_CONFIRM_VIEW;
	}

}
