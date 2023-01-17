package com.itbank.repository;

import org.springframework.stereotype.Repository;

import com.itbank.model.MemberDTO;

@Repository
public interface MemberDAO {

	public int insert(MemberDTO dto);

	public MemberDTO login(MemberDTO dto);

	public int update(MemberDTO dto);

	public MemberDTO selectOne(String userid);

	public int delete(String userid);

	public int selectUseridCount(String inputId);

}
