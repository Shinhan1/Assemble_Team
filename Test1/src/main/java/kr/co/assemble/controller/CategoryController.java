package kr.co.assemble.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.assemble.dao.CategoryDAO;
import kr.co.assemble.dto.CategoryDTO;

@Controller
public class CategoryController {
	
	@Autowired
	CategoryDAO cdao;
	
	public CategoryController(CategoryDAO cdao) {		
		this.cdao = cdao;
	}

	//카테고리 생성폼으로
	@RequestMapping(value = "/makeCategory")
	public String makeCategory() {		
		
		return "category/setCategories";
		//return "category/setCategories";
	}
	
	
	//카테고리 생성 OK
	@RequestMapping(value = "/makeCategoryOk")
	public String makecategoryOk(
			@RequestParam(value = "cgName")String name, Model model) {
		
		CategoryDTO dto = new CategoryDTO();
		
		//멤버 넘버 세션에서 받아오기
		dto.setMemberno(2);
		dto.setCategoryname(name);
		
		
		cdao.insertCategory(dto);
		model.addAttribute("dto", dto);
		
		return "category/inputCategoryOk";
		
	}
	


	
	
	
}
