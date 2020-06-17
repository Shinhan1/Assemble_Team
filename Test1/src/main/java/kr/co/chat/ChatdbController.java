package kr.co.chat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.assemble.chat.dto.CHATDTO;
import kr.co.chat.dao.ChatDAOImple;

public class ChatdbController {


	ChatDAOImple dao;
	
	
	public void setDao(ChatDAOImple dao) {
		this.dao = dao;
	}
	

	
	
	
}
