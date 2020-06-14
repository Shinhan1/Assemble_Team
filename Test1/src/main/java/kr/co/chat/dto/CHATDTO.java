package kr.co.chat.dto;

public class CHATDTO {
	private int roomname;
	private String assemblename;
	private int senderno;
	private String chatcontent;
	private String chattime;

	
	public CHATDTO(int roomname, String assemblename, int senderno, String chatcontent, String chattime) {
		super();
		this.roomname = roomname;
		this.assemblename = assemblename;
		this.senderno = senderno;
		this.chatcontent = chatcontent;
		this.chattime = chattime;
	}

	public CHATDTO(int roomname, int senderno, String chatcontent, String chattime) {
		super();
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

	public String getAssemblename() {
		return assemblename;
	}

	public void setAssemblename(String assemblename) {
		this.assemblename = assemblename;
	}
	
	
	
	
	
	
	
}
