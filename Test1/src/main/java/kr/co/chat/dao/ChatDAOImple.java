package kr.co.chat.dao;



import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.co.chat.Chatgogo;
import kr.co.chat.dto.CHATDTO;
import kr.co.chat.dto.GroupChatDTO;
import kr.co.chat.dto.MemberDTO;



@Repository
public class ChatDAOImple implements ChatDAO {
	

	
	
	@Inject
	private SqlSession session;


	@Override
	public List<CHATDTO> getchat(String roomId) {
		System.out.println("여기온다"+roomId);
		return session.selectList("getchat",roomId);
	}


	@Override
	public List<MemberDTO> getid(String assemblename) {
		// TODO Auto-generated method stub
		return session.selectList("getmember",assemblename);
	}


	@Override
	public void inputchat(Chatgogo gogo) {
		
		 session.insert("inputchat", gogo);
		 
	}


	@Override
	public void insertgroup(GroupChatDTO insertGroupChat) {
		
		session.insert("insertgroupchat", insertGroupChat);
		
	}


	@Override
	public List<GroupChatDTO> selectgroupchat(int myno) {
		return session.selectList("getgroup",myno);

	}
	
	
	

	
}
