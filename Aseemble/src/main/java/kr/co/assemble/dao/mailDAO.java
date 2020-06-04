package kr.co.assemble.dao;


import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import kr.co.assemble.dto.EmailDTO;

@Repository
public class mailDAO {
	@Autowired
    private SqlSessionTemplate sqlSession;
    
    private String nameSpace = "member.model.MemberMapper";
 
//    ------------------------------------- Member --------------------------------------
    //가입
    public void signUp(EmailDTO member) throws Exception {
        sqlSession.insert(nameSpace+".insertUser", member);
    }
    
    //email 중복 확인
    public EmailDTO checkEmail(String email) throws Exception {
        return sqlSession.selectOne(nameSpace+".chkEmail", email);
    }
 
    //이메일 인증 코드 확인
    public EmailDTO chkAuth(String authkey) throws Exception {
        return sqlSession.selectOne(nameSpace + ".chkAuthkey", authkey);
    }
    
    //인증 후 계정 활성화
    public void successAuthkey(EmailDTO member) throws Exception {
        sqlSession.update(nameSpace + ".keyConfirm", member);
    }


}
