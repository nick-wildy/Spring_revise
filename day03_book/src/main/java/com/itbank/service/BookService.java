package com.itbank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itbank.model.BookDTO;
import com.itbank.repository.BookDAO;

@Service
public class BookService {
	
	@Autowired private BookDAO dao;

	public List<BookDTO> getList() {
		
		return dao.selectList();
	}

	public int add(BookDTO dto) {
		
		return dao.insert(dto);
	}

	public BookDTO getOne(int idx) {
	
		return dao.selectOne(idx);
	}

	public int delete(int idx) {
	
		return dao.delete(idx);
	}

	public List<BookDTO> search1(String keyword) {
		
		return dao.search(keyword);
	}

	public int modify(BookDTO dto) {
		
		return dao.update(dto);
	}

	
}
