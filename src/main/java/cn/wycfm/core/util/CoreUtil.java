package cn.wycfm.core.util;

import javax.servlet.http.HttpServletRequest;

import cn.wycfm.core.model.Site;
import cn.wycfm.core.model.User;

public class CoreUtil {

	/**
	 * 用户key
	 */
	public static final String USER_KEY = "_user_key";
	
	/**
	 * 站点key
	 */
	public static final String SITE_KEY = "_site_key";
	
	/** 
	 * 获取用户信息
	 * @param request
	 * @return user
	 */
	public static User getUser(HttpServletRequest request) {
		return (User) request.getAttribute(SITE_KEY);
	}
	
	/**
	 * 获得用户ID
	 * @param request
	 * @return
	 */
	public static Integer getUserId(HttpServletRequest request) {
		User user = getUser(request);
		if(user != null) {
			return user.getUserId();
		}else {
			return null;
		}
	}
	
	/**
	 * 设置用户信息
	 * @param request
	 * @param user
	 */
	public static void setUser(HttpServletRequest request, User user) {
		request.setAttribute(USER_KEY, user);
	}
	
	/**
	 * 获得站点信息
	 * @param request
	 * @return
	 */
	public static Site getSite(HttpServletRequest request) {
		return (Site) request.getAttribute(SITE_KEY);
	}
	
	public static Integer getSiteId(HttpServletRequest request) {
		Site site = getSite(request);
		if(site != null) {
			return site.getSiteId();
		} else {
			return null;
		}
	}
	
	public static void setSite(HttpServletRequest request, Site site) {
		request.setAttribute(SITE_KEY, site);
	}
}
