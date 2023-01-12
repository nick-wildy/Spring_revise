package com.itbank.controller;

import java.util.List;

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
	
	@GetMapping("/list")						// [http://localhost:8080/day10_board/board/list]
	public ModelAndView list(Integer page) {	// viewName : /board/list
		ModelAndView mav = new ModelAndView();	// forward : /WEB-INF/views/board/list.jsp
		
		if(page == null) {	// 파라미터가 들어오지 않았다면
			page = 1;		// 기본은 1페이지
		}
		List<BoardDTO> list = boardService.getListAll(page);
		mav.addObject("list", list);
		
		// 페이징 기초 작업 (게시글의 총량, 페이지의 개수 확인)
		int boardCount = boardService.getBoardCount();	// 총 게시글 개수 (213)
		int perPage = 10;						// 화면당 출력할 게시글 개수	(10)
		int pageCount = boardCount / perPage;	// (21)
		if(boardCount % perPage != 0) {
			pageCount += 1;
		}
		mav.addObject("pageCount", pageCount);
		return mav;
	}
	
	@GetMapping("/view/{idx}")
	public ModelAndView view(@PathVariable("idx") int idx) {
		ModelAndView mav = new ModelAndView("/board/view");
		BoardDTO dto = boardService.get(idx);
		mav.addObject("dto", dto);
		return mav;
	}
	
	@GetMapping("/write")
	public void write() {}
	
	@PostMapping("/write")
	public String write(BoardDTO dto) {
		int row = boardService.write(dto);
		System.out.println(row != 0 ? "작성 성공" : "작성 실패");
		return "redirect:/board/list";
	}
	
	@GetMapping("/modify/{idx}")
	public ModelAndView modify(@PathVariable("idx") int idx) {
		ModelAndView mav = new ModelAndView("/board/modify");
		BoardDTO dto = boardService.get(idx);
		mav.addObject("dto", dto);
		return mav;
	}
	
	@PostMapping("/modify/{idx}")
	public String modify(BoardDTO dto) {
		int row = boardService.modify(dto);
		System.out.println(row != 0 ? "수정 성공" : "수정 실패");
		return "redirect:/board/view/" + dto.getIdx();
	}
	
	@GetMapping("/delete/{idx}")
	public String delete(@PathVariable("idx") int idx) {
		int row = boardService.delete(idx);
		System.out.println(row != 0 ? "삭제 성공" : "삭제 실패");
		return "redirect:/board/list";
	}

}




