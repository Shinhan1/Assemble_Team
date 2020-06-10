package kr.co.assemble.dto;

public class GroupDTO {
	private int groupno;
	private int categoryno;
	private int memberno;
	private String groupname;
	
	public GroupDTO() {}

	public GroupDTO(int groupno, int categoryno, int memberno, String groupname) {
		super();
		this.groupno = groupno;
		this.categoryno = categoryno;
		this.memberno = memberno;
		this.groupname = groupname;
	}

	public int getGroupno() {
		return groupno;
	}

	public void setGroupno(int groupno) {
		this.groupno = groupno;
	}

	public int getCategoryno() {
		return categoryno;
	}

	public void setCategoryno(int categoryno) {
		this.categoryno = categoryno;
	}

	public int getMemberno() {
		return memberno;
	}

	public void setMemberno(int memberno) {
		this.memberno = memberno;
	}

	public String getGroupname() {
		return groupname;
	}

	public void setGroupname(String groupname) {
		this.groupname = groupname;
	}

	
	
	
}
