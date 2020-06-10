package kr.co.assemble.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.assemble.dao.BoardDAO;
import kr.co.assemble.dto.BoardDTO;
import kr.co.assemble.dto.GroupDTO;

@Controller
public class BoardController {

	@Autowired
	BoardDAO dao;
	
	
	public void setDao(BoardDAO dao) {
		this.dao = dao;
	}


	//글쓰기 폼
	@RequestMapping(value = "/write")
	public String writeForm() {
		return "board/write";
	}
	
	
	//글쓰기 완료 페이지
	@RequestMapping(value = "/writeOk")
	public String writeOk(
			@RequestParam(value = "grNum") int grNum,
			@RequestParam(value = "cgNum") int cgNum,
			@RequestParam(value = "memNum") int memNum,
			@RequestParam(value = "contents") String contents, Model model) {
		
		BoardDTO dto = new BoardDTO();
		
		dto.setGroupno(grNum);
		dto.setCategoryno(cgNum);
		dto.setMemberno(memNum);
		dto.setBoardcontents(contents);
		dao.write(dto);
		model.addAttribute("contents", contents);
		
		return "board/wall";
	}
	
	
	
	//그룹별 게시글 조회
	@RequestMapping("/assemble.io/{mi_assembleName}/g/{groupno}/wall")
	public String groupBoard(
			@PathVariable("mi_assembleName") String assembleName,
			@PathVariable("groupno")int groupno, Model model){
		
			List<BoardDTO> list = dao.boardlist(groupno);
			model.addAttribute("list", list);
		
		System.out.println(groupno);
			
			return "board/wall";
	}
	
		
	
	//bno로 게시글 전체 조회
	   @RequestMapping(value = "/selectBoard")
	   public String selectbno(
	         @RequestParam(value = "bno")int bno, Model model) {
	      System.out.println(bno);
	      
	      List<BoardDTO> list = dao.selectOne(bno);
	      model.addAttribute("list", list);
	      
	      return "board/modify";
	   }
	   
	   
	   //북마크 UPDATE
	   
	   
	
	
	   //좋아요 update
	/*
	 * @RequestMapping("/like.do") public String Like(
	 * 
	 * @RequestParam int num1, Model model) throws Exception{
	 * 
	 * BoardDTO dto = new BoardDTO();
	 * 
	 * dto.setBoardlike(num1);
	 * 
	 * dao.updateLike(dto); model.addAttribute("dto", dto);
	 * 
	 * return "board/wall";
	 * 
	 * }
	 */
	   
	   
	   //좋아요 count
	   
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
