package kr.co.assemble.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.assemble.dao.BoardDAO;
import kr.co.assemble.dao.MemReqGroupDAO;
import kr.co.assemble.dao.RequestDAO;
import kr.co.assemble.dto.BoardDTO;
import kr.co.assemble.dto.MemReqGroupDTO;
import kr.co.assemble.dto.RequestDTO;

@Controller
public class RequestController {

   @Autowired
   RequestDAO rdao;

   @Autowired
   BoardDAO dao;

   @Autowired
   MemReqGroupDAO mrgDao;
   
   @Autowired
   PlatformTransactionManager transactionManager;
   
   // 요청 글쓰기 폼 띄우기
   @RequestMapping(value = "/request")
   public String reqForm() {
      return "board/request";
   }

   // 그룹보드에 요청 글쓰기와 동시에 요청테이블 업데이트
   @PostMapping(value = "/requestOk")
   public String request(
         @RequestParam(value = "groupno") int groupno,
         @RequestParam(value = "memberno") int memberno, 
         @RequestParam(value = "response") String response,
         @RequestParam(value = "contents") String contents, Model model, HttpSession session) {
      
      TransactionStatus status = this.transactionManager.getTransaction(new DefaultTransactionDefinition());
      
      BoardDTO dto = new BoardDTO();
      dto.setGroupno(groupno);
      dto.setMemberno(memberno);
      dto.setBoardcontents(contents);
      dto.setRequestboolean(1);

      dao.insertRequest(dto);

      
      this.transactionManager.commit(status);
      
      // 요청받는사람 업데이트
      RequestDTO reqdto = new RequestDTO();
      int bno = rdao.newlyReqbno();
      
      reqdto.setBno(bno);
      reqdto.setResponseid(response);
      rdao.updateReq(reqdto);
      
      String mi_assembleName = (String)session.getAttribute("mi_assemblename");
      model.addAttribute("mi_assemblename", mi_assembleName);
      model.addAttribute("groupno", groupno);

      return "redirect:/assemble.io/{mi_assemblename}/g/{groupno}/wall";
   }
   
   
   
   // 요청 status 변경 0=요청, 1=진행중, 2=완료
   @ResponseBody
   @RequestMapping(value = "/assemble.io/{mi_assemblename}/g/{groupno}/updateStatus", method = RequestMethod.POST)
   public String updateStatus(
		 @PathVariable("mi_assemblename")String assemblename,
         @RequestParam(value = "bno") int bno,
         @RequestParam(value = "groupno") int groupno,
         @RequestParam(value = "status") int status, Model model) {
      
      RequestDTO dto = new RequestDTO();
      
      System.out.println(status);
      	
      dto.setBno(bno);
      dto.setGroupno(groupno);
      dto.setReqstatus(status);
       rdao.updateStatus(dto);
      
      model.addAttribute("dto", dto);
      model.addAttribute("groupno", groupno);   
      
      return null;
   }
   
   
   
   //내가 받은 요청만 출력
   @RequestMapping(value = "/myRequest")
   public String myreq(
         @RequestParam(value = "memberno") int memberno, Model model) {
      //memberno는 세션의 값
      MemReqGroupDTO dto = new MemReqGroupDTO();
      dto.setMemberno(memberno);
      List<MemReqGroupDTO> list = mrgDao.myReq(dto);
      
      model.addAttribute("list", list);
      
      return "board/myRequest";
   }
   
   
   
   
   
   
   
   
   
   

}