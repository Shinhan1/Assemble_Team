package kr.co.assemble.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.assemble.dao.MemberDAO;
import kr.co.assemble.dto.MemberInfoDTO;



@Controller
public class Member_controller {
   /*
    * @Inject MemberSub_DAO dao;
    */
   
   @Autowired
   MemberDAO dao;
   //멤버 첫 홈 -                                           ===> 첫 홈에서 누르면 load 해놓음
   @RequestMapping(value = "/members")
   public String members(HttpServletRequest request, Model model) {
      HttpSession session = request.getSession();
      
      MemberInfoDTO dto = new MemberInfoDTO();
      String assemblename = (String) session.getAttribute("mi_assemblename");
      dto.setMi_assemblename(assemblename);
      
      int countmember = dao.countMember(assemblename);
      
      
      List<MemberInfoDTO> list = dao.selectMember(assemblename);
      model.addAttribute("memberlist", list);
      model.addAttribute("countmember", countmember);
      
      return "jisoo/members";
   }
   
   
   
}