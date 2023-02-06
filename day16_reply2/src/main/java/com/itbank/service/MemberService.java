package com.itbank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itbank.model.MemberDTO;
import com.itbank.repository.MemberDAO;

@Service
public class MemberService {

	@Autowired private MemberDAO dao;
	
	public int join(MemberDTO dto) {
		return dao.insert(dto);
	}

	public MemberDTO login(MemberDTO dto) {
		return dao.login(dto);
	}

	public int modify(MemberDTO dto) {
		// dto의 각 필드가 빈문자열이 있으면 null로 바꾼다
		return dao.update(dto);
	}

	public MemberDTO getMember(String userid) {
		return dao.selectOne(userid);
	}

	public int withdraw(String userid) {
		return dao.delete(userid);
	}

	public int dupCheck(String inputId) {
		return dao.selectUseridCount(inputId);
	}

}
