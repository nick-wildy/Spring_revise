package com.itbank.model;

import java.sql.Date;

import org.springframework.web.multipart.MultipartFile;

//	TABLE : BOARD2
//	====================================
//	IDX        NOT NULL NUMBER         
//	WRITER     NOT NULL VARCHAR2(100)  
//	TITLE      NOT NULL VARCHAR2(100)  
//	CONTENT    NOT NULL VARCHAR2(2000) 
//	WRITEDATE           DATE           
//	IPADDR     NOT NULL VARCHAR2(30)   
//	VIEWCOUNT           NUMBER         
//	UPLOADFILE          VARCHAR2(255)  

public class BoardDTO {

	private int idx;
	private String writer;
	private String title;
	private String content;
	private Date writeDate;
	private String ipaddr;
	private int viewCount;
	
	private String uploadFile;
	private MultipartFile file;
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getWriteDate() {
		return writeDate;
	}
	public void setWriteDate(Date writeDate) {
		this.writeDate = writeDate;
	}
	public String getIpaddr() {
		return ipaddr;
	}
	public void setIpaddr(String ipaddr) {
		this.ipaddr = ipaddr;
	}
	public int getViewCount() {
		return viewCount;
	}
	public void setViewCount(int viewCount) {
		this.viewCount = viewCount;
	}
	public String getUploadFile() {
		return uploadFile;
	}
	public void setUploadFile(String uploadFile) {
		this.uploadFile = uploadFile;
	}
	public MultipartFile getFile() {
		return file;
	}
	public void setFile(MultipartFile file) {
		this.file = file;
	}
	
}











