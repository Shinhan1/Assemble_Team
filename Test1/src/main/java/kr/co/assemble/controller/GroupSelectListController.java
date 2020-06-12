package kr.co.assemble.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.assemble.dao.GroupSelectListDAO;
import kr.co.assemble.dto.ComposedMemberInfoDTO;
import kr.co.assemble.dto.GroupDTO;
import kr.co.assemble.dto.GroupFileDTO;
import kr.co.assemble.dto.Groupboard_Memberinfo_FileDTO;

@Controller
public class GroupSelectListController {
	
	@Autowired
	GroupSelectListDAO dao;

	
	public GroupSelectListDAO getDao() {
		return dao;
	}


	//전체 셀렉트 폼 띄우기
	@RequestMapping(value = "/groupSelect")
	public String selectForm() {
		return "board/groupSelect";
	}
	
	
	//그룹 멤버 리스트
	@RequestMapping(value = "/groupMember")
	public String selectMember(
			@RequestParam(value = "groupno") int groupno, Model model) {
		
		ComposedMemberInfoDTO dto = new ComposedMemberInfoDTO();
		dto.setGroupno(groupno);
		
		List<ComposedMemberInfoDTO> list = dao.groupMemList(dto);
		
		model.addAttribute("list", list);
		model.addAttribute("groupno", groupno);
		
		
		return "board/groupSelectList";
	}
	
	
	//그룹 사진 리스트
	@RequestMapping(value = "/groupImg")
	public String selectImg(
			@RequestParam(value = "groupno") int groupno, Model model) {
		
		GroupFileDTO dto = new GroupFileDTO();
		dto.setGroupno(groupno);
		
		List<GroupFileDTO> list = dao.groupFileList(dto);
		
		model.addAttribute("list", list);
		model.addAttribute("groupno", groupno);
		
		return "board/groupSelectList";
	}
	
	
	//그룹 사진을 제외한 파일 가져오기
	@RequestMapping(value = "/groupFile")
	public String selectFiles(
			@RequestParam(value = "groupno") int groupno, Model model) {
		
		GroupFileDTO dto = new GroupFileDTO();
		dto.setGroupno(groupno);
		
		List<GroupFileDTO> list = dao.groupFileName(dto);
		
		model.addAttribute("list", list);
		model.addAttribute("groupno", groupno);

		return "board/groupSelectList";
	}
	
	
	//그룹별 요청이 존재하는 게시글만 조회
	@RequestMapping(value = "/groupReqList")
	public String selectReqList(
			@RequestParam(value = "groupno") int groupno, Model model) {
		
		Groupboard_Memberinfo_FileDTO dto = new Groupboard_Memberinfo_FileDTO();
		dto.setGroupno(groupno);
		
		List<Groupboard_Memberinfo_FileDTO> list = dao.groupReq(dto);
		
		model.addAttribute("list", list);
		model.addAttribute("groupno", groupno);
		
		return "board/groupSelectList";	
	}
	
	
	//그룹별 요청 요청status 따라서 다르게 출력
	@RequestMapping(value = "/groupReqStatus")
	public String selectReqStatus(
			@RequestParam(value = "status") int status,
			@RequestParam(value = "groupno") int groupno, Model model) {
		
		Groupboard_Memberinfo_FileDTO dto = new Groupboard_Memberinfo_FileDTO();
		dto.setReqstatus(status);
		dto.setGroupno(groupno);
		
		List<Groupboard_Memberinfo_FileDTO> list = dao.groupReqStatus(dto);
		
		model.addAttribute("list", list);
		model.addAttribute("groupno", groupno);
		
		return "board/groupSelectReq";	
	}
	
	
	
	
	
	
	
	
	
}
