package kr.co.assemble.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.assemble.dao.ComposedDAO;
import kr.co.assemble.dto.ComposedDTO;

@Controller
public class ComposedController {
	
	@Autowired
	ComposedDAO dao;
	
	
	//초대 폼
	@RequestMapping(value = "/invite")
	public String inviteMem() {
		return "composed/invite";
	}
	
	
	//초대 완료페이지로 이동
	@RequestMapping(value = "/inviteOk")
	public String inviteMemOk(
			@RequestParam(value = "cgNum") int cgNum,
			@RequestParam(value = "grNum") int grNum,
			@RequestParam(value = "memNum") int memNum, Model model) {
		
		ComposedDTO dto = new ComposedDTO();
		
		dto.setCategoryno(cgNum);
		dto.setGroupno(grNum);
		dto.setMemberno(memNum);
		
		dao.insertMem(dto);
		model.addAttribute("dto", dto);
		
		return "composed/inviteOk";
	}
	
	
	
}
