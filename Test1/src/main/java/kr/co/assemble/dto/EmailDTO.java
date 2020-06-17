package kr.co.assemble.dto;

import com.amazonaws.services.simpleemail.model.Body;
import com.amazonaws.services.simpleemail.model.Content;
import com.amazonaws.services.simpleemail.model.Destination;
import com.amazonaws.services.simpleemail.model.Message;
import com.amazonaws.services.simpleemail.model.SendEmailRequest;

public class EmailDTO {
	private String sendemail;
	private String receiveemail;
	private String title;
	private String contents;
	
	public EmailDTO() {}
	
	public EmailDTO(String sendemail, String receiveemail, String title, String contents) {
		super();
		this.sendemail = sendemail;
		this.receiveemail = receiveemail;
		this.title = title;
		this.contents = contents;
	}

	public String getSendemail() {
		return sendemail;
	}

	public void setSendemail(String sendemail) {
		this.sendemail = sendemail;
	}

	public String getReceiveemail() {
		return receiveemail;
	}

	public void setReceiveemail(String receiveemail) {
		this.receiveemail = receiveemail;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}
	
	public SendEmailRequest toSendRequestDto(){
        Destination destination = new Destination()
                .withToAddresses(this.receiveemail);

        Message message = new Message()
                .withSubject(createContent(this.title))
                .withBody(new Body()
                        .withHtml(createContent(this.contents))); // content body는 HTML 형식으로 보내기 때문에 withHtml을 사용합니다.

        return new SendEmailRequest()
                .withSource(this.sendemail)
                .withDestination(destination)
                .withMessage(message);
    }
	
	private Content createContent(String text) {
        return new Content()
                .withCharset("UTF-8")
                .withData(text);
    }
	
	
	
}
