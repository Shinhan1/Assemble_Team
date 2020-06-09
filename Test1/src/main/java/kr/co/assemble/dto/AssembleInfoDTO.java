package kr.co.assemble.dto;

public class AssembleInfoDTO {
	private String mi_assembleName;
	private int mi_memberNo;
	private String mi_memID;
	private String mi_regdate;
	
	
	public AssembleInfoDTO() {}
	
	public AssembleInfoDTO(String mi_assembleName, int mi_memberNo, String mi_memID, String mi_regdate) {
		super();
		this.mi_assembleName = mi_assembleName;
		this.mi_memberNo = mi_memberNo;
		this.mi_memID = mi_memID;
		this.mi_regdate = mi_regdate;
	}

	public String getMi_assembleName() {
		return mi_assembleName;
	}

	public void setMi_assembleName(String mi_assembleName) {
		this.mi_assembleName = mi_assembleName;
	}

	public int getMi_memberNo() {
		return mi_memberNo;
	}

	public void setMi_memberNo(int mi_memberNo) {
		this.mi_memberNo = mi_memberNo;
	}

	public String getMi_memID() {
		return mi_memID;
	}

	public void setMi_memID(String mi_memID) {
		this.mi_memID = mi_memID;
	}

	public String getMi_regdate() {
		return mi_regdate;
	}

	public void setMi_regdate(String mi_regdate) {
		this.mi_regdate = mi_regdate;
	}
	
	
	
	
	
	
}
