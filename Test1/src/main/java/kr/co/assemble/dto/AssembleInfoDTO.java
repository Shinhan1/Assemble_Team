package kr.co.assemble.dto;

public class AssembleInfoDTO {
	private String mi_assemblename;
	private int mi_memberno;
	private String mi_memid;
	private String mi_regdate;
	
	public AssembleInfoDTO() {}
	
	public AssembleInfoDTO(String mi_assemblename, int mi_memberno, String mi_memid, String mi_regdate) {
		super();
		this.mi_assemblename = mi_assemblename;
		this.mi_memberno = mi_memberno;
		this.mi_memid = mi_memid;
		this.mi_regdate = mi_regdate;
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
	public String getMi_regdate() {
		return mi_regdate;
	}
	public void setMi_regdate(String mi_regdate) {
		this.mi_regdate = mi_regdate;
	}
	
	
	
	
	
	
}
