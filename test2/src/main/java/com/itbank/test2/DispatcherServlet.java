package com.itbank.test2;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DispatcherServlet extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		String command = request.getRequestURI();
		String cpath = request.getContextPath();
		
		System.out.println(command);
		System.out.println(cpath);
		
		String requestMapping = command.substring(cpath.length());
		System.out.println(requestMapping);
		
		// 요청 주소에 따라 서로 다른 코드를 실행하고, 포워딩할 JSP의 이름을 만들어낸다
		String viewName = null;
		switch(requestMapping) {
		case "/":
			request.setAttribute("serverTime", new Date());
			viewName = "home";
			break;
			
		case "/info":
			String name = request.getParameter("name");
			int age = Integer.parseInt(request.getParameter("age"));
			String adult = age >= 20 ? "성인" : "미성년자";
			String msg = String.format("%s의 나이는 %d살이고, %s입니다", name, age, adult);
			request.setAttribute("msg", msg);
			viewName = "info";
			break;
		}
		
		viewName = prefix + viewName + suffix;
		RequestDispatcher rd = request.getRequestDispatcher(viewName);
		rd.forward(request, response);
		System.out.println("==========================");
	}
	
	private final String prefix = "/WEB-INF/views/";
	private final String suffix = ".jsp";

}
