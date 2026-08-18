package com.nt.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class LoggingInterceptor implements HandlerInterceptor {

	// Controller execute hone se pehle call hota hai

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("Request Started");
		System.out.println("URI : " + request.getRequestURI());
		System.out.println("Method : " + request.getMethod());

		// true ka matlab request controller tak jayegi
		return true;
	}

	// Controller execute hone ke baad,
	// lekin response complete hone se pehle call hota hai

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("Controller Executed");
	}

	// Request-response process complete hone ke baad call hota hai
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("Request Completed");
	}
}