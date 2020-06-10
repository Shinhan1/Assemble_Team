package kr.co.assemble.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import kr.co.assemble.dto.AssembleInfoDTO;
import kr.co.assemble.dto.IdCheckDTO;
import kr.co.assemble.dto.MemberInfoDTO;



public class MemberInfo_DAO implements MI_interface {
	
	@Inject
	SqlSession ss;
	
	public void setSs(SqlSession ss) {
		this.ss = ss;
	}
	
	@Override
	public List<AssembleInfoDTO> selectAllAI() {
		// TODO Auto-generated method stub
		return ss.selectList("selectAllAI");
	}
	
	@Override
	public List<MemberInfoDTO> selectAll() {
		// TODO Auto-generated method stub
		
		return ss.selectList("selectAll");
	}
	
	@Override
	public String selectAssembleName(String mi_assembleName) {
		// TODO Auto-generated method stub
		return ss.selectOne("selectAssembleName", mi_assembleName);
	}
	
	@Override
	public List<String> findAssembleName(String mi_memEmail) {
		// TODO Auto-generated method stub
		return ss.selectList("findAssembleName", mi_memEmail);
	}

	@Override
	public MemberInfoDTO selectOne(int no) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public IdCheckDTO selectId(IdCheckDTO dto1) {
		// TODO Auto-generated method stub
		return ss.selectOne("selectIdEncode", dto1);
	}
	
//	@Override
//	public String selectPw(IdCheckDTO dto1) {
//		// TODO Auto-generated method stub
//		return ss.selectOne("selectPw", dto1);
//	}
	


	@Override
	public void insertOne(MemberInfoDTO dto) {
		// TODO Auto-generated method stub
		ss.insert("insertOneAM", dto);
		ss.insert("insertOneAssemble", dto);
		ss.insert("insertOneMIAdmin", dto);
	}

	@Override
	public void updateOne(MemberInfoDTO dto) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteOne(int no) {
		// TODO Auto-generated method stub

	}

}
