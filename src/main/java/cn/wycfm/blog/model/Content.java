package cn.wycfm.blog.model;

import java.util.Date;

public class Content {

	private Integer contentId;
	private String title;
	private String titleImg;
	private String description;
	private String author;
	private String origin;
	private String originUrl;
	private String contentImg;
	private Date releaseDate;
	//是否需要重新生成静态页面
	private Integer needRegenerate;
	
	private String txt;
	
}
