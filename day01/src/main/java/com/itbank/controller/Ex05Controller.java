package com.itbank.controller;

import java.util.HashMap;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/ex05")
public class Ex05Controller {

	@GetMapping
	public void ex05() {}
	
	@PostMapping
	public ModelAndView ex05(@RequestParam HashMap<String, String> param) {
		// param.put("name", request.getParameter("name"));
		// param.put("age", "30");
		
		ModelAndView mav = new ModelAndView("ex05-result");
		String name = param.get("name");
		int age = Integer.parseInt(param.get("age"));
		String adult = age >= 20 ? "성인" : "미성년자";
		String msg = String.format("%s의 나이는 %d살이고, %s입니다", name, age, adult);
		mav.addObject("msg", msg);
		return mav;
	}
	
}
