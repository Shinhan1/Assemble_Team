package kr.co.chat.dto;

public class GroupChatDTO {
	private String togetherno;
	private String assemblename;
	private String roomname;
	private int memberno;
	
	
	
	
	
	
	
	
	public GroupChatDTO(String togetherno, String assemblename, String roomname, int memberno) {
		super();
		this.togetherno = togetherno;
		this.assemblename = assemblename;
		this.roomname = roomname;
		this.memberno = memberno;
	}
	
	
	public String getTogetherno() {
		return togetherno;
	}
	public void setTogetherno(String togetherno) {
		this.togetherno = togetherno;
	}
	public String getAssemblename() {
		return assemblename;
	}
	public void setAssemblename(String assemblename) {
		this.assemblename = assemblename;
	}
	public String getRoomname() {
		return roomname;
	}
	public void setRoomname(String roomname) {
		this.roomname = roomname;
	}
	public int getMemberno() {
		return memberno;
	}
	public void setMemberno(int memberno) {
		this.memberno = memberno;
	}
	
	
	
	
	

}
