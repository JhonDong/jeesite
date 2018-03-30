package com.thinkgem.jeesite.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.thinkgem.jeesite.service.bean.Result;

@Controller
public class WebService {

	@RequestMapping("rest")
	@ResponseBody
	public Result rest(HttpServletRequest request) {
		String params = (String) request.getParameter("params");
		return Result.success(params);
	}
	

}
