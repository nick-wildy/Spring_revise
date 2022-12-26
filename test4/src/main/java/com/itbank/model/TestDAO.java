package com.itbank.model;

import java.sql.ResultSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class TestDAO {
	
	@Autowired	// 스프링 컨테이너에 등록된 스프링 빈 중에서 타입이 일치하는 객체를 자동으로 연결한다
	private JdbcTemplate jdbcTemplate;

	public String selectVersion() {
		// DB에 접근해서 데이터를 불러오려면, Connection이 필요하다
		
		String sql = "select banner from v$version";
		RowMapper<String> mapper = (ResultSet rs, int rowNum) -> rs.getString(1);
		String data = jdbcTemplate.queryForObject(sql, mapper);
		System.out.println(data);
		return data;
	}

}
