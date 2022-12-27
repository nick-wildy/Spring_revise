package com.itbank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.itbank.service.UpdownService;

@Controller	// 요청을 받아서, 응답을 만들어주는 기능
@RequestMapping("/updown")
public class UpDownController {
	
	@Autowired private UpdownService updownService;
	// Autowired : 스프링 빈 간의 객체 의존성을 자동으로 주입해준다
	// DI : Dependency Injection (의존 주입)
	// Auto DI : 자동 의존 주입

	@GetMapping
	public void updown() {			// 파라미터 없이 GET으로 접근하면
		updownService.initialize();	// 게임을 처음부터 시작하도록 초기화한다
	}
	
	@PostMapping
	public ModelAndView updown(int user) {
		ModelAndView mav = new ModelAndView();
		
		String status = updownService.getStatus(user);
		
		switch(status) {
		case "Correct":
			mav.setViewName("clear");
			break;
		}
		
		mav.addObject("status", status);
		return mav;
	}
	
}
