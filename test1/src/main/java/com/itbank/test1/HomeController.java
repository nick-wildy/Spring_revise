package com.itbank.test1;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
class HomeController {

	@RequestMapping("/")
	public String home(HttpServletRequest request) {
		
		request.setAttribute("serverTime", new Date());
		return "home";
	}
	
	@RequestMapping("/info")
	public String info(HttpServletRequest request) {
		
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		String adult = age >= 20 ? "성인" : "미성년자";
		String msg = String.format("%s의 나이는 %d살이고, %s입니다", name, age, adult);
		
		request.setAttribute("msg", msg);
		return "info";
		
	}
}