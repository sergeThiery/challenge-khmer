package com.challenge.interceptor;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.challenge.domain.User;
import com.challenge.service.definition.UserService;

public class LoginInterceptor extends HandlerInterceptorAdapter{
	
	@Inject
	private UserService userService;
	
	
	 @Override
	    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
	        HttpSession session = request.getSession();

	        User user = (User) session.getAttribute("user");
	        if(user == null){
	            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	            String email = auth.getName();
	            user = userService.findByEmail(email);
	            session.setAttribute("user", user);
	        }

	        return super.preHandle(request, response, handler);
	    }

}
