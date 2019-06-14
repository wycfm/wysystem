package cn.wycfm.blog.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import cn.wycfm.blog.model.Content;
import cn.wycfm.blog.service.ContentService;
import cn.wycfm.blog.service.impl.ContentServiceImpl;
import cn.wycfm.core.model.ResultBean;
import cn.wycfm.core.model.User;
import cn.wycfm.core.util.CoreUtil;
import cn.wycfm.core.util.FrontUtils;
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
		
		User user = CoreUtil.getUser(request);
		/*if(user==null) {
			FrontUtils.errorResponse(response, "noLogin");
			return ;
		}*/
		user = new User();
		user.setUserId(1);
		//String title = request.getParameter("title");
		String typeId = request.getParameter("typeId");
		Content c = new Content();
		c.setTitle(request.getParameter("title"));
		c.setTxt(request.getParameter("txt"));
		c.setDescription(request.getParameter("description"));
		c.setTypeId(typeId==null ? 1 : Integer.valueOf(typeId));
		c.setContentTag(request.getParameter("tagName"));
		ContentService cs = new ContentServiceImpl();
		ResultBean<Integer> addContent = cs.addContent(user,c);
		
		FrontUtils.resultResponse(response, addContent);
		
	}

}
