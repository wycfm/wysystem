package cn.wycfm.blog.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import cn.wycfm.blog.dao.ContentDao;
import cn.wycfm.blog.dao.impl.ContentDaoImpl;
import cn.wycfm.blog.service.ContentService;
import cn.wycfm.blog.service.impl.ContentServiceImpl;
import cn.wycfm.core.model.User;
import cn.wycfm.core.util.CoreUtil;
import cn.wycfm.core.util.FrontUtils;
import cn.wycfm.core.util.TemplateEngineUtil;

public class BlogServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7835574135375924311L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		TemplateEngine engine = TemplateEngineUtil.getTemplateEngine(req.getServletContext());
		WebContext context = new WebContext(req, resp, req.getServletContext());
		ContentService contentService = new ContentServiceImpl();
		User user = CoreUtil.getUser(req);
		//System.out.println("BlogAction:" + req.getRequestURI());
		if(user==null) {
			FrontUtils.errorResponse(resp, "noLogin");
			return;
		}
		try {
			List<Map<String, Object>> contentList = contentService.listContent(user,null);
			req.setAttribute("contentList", contentList);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		engine.process("/blog/index/index.html", context, resp.getWriter());
		//req.getRequestDispatcher("/WEB-INF/t/blog/index/index.html").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		super.doPost(req, resp);
	}
}
