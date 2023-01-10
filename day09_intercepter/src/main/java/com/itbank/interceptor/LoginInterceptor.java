package com.itbank.interceptor;

import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.itbank.model.MemberDTO;

// 저장 - 우클릭 - source - override/implement methods

// 스프링 인터셉터 : 요청을 가로채서, 사전 코드를 실행할 수 있다. 여러 주소에 대해 일괄 적용 가능
// Handle : 컨트롤러의 메서드를 나타낸다

// 1) preHandle : 요청이 컨트롤러에 도달하기 전에 실행되는 함수 (DispatcherServlet -> controller)
// 2) postHandle : 컨트롤러의 메서드가 수행된 이후 실행되는 함수 (return mav 이후)
// 3) afterCompletion : 응답이 클라이언트 방향으로 출발한 이후 실행되는 함수 (forward/redirect 이후)

public class LoginInterceptor extends HandlerInterceptorAdapter {

	// preHandle은 반환형이 boolean 이다
	// true를 반환하면, 예정되어 있던 컨트롤러의 메서드(handler)를 수행한다
	// false를 반환하면, 예정되어 있던 컨트롤러의 메서드(handler)를 수행하지 않는다
	// 즉, preHandle 의 반환값은 예정대로 진행할 것인가? 에 대한 답이다
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("preHandle");
		System.out.println("handler : " + handler);
		
//		response.getWriter().append("<h1>Hello, Interceptor</h1>");
//		response.sendRedirect(request.getContextPath() + "/");
		
		HttpSession session = request.getSession();
		MemberDTO login = (MemberDTO)session.getAttribute("login");
		
		String url = request.getRequestURL().toString();	// 요청받은 주소
		url = URLEncoder.encode(url, "utf-8");	// https:// 특수기호, 한글, 공백문자 변환
		
		if(login == null) {
			System.out.println("인터셉터에 의해 로그인 페이지로 이동합니다");
			response.sendRedirect(request.getContextPath() + "/login?url=" + url);
			return false;
		}
		
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("postHandle");
		super.postHandle(request, response, handler, modelAndView);
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("afterCompletion");
		super.afterCompletion(request, response, handler, ex);
	}
	
	

}
