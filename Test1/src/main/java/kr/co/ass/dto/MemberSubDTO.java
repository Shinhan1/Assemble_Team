package kr.co.ass.dto;

// MemberSub Table - DTO

public class MemberSubDTO {
	private int ms_memberNo;
	private String ms_memTeam;
	private String ms_memPhone; 
	private String ms_memProfileImg;
	private String ms_memgrade;
	
	public MemberSubDTO() {}
		
	public MemberSubDTO(int ms_memberNo, String ms_memTeam, String ms_memPhone, String ms_memProfileImg,
			String ms_memgrade) {
		super();
		this.ms_memberNo = ms_memberNo;
		this.ms_memTeam = ms_memTeam;
		this.ms_memPhone = ms_memPhone;
		this.ms_memProfileImg = ms_memProfileImg;
		this.ms_memgrade = ms_memgrade;
	}
	public int getMs_memberNo() {
		return ms_memberNo;
	}
	public void setMs_memberNo(int ms_memberNo) {
		this.ms_memberNo = ms_memberNo;
	}
	public String getMs_memTeam() {
		return ms_memTeam;
	}
	public void setMs_memTeam(String ms_memTeam) {
		this.ms_memTeam = ms_memTeam;
	}
	public String getMs_memPhone() {
		return ms_memPhone;
	}
	public void setMs_memPhone(String ms_memPhone) {
		this.ms_memPhone = ms_memPhone;
	}
	public String getMs_memProfileImg() {
		return ms_memProfileImg;
	}
	public void setMs_memProfileImg(String ms_memProfileImg) {
		this.ms_memProfileImg = ms_memProfileImg;
	}
	public String getMs_memgrade() {
		return ms_memgrade;
	}
	public void setMs_memgrade(String ms_memgrade) {
		this.ms_memgrade = ms_memgrade;
	}
	
	
	
	
}
