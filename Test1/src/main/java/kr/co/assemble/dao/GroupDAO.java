package kr.co.assemble.dao;

import java.util.List;

import kr.co.assemble.dto.GroupDTO;

public interface GroupDAO {
	//그룹 생성 - 이때 무조건 미분류그룹의(공동게시판) 카테고리로 들어가게됨. (후에 이동)
	public void insertGroup(GroupDTO dto);	
	
	//그룹의 카테고리 변경
	public void updateOne(GroupDTO dto);
	
	//그룹의 이름 변경
	public void updateName(GroupDTO dto);
	
	//그룹 전체 조회
	public List<GroupDTO> selectGroup();
	
	//카테고리별 그룹조회
//	public List<GroupDTO> grouplist(int categoryno);
	
	public List<GroupDTO> grouplist();
	
}
