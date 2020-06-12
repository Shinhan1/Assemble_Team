package kr.co.assemble.dao;


import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.assemble.dto.FileDTO;

@Repository
public class FileDAO {
	
	@Autowired
	SqlSession ss;
	

	//파일 최신 번호 가져오기
	public int filenewly() {
		return ss.selectOne("filenoNewly");
	}
	
	//트리거로 추가된 파일의 업데이트
	public void updateFile(FileDTO dto) {
		ss.update("updateFile", dto);
	}
	
	//파일 이름 하나 얻기
	public String fileName(int bno) {
		return ss.selectOne("selectfileOne", bno);
	}
	
	//파일 리스트 출력
	public List<FileDTO> fileList(int bno){
		return ss.selectList("selectFileList", bno);
	}
	
	//파일 수정
	public void changeFile(FileDTO dto) {
		ss.update("changeFile", dto);
	}
	
}
