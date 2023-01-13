package com.itbank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itbank.model.MemberDTO;
import com.itbank.repository.MemberDAO;

@Service
public class MemberService {
	@Autowired private MemberDAO dao;

	public int add(MemberDTO dto) {
		return dao.insert(dto);
	}

	public MemberDTO login(MemberDTO dto) {
		
		return dao.login(dto);
	}

	public int modify(MemberDTO dto) {
	
		return dao.update(dto);
	}

	public int delete(int idx) {
	
		return dao.delete(idx);
	}
}
