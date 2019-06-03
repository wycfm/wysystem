package cn.wycfm.core.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ITemplateResolver;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

import cn.wycfm.core.util.TemplateEngineUtil;
@WebListener
public class ThymeleafConfig implements ServletContextListener{

	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		
	}

	public void contextInitialized(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		TemplateEngine engine = templateEngine(sce.getServletContext());
		TemplateEngineUtil.storeTemplateEngine(sce.getServletContext(), engine);
	}
	
	private TemplateEngine templateEngine(ServletContext servletContext) {
		TemplateEngine engine = new TemplateEngine();
		engine.setTemplateResolver(templateResolver(servletContext));
		return engine;
	}
	
	
	private ITemplateResolver templateResolver(ServletContext servletContext) {
		ServletContextTemplateResolver resolver = new ServletContextTemplateResolver(servletContext);
		resolver.setPrefix("/WEB-INF/templates/");
		resolver.setCharacterEncoding("UTF-8");
		resolver.setTemplateMode(TemplateMode.HTML);;
		
		return resolver;
	}

}
