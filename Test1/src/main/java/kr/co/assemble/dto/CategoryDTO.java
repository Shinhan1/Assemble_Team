package kr.co.assemble.dto;

public class CategoryDTO {
	private int categoryno;
	private int memberno;
	private String categoryname;
	private int admin;
	
	public CategoryDTO() {}

	public CategoryDTO(int categoryno, int memberno, String categoryname, int admin) {
		super();
		this.categoryno = categoryno;
		this.memberno = memberno;
		this.categoryname = categoryname;
		this.admin = admin;
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

	public String getCategoryname() {
		return categoryname;
	}

	public void setCategoryname(String categoryname) {
		this.categoryname = categoryname;
	}

	public int getAdmin() {
		return admin;
	}

	public void setAdmin(int admin) {
		this.admin = admin;
	}

	
	

	
	
}
