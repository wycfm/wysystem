package cn.wycfm.bill.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import cn.wycfm.bill.model.Bill;
import cn.wycfm.bill.service.BillService;
import cn.wycfm.bill.service.impl.BillServiceImpl;
import cn.wycfm.core.model.ResultBean;
import cn.wycfm.core.model.User;
import cn.wycfm.core.util.CoreUtil;

/**
 * Servlet implementation class AddBillServlet
 */
public class BillAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BillAddServlet() {
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
		User user = CoreUtil.getUser(request);
		if(user == null) {
			
		}
		Bill bill = new Bill();
		bill.setBillDate(new Date(request.getParameter("billDate")));
		bill.setDescription(request.getParameter("description"));
		bill.setAmount(Double.valueOf(request.getParameter("amount")));
		ResultBean<Integer> rb = new ResultBean<Integer>();
		BillService billService = new BillServiceImpl();
		billService.saveBill(bill,user);
		
		
		//Gson gson = new Gson();
		//String jsonResult = gson.toJson(result, new TypeToken<ResultBean<User>>() {}.getType());
		response.setContentType("application/json;charset=utf-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter writer = null;
		writer = response.getWriter();
		writer.write("");
		writer.close();
		
	}

}
