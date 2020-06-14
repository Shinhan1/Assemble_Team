package kr.co.chat.dto;

public class MemberidDTO {
	private int memberno;
	private String memid;
	

	public MemberidDTO(int memberno, String memid) {
		super();
		this.memberno = memberno;
		this.memid = memid;
	}
	
	
	
	public int getMemberno() {
		return memberno;
	}
	public void setMemberno(int memberno) {
		this.memberno = memberno;
	}
	public String getMemid() {
		return memid;
	}
	public void setMemid(String memid) {
		this.memid = memid;
	}
	
	
	
	
	
}
