package cn.wycfm.core.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

public class CoreServlet extends HttpServlet{
	
	private static Logger log = Logger.getLogger(CoreServlet.class);
	
	public final static String BLOG_SERVER_HOST = "blog.wycfm.com";
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doGet(req, resp);
		String requestURI = req.getRequestURI();
		String serverName = req.getServerName();
		//System.out.println("serverName:"+serverName);
		log.info("serverName:"+serverName);
		if(BLOG_SERVER_HOST.equals(serverName)) {
			req.getRequestDispatcher("/blog").forward(req, resp);
		}else {
			req.getRequestDispatcher("/index.html").forward(req, resp);
		}
		
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
		System.out.println("post post");
	}
	
}
