package com.itbank.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itbank.model.BookDTO;
import com.itbank.repository.BookDAO;

@Service
public class BookService {
	
	@Autowired private BookDAO dao;

	public List<BookDTO> getList() {
		return dao.selectListAll();
	}

	public List<BookDTO> getSearchList(HashMap<String, String> param) {
		return dao.selectSearchList(param);
	}

	public int add(BookDTO dto) {
		return dao.insertBook(dto);
	}

	public BookDTO getDTO(int idx) {
		return dao.selectOne(idx);
	}

	public int modify(BookDTO dto) {
		return dao.update(dto);
	}

	public int remove(int idx) {
		return dao.delete(idx);
	}

}
