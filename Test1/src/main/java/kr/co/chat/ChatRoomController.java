package kr.co.chat;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.support.HttpRequestHandlerServlet;

import kr.co.assemble.chat.dto.CHATDTO;
import kr.co.assemble.chat.dto.GroupChatDTO;
import kr.co.assemble.chat.dto.MemberDTO;
import kr.co.assemble.chat.dto.MemberidDTO;
import kr.co.chat.dao.ChatDAO;
import kr.co.chat.dao.ChatDAOImple;

//@RequiredArgsConstructor 
//어노테이션은 final이나 @NonNull인 필드 값만 파라미터로 받는 생성자를 만들어줍니다

@Controller
@RequestMapping("/chatroom")
public class ChatRoomController {

	@Autowired
	private ChatRoomRepository chatRoomRepository;
	
	@Inject
	private ChatDAO dao;

	public void setDao(ChatDAOImple dao) {
		this.dao = dao;
	}

	// 채팅 리스트 화면
	@GetMapping("/room")
	public String room(Model model) {

		return "chatlist";
	}

	/*
	 * // 모든 채팅방 목록 반환
	 * 
	 * @GetMapping("/rooms")
	 * 
	 * @ResponseBody public ModelAndView roomlist(Model model){ ModelAndView mav =
	 * new ModelAndView();
	 * 
	 * 
	 * 
	 * System.out.println(chatRoomRepository.findAllRoom().isEmpty());
	 * mav.addObject("list", chatRoomRepository.findAllRoom());
	 * mav.setViewName("list");
	 * 
	 * 
	 * return mav; }
	 */

	// 모든 채팅방 목록 반환
//	@GetMapping("/rooms")
//	@ResponseBody
//	public List<ChatRoom> room(HttpServletRequest req) {
//		System.out.println(req.getAttribute("id"));
//
//		return chatRoomRepository.findAllRoom();
//	}

	// 채팅바(메인화면 오면 
	@RequestMapping("/room/side")
	// @ResponseBody
	public String createRoom(Model model,HttpServletRequest req) {

		HttpSession session = req.getSession();
		
		session.getAttribute("mi_memid");
		
		session.getAttribute("memberno");
		session.getAttribute("mi_assemblename");
		// withh가 어셈블 이름
		List<MemberDTO> memlist = dao.getid((String) session.getAttribute("mi_assemblename"));
		
		
		
		model.addAttribute("memlist", memlist);
		
		 System.out.println(session.getAttribute("id"));
		/* int memberno = (int) session.getAttribute("bno"); */
		 
		 
		// int memberno = 1; // 세션 멤버넘버
		 List<GroupChatDTO> grouplist=dao.selectgroupchat((int) session.getAttribute("memberno"));
		 
		 
		 model.addAttribute("grouplist", grouplist);
		 
		//session.setAttribute("id", "yssy3135");
		
		
		
		
		// System.out.println(memlist.get(0).getmI_memName());
		 
		return "pop";
	}

//	public ChatRoom createRoom(@RequestParam String name) {
//		return chatRoomRepository.createChatRoom(name);
//	}

	// 채팅방 입장
//	@GetMapping("/enter/{roomId}")
//	public String roomDetail( @PathVariable String roomId, Model model,HttpServletRequest req) {
//		// model.addAttribute("roomId", roomId);
//
//	
//		 List<CHATDTO> list = dao.getchat("1415");
//		 model.addAttribute("list",list);
//		 
//		//req.setAttribute("list", list); 
//		 
//		 
//		 
//		 System.out.println(list.get(0).getChatcontent());
//		 
//
//		// Model객체는 이용하여 view로 데이터전송
//		// 데이터 전송
//		 HttpSession session = req.getSession();
//		session.setAttribute("id", "yssy3135");
//
//		// return "/chat/roomdetail";
//		return "stomp";
//
//	}
//	
	@ResponseBody
	@RequestMapping( value = "/room/getchat" , method = RequestMethod.POST)
	public List<CHATDTO>getchat(HttpServletRequest req, @RequestParam String roomid ){
	
		System.out.println("방아이디"+roomid);
		
		List<CHATDTO> list = dao.getchat(roomid);
	
		return list;
		
	}
	
	
	@RequestMapping(value = "/room/inputchat")
	public void inputchat(HttpServletRequest req,Chatgogo chatgogo) {
		
		// 받아야하는 데이터 ${sessiongname},roomid.채팅내용,보낸사람,sysdate();
		dao.inputchat(chatgogo);
		System.out.println("입력 데이터 :"+chatgogo.getChatcontents()  );

		
		
	}
	
	
	@ResponseBody
	@RequestMapping( value = "/room/insertgroup" , method = RequestMethod.POST)
	public void insertgroup(HttpServletRequest req, GroupChatDTO insertGroupChat ){
		
		
		//System.out.println(insertGroupChat.getTogetherno());
		dao.insertgroup(insertGroupChat);
		
	
	
		
	}
	
	
	
	@ResponseBody
	@RequestMapping( value = "/room/selectgroupchat" , method = RequestMethod.POST)
	public List<GroupChatDTO>selectgroupchat(HttpServletRequest req, @RequestParam int myno ){
	
		System.out.println("방아이디"+myno);
		
		 List<GroupChatDTO> grouplist = dao.selectgroupchat(myno);  
	
		return grouplist ;
		
	}
	
	
	
	

}













