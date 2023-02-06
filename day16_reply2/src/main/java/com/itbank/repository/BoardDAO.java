package com.itbank.repository;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.itbank.model.BoardDTO;
import com.itbank.model.ReplyDTO;

@Repository
public interface BoardDAO {

	List<BoardDTO> selectAll(HashMap<String, Object> param);

	BoardDTO selectOne(int idx);

	int insert(BoardDTO dto);

	int modify(BoardDTO dto);

	int delete(int idx);

	int selectBoardCount();

	int updateViewCount(int idx);

	List<ReplyDTO> selectReplyList(int board_idx);

	int insertReply(ReplyDTO dto);

}
