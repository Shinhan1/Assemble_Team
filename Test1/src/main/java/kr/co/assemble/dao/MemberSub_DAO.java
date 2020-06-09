package kr.co.assemble.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;

import kr.co.assemble.dto.MemberSubDTO;


public class MemberSub_DAO implements MS_interface {
	
	@Inject
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
