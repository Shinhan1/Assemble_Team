package kr.co.assemble.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.assemble.dao.MyWriteDAO;
import kr.co.assemble.dto.MyWriteDTO;

@Controller
public class MyWriteController {
   
   @Autowired
   MyWriteDAO dao;
   
   @RequestMapping(value = "/myBoard")
   public String myWrite(HttpSession session, Model model) {
      
	  int memberno = (int) session.getAttribute("memberno");
	   
      MyWriteDTO dto = new MyWriteDTO();
      dto.setMemberno(memberno);
      List<MyWriteDTO> list = dao.myWrite(dto);
      
      model.addAttribute("mywirtelist", list);
      model.addAttribute("memberno", memberno);      
      
      return "board/myWriteBoard";
   }
   
}