package kr.co.assemble.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.assemble.dao.CategoryDAO;
import kr.co.assemble.dao.GroupDAO;
import kr.co.assemble.dto.GroupDTO;
import kr.co.assemble.dto.NavbarDTO;


@Controller
public class NavbarController {

	@Autowired
	GroupDAO gdao;
	@Autowired
	CategoryDAO cdao;
	
	
	//카테고리 전체 조회
	@RequestMapping(value = "/assemble.io/{mi_assemblename}/header")	
	public String categoryList(@PathVariable("mi_assemblename")String assemblename,
			HttpServletRequest request, Model model) {
		
		//session 받아서 assemble명 바꾸기
		//assemblename = (String) session.getAttribute("mi_assembleName");
		HttpSession session = request.getSession();
		int memberNo = (Integer)session.getAttribute("memberno");
	
		//System.out.println(assemblename);
		NavbarDTO dto = new NavbarDTO();
		dto.setMemberno(memberNo);
		dto.setAssemblename(assemblename);
		List<NavbarDTO> list = cdao.selectCategory(dto);
		model.addAttribute("categoryList", list);
		
//		System.out.println(assemblename);
		
//		List<CategoryDTO> list = cdao.selectCategory(dto);
		
		//categoryno 같을때만 뽑는 조건을 jsp상에서 주었음
		List<GroupDTO> list2 = gdao.grouplist();	
		model.addAttribute("groupList", list2);
		
//		model.addAttribute("memberno", memberNo);
				
		return "include/header";
		//return "category/categoryForm";
	}
	
	@RequestMapping(value="/test")
	public String test1() {
		
		return "include/header";
	}
	
}
