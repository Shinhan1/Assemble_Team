package kr.co.assemble.dao;

import java.util.List;

import kr.co.assemble.dto.MemReqGroupDTO;
import kr.co.assemble.dto.RequestDTO;

public interface RequestDAO {
   //request update
   public void updateReq(RequestDTO dto);
   
   //bno 최신거로 가져오기
   public int newlyReqbno();
   
   //요청 status 업데이트 0=요청, 1=진행, 2=완료
   public int updateStatus(RequestDTO dto);
   
   //내가 받은 요청 모든 목록
   public List<MemReqGroupDTO> selectMyReq(MemReqGroupDTO dto);
   
   //내가 받은 요청 목록 상태별
//   public List<MemReqGroupDTO> selectMyReqStatus(MemReqGroupDTO dto);
   
 //내가 받은 요청 목록 상태별
   public List<RequestDTO> selectMyReqStatus(RequestDTO dto);
   
}