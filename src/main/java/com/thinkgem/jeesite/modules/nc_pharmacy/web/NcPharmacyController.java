/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.nc_pharmacy.web;

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
import com.thinkgem.jeesite.modules.nc_pharmacy.entity.NcPharmacy;
import com.thinkgem.jeesite.modules.nc_pharmacy.service.NcPharmacyService;

/**
 * 门店映射Controller
 * @author 董志强
 * @version 2018-03-23
 */
@Controller
@RequestMapping(value = "${adminPath}/nc_pharmacy/ncPharmacy")
public class NcPharmacyController extends BaseController {

	@Autowired
	private NcPharmacyService ncPharmacyService;
	
	@ModelAttribute
	public NcPharmacy get(@RequestParam(required=false) String id) {
		NcPharmacy entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = ncPharmacyService.get(id);
		}
		if (entity == null){
			entity = new NcPharmacy();
		}
		return entity;
	}
	
	@RequiresPermissions("nc_pharmacy:ncPharmacy:view")
	@RequestMapping(value = {"list", ""})
	public String list(NcPharmacy ncPharmacy, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<NcPharmacy> page = ncPharmacyService.findPage(new Page<NcPharmacy>(request, response), ncPharmacy); 
		model.addAttribute("page", page);
		return "modules/nc_pharmacy/ncPharmacyList";
	}

	@RequiresPermissions("nc_pharmacy:ncPharmacy:view")
	@RequestMapping(value = "form")
	public String form(NcPharmacy ncPharmacy, Model model) {
		model.addAttribute("ncPharmacy", ncPharmacy);
		return "modules/nc_pharmacy/ncPharmacyForm";
	}

	@RequiresPermissions("nc_pharmacy:ncPharmacy:edit")
	@RequestMapping(value = "save")
	public String save(NcPharmacy ncPharmacy, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, ncPharmacy)){
			return form(ncPharmacy, model);
		}
		ncPharmacyService.save(ncPharmacy);
		addMessage(redirectAttributes, "保存门店映射成功");
		return "redirect:"+Global.getAdminPath()+"/nc_pharmacy/ncPharmacy/?repage";
	}
	
	@RequiresPermissions("nc_pharmacy:ncPharmacy:edit")
	@RequestMapping(value = "delete")
	public String delete(NcPharmacy ncPharmacy, RedirectAttributes redirectAttributes) {
		ncPharmacyService.delete(ncPharmacy);
		addMessage(redirectAttributes, "删除门店映射成功");
		return "redirect:"+Global.getAdminPath()+"/nc_pharmacy/ncPharmacy/?repage";
	}

}