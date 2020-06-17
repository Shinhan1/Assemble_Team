package kr.co.assemble.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.assemble.dao.CategoryDAO;
import kr.co.assemble.dto.CategoryDTO;
import kr.co.assemble.dto.NavbarDTO;

@Controller
public class CategoryController {
   
   @Autowired
   CategoryDAO cdao;
   
   public CategoryController(CategoryDAO cdao) {      
      this.cdao = cdao;
   }

   //카테고리 생성폼으로
   @RequestMapping(value = "/makeCategory")
   public String makeCategory(HttpServletRequest request, Model model) {      
      
      HttpSession session = request.getSession();
      String assemblename = (String) session.getAttribute("mi_assemblename");
      int memberNo = (Integer)session.getAttribute("memberno");
      //System.out.println(assemblename);
      NavbarDTO dto = new NavbarDTO();
      dto.setMemberno(memberNo);
      dto.setAssemblename(assemblename);
      
      List<NavbarDTO> list = cdao.selectCategory(dto);
      model.addAttribute("categoryList2", list);

      return "category/setCategories";
      //return "category/setCategories";
   }
   
   
   //카테고리 생성 OK
   @RequestMapping(value = "/makeCategoryOk")
   public String makecategoryOk(
         @RequestParam(value = "cgName")String name, Model model, HttpSession session, HttpServletRequest req) {
      
      CategoryDTO dto = new CategoryDTO();
      
      int memberno = (int) session.getAttribute("memberno");
      String assemblename = (String) session.getAttribute("mi_assemblename");
      //멤버 넘버 세션에서 받아오기
      dto.setMemberno(memberno);
      dto.setCategoryname(name);
      dto.setAssemblename(assemblename);
      
      
      cdao.insertCategory(dto);
      model.addAttribute("dto", dto);
      
      return "redirect:/makeCategory";
      
   }
   


   
   
   
}