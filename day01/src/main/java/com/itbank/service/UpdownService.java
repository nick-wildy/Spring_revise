package com.itbank.service;

import java.util.Random;

import org.springframework.stereotype.Service;

@Service
public class UpdownService {
	
	private int answer;
	
	public void initialize() {
		Random ran = new Random();
		answer = ran.nextInt(100) + 1;
	}

	public String getStatus(int user) {
		String status = null;

		if(answer == user) {
			status = "Correct";
			initialize();
		}
		
		else if(answer > user)		status = "Up";
		else 						status = "Down";
		
		return status;
	}

}
