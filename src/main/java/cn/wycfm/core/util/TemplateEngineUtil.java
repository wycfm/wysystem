package cn.wycfm.core.util;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;

import org.thymeleaf.TemplateEngine;

/**
 * 将Thymeleaf TemplateEngine存储并检索到应用程序servlet上下文中。
 * @author Administrator
 *
 */
@WebListener
public class TemplateEngineUtil {
	
	private static final String TEMPLATE_ENGINE_ATTR = "cn.wycfm.core.TemplateEngineInstance";
	
	public static void storeTemplateEngine(ServletContext context, TemplateEngine engine) {
        context.setAttribute(TEMPLATE_ENGINE_ATTR, engine);
    }

    public static TemplateEngine getTemplateEngine(ServletContext context) {
        return (TemplateEngine) context.getAttribute(TEMPLATE_ENGINE_ATTR);
    }


}
