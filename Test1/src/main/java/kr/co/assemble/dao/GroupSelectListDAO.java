package kr.co.assemble.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.assemble.dto.ComposedMemberInfoDTO;
import kr.co.assemble.dto.GroupFileDTO;
import kr.co.assemble.dto.Groupboard_Memberinfo_FileDTO;

@Repository
public class GroupSelectListDAO {
	
	@Autowired
	SqlSession ss;
	
	
	//그룹에 속한 멤버 List (membername, id)
	public List<ComposedMemberInfoDTO> groupMemList(ComposedMemberInfoDTO dto){
		
		List<ComposedMemberInfoDTO> list = ss.selectList("selectGroupMember", dto);
		
		return list;
	}
	
	
	//그룹에 있는 사진만 가져오기
	public List<GroupFileDTO> groupFileList(GroupFileDTO dto){
		List<GroupFileDTO> list = ss.selectList("selectGroupImg", dto);
		
		return list; 
	}
	
	
	//그룹에 있는 사진을 제외한 파일 이름 가져오기
	public List<GroupFileDTO> groupFileName(GroupFileDTO dto) {
		
		List<GroupFileDTO> list = ss.selectList("selectGroupFileName", dto);
		
		return list;
	}
	
	
	//그룹보드에 요청여부가 1인것만 가져오기
	public List<Groupboard_Memberinfo_FileDTO> groupReq(Groupboard_Memberinfo_FileDTO dto){
		List<Groupboard_Memberinfo_FileDTO> list = ss.selectList("selectGroupReq", dto);
		return list;
	}
	
	//그룹보드와 bno가 같은 요청테이블에 요청status가 0=요청, 1=진행, 2=완료 일때
	public List<Groupboard_Memberinfo_FileDTO> groupReqStatus(Groupboard_Memberinfo_FileDTO dto){
		List<Groupboard_Memberinfo_FileDTO> list = ss.selectList("selectGroupReqStatus", dto);
		return list;
	}
	
	
	
	
	
	
	
	
	
}

