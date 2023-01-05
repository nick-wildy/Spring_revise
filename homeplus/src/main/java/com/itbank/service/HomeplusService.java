package com.itbank.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itbank.model.HomeplusDTO;
import com.itbank.repository.HomeplusDAO;

@Service
public class HomeplusService {
	
	@Autowired private HomeplusDAO dao;
	
	private final String saveDirectory = "D:\\homeplus";
	
	public HomeplusService() {
		File dir = new File(saveDirectory);
		if(dir.exists()==false) {
			dir.mkdir();
		}
	}

	public List<HomeplusDTO> getList() {
		
		return dao.selectList();
	}

	public int add(HomeplusDTO dto) {
		File dest = new File(saveDirectory, dto.getThumbnailFile().getOriginalFilename());
		File dest2 = new File(saveDirectory,dto.getReviewImageFile().getOriginalFilename());
		
		try {
			dto.getThumbnailFile().transferTo(dest);
			dto.getReviewImageFile().transferTo(dest2);
			dto.setThumbnail(dto.getThumbnailFile().getOriginalFilename());
			dto.setReviewImage(dto.getReviewImageFile().getOriginalFilename());
			int row = dao.insert(dto);
			System.out.println(dto.getThumbnail());
			return row;
		 } catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
		
		return 0;
	}

	public HomeplusDTO getOne(int idx) {
		
		return dao.selectOne(idx);
	}

	public int delete(int idx) {
		
		return dao.delete(idx);
	}

	public int modify(HomeplusDTO dto) {
		if(dto.getThumbnailFile().getSize() == 0 && dto.getReviewImageFile().getSize()==0) {
			int row = dao.update2(dto);
			return row;
		}
		
					
		File dest = new File(saveDirectory, dto.getThumbnailFile().getOriginalFilename());
		File dest2 = new File(saveDirectory,dto.getReviewImageFile().getOriginalFilename());
			
		try {
			dto.getThumbnailFile().transferTo(dest);
			dto.getReviewImageFile().transferTo(dest2);
			dto.setThumbnail(dto.getThumbnailFile().getOriginalFilename());
			dto.setReviewImage(dto.getReviewImageFile().getOriginalFilename());
			int row = dao.update(dto);
			System.out.println(dto.getThumbnail());
			return row;
		 } catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
		
		return 0;
	}

	public List<HomeplusDTO> search(String keyword) {
		
		return dao.searchAll(keyword);
	}
	

}
