package com.itbank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.itbank.service.MemberService;

@RestController
public class AjaxController {
	
	@Autowired private MemberService memberService;
	
	@GetMapping(value="/member/dupCheck/{inputId}", produces="plain/text;charset=utf-8")
	public String dupCheck(@PathVariable("inputId") String inputId) {
		
		int row = memberService.dupCheck(inputId);
		String msg = row == 1 ? "이미 사용중인 ID입니다" : "사용 가능한 ID입니다";
		msg = row + ":" + msg;
		return msg;
	}
}
