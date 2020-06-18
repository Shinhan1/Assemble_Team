package kr.co.assemble.dao;

import java.io.UnsupportedEncodingException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.amazonaws.AmazonClientException;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailServiceClientBuilder;

import kr.co.assemble.dto.EmailDTO;

@Service
public class SendMailImple implements SendMail {
	
//	@Autowired
//	JavaMailSender mailSender;
	
//	@Value("${aws.ses.port")
	String smptport = "-";
//	@Value("${aws.ses.host}")
	String seshost = "---";
//	@Value("${aws.ses.username}")
	String Access_Key = "--";
//	@Value("${aws.ses.password}")
	String Secret_Key = "--";
//	@Value("${aws.ses.region}")
	String region = "--";
	
	
	@Override
	@Async
	public void sendEmail(EmailDTO emaildto) throws UnsupportedEncodingException, MessagingException{
		// TODO Auto-generated method stub
		
		Properties props = System.getProperties();
    	props.put("mail.transport.protocol", "smtp");
    	props.put("mail.smtp.port", smptport); 
    	props.put("mail.smtp.starttls.enable", "true");
    	props.put("mail.smtp.auth", "true");
    	props.put("mail.debug", "true");
    	
    	Session session = Session.getDefaultInstance(props);
    	
    	
    	System.out.println(emaildto.getSendemail());
        MimeMessage msg = new MimeMessage(session);
        
        
        msg.setFrom(new InternetAddress(emaildto.getSendemail(),"<ASSEMBLE>"));
        msg.setRecipient(Message.RecipientType.TO, new InternetAddress(emaildto.getReceiveemail()));
        msg.setSubject(emaildto.getTitle());
        msg.setContent(emaildto.getContents(),"text/html; charset=utf-8");
        
//        MimeMessageHelper msghelper = new MimeMessageHelper(msg, true, "UTF-8");
//		// MimeMessageHelper에 set하기 위함
//		msghelper.setFrom(emaildto.getSendemail());		// 보내는 사람 이메일
//		msghelper.setTo(emaildto.getReceiveemail());		// 받는 사람 이메일
//		msghelper.setSubject(emaildto.getTitle());		// 제목
//		msghelper.setText(emaildto.getContents(), true);		// 내용
		
        Transport transport = session.getTransport();
		
        transport.connect(seshost, Access_Key, Secret_Key);	
        transport.sendMessage(msg, msg.getAllRecipients());

        transport.close();
		
		
//		System.out.println(mailSender);
//		System.out.println("mimeMessge 전");
//		MimeMessage message = mailSender.createMimeMessage();
//		System.out.println(message);
//		System.out.println("mimeMessage 후");
//		
//		try {
//			
//			MimeMessageHelper msghelper = new MimeMessageHelper(message, true, "UTF-8");
//			// MimeMessageHelper에 set하기 위함
//			msghelper.setFrom(emaildto.getSendemail());		// 보내는 사람 이메일
//			msghelper.setTo(emaildto.getReceiveemail());		// 받는 사람 이메일
//			msghelper.setSubject(emaildto.getTitle());		// 제목
//			msghelper.setText(emaildto.getContents(), true);		// 내용
//			
//			mailSender.send(message);
//			
////			return true;
//			
//		} catch (MessagingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
	
	@Override
	public void send(EmailDTO emaildto) {
		// TODO Auto-generated method stub
		
		BasicAWSCredentials awsCreds = new BasicAWSCredentials("Access_Key", "Secret_Key");
		AWSStaticCredentialsProvider credentialsProvider = new AWSStaticCredentialsProvider(awsCreds);
		
		try {
			credentialsProvider.getCredentials();
		} catch (Exception e) {
			throw new AmazonClientException(
                    "Cannot load the credentials from the credential profiles file. " +
                            "Please make sure that your credentials file is at the correct " +
                            "location (~/.aws/credentials), and is in valid format.",
                    e);
		}
		
		AmazonSimpleEmailService client = AmazonSimpleEmailServiceClientBuilder.standard()
                .withCredentials(credentialsProvider)
                // 자신이 설정한 리전으로 변경할 것!!
                .withRegion("us-west-2")
                .build();

        // Send the email.
        client.sendEmail(emaildto.toSendRequestDto());
		
		
	}
}
