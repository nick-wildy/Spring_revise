package com.itbank.model;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class Ex04DTO {
	
	private String name;
	private int age;
//	private String[] color;
	private List<String> color;
	private List<MultipartFile> uploadFile;
	private String fileName;
	

	@Override
	public String toString() {
		String str = String.format("%s, %d살, ", name, age);
//		String colors = "";
//		for(int i = 0; color != null && i < color.length; i++) {
//			colors += color[i];
//			colors += (i != color.length - 1) ? ", " : "\n";
//		}
//		str += colors;
		str += color;
		str += "\nuploadFile : " + uploadFile;
		return str;
	}
	
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
	public List<MultipartFile> getUploadFile() {
		return uploadFile;
	}
	public void setUploadFile(List<MultipartFile> uploadFile) {
		this.uploadFile = uploadFile;
	}
	public List<String> getColor() {
		return color;
	}
	public void setColor(List<String> color) {
		this.color = color;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	

}
