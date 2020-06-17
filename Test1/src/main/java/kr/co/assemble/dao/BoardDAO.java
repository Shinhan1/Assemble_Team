package kr.co.assemble.dao;

import java.util.List;

import kr.co.assemble.dto.BoardDTO;
import kr.co.assemble.dto.Groupboard_Memberinfo_FileDTO;
import kr.co.assemble.dto.bookmarkDTO;
import kr.co.assemble.dto.searchDTO;
import kr.co.assemble.dto.searchParamDTO;

public interface BoardDAO {
	//글쓰기 - 일반
	public void write(BoardDTO dto);
	
	//글 수정
	public void updateBoard(BoardDTO dto);
	
	//그룹별 글 전체 조회(타임라인)
	public List<Groupboard_Memberinfo_FileDTO> boardlist(int groupno);
	
	//myfeed 조회 (내가 속한 모든 그룹의 글 가져오기)
	public List<Groupboard_Memberinfo_FileDTO> selectMyFeed(int memberno);
	
	
	// bno로 contents 가져오기 위해 조회
	public List<BoardDTO> selectOne(int bno);

	// 글삭제
	public int deleteBoard(int bno);
	
	//request insert
	public void insertRequest(BoardDTO dto);
	

	//좋아요 update
	public void updateLike(BoardDTO dto);
	
	//싫어요 update
	public void updateHate(BoardDTO dto);
	
	//공지사항 등록, 취소
	public int
	updateNotice(BoardDTO dto);
	
	//북마크 등록,취소
	public void insertBookmark(bookmarkDTO dto);
	
	public void deleteBookmark(bookmarkDTO dto);
	
	//북마크 조회
	public List<bookmarkDTO> selectBookmark(int memberno);
	
	
	public List<Groupboard_Memberinfo_FileDTO> searchlist(searchParamDTO searchparamdto);
	
}