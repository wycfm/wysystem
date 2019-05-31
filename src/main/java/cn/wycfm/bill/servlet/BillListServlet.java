package cn.wycfm.bill.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import cn.wycfm.bill.model.Bill;
import cn.wycfm.bill.model.BillQuery;
import cn.wycfm.bill.model.BillResult;
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
		User user = CoreUtil.getUser(request);
		if(user == null) {
			FrontUtils.errorResponse(response, "noLogin");
			return ;
		}
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		String userIds = request.getParameter("userIds");
		BillService billService = new BillServiceImpl();
		BillQuery query = new BillQuery();
		query.setStartDate(startDate);
		query.setEndDate(endDate);
		query.setUserIds(userIds);
		List<BillResult> listBill = billService.listBill(query, user);
		ResultBean<List<BillResult>> result = new ResultBean<List<BillResult>>();
		result.setResult(listBill);
		FrontUtils.resultResponse(response, result);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
	}

}
