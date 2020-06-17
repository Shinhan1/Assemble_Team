package kr.co.assemble.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.assemble.dto.MemberInfoDTO;

@Repository
public class MemberDAO {

   @Autowired
   SqlSession ss;
   
   //어셈블에 있는 멤버 전체 조회
   
   public List<MemberInfoDTO> selectMember(String assemblename){
      
      List<MemberInfoDTO> memberlist = ss.selectList("selectmember", assemblename);
      
      return memberlist;
   }
   
   // 멤버 수 조회
   public int countMember(String assemblename) {
	   return ss.selectOne("membercount", assemblename);
	   
   }
   
}