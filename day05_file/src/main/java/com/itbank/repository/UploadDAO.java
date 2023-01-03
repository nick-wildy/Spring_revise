package com.itbank.repository;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.itbank.model.Ex03DTO;
import com.itbank.model.Ex04DTO;

@Repository
public interface UploadDAO {
	
	@Insert("insert into uploadTest3 values (#{name}, #{age}, #{fileName})")
	int insert(Ex03DTO dto);
	
	@Select("select * from uploadTest3")
	List<Ex03DTO> selectAll();

	@Insert("insert into uploadTest3 values (#{name}, #{age}, #{fileName})")
	int insertEx04DTO(Ex04DTO dto);

}
