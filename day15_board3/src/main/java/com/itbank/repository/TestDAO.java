package com.itbank.repository;

import java.sql.Date;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface TestDAO {

	@Select("select banner from v$version")
	String selectVersion();

	@Select("select sysdate from dual")
	Date selectSysDate();

}
