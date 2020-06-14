package kr.co.chat;

import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionContext;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
@RequestMapping("/chat")
public class SocketController  {

	
	
		@GetMapping("/new/{roomname}")
		public String viewChattingPage(HttpServletRequest req,@PathVariable String roomname) {
			
		
			
			//HttpSession session = req.getSession();
			
			req.setAttribute("roomname", roomname);
			
			
			return "stomp";
		}
		
		
		@GetMapping("/list")
		public String showchatlist(HttpServletRequest req) {
			
		
			HttpSession session = req.getSession();
			session.setAttribute("id", "yssy3135");
		
			
		
			req.setAttribute("id", "abc");
			
			
			return "chatlist";
		}
		
		
		
		

		
		@RequestMapping("/login")
		public String loginPage(HttpServletRequest req) {
			

			
			
			return "login";
		}
		
		
		
	
}
