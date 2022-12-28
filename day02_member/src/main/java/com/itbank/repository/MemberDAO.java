package com.itbank.repository;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.itbank.model.MemberDTO;

public interface MemberDAO {
	
	@Select("select * from member5")
	List<MemberDTO> selectList();
	
	@Insert("insert into member5 (userid, userpw, username, birth, gender) values(#{userid}, #{userpw}, #{username}, #{birth}, #{gender})")
	int insert(MemberDTO dto);
	
	
	
	@Delete("delete from member5 where idx= #{idx}")
	int delete(int idx);



}
