package kr.co.assemble.chat.dto;

// AssebleInfo Table - DTO

public class MemberDTO {
	private String mi_assemblename;
	private int mi_memberno;
	private String mi_memid;
	private String mi_mempw;
	private String mi_mememail;
	private int mi_admin;
	private String mi_regdate;
	private String mi_memname;
	
	public MemberDTO() {}

	public MemberDTO(String mi_assemblename, int mi_memberno, String mi_memid, String mi_mempw, String mi_mememail,
			int mi_admin, String mi_regdate, String mi_memname) {
		super();
		this.mi_assemblename = mi_assemblename;
		this.mi_memberno = mi_memberno;
		this.mi_memid = mi_memid;
		this.mi_mempw = mi_mempw;
		this.mi_mememail = mi_mememail;
		this.mi_admin = mi_admin;
		this.mi_regdate = mi_regdate;
		this.mi_memname = mi_memname;
	}

	public String getMi_assemblename() {
		return mi_assemblename;
	}

	public void setMi_assemblename(String mi_assemblename) {
		this.mi_assemblename = mi_assemblename;
	}

	public int getMi_memberno() {
		return mi_memberno;
	}

	public void setMi_memberno(int mi_memberno) {
		this.mi_memberno = mi_memberno;
	}

	public String getMi_memid() {
		return mi_memid;
	}

	public void setMi_memid(String mi_memid) {
		this.mi_memid = mi_memid;
	}

	public String getMi_mempw() {
		return mi_mempw;
	}

	public void setMi_mempw(String mi_mempw) {
		this.mi_mempw = mi_mempw;
	}

	public String getMi_mememail() {
		return mi_mememail;
	}

	public void setMi_mememail(String mi_mememail) {
		this.mi_mememail = mi_mememail;
	}

	public int getMi_admin() {
		return mi_admin;
	}

	public void setMi_admin(int mi_admin) {
		this.mi_admin = mi_admin;
	}

	public String getMi_regdate() {
		return mi_regdate;
	}

	public void setMi_regdate(String mi_regdate) {
		this.mi_regdate = mi_regdate;
	}

	public String getMi_memname() {
		return mi_memname;
	}

	public void setMi_memname(String mi_memname) {
		this.mi_memname = mi_memname;
	}
	
	
	
	
}
