package kr.co.assemble.dto;

public class IdCheckDTO {
	private int mi_memberno;
	private String mi_assemblename;
	private String mi_memid;
	private String mi_mempw;
	private String mi_memname;
	
	public IdCheckDTO() {
		super();
	}

	public IdCheckDTO(int mi_memberno, String mi_assemblename, String mi_memid, String mi_mempw, String mi_memname) {
		super();
		this.mi_memberno = mi_memberno;
		this.mi_assemblename = mi_assemblename;
		this.mi_memid = mi_memid;
		this.mi_mempw = mi_mempw;
		this.mi_memname = mi_memname;
	}

	public int getMi_memberno() {
		return mi_memberno;
	}

	public void setMi_memberno(int mi_memberno) {
		this.mi_memberno = mi_memberno;
	}

	public String getMi_assemblename() {
		return mi_assemblename;
	}

	public void setMi_assemblename(String mi_assemblename) {
		this.mi_assemblename = mi_assemblename;
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

	public String getMi_memname() {
		return mi_memname;
	}

	public void setMi_memname(String mi_memname) {
		this.mi_memname = mi_memname;
	}
	
	
	
	
	
	
}
