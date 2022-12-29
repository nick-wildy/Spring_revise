package com.itbank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.itbank.model.BookDTO;
import com.itbank.service.BookService;

@Controller
public class BookeController {
	
	@Autowired private BookService bookService;
	
	@GetMapping("/list")
	public ModelAndView list() {
		ModelAndView mav = new ModelAndView();
		List<BookDTO> list = bookService.getList();
		mav.addObject("list",list);
		return mav;		
	}
	
	@PostMapping("/list")
	public ModelAndView showList(String keyword) {
		ModelAndView mav = new ModelAndView("/list");
		List<BookDTO> list = bookService.search1(keyword);
		mav.addObject("list",list);
		
		return mav;
	}
	
	@GetMapping("/add")
	public void add() {}
	
	@PostMapping("/add")
	public String add2(BookDTO dto) {
		int row=bookService.add(dto);
		System.out.println(row == 1 ? "추가성공" : "추가 실패");
		
		return "redirect:/list";
	}
	@GetMapping("/modify")
	public ModelAndView modify(int idx) {
		ModelAndView mav = new ModelAndView();
		BookDTO dto = bookService.getOne(idx);
		mav.addObject("dto",dto);
		
		return mav;
	}
	@PostMapping("modify")
	public String update(BookDTO dto) {
		int row=bookService.modify(dto);
		System.out.println(row==1 ? "수정성공" : "수정실패");
		return "redirect:/list";
	}
	
	
	@GetMapping("/delete")
	public String delete(int idx) {
		int row=bookService.delete(idx);
		System.out.println(row==1 ? "삭제성공":"삭제실패");
		
		return "redirect:/";
	}
	
	@GetMapping("/detail")
	public ModelAndView detail(int idx) {
		ModelAndView mav = new ModelAndView();
		BookDTO dto = bookService.getOne(idx);
		mav.addObject("dto",dto);
		return mav;
	}
	
	@GetMapping("/search")
	public void search() {};
	
	@PostMapping("/search")
	public ModelAndView search(String keyword) {
		ModelAndView mav = new ModelAndView("/list");
		List<BookDTO> list = bookService.search1(keyword);
		mav.addObject("list",list);
		
		return mav;
	}
	
	
	

}
