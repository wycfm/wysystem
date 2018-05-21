package cn.wycfm.core.model;

import java.util.Date;

public class User {
	
	private Integer userId;
	private String userName;
	private String password;
	private String nickName;
	private String signature;
	private String mobile;
	private String email;
	private Date registerTime;
	private String registerIp;
	private Integer loginCount;
	private Boolean boolAdmin;
	private Boolean booldisabled;
	private Date lastLoginTime;
	private String lastLoginIp;
	
	
	public User() {
		init();
	}
	
	
	
	public User(String userName, String password, String nickName, String signature, String mobile, String email,
			Date registerTime, String registerIp, Integer loginCount, Boolean boolAdmin, Boolean booldisabled,
			Date lastLoginTime, String lastLoginIp) {
		this.userName = userName;
		this.password = password;
		this.nickName = nickName;
		this.signature = signature;
		this.mobile = mobile;
		this.email = email;
		this.registerTime = registerTime;
		this.registerIp = registerIp;
		this.loginCount = loginCount;
		this.boolAdmin = boolAdmin;
		this.booldisabled = booldisabled;
		this.lastLoginTime = lastLoginTime;
		this.lastLoginIp = lastLoginIp;
	}



	public void init() {};
	
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getSignature() {
		return signature;
	}
	public void setSignature(String signature) {
		this.signature = signature;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getRegisterTime() {
		return registerTime;
	}
	public void setRegisterTime(Date registerTime) {
		this.registerTime = registerTime;
	}
	public String getRegisterIp() {
		return registerIp;
	}
	public void setRegisterIp(String registerIp) {
		this.registerIp = registerIp;
	}
	public Integer getLoginCount() {
		return loginCount;
	}
	public void setLoginCount(Integer loginCount) {
		this.loginCount = loginCount;
	}
	public Boolean getBoolAdmin() {
		return boolAdmin;
	}
	public void setBoolAdmin(Boolean boolAdmin) {
		this.boolAdmin = boolAdmin;
	}
	public Boolean getBooldisabled() {
		return booldisabled;
	}
	public void setBooldisabled(Boolean booldisabled) {
		this.booldisabled = booldisabled;
	}
	public Date getLastLoginTime() {
		return lastLoginTime;
	}
	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}
	public String getLastLoginIp() {
		return lastLoginIp;
	}
	public void setLastLoginIp(String lastLoginIp) {
		this.lastLoginIp = lastLoginIp;
	}
	
	
	
}
