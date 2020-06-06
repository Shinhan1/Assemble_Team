package kr.co.ass.dao;

import java.util.List;

import kr.co.ass.dto.AssembleInfoDTO;
import kr.co.ass.dto.IdCheckDTO;



// AssembleInfo_DAO
public interface AI_interface {
	public List<AssembleInfoDTO> selectAll();
	public AssembleInfoDTO selectOne(int no);
	public void insertOne(AssembleInfoDTO dto);
	public void updateOne(AssembleInfoDTO dto);
	public void deleteOne(int no);
	public String selectAssembleName(String ai_assembleName);
	public String selectId(IdCheckDTO dto1);
	public String selectPw(IdCheckDTO dto1);
}
