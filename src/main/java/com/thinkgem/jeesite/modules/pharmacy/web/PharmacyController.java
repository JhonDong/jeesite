/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.pharmacy.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.thinkgem.jeesite.common.config.Global;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.modules.pharmacy.entity.Pharmacy;
import com.thinkgem.jeesite.modules.pharmacy.service.PharmacyService;

/**
 * 门户管理Controller
 * @author 董志强
 * @version 2018-03-21
 */
@Controller
@RequestMapping(value = "${adminPath}/pharmacy/pharmacy")
public class PharmacyController extends BaseController {

	@Autowired
	private PharmacyService pharmacyService;
	
	@ModelAttribute
	public Pharmacy get(@RequestParam(required=false) String id) {
		Pharmacy entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = pharmacyService.get(id);
		}
		if (entity == null){
			entity = new Pharmacy();
		}
		return entity;
	}
	
	@RequiresPermissions("pharmacy:pharmacy:view")
	@RequestMapping(value = {"list", ""})
	public String list(Pharmacy pharmacy, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<Pharmacy> page = pharmacyService.findPage(new Page<Pharmacy>(request, response), pharmacy); 
		model.addAttribute("page", page);
		return "modules/pharmacy/pharmacyList";
	}

	@RequiresPermissions("pharmacy:pharmacy:view")
	@RequestMapping(value = "form")
	public String form(Pharmacy pharmacy, Model model) {
		model.addAttribute("pharmacy", pharmacy);
		return "modules/pharmacy/pharmacyForm";
	}

	@RequiresPermissions("pharmacy:pharmacy:edit")
	@RequestMapping(value = "save")
	public String save(Pharmacy pharmacy, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, pharmacy)){
			return form(pharmacy, model);
		}
		pharmacyService.save(pharmacy);
		addMessage(redirectAttributes, "保存门户管理成功");
		return "redirect:"+Global.getAdminPath()+"/pharmacy/pharmacy/?repage";
	}
	
	@RequiresPermissions("pharmacy:pharmacy:edit")
	@RequestMapping(value = "delete")
	public String delete(Pharmacy pharmacy, RedirectAttributes redirectAttributes) {
		pharmacyService.delete(pharmacy);
		addMessage(redirectAttributes, "删除门户管理成功");
		return "redirect:"+Global.getAdminPath()+"/pharmacy/pharmacy/?repage";
	}

}