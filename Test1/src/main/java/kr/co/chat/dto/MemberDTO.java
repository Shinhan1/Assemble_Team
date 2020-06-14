package kr.co.chat.dto;

public class MemberDTO {
	private String mI_assembleName;
	private int mI_memberNo; 
	private String mI_memId;
	private String mI_memPw;
	private String mI_memEmail;
	private int mI_admin;
	private String mI_regdate;
	private String mI_memName;

	public MemberDTO() {
		// TODO Auto-generated constructor stub
	}
	
	
	

	public MemberDTO(String mI_assembleName, int mI_memberNo, String mI_memId, String mI_memPw, String mI_memEmail,
			int mI_admin, String mI_regdate, String mI_memName) {
		super();
		this.mI_assembleName = mI_assembleName;
		this.mI_memberNo = mI_memberNo;
		this.mI_memId = mI_memId;
		this.mI_memPw = mI_memPw;
		this.mI_memEmail = mI_memEmail;
		this.mI_admin = mI_admin;
		this.mI_regdate = mI_regdate;
		this.mI_memName = mI_memName;
	}




	public String getmI_assembleName() {
		return mI_assembleName;
	}

	public void setmI_assembleName(String mI_assembleName) {
		this.mI_assembleName = mI_assembleName;
	}

	public int getmI_memberNo() {
		return mI_memberNo;
	}

	public void setmI_memberNo(int mI_memberNo) {
		this.mI_memberNo = mI_memberNo;
	}

	public String getmI_memId() {
		return mI_memId;
	}

	public void setmI_memId(String mI_memId) {
		this.mI_memId = mI_memId;
	}

	public String getmI_memPw() {
		return mI_memPw;
	}

	public void setmI_memPw(String mI_memPw) {
		this.mI_memPw = mI_memPw;
	}

	public String getmI_memEmail() {
		return mI_memEmail;
	}

	public void setmI_memEmail(String mI_memEmail) {
		this.mI_memEmail = mI_memEmail;
	}

	public int getmI_admin() {
		return mI_admin;
	}

	public void setmI_admin(int mI_admin) {
		this.mI_admin = mI_admin;
	}

	public String getmI_regdate() {
		return mI_regdate;
	}

	public void setmI_regdate(String mI_regdate) {
		this.mI_regdate = mI_regdate;
	}

	public String getmI_memName() {
		return mI_memName;
	}

	public void setmI_memName(String mI_memName) {
		this.mI_memName = mI_memName;
	}
	
	
	
	
	
	
	
	
	
	
}
