package com.itbank.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/ex03")		// 현재 클래스의 모든 함수에 적용되는 RequestMapping (주소만)
public class Ex03Controller {
	
	@GetMapping				// 같은 주소에서 요청 메서드에 따라 구분(GET)
	public void ex03() {}
	
	@PostMapping			// 같은 주소에서 요청 메서드에 따라 구분(POST)
	public ModelAndView ex03(@RequestParam("name") String name, @RequestParam("age") int age) {	
		
		// 사용자 입력에 의해 들어오는 값만 매개변수
		ModelAndView mav = new ModelAndView();	// Model model
												// String viewName
		
		mav = new ModelAndView("ex03-result");	// 생성자 매개변수로 viewName을 전달하기
		
		mav.setViewName("ex03-result");	// setter로 viewName을 전달하기(포워드시킬 jsp의 이름)
		
		String adult = age >= 20 ? "성인" : "미성년자";
		String msg = String.format("%s의 나이는 %d살이고, %s입니다", name, age, adult);
		
		mav.addObject("msg", msg);	// jsp 에게 넘길 attribute(object)
		
		return mav;
	}
}
