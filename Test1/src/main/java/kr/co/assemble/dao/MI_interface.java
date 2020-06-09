package kr.co.assemble.dao;

import java.util.List;

import kr.co.assemble.dto.AssembleInfoDTO;
import kr.co.assemble.dto.IdCheckDTO;
import kr.co.assemble.dto.MemberInfoDTO;



// MemberInfo_DAO
public interface MI_interface {
	public List<AssembleInfoDTO> selectAllAI();
	public List<MemberInfoDTO> selectAll();
	public MemberInfoDTO selectOne(int no);
	public void insertOne(MemberInfoDTO dto);
	public void updateOne(MemberInfoDTO dto);
	public void deleteOne(int no);
	public String selectAssembleName(String ai_assembleName);
//	public String selectId(IdCheckDTO dto1);
//	public String selectPw(IdCheckDTO dto1);
	public IdCheckDTO selectId(IdCheckDTO dto1);
}
