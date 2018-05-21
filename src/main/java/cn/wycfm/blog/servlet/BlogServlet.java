package cn.wycfm.blog.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.wycfm.blog.dao.ContentDao;
import cn.wycfm.blog.dao.impl.ContentDaoImpl;
import cn.wycfm.blog.service.ContentService;
import cn.wycfm.blog.service.impl.ContentServiceImpl;

public class BlogServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7835574135375924311L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ContentService contentService = new ContentServiceImpl();
		System.out.println("BlogAction:" + req.getRequestURI());
		try {
			List<Map<String, Object>> contentList = contentService.listContent();
			for (Map<String, Object> map : contentList) {
				System.out.println("id:"+map.get("id")+",name:"+map.get("name"));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		req.getRequestDispatcher("/WEB-INF/t/blog/index/index.html").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		super.doPost(req, resp);
	}
}
