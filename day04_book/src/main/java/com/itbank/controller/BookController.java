package com.itbank.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.itbank.model.BookDTO;
import com.itbank.service.BookService;

@Controller
public class BookController {

	@Autowired private BookService bookService;
	
	@GetMapping("/list")
	public ModelAndView list() {
		ModelAndView mav = new ModelAndView("list");
		List<BookDTO> list = bookService.getList();
		mav.addObject("list", list);
		return mav;
	}
	
	@PostMapping("/list")
	public ModelAndView search(@RequestParam HashMap<String, String> param) {
		ModelAndView mav = new ModelAndView("list");
		List<BookDTO> list = bookService.getSearchList(param);
		mav.addObject("list", list);
		return mav;
	}

	@GetMapping("/add")
	public void add() {}
	
	@PostMapping("/add")
	public ModelAndView add(BookDTO dto) {
		int row = bookService.add(dto);
//		System.out.println(row != 0 ? "추가 성공" : "추가 실패");
		
		ModelAndView mav = new ModelAndView("redirect:/list");
		mav.addObject("msg", "add:" + (row != 0 ? "success" : "failure"));
		// 리다이렉트 할때 mav에 addObject를 수행하면 주소창의 파라미터(쿼리스트링)로 전달된다
		return mav;
	}
	
	@GetMapping("/view/{idx}")
	public ModelAndView view(@PathVariable("idx") int idx) {
		// PathVariable : 요청 주소의 일부를 파라미터처럼 받아서 활용한다
		// PathVariable 을 사용하면 viewName 지정을 생략하면 안된다
		
		ModelAndView mav = new ModelAndView("view");
		BookDTO dto = bookService.getDTO(idx);
		mav.addObject("dto", dto);
		return mav;
	}
	
	@GetMapping("/modify/{idx}")
	public ModelAndView modify(@PathVariable("idx") int idx) {
		ModelAndView mav = new ModelAndView("modify");
		BookDTO dto = bookService.getDTO(idx);
		mav.addObject("dto", dto);
		return mav;
	}
	
	@PostMapping("/modify/{idx}")
	public ModelAndView modify(BookDTO dto) {
		ModelAndView mav = new ModelAndView("redirect:/list");
		int row = bookService.modify(dto);
		mav.addObject("msg", "modify:" + (row != 0 ? "success" : "failure"));
		return mav;
	}
	
	@GetMapping("/delete/{idx}")
	public ModelAndView delete(@PathVariable("idx") int idx) {
		ModelAndView mav = new ModelAndView("redirect:/list");
		int row = bookService.remove(idx);
		mav.addObject("msg", "delete:" + (row != 0 ? "success" : "failure"));
		return mav;
	}


}







