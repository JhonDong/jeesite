package com.thinkgem.jeesite.service.bean;

import java.io.Serializable;

/**
 * 
 * Title: Result.java Description: 接口返回结果封装类
 * 
 * @author zqdong * @date 2018年3月28日
 */
public class Result implements Serializable {

	// 内部代码错误
	public static final int INNER_ERROR_CODE = 500;
	// 请求参数错误
	public static final int PARAM_ERROR_CODE = 400;
	// 令牌错误
	public static final int TOKEN_ERROE_CODE = 1001;
	// 用户认证错误
	public static final int ROLE_ERROE_CODE = 1002;
	// 错误的请求服务
	public static final int FALSE_REQUEST_CODE = 1003;

	// 未知错误信息
	public static final String INNER_ERROR_MSG = "Unknown error";
	// 请求参数错误信息
	public static final String PARAM_ERROR_MSG = "Invalid parameter";
	// 令牌错误信息
	public static final String TOKEN_ERROE_MSG = "Token invalid or no longer valid";
	// 角色有误信息
	public static final String ROLE_ERROE_MSG = "Invalid role info";
	//错误的请求
	public static final String FALSE_REQUEST_MSG = "Bad Request";

	private static final long serialVersionUID = 201803281000L;
	// 返回code码
	private int code;
	// 返回结果消息
	private String message;
	// 返回结果对象
	private Object data;

	/**
	 * @param i
	 * @param string
	 * @param obj
	 */
	public Result(int code, String message, Object data) {
		this.code = code;
		this.message = message;
		this.data = data;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	
	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	/**
	 * 返回成功结果
	 * 
	 * @param obj
	 * @return
	 */
	public static Result success(Object data) {
		return new Result(200, "success", data);
	}

}
