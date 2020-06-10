package kr.co.assemble.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.assemble.dto.ComposedDTO;

@Repository
public class ComposedDAO {
	
	@Autowired
	SqlSession ss;
	
	
	//그룹초대 - 유효성검사로 category admin 컬럼이 1인 경우만 가능
	public void insertMem(ComposedDTO dto) {
		ss.insert("inviteGroupMem", dto);
	}
	
	//검색
	public List<ComposedDTO> selectComposed(){
		List<ComposedDTO> list = ss.selectList("composedList");
		return list;
	}
	
}
