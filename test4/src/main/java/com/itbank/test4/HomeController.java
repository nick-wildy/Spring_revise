package com.itbank.test4;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itbank.service.TestService;

@Controller
public class HomeController {
	
	@Autowired private TestService testService;
	
	@RequestMapping("/")
	public String home(HttpServletRequest request) {
		String dbVersion = testService.getVersion();
		request.setAttribute("dbVersion", dbVersion);
		return "home";
	}
}