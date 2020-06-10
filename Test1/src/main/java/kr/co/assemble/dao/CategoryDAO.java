package kr.co.assemble.dao;

import java.util.List;

import kr.co.assemble.dto.CategoryDTO;

public interface CategoryDAO {
	// 카테고리'만' 생성 - 그룹번호는 0으로 입력
	public void insertCategory(CategoryDTO dto);

	// 카테고리가 지정된 그룹생성 - 그룹번호가 트리거로 insert되있는 경우니까 update해주어야함
	public void updateOne(CategoryDTO dto);
	
	//selectCategory
	public List<CategoryDTO> selectCategory();
}
