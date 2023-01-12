package com.itbank.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itbank.model.BoardDTO;
import com.itbank.repository.BoardDAO;

@Service
public class BoardService {

	@Autowired private BoardDAO dao;
	
	public List<BoardDTO> getListAll(Integer page) {
		HashMap<String, Object> param = new HashMap<String, Object>();
		
		int perPage = 10;					// 페이지 당 10개
		int offset = (page - 1) * perPage;	// 건너뛸 개수 (1->0, 2->10, 3->20...)
		param.put("offset", offset);
		param.put("perPage", perPage);
		
		return dao.selectAll(param);
	}

	public BoardDTO get(int idx) {
		return dao.selectOne(idx);
	}

	public int write(BoardDTO dto) {
		return dao.insert(dto);
	}

	public int modify(BoardDTO dto) {
		return dao.modify(dto);
	}

	public int delete(int idx) {
		return dao.delete(idx);
	}

	public int getBoardCount() {
		return dao.selectBoardCount();
	}

}
