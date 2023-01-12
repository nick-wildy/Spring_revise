package com.itbank.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.itbank.model.MemberDTO;

public class LoginInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		String url = request.getRequestURL().toString();	// 원래 가려던 주소
		String cpath = request.getContextPath();			// cpath
		HttpSession session = request.getSession();			// session
		MemberDTO login = (MemberDTO)session.getAttribute("login");	// 현재 로그인
		
		if(login == null) {	// 로그인이 되어 있지 않으면
			response.sendRedirect(cpath + "/member/login?url=" + url);
			// 원래 가려던 주소를 쿼리스트링으로 전달하면서 로그인 페이지로 이동시킨다
			
			return false;	
			// 인터셉터가 별도의 응답을 전달하고 있으니, 컨트롤러는 예정된 작업을 수행하지 않는다
		}
		return true;
	}
}
