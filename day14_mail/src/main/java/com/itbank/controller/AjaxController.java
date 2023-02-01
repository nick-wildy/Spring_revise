package com.itbank.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.itbank.service.MailService;

@RestController
public class AjaxController {
	
	@Autowired private MailService mailService;
	private HashMap<String, String> authNumberMap = new HashMap<String, String>();

	@GetMapping("/ajax01")
	public String ajax01(String email, String content) throws IOException {
		System.out.println(email + ", " +  content);
		int row = mailService.sendMail(email, content);
		return row == 1 ? "메일 보내기 성공" : "메일 보내기 실패";
	}
	
	@GetMapping("/sendAuthNumber")
	public int ajax02(String email) throws IOException {
		Random ran = new Random();
		String authNumber = ran.nextInt(89999999) + 10000000 + "";
		System.out.println(authNumber);
		int row = mailService.sendMail(email, authNumber);
		if(row == 1) {
			authNumberMap.put(email, authNumber);
		}
		return row;
	}
	
	@PostMapping("/sendAuthNumber")
	public int ajax03(@RequestBody HashMap<String, String> param) {
		// @RequestBody : HTML규칙에 상관없이 넘어오는 값을 그대로 요청으로 인식한다
		// @ResponseBody : 함수의 반환값이 그대로 응답객체로 적용된다 (forward하지 않는다)
		// @RestController : 모든 함수는 ResponseBody가 적용된다
		System.out.println(param);

		// ajax02 에서 생성하여 저장된 인증 번호
		String storedAuthNumber = authNumberMap.get(param.get("email"));
		
		// 메일 내용 확인 후 사용자가 입력한 인증번호
		String inputAuthNumber = param.get("authNumber");
		
		// 두 번호가 일치한다면 1, 아니면 0을 반환
		boolean flag = storedAuthNumber.equals(inputAuthNumber);
		return flag ? 1 : 0;
	}
}












