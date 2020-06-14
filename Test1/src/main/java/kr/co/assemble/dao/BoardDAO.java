package kr.co.assemble.dao;

import java.util.List;

import kr.co.assemble.dto.BoardDTO;
import kr.co.assemble.dto.Groupboard_Memberinfo_FileDTO;

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
	public void deleteBoard(int bno);
	
	//request insert
	public void insertRequest(BoardDTO dto);
	

	//좋아요 update
	public void updateLike(BoardDTO dto);
	
	//싫어요 update
	public void updateHate(BoardDTO dto);
	
	
}
