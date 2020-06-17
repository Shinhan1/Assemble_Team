package kr.co.assemble.dao;

import java.util.List;

import kr.co.assemble.dto.AssembleInfoDTO;
import kr.co.assemble.dto.IdCheckDTO;
import kr.co.assemble.dto.MemberInfoDTO;
import kr.co.assemble.dto.testDTO;



// MemberInfo_DAO
public interface MI_interface {
	public List<AssembleInfoDTO> selectAllAI();
	public List<MemberInfoDTO> selectAll();
	public int selectMemberNo(MemberInfoDTO dto);
	public void insertOne(MemberInfoDTO dto);
	public void insertMember(MemberInfoDTO dto);
	public void updatePasswordOne(MemberInfoDTO dto);
	public void deleteOne(int no);
	public String selectAssembleName(String ai_assembleName);
	public IdCheckDTO selectId(IdCheckDTO dto1);
	public List<testDTO> findAssembleName(String mi_memEmail);
	public int duplicationId(MemberInfoDTO dto);
	public int duplicationAssembleName(String mi_assembleName);
	public int emailck(MemberInfoDTO dto);
	
}
