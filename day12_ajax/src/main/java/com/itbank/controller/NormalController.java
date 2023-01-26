package com.itbank.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class NormalController {
	
	// 이 함수는 viewName을 반환하여 forward하여 response를 만드는 함수가 아니다 !!
	// 이 함수는 반환하는 값 그 자체가 response이다

	// 반환값이 응답이므로, 응답의 content-type과 encoding 규칙을 명시해야 한다
	// produces : 함수가 생산하는 값 (만들어내는 값, 반환값)
	
	@GetMapping(value="/ex01", produces="text/html; charset=utf-8")
	@ResponseBody 	// 반환값은 viewName으로 작동하지 않는다
	public String ex01() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String today = sdf.format(new Date());
		return "안녕하세요. 오늘은 " + today + " 입니다";
	}
}
