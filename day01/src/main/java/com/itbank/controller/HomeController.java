package com.itbank.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	
	// DispatcherServlet이 받은 요청을 분담하여 처리한다
	// 어떤 요청을 받았는지에 따라, 서로 다른 컨트롤러의 함수를 실행한다 (응답을 만들어야 한다)
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String home(HttpServletRequest request) {	// DispatcherServlet이 넘겨준다
		// request, response, session 을 매개변수로 받을 수 있다
		
		return "home";	// forward할 jsp의 이름을 문자열로 반환
	}

}
