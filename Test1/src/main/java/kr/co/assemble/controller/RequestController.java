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
   @RequestMapping(value = "/assemble.io/{mi_assemblename}/updateStatus", method = RequestMethod.POST)
   public int updateStatus(
		 @PathVariable("mi_assemblename")String assemblename,
         @RequestParam(value = "bno") int bno,
         @RequestParam(value = "groupno") int groupno,
         @RequestParam(value = "status") int status) {
      
      RequestDTO dto = new RequestDTO();
      
      System.out.println(status);
      	
      dto.setBno(bno);
      dto.setGroupno(groupno);
      dto.setReqstatus(status);
      int req = rdao.updateStatus(dto);
      
      System.out.println("req : "+req);
      
//      model.addAttribute("dto", dto);
//      model.addAttribute("groupno", groupno);   
      
      return req;
   }
   
   
   
   //내가 받은 요청만 출력
   @RequestMapping(value = "/myRequest")
   public String myreq(HttpSession session, Model model) {
      
	  String memname = (String) session.getAttribute("mi_memname");
	  String memid = (String) session.getAttribute("mi_memid");
	  String assemblename = (String)session.getAttribute("mi_assemblename");
	 
	  
      MemReqGroupDTO dto = new MemReqGroupDTO();
      //id와 name을 현재 나의 세션값으로
      dto.setValueid(memid);
      dto.setValuename(memname);
      dto.setAssemblename(assemblename);
   
         
      List<MemReqGroupDTO> list = rdao.selectMyReq(dto);
      
      model.addAttribute("list", list);
      
      return "jisoo/tasks";
   }
   
   
   //내가 받은 요청 status별로 출력
   @RequestMapping(value = "/myReqStatus")
   public String myReqStatus(
		   @RequestParam(value = "status") int status, HttpSession session, Model model) {
	   System.out.println(status);
	   
	   String memname = (String) session.getAttribute("mi_memname");
	   String memid = (String) session.getAttribute("mi_memid");
	   String assemblename = (String) session.getAttribute("mi_assemblename");
	   
	   
	   MemReqGroupDTO dto = new MemReqGroupDTO();
	   dto.setValueid(memid);
	   dto.setValuename(memname);
	   dto.setReqstatus(status);
	   dto.setAssemblename(assemblename);
	   
	   List<MemReqGroupDTO> list = rdao.selectMyReq(dto);
	   model.addAttribute("statuslist", list);
	   
	   String url = "";
	   
	   if(status==0) {
		    url = "jisoo/request/status0";
	   }else if(status==1) {
		    url = "jisoo/request/status1";
	   }else if(status==2) {
		    url = "jisoo/request/status2";		   
	   }
	   
	   return url;
	   
   }
   
   
   
   
   
   
   
   
   
   
   
   

}