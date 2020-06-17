package kr.co.assemble.dto;

public class AssembleGroupsDTO {

	private String assemblename;
	private String groupname;
	private int categoryno;
	private int groupno;
	private int memberno;
	private int roomname;
	private int senderno;
	private String chatcontent;
	private String chattime;
	
	public AssembleGroupsDTO(String assemblename, String groupname, int categoryno, int groupno, int memberno,
			int roomname, int senderno, String chatcontent, String chattime) {
		super();
		this.assemblename = assemblename;
		this.groupname = groupname;
		this.categoryno = categoryno;
		this.groupno = groupno;
		this.memberno = memberno;
		this.roomname = roomname;
		this.senderno = senderno;
		this.chatcontent = chatcontent;
		this.chattime = chattime;
	}


	public int getRoomname() {
		return roomname;
	}


	public void setRoomname(int roomname) {
		this.roomname = roomname;
	}


	public int getSenderno() {
		return senderno;
	}


	public void setSenderno(int senderno) {
		this.senderno = senderno;
	}


	public String getChatcontent() {
		return chatcontent;
	}


	public void setChatcontent(String chatcontent) {
		this.chatcontent = chatcontent;
	}


	public String getChattime() {
		return chattime;
	}


	public void setChattime(String chattime) {
		this.chattime = chattime;
	}


	public AssembleGroupsDTO() {
		// TODO Auto-generated constructor stub
	}
	

//	public AssembleGroupsDTO(String assemblename, String groupname, int groupno, int categoryno, int memberno) {
//		super();
//		this.assemblename = assemblename;
//		this.groupname = groupname;
//		this.groupno = groupno;
//		this.categoryno = categoryno;
//		this.memberno = memberno;
//	}


	public String getAssemblename() {
		return assemblename;
	}

	public void setAssemblename(String assemblename) {
		this.assemblename = assemblename;
	}

	public String getGroupname() {
		return groupname;
	}

	public void setGroupname(String groupname) {
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
	
	
	
	
	
}
