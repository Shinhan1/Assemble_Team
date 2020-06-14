package kr.co.chat;

import java.io.IOException;


import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

public class MessageSendUtil {
    public void sendMessage(WebSocketSession session, TextMessage message) {
        try {
            session.sendMessage(message);
        } catch (IOException e) {
            e.getMessage();
        }
    }
}
