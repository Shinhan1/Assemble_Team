package kr.co.assemble.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
import kr.co.assemble.dao.RequestDAO;
import kr.co.assemble.dto.BoardDTO;
import kr.co.assemble.dto.FileDTO;
import kr.co.assemble.dto.RequestDTO;

@Controller
public class FileController {

	@Autowired
	FileDAO dao;

	@Autowired
	BoardDAO bdao;

	@Autowired
	RequestDAO reqdao;

	@Autowired
	PlatformTransactionManager transactionManager;

	// 요청이 없고 파일이 있을 경우 보드에 입력
	@PostMapping("/upload")
	public String upload(
			@RequestParam(value = "uploadFile", required = false) MultipartFile mf, HttpServletRequest request, 
			@RequestParam(value = "groupno") int groupno, HttpSession session,
			@RequestParam(value = "memberno") int memberno, @RequestParam(value = "contents") String contents,
			@RequestParam(value = "filestatus") int filestatus, Model model) {

		System.out.println("file in : " + mf.getOriginalFilename());

		TransactionStatus status = this.transactionManager.getTransaction(new DefaultTransactionDefinition());

		BoardDTO bdto = new BoardDTO();

		bdto.setGroupno(groupno);
		bdto.setMemberno(memberno);
		bdto.setBoardcontents(contents);
		bdto.setFilestatus(1);
		bdao.write(bdto);

		this.transactionManager.commit(status);

		String root_filePath = request.getSession().getServletContext().getRealPath("/");
		String attach_path = "resources/uploadFiles/";
		String originalFileName = mf.getOriginalFilename();
		String time = Long.toString(System.currentTimeMillis());
		String safeFile = root_filePath + attach_path + time + originalFileName;

		// 파일 다운로드할 때
		// System.currentTimeMillis() + originalFileName

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
		fdto.setFilename(time + originalFileName);
		fdto.setFilepath(root_filePath + attach_path);
		fdto.setBno(bno);
		dao.updateFile(fdto);
		
		String mi_assembleName = (String)session.getAttribute("mi_assemblename");
		model.addAttribute("mi_assembleName", mi_assembleName);
		model.addAttribute("fileName", originalFileName);
		model.addAttribute("groupno", groupno);

		return "redirect:/assemble.io/{mi_assemblename}/g/{groupno}/wall";
	}

	// 요청이 있고 파일이 있을 경우 보드에 입력
	@PostMapping(value = "/requestFileOk")
	public String request(@RequestParam(value = "uploadFile", required = false) MultipartFile mf, HttpServletRequest request, 
			@RequestParam(value = "groupno") int groupno, HttpSession session,
			@RequestParam(value = "memberno") int memberno, 
			@RequestParam(value = "response") String response,
			@RequestParam(value = "contents") String contents, Model model) {

		TransactionStatus status = this.transactionManager.getTransaction(new DefaultTransactionDefinition());

		BoardDTO dto = new BoardDTO();
		dto.setGroupno(groupno);
		dto.setMemberno(memberno);
		dto.setBoardcontents(contents);
		dto.setFilestatus(1);

		bdao.insertRequest(dto);

		this.transactionManager.commit(status);

		// 요청받는사람 업데이트
		RequestDTO reqdto = new RequestDTO();
		int bno = reqdao.newlyReqbno();

		reqdto.setBno(bno);
		reqdto.setResponseid(response);
		reqdao.updateReq(reqdto);

		String root_filePath = request.getSession().getServletContext().getRealPath("/");
		String attach_path = "resources/uploadFiles/";
		String originalFileName = mf.getOriginalFilename();
		String time = Long.toString(System.currentTimeMillis());
		String safeFile = root_filePath + attach_path + time + originalFileName;

		// 파일 다운로드할 때
		// System.currentTimeMillis() + originalFileName

		try {
			mf.transferTo(new File(safeFile));

		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		int bno2 = dao.filenewly();
		System.out.println(bno);

		FileDTO fdto = new FileDTO();
		fdto.setFilename(time + originalFileName);
		fdto.setFilepath(root_filePath + attach_path);
		fdto.setBno(bno);
		dao.updateFile(fdto);
		
		String mi_assembleName = (String)session.getAttribute("mi_assemblename");
		model.addAttribute("mi_assemblename", mi_assembleName);
		model.addAttribute("fileName", originalFileName);
		model.addAttribute("groupno", groupno);

		return "redirect:/assemble.io/{mi_assemblename}/g/{groupno}/wall";
	}

	// 파일 다운로드
	@RequestMapping(value = "download")
	public void download(HttpServletRequest request, HttpServletResponse response) {

		String filename = request.getParameter("fileName");
		String realPath = request.getSession().getServletContext().getRealPath("/") + "resources/uploadFiles/";
		System.out.println(realPath);

		String fileName = filename;

		response.setContentType("application/octet-stream");
		response.setHeader("Content-Disposition", "attachment; filename=\"" + filename + "\";");
		response.setHeader("Content-Transfer-Encoding", "binary");
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Expires", "-1");

		try (FileInputStream fis = new FileInputStream(realPath + fileName);
				OutputStream out = response.getOutputStream();) {
			int readCount = 0;
			byte[] buffer = new byte[1024];
			while ((readCount = fis.read(buffer)) != -1)
				out.write(buffer, 0, readCount);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
