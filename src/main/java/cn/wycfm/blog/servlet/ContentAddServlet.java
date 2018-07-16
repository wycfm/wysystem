package cn.wycfm.blog.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 添加文章，只有登陆用户可以添加文章
 */
public class ContentAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * get 方式访问跳转到文章添加页面
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/t/blog/member/addArticle.html").forward(request, response);
	}

	/**
	 * post 提交添加的文章
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
