package cn.wycfm.core.servlet;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import cn.wycfm.core.util.TemplateEngineUtil;

public class IndexThymeleafServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		
		TemplateEngine engine = TemplateEngineUtil.getTemplateEngine(request.getServletContext());
        WebContext context = new WebContext(request, response, request.getServletContext());
        response.setCharacterEncoding("utf-8");
        request.setAttribute("username", "WuYan");
        try {
			engine.process("index.html", context, response.getWriter());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
}
