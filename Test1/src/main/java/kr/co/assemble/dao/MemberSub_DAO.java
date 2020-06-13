package kr.co.assemble.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.assemble.dto.MemberSubDTO;

// 상세 회원가입
@Repository
public class MemberSub_DAO implements MS_interface {
	
	@Autowired
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
	
	// 회원가입 Sub 입력 (부서, 전화번호, 이미지 등)
	@Override
	public void insertMemberSub(MemberSubDTO dto) {
		// TODO Auto-generated method stub
	}
	
	@Override
	public void updateMemberSub(MemberSubDTO dto) {
		// TODO Auto-generated method stub
		ss.insert("updateMemberSub", dto);
	}

	@Override
	public void deleteOne(int no) {
		// TODO Auto-generated method stub

	}

}
