package kr.co.assemble.dto;

public class EmailDTO {
	private String senderName;
	private String senderEmail;
	private String receiveEmail;
	private String subject;
	private String message;
	public String getSenderName() {
		return senderName;
	}
	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}
	public String getSenderEmail() {
		return senderEmail;
	}
	public void setSenderEmail(String senderEmail) {
		this.senderEmail = senderEmail;
	}
	public String getReceiveEmail() {
		return receiveEmail;
	}
	public void setReceiveEmail(String receiveEmail) {
		this.receiveEmail = receiveEmail;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	@Override
	public String toString() {
		return "EmailDTO [senderName=" + senderName + ", senderEmail=" + senderEmail + ", receiveEmail=" + receiveEmail
				+ ", subject=" + subject + ", message=" + message + "]";
	}
	
	
	
}
