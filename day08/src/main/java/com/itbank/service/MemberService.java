package com.itbank.service;

import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itbank.exception.TooShortUseridExceptoin;
import com.itbank.exception.WrongPasswordException;
import com.itbank.model.MemberDTO;
import com.itbank.repository.MemberDAO;

@Service
public class MemberService {

	@Autowired private MemberDAO dao;
	
	public List<MemberDTO> getList() {
		return dao.selectList();
	}

	public int add(MemberDTO dto) throws TooShortUseridExceptoin, WrongPasswordException {
		// 입력받은 나이가 0이면 예외가 발생함
		int age = Integer.parseInt(new SimpleDateFormat("yyyy").format(dto.getBirth()));
		age = 2023 - age;
		int tmp = 100 / age;
		//===========================
		
		// 입력받은 ID가 8글자 미만이면 강제로 예외 발생시키기
		if(dto.getUserid().length() < 8) {
			throw new TooShortUseridExceptoin();
		}
		
		// 패스워드 규칙에 어긋나면 예외 발생시키기 (문자열 처리)
		if(isWrongPassword(dto.getUserpw())) {
			throw new WrongPasswordException();
		}
		// 패스워드 규칙에 어긋나면 예외 발생시키기 (정규식)
		if(isWrongPasswordRegExp(dto.getUserpw())) {
			throw new WrongPasswordException();
		}
		
		return dao.insert(dto);
	}
	private boolean isWrongPassword(String userpw) {
		String filter = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		if(userpw.length() < 8) {
			return true;
		}
		for(char ch : userpw.toCharArray()) {
			if(filter.contains(ch + "") == false) {
				return true;
			}
		}
		return false;
	}
	
	private boolean isWrongPasswordRegExp(String userpw) {
		String regex = "^[a-zA-Z0-9]{8,}$";		
		boolean flag = userpw.matches(regex) == false;	// 조건을 만족하지 않으면 true
		System.out.println(flag);
		return flag;
	}

}
