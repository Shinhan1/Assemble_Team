package kr.co.assemble.controller;

import java.util.List;

import javax.mail.Session;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.assemble.dao.BoardDAO;
import kr.co.assemble.dao.ComposedDAO;
import kr.co.assemble.dao.GroupSelectListDAO;
import kr.co.assemble.dto.BoardDTO;
import kr.co.assemble.dto.ComposedMemberInfoDTO;
import kr.co.assemble.dto.GroupFileDTO;
import kr.co.assemble.dto.Groupboard_Memberinfo_FileDTO;
import kr.co.assemble.dto.searchDTO;
import kr.co.assemble.dto.searchParamDTO;

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
			@RequestParam(value = "groupno") int groupno,
			@RequestParam(value = "memberno") int memberno, HttpSession session,
			@RequestParam(value = "contents") String contents, 
			@RequestParam(value = "filestatus") int filestatus, Model model) {
		
		BoardDTO dto = new BoardDTO();
		
		dto.setGroupno(groupno);
		dto.setMemberno(memberno);
		dto.setBoardcontents(contents);
		dao.write(dto);
		
		String mi_assembleName = (String)session.getAttribute("mi_assemblename");
		model.addAttribute("mi_assemblename", mi_assembleName);
		model.addAttribute("contents", contents);
		model.addAttribute("groupno", groupno);
		
		return "redirect:/assemble.io/{mi_assemblename}/g/{groupno}/wall";
	}
	
	
	@Autowired
	ComposedDAO cdao;
	
	@Autowired
	GroupSelectListDAO gslDao;
	
	//그룹별 게시글 조회 
		//그룹별 정보, 구성원 정보(Groups_Memberinfo_Composed_DTO)
		@RequestMapping("/assemble.io/{mi_assemblename}/g/{groupno}/wall")
		public String groupBoard(@PathVariable("groupno")int groupno, 
								@PathVariable("mi_assemblename") String assemblename, Model model){	
			//그룹장 이름 출력
			String list = cdao.selectGroupMastername(groupno);
			model.addAttribute("mastername", list);
		
			//그룹장 아이디 출력
			String list1 = cdao.selectGroupMasterId(groupno);
			model.addAttribute("masterid", list1);
			
			//그룹명 출력
			String groupname = cdao.selectGroupName(groupno);
			model.addAttribute("groupname", groupname);
			
			//그룹별 게시글 출력
			List<Groupboard_Memberinfo_FileDTO> list3 = dao.boardlist(groupno);
			model.addAttribute("thirdlist", list3);
			
			model.addAttribute("groupno", groupno);
			
			///////////////////////////////////////////////////
			//그룹의 멤버만 출력
			ComposedMemberInfoDTO dto = new ComposedMemberInfoDTO();
			dto.setGroupno(groupno);

			List<ComposedMemberInfoDTO> profilelist = gslDao.groupMemList(dto);

			System.out.println(groupno);

			model.addAttribute("profilelist", profilelist);
			///////////////////////////////////////////////////
			//그룹의 사진만 출력
			GroupFileDTO gfDto = new GroupFileDTO();
		    gfDto.setGroupno(groupno);
		      
		    List<GroupFileDTO> imagelist = gslDao.groupFileList(gfDto);
		      
		    model.addAttribute("imagelist", imagelist);
		    ///////////////////////////////////////////////////
			//그룹의 사진을 제외한 파일만 출력
		    gfDto.setGroupno(groupno);
		      
		    List<GroupFileDTO> filelist = gslDao.groupFileName(gfDto);
		    model.addAttribute("filelist", filelist);

			//System.out.println(groupno);-+
			return "board/wall";
		}
	
		
	
	//게시글 수정을 위한 bno로 해당 게시글 정보 조회
		@RequestMapping(value = "/selectBoard")
		public String selectbno(
				@RequestParam(value = "bno") int bno, Model model) {
			//System.out.println(bno);
			
			List<BoardDTO> list = dao.selectOne(bno);
			model.addAttribute("list", list);
			
			return "board/modify";
		}
		
		
		//게시글 수정
		@RequestMapping(value = "/modify")
		public String modifyBoard(
				@RequestParam(value = "bno") int bno,
				@RequestParam(value = "contents") String contents,
				@RequestParam(value = "groupno") int groupno, Model model) {
			
			BoardDTO dto = new BoardDTO();
			dto.setBno(bno);
			dto.setBoardcontents(contents);
			
			dao.updateBoard(dto);

					
			model.addAttribute("dto", dto);
			model.addAttribute("groupno", groupno);
			
			return "redirect:/wall";
		}
		
		
		//게시글 삭제 - 파일이랑 연결되있으면 파일에도 bno넘겨서 삭제(트리거 걸어놓음)
		@ResponseBody
		@RequestMapping(value = "/assemble.io/{mi_assemblename}/deleteBoard", method = RequestMethod.POST)
		public int deleteBoard(
				@RequestParam(value = "bno") int bno,
				@RequestParam(value = "groupno") int groupno, Model model) {
			
			int del = dao.deleteBoard(bno);
			model.addAttribute("groupno", groupno);
			
			return del;
		}
	   
		
		//공지사항 등록1, 취소0
		@RequestMapping(value = "/assemble.io/{mi_assemblename}/notice" , method = RequestMethod.POST)
		@ResponseBody
		public int updateNotice(
				@RequestParam(value = "groupno") int groupno,
				@RequestParam(value = "bno") int bno, Model model) {
			System.out.println(groupno);
			
			BoardDTO dto = new BoardDTO();
			dto.setBno(bno);
			int notice = dao.updateNotice(dto);
			System.out.println(notice);
			
			model.addAttribute("groupno", groupno);
			
			
			return notice;
		}
		
		

		//전체검색
		@RequestMapping(value = "/searchBoard")
		public String searchBoard(@RequestParam(value = "value") String value,
								  @RequestParam(value = "assemble") String assemble,Model model) {
			String value2 = "%"+value+"%";
			
			searchParamDTO dto = new searchParamDTO(value2, assemble);
			
			List<Groupboard_Memberinfo_FileDTO> list = dao.searchlist(dto);
			model.addAttribute("searchlist",list);
			model.addAttribute("value", value);
			
			return "search";
			
		}
	
	
	
	
	
	
	
	
	
	
}