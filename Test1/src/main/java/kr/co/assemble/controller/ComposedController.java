package kr.co.assemble.controller;

import javax.servlet.http.HttpSession;

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
	@RequestMapping(value = "/attend")
	public String inviteMem() {
		return "jisoo/attendgroups";
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
	
	//속해있지않다면 참여가되고 속해있다면 나가기가됨
	   @RequestMapping(value = "/attendOk")
	   public String inviteMemOk(
	         @RequestParam(value = "groupno")int groupno, 
	         @RequestParam(value = "categoryno")int categoryno,
	         Model model, HttpSession session) {
	     
	      ComposedDTO dto = new ComposedDTO();

	      int memberno = (Integer)session.getAttribute("memberno");
	     
	      dto.setGroupno(groupno);
	      dto.setMemberno(memberno);
	      dto.setCategoryno(categoryno);
	      
	      int n = dao.composedGroup(dto);
	      
	      System.out.println(n);
	      
	      if(n == 0) {
	         dao.attendGroup(dto);         
	      }else if(n == 1) {
	         dao.deleteGroup(dto);
	      }
	      
	      model.addAttribute("n", n);
	      
	      return "redirect:/attendgroups";
	   }
	
	
}
