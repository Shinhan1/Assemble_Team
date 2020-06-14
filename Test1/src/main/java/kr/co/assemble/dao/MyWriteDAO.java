package kr.co.assemble.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.assemble.dto.MyWriteDTO;

@Repository
public class MyWriteDAO {
   
   @Autowired
   SqlSession ss;

   public void setSs(SqlSession ss) {
      this.ss = ss;
   }
   
   
   //내가 쓴 글만 가져오기
   public List<MyWriteDTO> myWrite(MyWriteDTO dto){
      List<MyWriteDTO> list = ss.selectList("myWrite", dto);
      
      return list;
   }
   
   
}