package kr.co.ass.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import kr.co.ass.dto.AssembleInfoDTO;



public class AssembleInfo_DAO implements AI_interface {
	
	@Inject
	SqlSession ss;
	
	public void setSs(SqlSession ss) {
		this.ss = ss;
	}
	
	@Override
	public List<AssembleInfoDTO> selectAll() {
		// TODO Auto-generated method stub
		
		return ss.selectList("selectAllAI");
	}

	@Override
	public AssembleInfoDTO selectOne(int no) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertOne(AssembleInfoDTO dto) {
		// TODO Auto-generated method stub
		ss.insert("insertOneAM", dto);
		ss.insert("insertOneAIAdmin", dto);
	}

	@Override
	public void updateOne(AssembleInfoDTO dto) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteOne(int no) {
		// TODO Auto-generated method stub

	}

}
