package kr.co.assemble.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.assemble.dto.RequestDTO;

@Repository
public class RequestDAOImple implements RequestDAO {
   
   @Autowired
   SqlSession ss;
   
   
   
   public void setSs(SqlSession ss) {
      this.ss = ss;
   }

   //자동으로 bno가 추가되어있는 요청테이블에 바로 요청 받는 사람 업데이트
   @Override
   public void updateReq(RequestDTO dto) {
      ss.update("requestUpdate", dto);
   }
   
   //요청에서 가장 최근에 들어온 bno 조회
   @Override
   public int newlyReqbno() {
      return ss.selectOne("requestNewly");
   }

   //요청 status 업데이트 0=요청, 1=진행, 2=완료
   @Override
   public int updateStatus(RequestDTO dto) {
      return ss.update("updateStatus", dto);
   }
   
   

}