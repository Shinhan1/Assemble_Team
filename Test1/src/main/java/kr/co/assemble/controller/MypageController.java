package kr.co.assemble.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import kr.co.assemble.dao.MemberSub_DAO;
import kr.co.assemble.dto.MemberSubDTO;

@Controller
public class MypageController {
	
	@Autowired
	MemberSub_DAO ms_dao;
	
	private String PROFILE = "editProfile";
	
	@RequestMapping(value="/profile")
	public String editprofile() {
		
		return PROFILE;
	}
	
	@RequestMapping(value="/assemble.io/{mi_assemblename}/modifySub")
	public String modifySub(@PathVariable("mi_assemblename") String assemblename,
			@ModelAttribute MemberSubDTO subdto, 
			HttpSession session,
			MultipartHttpServletRequest request) {
		
		subdto.setMs_memberno((int) session.getAttribute("memberno"));
		MultipartFile mf = request.getFile("ms_memprofileimg");

		
		String root_filePath = request.getSession().getServletContext().getRealPath("/");
        String attach_path = "resources/memprofileimg/";
		String originalFileName = mf.getOriginalFilename();
		String path = root_filePath + attach_path;
		String time = Long.toString(System.currentTimeMillis());
	    String safeFile = root_filePath + attach_path + time + originalFileName;

		
		File file = new File(path); 
		if(file.exists() == false){ 
			file.mkdirs(); 
		}

		try {
            mf.transferTo(new File(safeFile));
 
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
		
		subdto.setMs_memprofileImg(safeFile);
		System.out.println(subdto.getMs_memberno());
//		System.out.println(subdto.getMs_memgrade());
//		System.out.println(subdto.getMs_memprofileimg());
//		System.out.println(subdto.getMs_memteam());
//		System.out.println(subdto.getMs_memphone());
		ms_dao.updateMemberSub(subdto);		
		
		return "home";
	}
}
