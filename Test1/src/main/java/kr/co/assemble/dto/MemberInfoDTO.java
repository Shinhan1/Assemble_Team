package kr.co.assemble.dto;

// AssebleInfo Table - DTO

public class MemberInfoDTO {
	private String mi_assembleName;
	private int mi_memberNo;
	private String mi_memID;
	private String mi_memPw;
	private String mi_memEmail;
	private int mi_admin;
	private String mi_regdate;
	private String mi_memName;
	
	public MemberInfoDTO() {}
	
	public MemberInfoDTO(String mi_assembleName, int mi_memberNo, String mi_memID, String mi_memPw, String mi_memEmail,
			int mi_admin, String mi_regdate, String mi_memName) {
		super();
		this.mi_assembleName = mi_assembleName;
		this.mi_memberNo = mi_memberNo;
		this.mi_memID = mi_memID;
		this.mi_memPw = mi_memPw;
		this.mi_memEmail = mi_memEmail;
		this.mi_admin = mi_admin;
		this.mi_regdate = mi_regdate;
		this.mi_memName = mi_memName;
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

	public String getMi_memPw() {
		return mi_memPw;
	}

	public void setMi_memPw(String mi_memPw) {
		this.mi_memPw = mi_memPw;
	}

	public String getMi_memEmail() {
		return mi_memEmail;
	}

	public void setMi_memEmail(String mi_memEmail) {
		this.mi_memEmail = mi_memEmail;
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

	public String getMi_memName() {
		return mi_memName;
	}

	public void setMi_memName(String mi_memName) {
		this.mi_memName = mi_memName;
	}
	
	
}
