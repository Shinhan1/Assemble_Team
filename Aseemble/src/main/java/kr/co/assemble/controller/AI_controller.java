package kr.co.assemble.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.assemble.dao.AI_interface;
import kr.co.assemble.dto.AssembleInfoDTO;

// AssembleInfo_controller

@Controller
public class AI_controller {
	
	@Inject
	AI_interface dao;
	
	public void setDao(AI_interface dao) {
		this.dao = dao;
	}
	
	@RequestMapping(value = "/ai.do")
	public String list(Model model) {
		List<AssembleInfoDTO> list = dao.selectAll();
		
		model.addAttribute("list", list);
		
		return "ai_list";
	}
	
}
