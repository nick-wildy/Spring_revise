package com.itbank.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class Ex02Controller {
	// 1) @RequestMapping 의 단축 어노테이션이 존재한다 (GetMapping, PostMapping ...)
	// 2) request.getParameter() 대신 컨트롤러 메서드의 매개변수에 파라미터를 바로 받을 수 있다
	// 3) HttpServletRequest 대신 Model타입의 객체를 이용하여 attribute를 전달할 수 있다
	
	@GetMapping("/ex02")
	public void ex02() {}
	
	@PostMapping("/ex02")
	public String ex02(String name, int age, Model model) {
		// primitive type + String 형식은 매개변수로 받으면 request.getParameter()가 필요없다
		// HttpServletRequest는 파라미터 및 어트리뷰트만 처리하기에는 너무 무거운 객체이다
		// 어트리뷰트만 처리할 수 있는 간소화된 객체 Model을 사용한다 (스프링에서 사용하는 객체)
		
		// request.setCharacterEncoding("UTF-8"); 이 코드는 web.xml 에서 필터로 처리할 것임
		String adult = age >= 20 ? "성인" : "미성년자";
		
		String msg = String.format("%s의 나이는 %d살이고, %s입니다", name, age, adult);
		model.addAttribute("msg", msg);
		
		return "ex02-result";
	}

}
