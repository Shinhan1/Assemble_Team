package kr.co.assemble.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.assemble.dto.ComposedDTO;
import kr.co.assemble.dto.Groups_Memberinfo_Composed_DTO;

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
	
	//그룹별 정보, 구성원 정보(Groups_Memberinfo_Composed_DTO)
	//그룹장만
	public List<Groups_Memberinfo_Composed_DTO> selectGroupMaster(int groupno){
		List<Groups_Memberinfo_Composed_DTO> list = ss.selectList("selectGroupMaster", groupno);
		return list;
	}
	
	//그룹장이름
	public String selectGroupMastername(int groupno) {
		String mastername = ss.selectOne("selectGroupMasterName", groupno);
//		System.out.println(mastername);
//		System.out.println(groupno);
		return mastername;
	}
	
	//그룹장아이디
	public String selectGroupMasterId(int groupno) {
		String masterid = ss.selectOne("selectGroupMasterId", groupno);
		return masterid;
	}
	
	//그룹명
	public String selectGroupName(int groupno) {
		String groupname = ss.selectOne("selectGroupName", groupno);
		return groupname;
	}
	
	//그룹원 모두
	public List<Groups_Memberinfo_Composed_DTO> selectGroupMemberName(int groupno){
		List<Groups_Memberinfo_Composed_DTO> list = ss.selectList("selectGroupMemberName", groupno);
		return list;
	}
	
}
