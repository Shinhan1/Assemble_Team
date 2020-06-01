package kr.co.assemble.controller;

import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class emailController {
	@RequestMapping(value = "/email.do")
	public ModelAndView email() {
		ModelAndView mv = new ModelAndView();
		int ran = new Random().nextInt(900000) + 100000;
		mv.setViewName("test/email");
		mv.addObject("random", ran);
		return mv;
	}
	
	
}
