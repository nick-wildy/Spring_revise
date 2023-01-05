package com.itbank.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.itbank.model.HomeplusDTO;

@Repository
public interface HomeplusDAO {

	List<HomeplusDTO> selectList();

	int insert(HomeplusDTO dto);

	HomeplusDTO selectOne(int idx);

	int delete(int idx);

	int update(HomeplusDTO dto);

	int update2(HomeplusDTO dto);

	List<HomeplusDTO> searchAll(String keyword);
}
