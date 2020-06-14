package kr.co.assemble.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.assemble.dao.GroupDAO;
import kr.co.assemble.dto.GroupDTO;

@Controller
public class bookmarksController {
	
	/*
	 * @Autowired GroupDAO dao;
	 * 
	 * public GroupDAO getDao() { return dao; }
	 */
	
	
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

	
	
}
