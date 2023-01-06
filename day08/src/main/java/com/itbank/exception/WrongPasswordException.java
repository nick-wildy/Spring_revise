package com.itbank.exception;

public class WrongPasswordException extends Exception {

	private static final long serialVersionUID = 1L;

	@Override
	public String getMessage() {
		return "비밀번호는 8글자 이상의 영문 대문자/소문자, 숫자로 구성되어야 합니다"; 
	}
}
