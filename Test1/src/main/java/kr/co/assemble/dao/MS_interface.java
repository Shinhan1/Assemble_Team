package kr.co.assemble.dao;

import java.util.List;

import kr.co.assemble.dto.MemberSubDTO;

// MemberSub_DAO

public interface MS_interface {
	public List<MemberSubDTO> selectAll();
	public MemberSubDTO selectOne(int no);
	public void insertMemberSub(MemberSubDTO dto);
	public void updateMemberSub(MemberSubDTO dto);
	public void deleteOne(int no);
}
