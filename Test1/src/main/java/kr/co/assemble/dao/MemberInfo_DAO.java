package kr.co.assemble.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import kr.co.assemble.dto.AssembleInfoDTO;
import kr.co.assemble.dto.IdCheckDTO;
import kr.co.assemble.dto.MemberInfoDTO;
import kr.co.assemble.dto.testDTO;


@Repository
public class MemberInfo_DAO implements MI_interface {
	
	@Autowired
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
	
	// 어셈블명 조회
	@Override
	public String selectAssembleName(String mi_assembleName) {
		// TODO Auto-generated method stub
		System.out.println(mi_assembleName);
		return ss.selectOne("selectAssembleName", mi_assembleName);
	}
	
	// 이메일로 어셈블명들 조회
	@Override
	public List<testDTO> findAssembleName(String mi_memEmail) {
		// TODO Auto-generated method stub
		return ss.selectList("findAssembleName", mi_memEmail);
	}
	
	// 회원가입 세부내용 작성하기 위해 sub의 memberno를 조회 하기 위한 select문
	@Override
	public int selectMemberNo(MemberInfoDTO dto) {
		// TODO Auto-generated method stub
		return ss.selectOne("selectMemberNo", dto);
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
	public void insertMember(MemberInfoDTO dto) {
		ss.insert("insertOneAM", dto);
		ss.insert("insertOneMIMember", dto);
	}

	@Override
	public void updateOne(MemberInfoDTO dto) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteOne(int no) {
		// TODO Auto-generated method stub

	}
	@Override
	public int duplicationAssembleName(String mi_assembleName) {
		// TODO Auto-generated method stub
		return ss.selectOne("countAssembleName", mi_assembleName);
	}
	
	@Override
	public int duplicationId(MemberInfoDTO dto) {
		// TODO Auto-generated method stub
		System.out.println(dto.getMi_assemblename());
		System.out.println(dto.getMi_memid());
		return ss.selectOne("countMemberId", dto);
	}

}
