package kr.co.chat;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ChatMessage {
	
	
    private String chatRoomId;
    private String writer;
    private String message;
    private String sendTime;
    private MessageType type;
    
    
    
    
    
    
    
	public String getSendTime() {
		return sendTime;
	}
	public void setSendTime(Date sendTime) {

	}
	public ChatMessage(String chatRoomId, String writer, String message, MessageType type) {
		super();
		this.chatRoomId = chatRoomId;
		this.writer = writer;
		this.message = message;
		this.type = type;
	}
	public String getChatRoomId() {
		return chatRoomId;
	}
	public void setChatRoomId(String chatRoomId) {
		this.chatRoomId = chatRoomId;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public MessageType getType() {
		return type;
	}
	public void setType(MessageType type) {
		this.type = type;
	}
    
    

    
    
    
}
