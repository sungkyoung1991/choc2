package com.sample.choc2.common.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.sample.choc2.service.domain.User;

public class LogonCheckInterceptor extends HandlerInterceptorAdapter {

	public LogonCheckInterceptor() {
		super();
		System.out.println("logonInterceptor 생성자");
		// TODO Auto-generated constructor stub
	}

	/*
	 * @Override public void afterCompletion(HttpServletRequest request,
	 * HttpServletResponse response, Object handler, Exception ex) throws Exception
	 * { // TODO Auto-generated method stub // This implementation is empty.
	 * super.afterCompletion(request, response, handler, ex);
	 * System.out.println("Interceptor afterCompletion............ 확인"); }
	 * 
	 * @Override public void afterConcurrentHandlingStarted(HttpServletRequest
	 * request, HttpServletResponse response, Object handler) throws Exception { //
	 * TODO Auto-generated method stub // This implementation is empty.
	 * super.afterConcurrentHandlingStarted(request, response, handler); System.out.
	 * println("Interceptor afterConcurrentHandlingStarted............ 확인"); }
	 * 
	 * @Override public void postHandle(HttpServletRequest request,
	 * HttpServletResponse response, Object handler, ModelAndView modelAndView)
	 * throws Exception { // TODO Auto-generated method stub // This implementation
	 * is empty. super.postHandle(request, response, handler, modelAndView);
	 * System.out.println("Interceptor postHandle............ 확인"); }
	 */

	// HandlerInterceptor와 AsyncHandlerInterceptor에서 interface를 모두 구현해 두었기 때문에
	// HandlerInterceptorAdapter를 확장하여 필요한 메서드만 overriding 하여 사용한다.

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		// This implementation is true.
		// Service가 실행되기 전 호출되는 preHandle Method..
		System.out.println("Interceptor preHandle............ 확인");

		HttpSession session = request.getSession(true);
		// request 에 해당하는 session 을 가져온다. session 이 없으면 boolean 타입으로 session create 여부를
		// 정의한다.
		User user = (User) session.getAttribute("user");
		// login Method를 통해 "user"로 setAttribute 된 User 정보를 가져온다.
		
		System.out.println("user 정보.." + user);
		
		String urii = request.getRequestURI();
		System.out.println("interceptor uri 확인.." + urii);
		
		
	

		if (user != null) {
			
			String uri = request.getRequestURI();
			
			if(uri.indexOf("login") != -1) {
				
				System.out.println("login 상태입니다.");
				System.out.println("interceptor .getRequestURI check.............." + uri);
				
				request.getRequestDispatcher("/WEB-INF/views/index.jsp").forward(request, response);
				
				return false;
				
			}
			
			// getRequestURI : requset URL 을 query string을 decode 하지 않고 읽어옴.
			System.out.println("user login 후 if 문 빠져나오는 로직 확인...");
			
			return true;
		

			// ========= Method 해석 = Interceptor를 통해 request 가 handler로 들어오기 전 session을 확인하고
			// user Object에 String "user" 로 session 을 저장된 session 을 불러와 session 정보가 있다면
			// uri변수에 request에서의 URI 를 저장한다.

			// request.getRequestDispatcher("/index.jsp").forward(request, response);
			// =========요청한 requset를 받아 Dispatcher의 handler에게 mapping parameter의 값으로 mapping
			// 요청을 함. forward방식으로 req,res 인자도 함께 보낸다.

		} // user!=null

		// 비로그인..
		else {
			
			String uri = request.getRequestURI();
			
	if(uri.indexOf("login") != -1) {
				
				System.out.println("uri=" + uri);
				
				return true;
				
			}
			
			System.out.println("비로그인 else문");

			request.getRequestDispatcher("index").forward(request, response);
			// 비로그인시 login.jsp로 돌린다.

			return false;

		}

	}

}
