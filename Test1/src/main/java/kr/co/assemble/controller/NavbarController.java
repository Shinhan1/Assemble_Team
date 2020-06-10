package kr.co.assemble.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.assemble.dao.CategoryDAO;
import kr.co.assemble.dao.GroupDAO;
import kr.co.assemble.dto.CategoryDTO;
import kr.co.assemble.dto.GroupDTO;

@Controller
public class NavbarController {

	@Autowired
	GroupDAO gdao;
	@Autowired
	CategoryDAO cdao;
	
	
	//카테고리 전체 조회
	@RequestMapping(value = "/assemble.io/{mi_assembleName}/header")	
	public String categoryList(
			@PathVariable("mi_assembleName") String assembleName,
			Model model) {
		
		List<CategoryDTO> list = cdao.selectCategory();
		model.addAttribute("categoryList", list);
		
		List<GroupDTO> list2 = gdao.grouplist();
		model.addAttribute("groupList", list2);
				
		return "include/header";
		//return "category/categoryForm";
	}
	
}
