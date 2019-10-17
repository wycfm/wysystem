/**
 * 
 */
/**
 * @author Administrator
 *
 */
package cn.wycfm.crawler.servlet;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import cn.wycfm.core.util.TemplateEngineUtil;
@WebServlet("/crawler")
public class CrawlerIndexServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	
	private static Logger log = Logger.getLogger(CrawlerIndexServlet.class);
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		TemplateEngine engine = TemplateEngineUtil.getTemplateEngine(request.getServletContext());
		WebContext context = new WebContext(request, response, request.getServletContext());
		
		try {
			engine.process("crawler/crawler.html", context, response.getWriter());
		} catch (IOException e) {
			log.error("CrawlerIndexServlet:"+e.getMessage());
			e.printStackTrace();
		}
		
	}
}