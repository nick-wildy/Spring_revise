package com.itbank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.itbank.model.Ex03DTO;
import com.itbank.service.FileService;

@Controller
@RequestMapping("/ex03")
public class Ex03Controller {
	
	@Autowired private FileService fileService;

	@GetMapping
	public ModelAndView ex03() {
		ModelAndView mav = new ModelAndView();
		List<Ex03DTO> list = fileService.getList();
		mav.addObject("list", list);
		return mav;
	}
	
	@PostMapping
	public ModelAndView ex03(Ex03DTO dto) {
		
		System.out.println(dto.getName());
		System.out.println(dto.getAge());
		System.out.println(dto.getUploadFile().getOriginalFilename());
		System.out.println("===============================");
		
		
		ModelAndView mav = new ModelAndView("redirect:/ex03");
		int row = fileService.uploadDTO(dto);
		System.out.println(row);
		return mav;
	}
}
