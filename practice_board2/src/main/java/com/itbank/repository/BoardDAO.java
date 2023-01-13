package com.itbank.repository;

import java.util.List;

import com.itbank.model.BoardDTO;

public interface BoardDAO {

	List<BoardDTO> selectList();

	int insert(BoardDTO dto);

	BoardDTO selectOne(int idx);

	int update(BoardDTO dto);

	int updat2(BoardDTO dto);

	int delete(int idx);

	List<BoardDTO> searchList(String keyword);

	int uploadText(BoardDTO dto);

	int selectViewCount(int idx);

}
