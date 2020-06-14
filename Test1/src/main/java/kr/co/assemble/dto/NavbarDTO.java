package kr.co.assemble.dto;

public class NavbarDTO {
	private int categoryno;
	private String categoryname;
	private int memberno;
	private String assemblename;
	
	public NavbarDTO() {}


	public NavbarDTO(int categoryno, String categoryname, int memberno, String assemblename) {
		super();
		this.categoryno = categoryno;
		this.categoryname = categoryname;
		this.memberno = memberno;
		this.assemblename = assemblename;
	}


	public int getCategoryno() {
		return categoryno;
	}


	public void setCategoryno(int categoryno) {
		this.categoryno = categoryno;
	}


	public String getCategoryname() {
		return categoryname;
	}


	public void setCategoryname(String categoryname) {
		this.categoryname = categoryname;
	}


	public int getMemberno() {
		return memberno;
	}


	public void setMemberno(int memberno) {
		this.memberno = memberno;
	}


	public String getAssemblename() {
		return assemblename;
	}


	public void setAssemblename(String assemblename) {
		this.assemblename = assemblename;
	}
	
	
	
	

}
