package com.itbank.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.itbank.model.MemberDTO;
import com.itbank.service.MemberService;

@Controller
public class MemberController {
	
	@Autowired private MemberService memberService;

	@GetMapping("/join")
	public ModelAndView join() {
		
		System.out.println("handle");
		
		ModelAndView mav = new ModelAndView();
		List<MemberDTO> list = memberService.getList();
		mav.addObject("list", list);
		return mav;
	}
	
	@PostMapping("/join")
	public String join(MemberDTO dto) {
		int row = memberService.join(dto);
		System.out.println(row != 0 ? "성공" : "실패");
		return "redirect:/join";
	}


	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@PostMapping("/login")
	public String login(MemberDTO user, String url, HttpSession session) {
		System.out.println("로그인 이후 이동할 주소 : " + url);
		
		MemberDTO login = memberService.login(user);
		session.setAttribute("login", login);
		
//		if(url == null) {
//			return "redirect:/";
//		}
//		else {
//			return "redirect:" + url;
//		}
		return "redirect:" + (url == null ? "/" : url);
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
}





