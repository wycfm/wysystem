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
import cn.wycfm.core.util.FrontUtils;

/**
 * Servlet implementation class AddBillServlet
 */
public class BillListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BillListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet~~");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("deprecation")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = CoreUtil.getUser(request);
		if(user == null) {
			return ;
		}
		Bill bill = new Bill();
		bill.setBillDate(request.getParameter("billDate"));
		bill.setDescription(request.getParameter("description"));
		bill.setAmount(Double.valueOf(request.getParameter("amount")));
		BillService billService = new BillServiceImpl();
		ResultBean<Integer> result = billService.saveBill(bill,user);
		
		
		FrontUtils.resultResponse(response, result);
		
	}

}
