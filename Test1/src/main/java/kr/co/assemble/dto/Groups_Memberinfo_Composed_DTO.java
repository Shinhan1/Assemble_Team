package kr.co.assemble.dto;

//그룹별 정보, 구성원 가져와야 대는 DTO => ComposedDAO에!!
public class Groups_Memberinfo_Composed_DTO {

	private String groupname;
	private String mi_memname;
	private String mi_memid;
	private String mi_assemblename;
	
	public Groups_Memberinfo_Composed_DTO() {
		// TODO Auto-generated constructor stub
	}

	public Groups_Memberinfo_Composed_DTO(String groupname, String mi_memname, String mi_memid,
			String mi_assemblename) {
		super();
		this.groupname = groupname;
		this.mi_memname = mi_memname;
		this.mi_memid = mi_memid;
		this.mi_assemblename = mi_assemblename;
	}

	public String getGroupname() {
		return groupname;
	}

	public void setGroupname(String groupname) {
		this.groupname = groupname;
	}

	public String getMi_memname() {
		return mi_memname;
	}

	public void setMi_memname(String mi_memname) {
		this.mi_memname = mi_memname;
	}

	public String getMi_memid() {
		return mi_memid;
	}

	public void setMi_memid(String mi_memid) {
		this.mi_memid = mi_memid;
	}

	public String getMi_assemblename() {
		return mi_assemblename;
	}

	public void setMi_assemblename(String mi_assemblename) {
		this.mi_assemblename = mi_assemblename;
	}
	
	
	

	
	
	

	
	
	
	
}
