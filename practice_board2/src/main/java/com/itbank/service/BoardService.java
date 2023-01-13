package com.itbank.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itbank.model.BoardDTO;
import com.itbank.repository.BoardDAO;

@Service
public class BoardService {
	
	public BoardService() {
		File dir = new File(saveDirectory);
		if(dir.exists()==false) {
			dir.mkdir();
		}
	}
@Autowired private BoardDAO dao;

private final String saveDirectory = "D:\\board2";
	
	public List<BoardDTO> getList() {
		
		return dao.selectList();
	}

	public int upload(BoardDTO dto) {
		if(dto.getUploadFile().getSize()==0) {
			int row = dao.uploadText(dto);
			System.out.println(row==1?"추가성공":"추가실패");
			return row;
		}
		
		File dest = new File(saveDirectory, dto.getUploadFile().getOriginalFilename());
		
		try {
			dto.getUploadFile().transferTo(dest);
			dto.setFileName(dto.getUploadFile().getOriginalFilename());
			int row = dao.insert(dto);
			System.out.println(row==1?"DAO에 추가성공":"추가 실패");
			return 1;
		} catch (IllegalStateException | IOException e) {
			
			e.printStackTrace();
		}	
		return 0;
	}
	public BoardDTO getOne(int idx) {		
		return dao.selectOne(idx);
	}
	
	public int modify(BoardDTO dto) {	
		if(dto.getUploadFile().getSize() ==0) {
			int row = dao.updat2(dto);
			System.out.println(row==1?"이미지없이 수정성공" : "이미지없는수정 실패ㅠ");
			
			return row;
		}
		
		File file = new File(saveDirectory,dto.getUploadFile().getOriginalFilename());
		
		try {
			dto.getUploadFile().transferTo(file);
			dto.setFileName(dto.getUploadFile().getOriginalFilename());
			int row = dao.update(dto);
			System.out.println(row==1?"DAO에 수정성공":"수정 실패");
			return row;
		} catch (IllegalStateException | IOException e) {
			
			e.printStackTrace();
		}
		
		return 0;
	}

	public int delete(int idx) {
		
		return dao.delete(idx);
	}

	public List<BoardDTO> searchList(String keyword) {
		
		return dao.searchList(keyword);
	}

	public int getViewcount(int idx) {
		
		return dao.selectViewCount(idx);
	}

}
