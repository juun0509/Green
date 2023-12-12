package com.green.tonicbank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.green.tonicbank.model.User;
import com.green.tonicbank.service.UserService;

@Controller
@RequestMapping("/signUp")
public class SignUpController {

	@Autowired
	UserService userSvc;
	
	@GetMapping("/join")
	public String join() {
		return "signUp";
	}
	
	@GetMapping("/test")
	public String zz() {
		return "signUp";
	}
	
	@PostMapping("join")
	public String postJoin(User user, Model m, RedirectAttributes redatt) {
		System.out.println("ȸ������:"+user);
		try {
			int res = userSvc.join(user);
			if(res == 1)
				System.out.println("ȸ������ ����:"+user);
			redatt.addFlashAttribute("msg","join_ok");
			return "redirect:/";
		} catch (Exception e) {
			e.printStackTrace();
			redatt.addFlashAttribute("msg","join_fail");
		}
		return "redirect:/signup/join";
	}
	
	//���̵� �ߺ�Ȯ��
	@ResponseBody
	@PostMapping("/duplId")
	public int duplId(String userId) throws Exception {
	    int result = userSvc.idCheck(userId);
	    if(result != 0)
	    	System.out.println(userId+"(��)�� �ߺ��� ���̵�");
	    return result;
	}
	
	//�г��� �ߺ�Ȯ��
	@ResponseBody
	@PostMapping("/duplNick")
	public int duplNick(String nick) throws Exception {
		int result = userSvc.nickCheck(nick);
		if(result != 0)
			System.out.println(nick+"(��)�� �ߺ��� �г���");
		return result;
	}
	
}
