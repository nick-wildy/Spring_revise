package com.itbank.model;

import org.springframework.web.multipart.MultipartFile;

//	create table uploadTest3 (
//		name 		varchar2(100)		not null,
//		age			number				not null,
//		fileName	varchar2(255)		not null,
//	);

public class Ex03DTO {
	private String name;
	private int age;
	private MultipartFile uploadFile;
	private String fileName;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public MultipartFile getUploadFile() {
		return uploadFile;
	}
	public void setUploadFile(MultipartFile uploadFile) {
		this.uploadFile = uploadFile;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
}
