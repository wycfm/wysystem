package cn.wycfm.core.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class AuthenLoginFilter implements Filter{

	
	public void destroy() {
		
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
			throws IOException, ServletException {
		//HttpServletRequest req = (HttpServletRequest)request;
		//HttpSession session = req.getSession();
		/*if(session.getAttribute("wysystemuser") !=null) {
			filterChain.doFilter(request, response);
			return;
		}
		request.getRequestDispatcher("/login.jsp").forward(req, response);*/
		
		filterChain.doFilter(request, response);
	}

	public void init(FilterConfig arg0) throws ServletException {
		
	}

}
