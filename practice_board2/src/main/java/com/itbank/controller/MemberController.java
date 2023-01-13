package com.itbank.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.itbank.model.MemberDTO;
import com.itbank.service.MemberService;


@Controller
@RequestMapping("/member")
public class MemberController {
	@Autowired private MemberService memberService;
	
	@GetMapping("/login")
	public void login() {
		
	}
	@PostMapping("/login")
	public String login(MemberDTO dto, String url, HttpSession session) {
		MemberDTO login = memberService.login(dto);
		session.setAttribute("login", login);
		session.setMaxInactiveInterval(600);
		return "redirect:" + (url != null ? url : "/") ;
	}
	
	@GetMapping("/join")
	public void join() {}
	
	@PostMapping("/join")
	public String join(MemberDTO dto, HttpSession session) {
		int row = memberService.add(dto);
		System.out.println(row == 1 ? "추가성공" : "추가실패");
		session.setAttribute("login", dto);
		session.setMaxInactiveInterval(600);
		
		return "redirect:/";
	}
	
	@GetMapping("/mypage")
	public void mypage() {}
	
	@GetMapping("/modify")
	public void modify() {}
	
	@PostMapping("/modify")
	public String modify(MemberDTO dto, HttpSession session) {
		int row = memberService.modify(dto);
		System.out.println(row==1?"수정성공" : "수정실패");
		session.setAttribute("login", dto);
		session.setMaxInactiveInterval(600);
		
		return "redirect:/";
	}
	
	@GetMapping("/withdraw")
	public String withdraw(HttpSession session) {
		int idx = ((MemberDTO)session.getAttribute("login")).getIdx();
		int row = memberService.delete(idx);
		System.out.println(row==1? "삭제성공" : "삭제실패");
		session.invalidate();
		
		return "redirect:/";
	}
	

}
