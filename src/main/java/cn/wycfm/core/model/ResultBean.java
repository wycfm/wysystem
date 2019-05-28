package cn.wycfm.core.model;

public class ResultBean<T> {

	/**
	 * code 返回服务返回的code 200 success, 500 sercice error 等
	 */
	public String code;
	/**
	 * status 当前请求结果的描述， 如 "success","error","noAuth","noLogin" 等
	 */
	public String status;
	/**
	 * 返回结果的描述
	 */
	public String description;
	
	/**
	 * 返回的数据
	 */
	public T result;
	
	
	public ResultBean() {}
	
	public ResultBean(String code, String status, T result) {
		this.code = code;
		this.status = status;
		this.result = result;
	}
	
	public ResultBean(String code, String status, String description, T result) {
		this.code = code;
		this.status = status;
		this.description = description;
		this.result = result;
	}
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public T getResult() {
		return result;
	}
	public void setResult(T result) {
		this.result = result;
	}
	
	
	
}
