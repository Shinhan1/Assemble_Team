package kr.co.assemble.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


import kr.co.assemble.dao.BoardDAO;
import kr.co.assemble.dao.FileDAO;
import kr.co.assemble.dto.BoardDTO;
import kr.co.assemble.dto.FileDTO;

@Controller
public class FileController {

	@Autowired
	FileDAO dao;
	
	@Autowired
	BoardDAO bdao;
	
	@Autowired
	PlatformTransactionManager transactionManager;
	
	
	
	@PostMapping("/upload")
    public String upload(
    	@RequestParam(value = "uploadFile", required = false) MultipartFile mf, HttpServletRequest request,
    	@RequestParam(value = "grNum") int grNum,
		@RequestParam(value = "cgNum") int cgNum,
		@RequestParam(value = "memNum") int memNum,
		@RequestParam(value = "contents") String contents,
		@RequestParam(value = "fileStatus") int fileStatus, Model model) {
		
		
		System.out.println("file in : " + mf.getOriginalFilename());

		TransactionStatus status = this.transactionManager.getTransaction(new DefaultTransactionDefinition());
		
		BoardDTO bdto = new BoardDTO();
		
		bdto.setGroupno(grNum);
		bdto.setCategoryno(cgNum);
		bdto.setMemberno(memNum);
		bdto.setBoardcontents(contents);
		bdto.setFilestatus(1);
		bdao.write(bdto);		
		
		
		
		this.transactionManager.commit(status);
		
		
		String root_filePath = request.getSession().getServletContext().getRealPath("/");
        String attach_path = "resources/uploadFiles/";
		String originalFileName = mf.getOriginalFilename();
        
        String safeFile = root_filePath + attach_path + originalFileName;
        
        //파일 다운로드할 때
        //System.currentTimeMillis() + originalFileName
            
        try {
            mf.transferTo(new File(safeFile));
 
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        int bno = dao.filenewly();
        System.out.println(bno);
        
        FileDTO fdto = new FileDTO();
        fdto.setFilename(originalFileName);
        fdto.setFilepath(root_filePath+attach_path);
        fdto.setBno(bno);
        dao.updateFile(fdto);
        
        model.addAttribute("fileName", originalFileName);
        model.addAttribute("groupno", grNum);
        
        return "redirect:/wall";
	}

	
	
	//파일 다운로드
	@RequestMapping(value = "download")
	public void download(HttpServletRequest request, HttpServletResponse response){
		
        String filename = request.getParameter("fileName");
//      String downname = System.currentTimeMillis() + filename;
        String realPath = request.getSession().getServletContext().getRealPath("/")+"resources/uploadFiles/";
        System.out.println(realPath);


		String fileName = filename;
		

		response.setContentType("application/octet-stream");		
		response.setHeader("Content-Disposition", "attachment; filename=\"" + filename + "\";");
		response.setHeader("Content-Transfer-Encoding", "binary");
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Expires", "-1");
		
		try (
			FileInputStream fis = new FileInputStream(filename);
			OutputStream out = response.getOutputStream();
		){
			int readCount = 0;
			byte[] buffer = new byte[1024];
		    while((readCount = fis.read(buffer)) != -1)
		    out.write(buffer,0,readCount);
			
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
//		try (
//			FileInputStream fis = new FileInputStream(fileName);
//			OutputStream out = response.getOutputStream();
//		){
//			int readCount = 0;
//			byte[] buffer = new byte[1024];
//		    while((readCount = fis.read(buffer)) != -1)
//		    out.write(buffer,0,readCount);
//		    
//		} catch (Exception e) {
//		   	// TODO Auto-generated catch block
//		 	e.printStackTrace();
//		}
	}
}


	
	
	
	
