package com.itbank.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.itbank.model.Ex03DTO;
import com.itbank.model.Ex04DTO;
import com.itbank.repository.UploadDAO;

@Service
public class FileService {
	
	@Autowired private UploadDAO dao;
	
	private final String saveDirectory = "D:\\upload_2023";
	
	public FileService() {
		File dir = new File(saveDirectory);
		if(dir.exists() == false) {
			dir.mkdirs();
		}
	}
	public int upload(MultipartFile file) {
		File dest = new File(saveDirectory, file.getOriginalFilename());
		
		try {
			file.transferTo(dest);
			System.out.println(dest.getAbsolutePath());
			return 1;
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		} 
		
		return 0;
	}
	
	public int uploadDTO(Ex03DTO dto) {
		File dest = new File(saveDirectory, dto.getUploadFile().getOriginalFilename());
		try {
			dto.getUploadFile().transferTo(dest);
			System.out.println(dest.getAbsolutePath());
			// 사용자가 입력한 내용은 [이름], [나이], [파일]
			// DB에 저장할 내용은 [이름], [나이], [파일이름]
			dto.setFileName(dto.getUploadFile().getOriginalFilename());
			int row = dao.insert(dto);
			return row;
			
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		} 
		
		return 0;
	}
	
	public List<Ex03DTO> getList() {
		return dao.selectAll();
	}
	public int uploadMultipleFile(Ex04DTO dto) {
		int row = 0;
		
		// 문자열을 특정 글자로 구분하여 저장하기
		String fileName = "";
		
		for(MultipartFile f : dto.getUploadFile()) {
			row += upload(f);
			fileName += f.getOriginalFilename();
			fileName += ",";
		}
		
		fileName = fileName.substring(0, fileName.lastIndexOf(","));
		dto.setFileName(fileName);
		System.out.println(fileName);
		
		dao.insertEx04DTO(dto);
		
		return row;
	}

}









