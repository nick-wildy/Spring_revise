package com.itbank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.itbank.model.HomeplusDTO;
import com.itbank.service.HomeplusService;

@Controller
public class HomeplusController {
	@Autowired private HomeplusService homeplusService;
	
	
	@GetMapping("/list")
	public ModelAndView list() {
		ModelAndView mav = new ModelAndView();
		List<HomeplusDTO> list = homeplusService.getList();
		mav.addObject("list",list);
		return mav;
	}
	
	@PostMapping("/list")
	public ModelAndView search(String keyword){
		ModelAndView mav = new ModelAndView();
		List<HomeplusDTO> list = homeplusService.search(keyword);
		mav.addObject("list",list);
		return mav;
	}
	@GetMapping("/add")
	public void add() {}
	
	@PostMapping("/add")
	public ModelAndView add(HomeplusDTO dto) {
		ModelAndView mav = new ModelAndView("redirect:/list");
		int row = homeplusService.add(dto);
		System.out.println(row);
		
		return mav;
	}
	
	@GetMapping("/detail")
	public ModelAndView detail(int idx) {
		ModelAndView mav = new ModelAndView();
		HomeplusDTO dto = homeplusService.getOne(idx);
		mav.addObject("dto",dto);
		return mav;
	}
	
	@GetMapping("/delete")
	public ModelAndView delete(int idx) {
		ModelAndView mav = new ModelAndView();
		int row = homeplusService.delete(idx);
		mav.addObject("msg", "delete:" + (row != 0 ? "success" : "failure"));
		return mav;
	}
	
	@GetMapping("/modify")
		public ModelAndView modify(int idx) {
		ModelAndView mav = new ModelAndView();
		HomeplusDTO dto = homeplusService.getOne(idx);
		mav.addObject("dto",dto);
		return mav;
	}
	
	@PostMapping("/modify")
	public ModelAndView modify(HomeplusDTO dto) {
		ModelAndView mav = new ModelAndView("redirect:/list");
		int row = homeplusService.modify(dto);
		mav.addObject("msg",  "modify:" + (row != 0 ? "success" : "failure"));
		
		return mav;
	}
	
	

}
