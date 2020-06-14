package kr.co.assemble.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.assemble.dto.MemReqGroupDTO;

@Repository
public class MemReqGroupDAO {
   @Autowired
   SqlSession ss;
   
   public void setSs(SqlSession ss) {
      this.ss = ss;
   }


   public List<MemReqGroupDTO> myReq(MemReqGroupDTO dto){
      List<MemReqGroupDTO> list = ss.selectList("myReq", dto);
      return list;
   }
   
}