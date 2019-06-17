package cn.wycfm.blog.model;

import java.sql.Timestamp;
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
	private Timestamp releaseDate;
	//是否需要重新生成静态页面
	private Integer needRegenerate;
	
	private String txt;
	
	private Integer tagId;
	private String contentTag;
	private Integer typeId;

	
	public Integer getContentId() {
		return contentId;
	}

	public void setContentId(Integer contentId) {
		this.contentId = contentId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitleImg() {
		return titleImg;
	}

	public void setTitleImg(String titleImg) {
		this.titleImg = titleImg;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getOriginUrl() {
		return originUrl;
	}

	public void setOriginUrl(String originUrl) {
		this.originUrl = originUrl;
	}

	public String getContentImg() {
		return contentImg;
	}

	public void setContentImg(String contentImg) {
		this.contentImg = contentImg;
	}

	public Timestamp getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Timestamp releaseDate) {
		this.releaseDate = releaseDate;
	}

	public Integer getNeedRegenerate() {
		return needRegenerate;
	}

	public void setNeedRegenerate(Integer needRegenerate) {
		this.needRegenerate = needRegenerate;
	}

	public String getTxt() {
		return txt;
	}

	public void setTxt(String txt) {
		this.txt = txt;
	}

	public Integer getTagId() {
		return tagId;
	}

	public void setTagId(Integer tagId) {
		this.tagId = tagId;
	}

	public String getContentTag() {
		return contentTag;
	}

	public void setContentTag(String contentTag) {
		this.contentTag = contentTag;
	}

	public Integer getTypeId() {
		return typeId;
	}

	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}
	
	
	
}
