package com.itbank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.itbank.service.FileService;

import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class Ex02Controller {
	
	@Autowired private FileService fileService;

	@GetMapping("/ex02")
	public void ex02() {}
	
	@PostMapping("/ex02")
	public ModelAndView ex02(MultipartFile uploadFile) {
		// request 없이 parameter를 단일 변수로 받을 수 있듯
		// MultipartRequest를 지정하지 않아도 곧바로 MultipartFile로 받을 수 있다
		
		ModelAndView mav = new ModelAndView("redirect:/ex02");
		int row = fileService.upload(uploadFile);
		System.out.println(row);
		return mav;
	}
}
