package kr.co.ass.dto;

public class IdCheckDTO {
	private String ai_assembleName;
	private String ai_memID;
	private String ai_memPw;
	
	public IdCheckDTO() {
		super();
	}
	public IdCheckDTO(String ai_assembleName, String ai_memID, String ai_memPw) {
		super();
		this.ai_assembleName = ai_assembleName;
		this.ai_memID = ai_memID;
		this.ai_memPw = ai_memPw;
	}
	public String getAi_memID() {
		return ai_memID;
	}
	public void setAi_memID(String ai_memID) {
		this.ai_memID = ai_memID;
	}
	public String getAi_memPw() {
		return ai_memPw;
	}
	public void setAi_memPw(String ai_memPw) {
		this.ai_memPw = ai_memPw;
	}
	public String getAi_assembleName() {
		return ai_assembleName;
	}
	public void setAi_assembleName(String ai_assembleName) {
		this.ai_assembleName = ai_assembleName;
	}
	
	
	
	
}
