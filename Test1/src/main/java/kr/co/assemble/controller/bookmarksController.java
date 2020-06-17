package kr.co.assemble.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.assemble.dao.BoardDAO;
import kr.co.assemble.dao.GroupDAO;
import kr.co.assemble.dto.GroupDTO;
import kr.co.assemble.dto.bookmarkDTO;

@Controller
public class bookmarksController {
	
	
	  @Autowired 
	  BoardDAO dao;
	  
	  public BoardDAO getDao() { return dao; }
	 
	
	
	//북마크 첫 홈 - 북마크 순															===> 첫 홈에서 누르면 load 해놓음
	@RequestMapping(value = "/bookmarks")
	public String bookmarks() {
		return "jisoo/bookmarks";
	}
	
	//북마크 - 글 작성일 순
	@RequestMapping(value = "bookmark/sort1")
	public String tasks0() {
		return "jisoo/bookmark/sort1";
	}
	
	@ResponseBody
	@RequestMapping(value = "/bookmarkinsert")
	public void bookmarkinsert(bookmarkDTO dto ) {
			System.out.println("이거는"+dto.getGroupno());
			dao.insertBookmark(dto);
	}
	
	@ResponseBody
	@RequestMapping(value = "/bookmarkdelete")
	public void bookmarkdelete(bookmarkDTO dto ) {

			dao.deleteBookmark(dto);
	}
	
	@RequestMapping(value = "/selectBookmark")
	public String selectBookmark(Model model, HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		int memberno = (Integer)session.getAttribute("memberno");
		
		
		List<bookmarkDTO> list = dao.selectBookmark(memberno);
		
		model.addAttribute("selectBookmark", list);
		
		return "board/bookmark"; 
	}
	

	
	
}