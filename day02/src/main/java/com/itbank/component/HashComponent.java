package com.itbank.component;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.springframework.stereotype.Component;

@Component	// 컨트롤러도 서비스도 DAO도 아니지만
			// 일단 스프링 빈으로 등록할 클래스 (@Controller, @Service, @Repository, @Component)
public class HashComponent {
	
	public String getHash(String input) {
		String hash = null;
		
		try {
			// 내가 사용할 해쉬 알고리즘은 SHA-512 (Secure Hash Algorithm)
			MessageDigest md = MessageDigest.getInstance("SHA-512");
			
			// 입력받은 문자열을 바이트 단위로 분해하여 md에 업데이트
			md.update(input.getBytes());		
			
			// 바이트 단위 값을 SHA-512알고리즘으로 계산하여 그 결과를 128자리의 16진수 문자열로 변환한다
			hash = String.format("%0128x", new BigInteger(1, md.digest()));
			
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		return hash;	// 만들어진 해쉬값을 반환
	}
}
