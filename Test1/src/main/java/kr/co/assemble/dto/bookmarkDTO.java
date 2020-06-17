package kr.co.assemble.dto;

public class bookmarkDTO {
	private int bno;
	private int groupno;
	private int memberno;
	private String mark_memno;
	
	
	public bookmarkDTO(int bno, int memberno) {
		super();
		this.bno = bno;
		this.memberno = memberno;
		
	}
	
	
	
	public bookmarkDTO(int bno, int groupno, int memberno, String mark_memno) {
		super();
		this.bno = bno;
		this.groupno = groupno;
		this.memberno = memberno;
		this.mark_memno = mark_memno;
	}


	public bookmarkDTO() {
		// TODO Auto-generated constructor stub
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


	public int getMemberno() {
		return memberno;
	}


	public void setMemberno(int memberno) {
		this.memberno = memberno;
	}


	public String getMark_memno() {
		return mark_memno;
	}


	public void setMark_memno(String mark_memno) {
		this.mark_memno = mark_memno;
	}
	
	
	
	
	
	
}