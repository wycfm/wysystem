package cn.wycfm.crawler.servlet;

import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.wycfm.core.model.ResultBean;
import cn.wycfm.core.util.FrontUtils;
import cn.wycfm.crawler.model.AUrlModel;
import cn.wycfm.crawler.service.CrawlerService;
import cn.wycfm.crawler.service.impl.CrawlerServiceImpl;

@WebServlet("/crawler/demo.do")
public class CrawlerDataDemoServlet extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		
		String crawlerUrl = request.getParameter("crawlerUrl");
		String selectStr = request.getParameter("targetSelectStr");
		//"https://www.cnblogs.com/"   "div.post_item_body a.titlelnk"
		
		CrawlerService cs = new CrawlerServiceImpl();
		List<AUrlModel> list = cs.getAUrlModelList(crawlerUrl, selectStr);
		ResultBean<List<AUrlModel>> result = new ResultBean<List<AUrlModel>>();
		result.setResult(list);
		FrontUtils.resultResponse(response, result);
		
	}
}
