package kr.co.chat;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.messaging.converter.SimpleMessageConverter;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.util.HtmlUtils;

@Controller
public class GreetingController {



   @MessageMapping("/hello")
   @SendTo("/topic/all")
   public Greeting greeting(HelloMessage message) throws Exception{
      System.out.println("메시지 컨트롤");
      System.out.println(message);
      
      //0을 보내면 회색 1을 보내면 초록색
      
      Thread.sleep(1000);
      
      return new Greeting("Hello," +HtmlUtils.htmlEscape(message.getName()) + "!" + ":"+HtmlUtils.htmlEscape(message.getContents())    );
   }
   
   
   /* @SendTo("/queue/{roomid}") */
   @MessageMapping("/status/{memberno}")
   @SendTo("/queue/{memberno}")
   public Greeting welcome(HelloMessage message,@DestinationVariable String memberno) throws Exception{
      
      System.out.println(message.getRoomid());
      System.out.println("노란색");
      
      //System.out.println("rpomname"+roomname);
      
      SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd HH:mm:ss");
      String time = sdf.format(new Date());
   
   
      //return new Greeting("Hello," +HtmlUtils.htmlEscape(message.getName())+"님 접속했습니다" );
      return new Greeting(message.getContents(),time,message.getName(),message.getSender(),message.getRoomid());
   
   }
   
   
   @MessageMapping("/welcome/{roomid}")
   @SendTo("/queue/{roomid}")
   public Greeting tmp(HelloMessage message,@DestinationVariable String roomid) throws Exception{
      
      System.out.println(message.getName());
      System.out.println(message.getRoomid());
      System.out.println(message.getContents());
      System.out.println(message.getSender());
      System.out.println("0----------");
      System.out.println("컨트롤러");
      
      //System.out.println("rpomname"+roomname);
      
      SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd HH:mm:ss");
      String time = sdf.format(new Date());
   
   
      //return new Greeting("Hello," +HtmlUtils.htmlEscape(message.getName())+"님 접속했습니다" );
      return new Greeting(message.getContents(),time,message.getName(),message.getSender(),message.getRoomid());
   
   }


   
   
   
   
   
}