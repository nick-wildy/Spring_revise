package com.itbank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;
import org.springframework.web.servlet.ModelAndView;

import com.itbank.service.FileService;

@Controller
public class Ex01Controller {
	
	@Autowired private FileService fileService;
	
	@GetMapping("/ex01")
	public void ex01() {}
	
	@PostMapping("/ex01")
	public ModelAndView ex01(MultipartRequest request) {
		// HttpServletRequest를 MultipartRequest로 변환하는 코드를 작성할 필요가 없다
		// Service의 함수를 호출할 때는, 가급적 request를 넘기지 않는다
		ModelAndView mav = new ModelAndView("redirect:/ex01");
		
		MultipartFile file = request.getFile("uploadFile");
		System.out.println(file.getContentType());		// 파일의 유형
		System.out.println(file.getName());				// input의 name
		System.out.println(file.getOriginalFilename());	// 파일의 원래 이름
		System.out.println(file.getSize());				// 파일 크기 (byte)
		System.out.println("=============================");
		
		int row = fileService.upload(file);
		System.out.println(row);
		
		return mav;
	}

}
