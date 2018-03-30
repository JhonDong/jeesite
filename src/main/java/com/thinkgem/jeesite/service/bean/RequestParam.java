package com.thinkgem.jeesite.service.bean;

import java.io.Serializable;

/**
 * 请求参数
 * 
 * @author User
 *
 */
public class RequestParam implements Serializable{

	// 接口令牌
	private String token;
	// 角色
	private String role;
	// 服务名称
	private String service_name;
	// 时间戳
	private String time_stamp;
	// 请求参数json串
	private String params;

}
