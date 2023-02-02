package com.itbank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itbank.model.ReplyDTO;
import com.itbank.service.BoardService;

@RestController
@RequestMapping("/board/reply")
public class ReplyController {

	@Autowired private BoardService boardService;
	
	@GetMapping("/{board_idx}")
	public List<ReplyDTO> getReplyList(@PathVariable("board_idx") int board_idx) {
		List<ReplyDTO> list = boardService.getReplyList(board_idx);
		return list;
	}
	
	@PostMapping("/{board_idx}")
	public int writeReply(@RequestBody ReplyDTO dto) {
		System.out.println(dto.getBoard_idx());
		System.out.println(dto.getWriter());
		System.out.println(dto.getContent());
		int row = boardService.writeReply(dto);
		return row;
	}
	
	@DeleteMapping("/{board_idx}/{idx}")
	public int deleteReply(@PathVariable("idx") int idx) {
		int row = 0;
		System.out.println("삭제할 댓글 idx : " + idx);
		return row;
	}
}




