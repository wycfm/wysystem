package cn.wycfm.core.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import cn.wycfm.core.service.UserService;
import cn.wycfm.core.service.impl.UserServiceImpl;


public class CoreFilter implements Filter{

	private UserService userService;
	
	public void init(FilterConfig filterConfig) throws ServletException {
		userService = new UserServiceImpl();
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		//userService
		
	}

	public void destroy() {
		
		
	}


}
