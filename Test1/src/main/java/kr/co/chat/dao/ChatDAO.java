package kr.co.chat.dao;

import java.util.List;

import kr.co.assemble.chat.dto.CHATDTO;
import kr.co.assemble.chat.dto.GroupChatDTO;
import kr.co.assemble.chat.dto.MemberDTO;
import kr.co.assemble.chat.dto.MemberidDTO;
import kr.co.chat.Chatgogo;

public interface ChatDAO {
	
	public List<CHATDTO> getchat(String i);
	public List<MemberDTO> getid(String assemblename);
	public void inputchat(Chatgogo chatgogo);
	public void insertgroup (GroupChatDTO insertGroupChat);
	public List<GroupChatDTO> selectgroupchat (int myno);
	
	
	
	
}
