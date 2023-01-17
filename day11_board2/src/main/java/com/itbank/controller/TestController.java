package com.itbank.controller;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.itbank.service.TestService;

@Controller
public class TestController {

	@Autowired private TestService testService;
	
	@GetMapping("/ex01")
	public ModelAndView ex01() {
		ModelAndView mav = new ModelAndView();
		String version = testService.getVersion();
		mav.addObject("version", version);
		return mav;
	}
	
	@GetMapping("/ex02")
	public ModelAndView ex02() {
		ModelAndView mav = new ModelAndView();
		Date sysdate = testService.getSysDate();
		mav.addObject("sysdate", sysdate);
		return mav;
	}
}
