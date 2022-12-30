package com.itbank.repository;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.itbank.model.BookDTO;

@Repository
public interface BookDAO {

	List<BookDTO> selectListAll();

	List<BookDTO> selectSearchList(HashMap<String, String> param);

	int insertBook(BookDTO dto);

	BookDTO selectOne(int idx);

	int update(BookDTO dto);

	int delete(int idx);
	
}











