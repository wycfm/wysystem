package cn.wycfm.core.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Type;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import cn.wycfm.core.model.ResultBean;
import cn.wycfm.core.model.User;
import cn.wycfm.core.service.UserService;
import cn.wycfm.core.service.impl.UserServiceImpl;
import cn.wycfm.core.util.CoreUtil;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		UserService userService = new UserServiceImpl();
		User user = userService.getUser(username, password);
		ResultBean<User> result = new ResultBean<User>();
		if(user!=null) {
			CoreUtil.setUser(request, user);
			result.setResult(user);
			result.setCode("200");
			result.setStatus("success");
			result.setDescription("Login Success");
			
		}else {
			result.setResult(null);
			result.setCode("400");
			result.setStatus("fail");
			result.setDescription("Login fail");
		}
		
		
		Gson gson = new Gson();
		String jsonResult = gson.toJson(result, new TypeToken<ResultBean<User>>() {}.getType());
		response.setContentType("application/json;charset=utf-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter writer = null;
		writer = response.getWriter();
		writer.write(jsonResult);
		writer.close();
	}

}
