package cn.wycfm.core.util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import cn.wycfm.core.model.ResultBean;

public class FrontUtils {

	public static <T> void resultResponse(HttpServletResponse response, ResultBean<T> result) {
		
		Gson gson = new Gson();
		String jsonResult = gson.toJson(result, new TypeToken<ResultBean<Object>>() {}.getType());
		response.setContentType("application/json;charset=utf-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter writer = null;
		try {
			writer = response.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}
		writer.write(jsonResult);
		writer.close();
	}
}
