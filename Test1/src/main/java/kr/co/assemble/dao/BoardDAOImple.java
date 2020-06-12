package kr.co.assemble.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.assemble.dto.BoardDTO;
import kr.co.assemble.dto.Groupboard_Memberinfo_FileDTO;

@Repository
public class BoardDAOImple implements BoardDAO{

	@Autowired
	private SqlSession ss;
	
	
	public void setSs(SqlSession ss) {
		this.ss = ss;
	}
	

	//글쓰기
	@Override
	public void write(BoardDTO dto) {
		ss.insert("writeBoard", dto);
	}

	
	//그룹별 글 출력
	@Override
	public List<Groupboard_Memberinfo_FileDTO> boardlist(int groupno) {
		
		List<Groupboard_Memberinfo_FileDTO> list = ss.selectList("selectGroupBoard", groupno);
		
		return list;
	}

	//글 수정
	@Override
	public void updateBoard(BoardDTO dto) {
		ss.update("updateBoard", dto);
	}


	@Override
	public List<BoardDTO> selectOne(int bno) {
		// TODO Auto-generated method stub
		
		return ss.selectList("selectOneBno", bno);
	}

	//좋아요 update
	@Override
	public void updateLike(BoardDTO dto) {
		// TODO Auto-generated method stub
		ss.update("updateLike", dto);
		
	}

	//싫어요 update
	@Override
	public void updateHate(BoardDTO dto) {
		// TODO Auto-generated method stub
		ss.update("updateHate", dto);
		
	}

	//myfeed 조회 (내가 속한 모든 그룹의 글 가져오기)
	@Override
	public List<Groupboard_Memberinfo_FileDTO> selectMyFeed(int memberno) {
		
		List<Groupboard_Memberinfo_FileDTO> list = ss.selectList("myGroupBoard", memberno);
		
		return list;
	}
	
	//요청 글쓰기
		@Override
		public void insertRequest(BoardDTO dto) {
			ss.insert("insertRequest", dto);
		}


	
}
