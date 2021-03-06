package kr.co.assemble.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.assemble.dto.CategoryDTO;
import kr.co.assemble.dto.NavbarDTO;

@Repository
public class CategoryDAOImple implements CategoryDAO {

	@Autowired
	private SqlSession ss;	
	
	public void setSs(SqlSession ss) {
		this.ss = ss;
	}

	//카테고리 생성
	@Override
	public void insertCategory(CategoryDTO dto) {
		ss.insert("insertCategory", dto);
	}

	//update
	@Override
	public void updateOne(CategoryDTO dto) {
		
	}

	//전체 카테고리 조회
	@Override
	public List<NavbarDTO> selectCategory(NavbarDTO dto) {	
		//session 값 받아서 일치하는 assemblename만 출력
		List<NavbarDTO> list = ss.selectList("categoryGroup", dto);
		
		return list;
	}
	
	@Override
	public List<CategoryDTO> myCategory(CategoryDTO dto) {
		// TODO Auto-generated method stub
		List<CategoryDTO> list = ss.selectList("myCategory", dto);
		
		return list;
	}
	
	

	@Override
	public List<NavbarDTO> ingroupCategory(NavbarDTO dto) {
		// TODO Auto-generated method stub
		List<NavbarDTO> list = ss.selectList("ingroupcategory", dto);
		
		return list;
	}


	
	
	

}
