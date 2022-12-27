package com.itbank.model;

public class Ex04DTO {	// 개별 데이터를 나타내기 위한 클래스
	
	// 싱글톤 적용하면 안된다. 같은 형식이라도 서로 다른 데이터를 나타날 수 있어야 한다
	// 따라서, 스프링 빈으로 등록하지 않는다
	
	private String name;
	private int age;
	
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
}
