package kr.co.chat;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Greeting {
	
	private String content;
	private String sendTime;
	private String id;
	private String sender;
	
	
	public Greeting() {

		// TODO Auto-generated constructor stub
	}
	public String getContent() {
		return content;
	}
	public Greeting(String content) {
		this.content = content;
	}
	public String getSendTime() {
		return sendTime;
	}
	public void setSendTime(String sendTime) {
		this.sendTime = sendTime;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	public Greeting(String content, String sendTime, String id, String sender) {
		super();
		this.content = content;
		this.sendTime = sendTime;
		this.id = id;
		this.sender = sender;
	}
	
	

}
