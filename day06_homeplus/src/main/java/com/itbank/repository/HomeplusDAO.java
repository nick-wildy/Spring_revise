package com.itbank.repository;

import java.util.List;

import com.itbank.model.HomeplusDTO;

public interface HomeplusDAO {

	List<HomeplusDTO> selectList();

	int insert(HomeplusDTO dto);

	HomeplusDTO selectOne(int idx);

	int update(HomeplusDTO dto);

	List<HomeplusDTO> selectListOrderBy(String orderBy);

	int selectCount();

	List<HomeplusDTO> selectSearchList(String keyword);

}



















