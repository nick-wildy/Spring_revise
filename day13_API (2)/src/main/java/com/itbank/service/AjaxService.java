package com.itbank.service;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;

import org.springframework.stereotype.Service;

@Service
public class AjaxService {
	// 자바로 요청하여 데이터를 받아와서 반환하기
	// 데이터를 받기 위해 전달해야 하는 파라미터를 먼저 정리해야 한다
	// 서비스키, 페이지번호, 페이지당데이터개수, 데이터타입, 도시번호, 요청시점
	
	private final String serviceKey = "K7G5hCA%2FRqnmALDK%2F7POZXDGSgTgQFRIcOqpF8HUf9rqLn17QSaJ4Q0Ox732h%2BF%2FgxuyB3bXrdEWApNVwrOtWA%3D%3D";
	private final String pageNo = "1";
	private final String numOfRows = "10";
	private final String dataType = "JSON";
	private final String regId = "11H20201";	// 부산
	
	public String getMidFcst() throws IOException {
		// 주소를 https로 요청하면 SSL인증서를 자바에 추가로 설치해야 한다
		// 1) 요청을 위해서 주소와 파라미터를 준비한다
		String url = "http://apis.data.go.kr/1360000/MidFcstInfoService/getMidTa";
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String tmFc = sdf.format(new Date()) + "0600";	// 202301270600
		
		HashMap<String, String> params = new HashMap<String, String>();
		params.put("serviceKey", serviceKey);
		params.put("pageNo", pageNo);
		params.put("numOfRows", numOfRows);
		params.put("dataType", dataType);
		params.put("regId", regId);
		params.put("tmFc", tmFc);
		
		url += "?";		// 주소 이후 쿼리스트링 형태의 파라미터가 들어온다
						// name=이지은&age=31
		for(String key : params.keySet()) {
			url += key + "=" + params.get(key) + "&";
		}
//		System.out.println(url);
		
		// 2) 위에서 확인한 주소로 요청하여 응답을 문자열로 받는다
		URL requestURL = new URL(url);
		HttpURLConnection conn = (HttpURLConnection)requestURL.openConnection();
		conn.setRequestMethod("GET");
		
		Scanner sc = null;
		String data = "";
		
		// 3) 응답 결과에 따라서 JSON 데이터 혹은 null을 반환한다
		if(conn.getResponseCode() == 200) {				// 응답이 200 OK 이면
			sc = new Scanner(conn.getInputStream());	// 연결된 곳에서 데이터를 읽어들이는 스캐너
			while(sc.hasNextLine()) {	// 다음 줄이 있다면
				data += sc.nextLine();	// 다음 줄을 data에 더한다
			}
			sc.close();			// 데이터 읽기가 끝나면 sc를 닫아준다
			conn.disconnect();	// 작업이 끝났으면, 연결도 종료한다
			return data;		// 만들어진 데이터를 컨트롤러로 반환한다
		}
		return null;
	}

	public String getAirInfo() throws IOException {
		String url = "http://apis.data.go.kr/B552584/ArpltnStatsSvc/getCtprvnMesureLIst";
		HashMap<String, String> params = new HashMap<String, String>();
		params.put("serviceKey", "K7G5hCA%2FRqnmALDK%2F7POZXDGSgTgQFRIcOqpF8HUf9rqLn17QSaJ4Q0Ox732h%2BF%2FgxuyB3bXrdEWApNVwrOtWA%3D%3D");
		params.put("returnType", "json");
		params.put("numOfRows", "100");
		params.put("pageNo", "1");
		params.put("itemCode", "PM10");
		params.put("dataGubun", "DAILY");		// 시간평균: HOUR, 일평균: DAILY
		params.put("searchCondition", "WEEK");	// 일주일: WEEK, 한달: MONTH
		
		url += "?";
		for(String key : params.keySet()) {
			String value = params.get(key);
			url += key + "=" + value + "&";
		}
		
		URL requestURL = new URL(url);
		HttpURLConnection conn = (HttpURLConnection) requestURL.openConnection();
		String ret = "";
		if(conn.getResponseCode() == 200) {
			Scanner sc = new Scanner(conn.getInputStream());
			while(sc.hasNextLine()) {
				ret += sc.nextLine();
			}
			sc.close();
			conn.disconnect();
			return ret;
		}
		return null;
	}

}













