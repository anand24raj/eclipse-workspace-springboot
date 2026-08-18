package com.nt.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Component
public class AuthInterceptor implements HandlerInterceptor
{
    @Override
    public boolean preHandle(HttpServletRequest request,
            HttpServletResponse response,Object handler) throws Exception 
    {
        HttpSession session = request.getSession(false);

        // User is not logged in
        if (session == null || session.getAttribute("user") == null) {

            System.out.println("Unauthenticated request. Redirecting to login.");

            response.sendRedirect(request.getContextPath() + "/login" );

            return false;
        }
        return true;
    }
}
