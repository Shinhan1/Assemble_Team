package kr.co.assemble.dto;

import java.util.Date;

public class BoardDTO {
	
	private int bno;
	private int groupno;
	private int categoryno;
	private int memberno;
	private Date boarddate;
	private String boardcontents;
	private int boardnotice;
	private int boardlike;
	private int boardhate;
	private int requestboolean;
	private int filestatus;
	
	public BoardDTO() {}

	public BoardDTO(int bno, int groupno, int categoryno, int memberno, Date boarddate, String boardcontents,
			int boardnotice, int boardlike, int boardhate, int requestboolean, int filestatus) {
		super();
		this.bno = bno;
		this.groupno = groupno;
		this.categoryno = categoryno;
		this.memberno = memberno;
		this.boarddate = boarddate;
		this.boardcontents = boardcontents;
		this.boardnotice = boardnotice;
		this.boardlike = boardlike;
		this.boardhate = boardhate;
		this.requestboolean = requestboolean;
		this.filestatus = filestatus;
	}

	public int getBno() {
		return bno;
	}

	public void setBno(int bno) {
		this.bno = bno;
	}

	public int getGroupno() {
		return groupno;
	}

	public void setGroupno(int groupno) {
		this.groupno = groupno;
	}

	public int getCategoryno() {
		return categoryno;
	}

	public void setCategoryno(int categoryno) {
		this.categoryno = categoryno;
	}

	public int getMemberno() {
		return memberno;
	}

	public void setMemberno(int memberno) {
		this.memberno = memberno;
	}

	public Date getBoarddate() {
		return boarddate;
	}

	public void setBoarddate(Date boarddate) {
		this.boarddate = boarddate;
	}

	public String getBoardcontents() {
		return boardcontents;
	}

	public void setBoardcontents(String boardcontents) {
		this.boardcontents = boardcontents;
	}

	public int getBoardnotice() {
		return boardnotice;
	}

	public void setBoardnotice(int boardnotice) {
		this.boardnotice = boardnotice;
	}

	public int getBoardlike() {
		return boardlike;
	}

	public void setBoardlike(int boardlike) {
		this.boardlike = boardlike;
	}

	public int getBoardhate() {
		return boardhate;
	}

	public void setBoardhate(int boardhate) {
		this.boardhate = boardhate;
	}

	public int getRequestboolean() {
		return requestboolean;
	}

	public void setRequestboolean(int requestboolean) {
		this.requestboolean = requestboolean;
	}

	public int getFilestatus() {
		return filestatus;
	}

	public void setFilestatus(int filestatus) {
		this.filestatus = filestatus;
	}

	
	
	
	
}
