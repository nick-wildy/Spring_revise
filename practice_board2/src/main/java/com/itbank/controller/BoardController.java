package com.itbank.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.itbank.model.BoardDTO;
import com.itbank.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {
	@Autowired private BoardService boardService;
	
	@GetMapping("/list")
	public ModelAndView list() {
		ModelAndView mav = new ModelAndView();
		List<BoardDTO> list = boardService.getList();
		mav.addObject("list",list);
		return mav;
	}
	@PostMapping("/list")
	public ModelAndView list(String keyword) {
		ModelAndView mav = new ModelAndView("/board/list");
		List<BoardDTO> list = boardService.searchList(keyword);
		mav.addObject("list",list);
		return mav;
	}
	
	@GetMapping("/write")
	public void write() {}
	
	@PostMapping("/write")
	public String wirte(BoardDTO dto, HttpServletRequest request) {
		dto.setIpaddr(request.getRemoteAddr());
		int row=boardService.upload(dto);
		System.out.println(row==1?"추가성공":"추가실패");
		return "redirect:/board/list";
	}
	@GetMapping("/detail/{idx}")
	public ModelAndView detail(@PathVariable("idx") int idx) {
		ModelAndView mav = new ModelAndView("/board/detail");
		BoardDTO dto = boardService.getOne(idx);
		int row = boardService.getViewcount(idx);
		System.out.println(row==1?"조회수업" : "실패");
		mav.addObject("dto",dto);
		
		return mav;
	}
	
	@GetMapping("/modify/{idx}")
	public ModelAndView modify(@PathVariable("idx") int idx) {
		ModelAndView mav = new ModelAndView("/board/modify");
		BoardDTO dto = boardService.getOne(idx);
		mav.addObject("dto",dto);
		return mav;
	}
	
	@PostMapping("/modify/{idx}")
	public String modify(BoardDTO dto, HttpServletRequest request) {
		dto.setIpaddr(request.getRemoteAddr());
		int row =boardService.modify(dto);
		System.out.println(row==1?"수정성공":"수정실패");
		
		return "redirect:/board/list";
	}
	
	@GetMapping("/delete/{idx}")
	public String delete(@PathVariable("idx") int idx) {
		int row = boardService.delete(idx);
		System.out.println(row==1? "삭제서공":"삭제실패");
		
		return "redirect:/board/list";
	}
	

}
