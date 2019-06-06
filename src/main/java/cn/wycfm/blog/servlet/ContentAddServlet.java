package cn.wycfm.blog.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import cn.wycfm.core.model.User;
import cn.wycfm.core.util.TemplateEngineUtil;

/**
 * 添加文章，只有登陆用户可以添加文章
 */
@WebServlet("/content/add")
public class ContentAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * get 方式访问跳转到文章添加页面
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TemplateEngine engine = TemplateEngineUtil.getTemplateEngine(request.getServletContext());
		WebContext context = new WebContext(request, response, request.getServletContext());
		User user = new User();//CoreUtil.getUser(request);
		user.setUserId(1);
		user.setUserName("欢迎");
		user.setNickName("Wu Yan");
		/*if(user==null) {
			FrontUtils.errorResponse(response, "noLogin");
		}*/
		
		request.setAttribute("user", user);
		
		engine.process("/blog/member/addArticle.html", context, response.getWriter());
		
		
	}

	/**
	 * post 提交添加的文章
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
