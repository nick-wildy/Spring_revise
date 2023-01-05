package com.itbank.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.itbank.model.HomeplusDTO;
import com.itbank.service.HomeplusService;

@Controller
public class HomeplusController {

	@Autowired private HomeplusService homeplusService;
	
	@GetMapping("/")
	public String home() {
		return "redirect:/list";
	}
	
	// 전체 목록
	@GetMapping("/list")
	public ModelAndView list() {
		ModelAndView mav = new ModelAndView("list");
		List<HomeplusDTO> list = homeplusService.getList();
		int count = homeplusService.getCount();
		mav.addObject("list", list);
		mav.addObject("count", count);
		return mav;
	}
	
	// 검색
	@PostMapping("/list")
	public ModelAndView search(String keyword) {
		ModelAndView mav = new ModelAndView();
		List<HomeplusDTO> list = homeplusService.getSearchList(keyword);
		mav.addObject("list", list);
		return mav;
	}
	
	// 정렬
	@GetMapping("/list/{orderBy}")
	public ModelAndView sort(@PathVariable("orderBy") String orderBy) {
		ModelAndView mav = new ModelAndView("list");
//		System.out.println(orderBy);
		List<HomeplusDTO> list = homeplusService.getListOrderBy(orderBy);
		int count = homeplusService.getCount();
		mav.addObject("count", count);
		mav.addObject("list", list);
		return mav;
	}
	
	// 추가
	@GetMapping("/add")
	public void add() {}
	
	@PostMapping("/add")
	public String add(HomeplusDTO dto) {
		int row = homeplusService.add(dto);
		
		return "redirect:/list";
	}
	
	// 단일 조회 (쿼리스트링 or 경로변수)
	@GetMapping("/view/{idx}")
	public ModelAndView view(@PathVariable("idx") int idx) {
		ModelAndView mav = new ModelAndView("view");
		HomeplusDTO dto = homeplusService.get(idx);
		mav.addObject("dto", dto);
		return mav;
	}
	
	// 수정
	@GetMapping("/modify/{idx}")
	public ModelAndView modify(@PathVariable("idx") int idx) {
		ModelAndView mav = new ModelAndView("modify");
		HomeplusDTO dto = homeplusService.get(idx);
		mav.addObject("dto", dto);
		return mav;
	}
	@PostMapping("/modify/{idx}")
	public String modify(HomeplusDTO dto) throws IllegalStateException, IOException {
		int row = homeplusService.modify(dto);
		return "redirect:/view/" + dto.getIdx();
	}
	
	// 삭제
	@GetMapping("/delete/{idx}")
	public String delete(@PathVariable("idx") int idx) {
		return "redirect:/list";
	}
	
	
}
