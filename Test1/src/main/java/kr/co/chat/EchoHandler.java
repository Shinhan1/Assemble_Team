package kr.co.chat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpRequest;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class EchoHandler extends TextWebSocketHandler {
	private Logger logger = LoggerFactory.getLogger(EchoHandler.class);
	
	//1. 일대일 챗팅 map 사용
	
	//Map<String, WebSocketSession> sessions = new HashMap<String, WebSocketSession>(); 
	 
	
	private List<WebSocketSession> sessionList = new ArrayList<WebSocketSession>();

	@Override
	public void afterConnectionEstablished(WebSocketSession session)
	
		throws Exception{
		//Map사용시
		//sessions.put(session.getId(), session);
		
		
		//List 쓸때
		sessionList.add(session);
		
		logger.info("{} 열결됨",session.getId());
		for(int i = 0 ; i < sessionList.size();i++) {
        	
        	//session.sendMessage(new TextMessage(session.getId()+"로부터"+ message.getPayload()+"받음"));
        	sessionList.get(i).sendMessage(new TextMessage(session+"님이 접속하셨습니다"));
        }
		
		
		
	}
	
	//클라이언트가 웹소켓서버로 메시지를 전송했을 때 실행되는 메소드
	
	@Override
	protected void handleTextMessage(WebSocketSession session,
		TextMessage message) throws Exception {
			
			logger.info("{}로부터 {} 받음", session.getId(), message.getPayload());
		
			System.out.println(1222);
			
	        //map사용 key가 사용자 이름
//	        Iterator<String> sessionIds = sessions.keySet().iterator();
//	        
//	        
//	        String sessionId="";
//	        while(sessionIds.hasNext()){
//	            sessionId = sessionIds.next();
//	            sessions.get(sessionId).sendMessage(new TextMessage("echo:" + message.getPayload()));
//	            
//	            
//	        }
	        for(int i = 0 ; i < sessionList.size();i++) {
	        	
	        	//session.sendMessage(new TextMessage(session.getId()+"로부터"+ message.getPayload()+"받음"));
	        	sessionList.get(i).sendMessage(new TextMessage(session.getId()+" : "+ message.getPayload()));
	        }
			
			
			
			//배열이면 많이 쓸수 있고, 쓰지않으면 최대 2개임여
	        /*logger.info("{}와 부터 {}받음",new String[] {session.getId(), message.getPayload()});*/
	        
	        //연결되어있는 모든 클라이언트들에게 메시지를 전송한다 


	}
	
	
	// 클라이언트가 연결을 끊었을 때 실행
	
	@Override
	public void afterConnectionClosed(WebSocketSession session,
			CloseStatus status) throws Exception{
		
		sessionList.remove(session);
		for(int i = 0 ; i < sessionList.size();i++) {
			sessionList.get(i).sendMessage(new TextMessage(session.getId()+"님이 나갔습니다"));
        }
		
		
	}
	
	
	
	
}
