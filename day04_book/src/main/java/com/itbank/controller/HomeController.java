package com.itbank.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	// [요청]에 따라서 실행할 [함수, 반환형이 응답을 만드는데 사용된다]를 작성한다

	@RequestMapping("/")
	public String home() {
		return "home";
	}
}
