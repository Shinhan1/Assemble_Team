package kr.co.chat;

public class HelloMessage {
	private String name;
	private String contents; 
	private String roomid;
	private String sendTime;
	private String sender;
	
	
	
	
	

	public HelloMessage(String name, String contents, String roomid, String sendTime, String sender) {
		super();
		this.name = name;
		this.contents = contents;
		this.roomid = roomid;
		this.sendTime = sendTime;
		this.sender = sender;
	}


	public String getRoomid() {
		return roomid;
	}


	public void setRoomid(String roomid) {
		this.roomid = roomid;
	}


	public HelloMessage() {
		// TODO Auto-generated constructor stub
	}

	
	  public HelloMessage(String name,String contents) { 
		  this.contents = contents;
		  this.name = name; 
	  }
	 

//	public HelloMessage(String name) {
//
//		this.name = name;
//	}

	
	public String getContents() {
		  return contents;
	}
	 
	public void setContents(String contents) { 
		  this.contents = contents; 
	  }
	 

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public String getSendTime() {
		return sendTime;
	}


	public void setSendTime(String sendTime) {
		this.sendTime = sendTime;
	}


	public String getSender() {
		return sender;
	}


	public void setSender(String sender) {
		this.sender = sender;
	}

}
