package kr.co.assemble.dto;

// AssebleInfo Table - DTO

public class AssembleInfoDTO {
	private String ai_assembleName;
	private int ai_memberNo;
	private String ai_memId, ai_memPw, ai_memEmail;
	private int ai_admin;
	private String ai_regdate;
	
	public AssembleInfoDTO() {}
	
	public AssembleInfoDTO(String ai_assembleName, int ai_memberNo, String ai_memId, String ai_memPw, String ai_memEmail,
			int ai_admin, String ai_regdate) {
		super();
		this.ai_assembleName = ai_assembleName;
		this.ai_memberNo = ai_memberNo;
		this.ai_memId = ai_memId;
		this.ai_memPw = ai_memPw;
		this.ai_memEmail = ai_memEmail;
		this.ai_admin = ai_admin;
		this.ai_regdate = ai_regdate;
	}
	public String getAi_assembleName() {
		return ai_assembleName;
	}
	public void setAi_assembleName(String ai_assembleName) {
		this.ai_assembleName = ai_assembleName;
	}
	public int getAi_memberNo() {
		return ai_memberNo;
	}
	public void setAi_memberNo(int ai_memberNo) {
		this.ai_memberNo = ai_memberNo;
	}
	public String getAi_memId() {
		return ai_memId;
	}
	public void setAi_memId(String ai_memId) {
		this.ai_memId = ai_memId;
	}
	public String getAi_memPw() {
		return ai_memPw;
	}
	public void setAi_memPw(String ai_memPw) {
		this.ai_memPw = ai_memPw;
	}
	public String getAi_memEmail() {
		return ai_memEmail;
	}
	public void setAi_memEmail(String ai_memEmail) {
		this.ai_memEmail = ai_memEmail;
	}
	public int getAi_admin() {
		return ai_admin;
	}
	public void setAi_admin(int ai_admin) {
		this.ai_admin = ai_admin;
	}
	public String getAi_regdate() {
		return ai_regdate;
	}
	public void setAi_regdate(String ai_regdate) {
		this.ai_regdate = ai_regdate;
	}
	
	
	
}
