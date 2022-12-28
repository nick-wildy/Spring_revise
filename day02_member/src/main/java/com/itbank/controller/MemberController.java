package com.itbank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.itbank.model.MemberDTO;
import com.itbank.service.MemberService;

@Controller
public class MemberController {
	
	@Autowired private MemberService memberService;
	
	@GetMapping("/list")
	public ModelAndView list() {
		ModelAndView mav = new ModelAndView();
		List<MemberDTO> list = memberService.getList();
		mav.addObject("list",list);
		
		return mav;
	}
	@GetMapping("/add")
	public void member() {}
	
	@PostMapping("/add")
	public String member(MemberDTO dto) {
		int row= memberService.insert(dto);
		System.out.println(row !=0 ? "추가성공" : "추가실패");
		
		return "redirect:/list";
	}
	
	@GetMapping("/delete")
	public void delete() {}
	
	@PostMapping("/delete")
	public String delete1(int idx) {
		int row =memberService.delete(idx);
		
		return "redirect:/list";
	}
	
	
	
	
	

}
