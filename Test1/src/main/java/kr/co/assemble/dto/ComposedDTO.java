package kr.co.assemble.dto;

public class ComposedDTO {
	private int groupno;
	private int categoryno;
	private int memberno;
	
	public ComposedDTO() {}
	
	public ComposedDTO(int groupno, int categoryno, int memberno) {
		super();
		this.groupno = groupno;
		this.categoryno = categoryno;
		this.memberno = memberno;
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
	
	
	
}
