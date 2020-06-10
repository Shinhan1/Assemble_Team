package kr.co.assemble.dto;

public class IdCheckDTO {
	private int mi_memberNo;
	private String mi_assembleName;
	private String mi_memID;
	private String mi_memPw;
	private String mi_memName;
	
	public IdCheckDTO() {
		super();
	}
	public IdCheckDTO(int mi_memberNo, String mi_assembleName, 
			String mi_memID, String mi_memPw, String mi_memName) {
		super();
		this.mi_memberNo = mi_memberNo;
		this.mi_assembleName = mi_assembleName;
		this.mi_memID = mi_memID;
		this.mi_memPw = mi_memPw;
		this.mi_memName = mi_memName;
	}
	
	
	public int getMi_memberNo() {
		return mi_memberNo;
	}
	public void setMi_memberNo(int mi_memberNo) {
		this.mi_memberNo = mi_memberNo;
	}
	public String getmi_memID() {
		return mi_memID;
	}
	public void setmi_memID(String mi_memID) {
		this.mi_memID = mi_memID;
	}
	public String getmi_memPw() {
		return mi_memPw;
	}
	public void setmi_memPw(String mi_memPw) {
		this.mi_memPw = mi_memPw;
	}
	public String getmi_assembleName() {
		return mi_assembleName;
	}
	public void setmi_assembleName(String mi_assembleName) {
		this.mi_assembleName = mi_assembleName;
	}
	public String getMi_memName() {
		return mi_memName;
	}
	public void setMi_memName(String mi_memName) {
		this.mi_memName = mi_memName;
	}
	
	
	
	
}
