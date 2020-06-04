package kr.co.ass.dao;

import java.util.List;

import kr.co.ass.dto.AssembleInfoDTO;



// AssembleInfo_DAO
public interface AI_interface {
	public List<AssembleInfoDTO> selectAll();
	public AssembleInfoDTO selectOne(int no);
	public void insertOne(AssembleInfoDTO dto);
	public void updateOne(AssembleInfoDTO dto);
	public void deleteOne(int no);
}
