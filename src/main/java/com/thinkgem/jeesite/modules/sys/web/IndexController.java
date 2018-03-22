/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.sys.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.thinkgem.jeesite.common.web.BaseController;

/**
 * 首页Controller
 * 
 * @author 董志强
 * @version 2018-3-14
 */
@Controller
public class IndexController extends BaseController {

	@RequestMapping(value = "${adminPath}/sys/index/info", method = RequestMethod.GET)
	public String index() {
		return "modules/sys/index";
	}

}
