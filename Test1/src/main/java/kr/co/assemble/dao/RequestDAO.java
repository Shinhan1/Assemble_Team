package kr.co.assemble.dao;

import kr.co.assemble.dto.RequestDTO;

public interface RequestDAO {
	//request update
	public void updateReq(RequestDTO dto);
	
	//bno 최신거로 가져오기
	public int newlyReqbno();
	
	//요청 status 업데이트 0=요청, 1=진행, 2=완료
	public int updateStatus(RequestDTO dto);
}
