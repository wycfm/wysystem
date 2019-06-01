package cn.wycfm.bill.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
public class BillDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BillDeleteServlet() {
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

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = CoreUtil.getUser(request);
		if(user == null) {
			FrontUtils.errorResponse(response, "noLogin");
			return ;
		}
		Bill bill = new Bill();
		String billId = request.getParameter("billId");
		if(billId == null) {
			FrontUtils.errorResponse(response, "error");
			return ;
		}
		bill.setBillId(Integer.parseInt(billId));
		BillService billService = new BillServiceImpl();
		ResultBean<Integer> result = billService.deleteBill(bill,user);
		
		
		FrontUtils.resultResponse(response, result);
		
	}

}
