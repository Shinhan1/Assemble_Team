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
public class tasksController {
	
	/*
	 * @Autowired GroupDAO dao;
	 * 
	 * public GroupDAO getDao() { return dao; }
	 */
	
	
	//요청 첫 홈															===> 첫 홈에서 누르면 load 해놓음
	@RequestMapping(value = "/tasks")
	public String tasks() {
		return "jisoo/tasks";
	}
	
	//요청 - 요청
	@RequestMapping(value = "request/status0")
	public String tasks0() {
		return "jisoo/request/status0";
	}
	
	//요청 - 진행
	@RequestMapping(value = "request/status1")
	public String tasks1() {
		return "jisoo/request/status1";
	}
	
	//요청 - 완료
	@RequestMapping(value = "request/status2")
	public String tasks2() {
		return "jisoo/request/status2";
	}
	
	
	
}
