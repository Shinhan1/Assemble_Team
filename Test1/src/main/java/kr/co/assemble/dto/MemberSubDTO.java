package kr.co.assemble.dto;

// MemberSub Table - DTO

public class MemberSubDTO {
	private int ms_memberno;
	private String ms_memteam;
	private String ms_memphone; 
	private String ms_memprofileImg;
	private String ms_memgrade;
	
	public MemberSubDTO() {}

	public MemberSubDTO(int ms_memberno, String ms_memteam, String ms_memphone, String ms_memprofileImg,
			String ms_memgrade) {
		super();
		this.ms_memberno = ms_memberno;
		this.ms_memteam = ms_memteam;
		this.ms_memphone = ms_memphone;
		this.ms_memprofileImg = ms_memprofileImg;
		this.ms_memgrade = ms_memgrade;
	}

	public int getMs_memberno() {
		return ms_memberno;
	}

	public void setMs_memberno(int ms_memberno) {
		this.ms_memberno = ms_memberno;
	}

	public String getMs_memteam() {
		return ms_memteam;
	}

	public void setMs_memteam(String ms_memteam) {
		this.ms_memteam = ms_memteam;
	}

	public String getMs_memphone() {
		return ms_memphone;
	}

	public void setMs_memphone(String ms_memphone) {
		this.ms_memphone = ms_memphone;
	}

	public String getMs_memprofileImg() {
		return ms_memprofileImg;
	}

	public void setMs_memprofileImg(String ms_memprofileImg) {
		this.ms_memprofileImg = ms_memprofileImg;
	}

	public String getMs_memgrade() {
		return ms_memgrade;
	}

	public void setMs_memgrade(String ms_memgrade) {
		this.ms_memgrade = ms_memgrade;
	}
		
	
	
	
	
}
