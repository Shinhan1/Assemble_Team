package kr.co.assemble.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
public class Member_controller {
	/*
	 * @Inject MemberSub_DAO dao;
	 */
	
	//멤버 첫 홈 - 														===> 첫 홈에서 누르면 load 해놓음
	@RequestMapping(value = "/members")
	public String members() {
		return "jisoo/members";
	}
	
	
}
