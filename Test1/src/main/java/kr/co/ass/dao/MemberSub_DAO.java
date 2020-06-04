package kr.co.ass.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.co.ass.dto.MemberSubDTO;


public class MemberSub_DAO implements MS_interface {
	
	SqlSession ss;
	
	public void setSs(SqlSession ss) {
		this.ss = ss;
	} 

	@Override
	public List<MemberSubDTO> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MemberSubDTO selectOne(int no) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertOne(MemberSubDTO dto) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateOne(MemberSubDTO dto) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteOne(int no) {
		// TODO Auto-generated method stub

	}

}
