package com.itbank.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.itbank.model.MemberDTO;

// @Repository 의 기능
// 1) 스프링 MVC에서 DAO의 역할을 수행하는 스프링 빈으로 등록한다
// 2) 해당 클래스에서 발생하는 예외를 java.sql.DataAccessException 으로 형변환하여 throws 한다

@Repository
public interface MemberDAO {

	List<MemberDTO> selectList();

	int insert(MemberDTO dto);

}
