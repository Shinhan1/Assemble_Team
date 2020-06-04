package kr.co.ass.dao;

import java.util.List;

import kr.co.ass.dto.MemberSubDTO;

// MemberSub_DAO

public interface MS_interface {
	public List<MemberSubDTO> selectAll();
	public MemberSubDTO selectOne(int no);
	public void insertOne(MemberSubDTO dto);
	public void updateOne(MemberSubDTO dto);
	public void deleteOne(int no);
}
