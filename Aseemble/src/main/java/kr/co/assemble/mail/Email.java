package kr.co.assemble.mail;

public interface Email {
	public boolean send(String subject, String text, String from, String to, String filePath);
	
	
	
}




