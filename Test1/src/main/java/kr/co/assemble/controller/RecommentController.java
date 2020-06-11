package kr.co.assemble.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.assemble.dao.RecommentDAO;
import kr.co.assemble.dto.RecommentDTO;

@Controller
public class RecommentController {

   @Autowired
   RecommentDAO dao;

   public RecommentDAO getDao() {
      return dao;
   }
   
   //그룹안에서 댓글 달기
   @RequestMapping(value = "/assemble.io/{mi_assembleName}/g/{groupno}/insertComment")
   public String reco(
		 @PathVariable("mi_assembleName")String assemblename,
         @RequestParam(value = "bno") int bno,
         @RequestParam(value = "groupno") int groupno,
         @RequestParam(value = "categoryno") int categoryno,
         @RequestParam(value = "contents") String contents, HttpServletRequest request, Model model) {
      
      RecommentDTO dto = new RecommentDTO();
      dto.setBno(bno);
      dto.setGroupno(groupno);
      dto.setCategoryno(categoryno);
      dto.setRecontents(contents);
      
      //멤버세션으로 id 조회해서 댓글작성자에 현재 세션의 id 집어넣기
      HttpSession session = request.getSession();
      String memberId = (String) session.getAttribute("mi_memID");
      dto.setReid(memberId);
      
      dao.insertComment(dto);
      model.addAttribute("dto", dto);
      model.addAttribute("groupno", groupno);
      
      return "redirect:/assemble.io/{mi_assembleName}/g/{groupno}/wall";
   }
   
   //메인 홈에서 댓글 달기
   @RequestMapping(value = "/assemble.io/{mi_assembleName}/insertCommentatHome")
   public String recoHome(
		 @PathVariable("mi_assembleName")String assemblename,
         @RequestParam(value = "bno") int bno,
         @RequestParam(value = "groupno") int groupno,
         @RequestParam(value = "categoryno") int categoryno,
         @RequestParam(value = "contents") String contents, HttpServletRequest request, Model model) {
      
      RecommentDTO dto = new RecommentDTO();
      dto.setBno(bno);
      dto.setGroupno(groupno);
      dto.setCategoryno(categoryno);
      dto.setRecontents(contents);
      
      //멤버세션으로 id 조회해서 댓글작성자에 현재 세션의 id 집어넣기
      HttpSession session = request.getSession();
      String memberId = (String) session.getAttribute("mi_memID");
      int memberNo = (Integer) session.getAttribute("memberno");
      System.out.println(memberNo);
      dto.setReid(memberId);
      
      dao.insertComment(dto);
      model.addAttribute("dto", dto);
      model.addAttribute("memberno", memberNo);
      
      return "redirect:/assemble.io/{mi_assembleName}/home";
   }
   
   //그룹에서 bno별 댓글 조회  
 // @RequestMapping(value= "/assemble.io/{mi_assembleName}/g/{groupno}/selectRecomment")
  @RequestMapping(value= "/assemble.io/{mi_assembleName}/g/{groupno}/selectRecomment",method = RequestMethod.POST)
  @ResponseBody 
  public List<RecommentDTO> SelectRecomment(
        @PathVariable("mi_assembleName")String assemblename,
         @RequestParam(value = "bno") int bno,
         @RequestParam(value = "groupno") int groupno, Model model) {
     
     System.out.println(bno);
     System.out.println(groupno);
     
     List<RecommentDTO> recomment = dao.recommentlist(bno);  
     
     model.addAttribute("recommentlist", recomment);
     
     System.out.println(recomment.get(0).getRecontents());
     
     return recomment;     
  }
   
   
}