package kr.co.assemble.dao;

import java.util.List;

import kr.co.assemble.dto.RecommentDTO;

public interface RecommentDAO {

   //댓글 작성
   public void insertComment(RecommentDTO dto);
   
   //댓글 조회
   public List<RecommentDTO> recommentlist(int bno);
   
}