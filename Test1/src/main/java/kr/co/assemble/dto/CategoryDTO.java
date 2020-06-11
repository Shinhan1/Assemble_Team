package kr.co.assemble.dto;

public class CategoryDTO {
	private int categoryno;
	private int memberno;
	private String categoryname;
	private int admin;
	private String assemblename;
	
	public CategoryDTO() {}

	public CategoryDTO(int categoryno, int memberno, String categoryname, int admin, String assemblename) {
		super();
		this.categoryno = categoryno;
		this.memberno = memberno;
		this.categoryname = categoryname;
		this.admin = admin;
		this.assemblename = assemblename;
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

	public String getAssemblename() {
		return assemblename;
	}

	public void setAssemblename(String assemblename) {
		this.assemblename = assemblename;
	}

	
	
	

	
	
}
