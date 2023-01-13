package com.itbank.repository;

import org.springframework.stereotype.Repository;

import com.itbank.model.MemberDTO;

@Repository
public interface MemberDAO {

	int insert(MemberDTO dto);

	MemberDTO login(MemberDTO dto);

	int update(MemberDTO dto);

	int delete(int idx);

}
