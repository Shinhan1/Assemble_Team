package kr.co.chat;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ChatRoomRepository {

	// 여기서는 Map으로 구현하지만 db로 들어가야함
	
	private Map<String, ChatRoom> chatRoomMap;
	
	@PostConstruct
	private void init() {
		chatRoomMap = new LinkedHashMap<>();
		System.out.println("초기화 해라");
		System.out.println(chatRoomMap);
	}
	
	
	public ChatRoom findRoomByID(String id) {
		return chatRoomMap.get(id);
	}
	
	public List<ChatRoom> findAllRoom(){
		
		List chatRooms = new ArrayList<>(chatRoomMap.values());
		Collections.reverse(chatRooms);
		
		return chatRooms;
	}
	
	
	
	public ChatRoom createChatRoom(String name) {
		ChatRoom chatRoom = ChatRoom.create(name);
		
		System.out.println(chatRoom.getRoomId()+"------"+chatRoom);
		System.out.println(chatRoomMap);
		
		chatRoomMap.put(chatRoom.getRoomId(),chatRoom);
		
		return chatRoom;
		
	}
	
	
}
