package kr.co.assemble.dto;

import java.util.Date;

public class FileDTO {
	private int fileno;
	private int bno;
	private String filename;
	private String filepath;
	private Date filedate;
	
	public FileDTO() {}

	public FileDTO(int fileno, int bno, String filename, String filepath, Date filedate) {
		super();
		this.fileno = fileno;
		this.bno = bno;
		this.filename = filename;
		this.filepath = filepath;
		this.filedate = filedate;
	}

	public int getFileno() {
		return fileno;
	}

	public void setFileno(int fileno) {
		this.fileno = fileno;
	}

	public int getBno() {
		return bno;
	}

	public void setBno(int bno) {
		this.bno = bno;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getFilepath() {
		return filepath;
	}

	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}

	public Date getFiledate() {
		return filedate;
	}

	public void setFiledate(Date filedate) {
		this.filedate = filedate;
	}
	
	
	
}
