package cn.wycfm.core.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class EncodingFilter implements Filter {

	protected FilterConfig config;
	protected String encoding = null;
	
	public void destroy() {
		encoding = null;

	}

	public void doFilter(ServletRequest reqeust, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		if(encoding == null) {
			encoding = "UTF-8";
		}
		
		response.setCharacterEncoding(encoding);
		reqeust.setCharacterEncoding(encoding);
		//response.setContentType("text/html;charset="+encoding);
		chain.doFilter(reqeust, response);
	}

	public void init(FilterConfig config) throws ServletException {
		this.config = config;
		
		//从web.xml 中获取encoding
		this.encoding = config.getInitParameter("encoding");
		

	}

}
