package kr.co.assemble.controller;


import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.assemble.dao.BoardDAO;
import kr.co.assemble.dto.Groupboard_Memberinfo_FileDTO;
@Controller
public class HomeController {

	@Autowired
	BoardDAO dao;
	
	private String HOME = "home";
	

	//내가 속한 그룹의 전체 게시글 출력
	@RequestMapping(value = "/assemble.io/{mi_assembleName}/home")
	public String selectMyGroup(@PathVariable("mi_assembleName") String assemblename,
								@RequestParam(value = "memberno") int memberno, Model model){
		
		//assemblename = (String) session.getAttribute("mi_assembleName");
		
		
		//model.addAttribute("assemblename", assemblename);
		
		List<Groupboard_Memberinfo_FileDTO> list = dao.selectMyFeed(memberno);
		model.addAttribute("mainlist", list);
		
		return HOME;
	}


	
}

