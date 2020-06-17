package kr.co.assemble.dto;

public class searchParamDTO {
	
	private String value;
	private String assemble;
	
	
	
	
	
	
	
	public String getValue() {
		return value;
	}







	public void setValue(String value) {
		this.value = value;
	}







	public String getAssemble() {
		return assemble;
	}







	public void setAssemble(String assemble) {
		this.assemble = assemble;
	}







	public searchParamDTO(String value, String assemble) {
		super();
		this.value = value;
		this.assemble = assemble;
	};
	
	
	
	
	

}