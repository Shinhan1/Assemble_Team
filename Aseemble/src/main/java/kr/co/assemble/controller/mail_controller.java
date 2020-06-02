package kr.co.assemble.controller;

import javax.mail.Service;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

public class mail_controller {
	@RequestMapping(value = "/register", method = RequestMethod.POST)
    public String RegisterPost(MemberVO user,Model model,RedirectAttributes rttr) throws Exception{
    
        System.out.println("regesterPost 진입 ");
        Service.regist(user);
        rttr.addFlashAttribute("msg" , "가입시 사용한 이메일로 인증해주세요");
        return "redirect:/";
    }

    //이메일 인증 코드 검증
    @RequestMapping(value = "/emailConfirm", method = RequestMethod.GET)
    public String emailConfirm(MemberVO user,Model model,RedirectAttributes rttr) throws Exception { 
        
        System.out.println("cont get user"+user);
        MemberVO vo = new MemberVO();
        vo=Service.userAuth(user);
        if(vo == null) {
            rttr.addFlashAttribute("msg" , "비정상적인 접근 입니다. 다시 인증해 주세요");
            return "redirect:/";
        }
        //System.out.println("usercontroller vo =" +vo);
        model.addAttribute("login",vo);
        return "/user/emailConfirm";
    }
}
