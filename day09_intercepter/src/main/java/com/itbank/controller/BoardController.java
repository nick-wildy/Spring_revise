package com.itbank.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class BoardController {

//	@GetMapping("/board")							// "/board" 로 접근할 때
//	public String board(HttpSession session) {		// session을 참조하여
//		if(session.getAttribute("login") == null) {	// 로그인이 되지 않았다면
//			return "redirect:/login";				// 로그인 페이지로 강제 이동시킨다
//		}
//		return "board";	// 이미 로그인이 되어 있으면 게시판으로 이동
//	}
	
	@GetMapping("/board")
	public void board() {}
	
	@GetMapping("/board/write")
	public String write() {
		return "write";
	}
	
	@GetMapping("/board/modify/{idx}")
	public String modify(@PathVariable("idx") int idx) {
		return "modify";
	}
	
	@GetMapping("/board/delete/{idx}")
	public String delete() {
		return "delete";
	}
	
	
}
