package com.itbank.service;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.itbank.model.HomeplusDTO;
import com.itbank.repository.HomeplusDAO;

@Service
public class HomeplusService {
	
	@Autowired private HomeplusDAO dao;
	
	private String saveDirectory = "D:\\upload_homeplus";
	
	public HomeplusService() {
		File dir = new File(saveDirectory);
		if(dir.exists() == false) {
			dir.mkdirs();
		}
	}

	public List<HomeplusDTO> getList() {
		return dao.selectList();
	}
	
	// 업로드 받은 파일 이름의 새로운 파일 이름을 반환하는 함수 (문자열 처리) 
	private String makeNewName(String productName, String oldName, String imageType) {
		String today = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
		String ext = oldName.substring(oldName.lastIndexOf("."));
		String newName = today + "_" + productName + "_" + imageType;
		newName += ext;
		return newName;
	}

	public int add(HomeplusDTO dto) {
		// 1) 파일을 업로드 한다 (파일 이름 새로 변경해주기)
		MultipartFile thumbnail = dto.getThumbnailFile();
		MultipartFile reviewImage = dto.getReviewImageFile();
		
		String newName1 = makeNewName(dto.getProductName(), thumbnail.getOriginalFilename(), "thumbnail");
		String newName2 = makeNewName(dto.getProductName(), reviewImage.getOriginalFilename(), "reviewImage");
		
		File dest1 = new File(saveDirectory, newName1);
		File dest2 = new File(saveDirectory, newName2);
		
		int row = 0;
		
		try {
			thumbnail.transferTo(dest1);
			reviewImage.transferTo(dest2);
			
			dto.setThumbnail(newName1);
			dto.setReviewImage(newName2);
			
			// 2) 변경된 파일이름을 포함하는 dto를 dao에게 전달한다
			row = dao.insert(dto);
			
		} catch(IllegalStateException | IOException e) {
			// 용량이 부족하거나, saveDirectory가 존재하지 않으면 예외발생
			// 지정한 용량(10MB)를 초과하면 예외 발생
			e.printStackTrace();
		}
		
		return row;
	}

	public HomeplusDTO get(int idx) {
		return dao.selectOne(idx);
	}

	public int modify(HomeplusDTO dto) throws IllegalStateException, IOException {
//		System.out.println(dto.getThumbnailFile().getSize() != 0);
//		System.out.println(dto.getReviewImageFile().getSize() != 0);
		
		MultipartFile thumbnailFile = dto.getThumbnailFile();
		MultipartFile reviewImageFile = dto.getReviewImageFile();
		
		if(thumbnailFile.getSize() != 0) {
			File oldFile1 = new File(saveDirectory, dto.getThumbnail());
			if(oldFile1.exists()) {
				oldFile1.delete();
			}
			String newName1 = makeNewName(dto.getProductName(), thumbnailFile.getOriginalFilename(), "thumbnail");
			dto.setThumbnail(newName1);
			File dest1 = new File(saveDirectory, dto.getThumbnail());
			thumbnailFile.transferTo(dest1);
		}
		if(reviewImageFile.getSize() != 0) {
			File oldFile2 = new File(saveDirectory, dto.getReviewImage());
			if(oldFile2.exists()) {
				oldFile2.delete();
			}
			String newName2 = makeNewName(dto.getProductName(), reviewImageFile.getOriginalFilename(), "reviewImage");
			dto.setReviewImage(newName2);
			File dest2 = new File(saveDirectory, dto.getReviewImage());
			reviewImageFile.transferTo(dest2);
		}
		int row = dao.update(dto);
		return row;
	}

	public List<HomeplusDTO> getListOrderBy(String orderBy) {
		return dao.selectListOrderBy(orderBy);
	}

	public int getCount() {
		return dao.selectCount();
	}

	public List<HomeplusDTO> getSearchList(String keyword) {
		return dao.selectSearchList(keyword);
	}

}













