/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.medicine_sell.web;

import java.util.Date;

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
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.modules.medicine_sell.entity.MedicineSell;
import com.thinkgem.jeesite.modules.medicine_sell.service.MedicineSellService;

/**
 * 商品销售Controller
 * 
 * @author 董志强
 * @version 2018-03-08
 */
@Controller
@RequestMapping(value = "${adminPath}/medicine_sell/medicineSell")
public class MedicineSellController extends BaseController {

	@Autowired
	private MedicineSellService medicineSellService;

	@ModelAttribute
	public MedicineSell get(@RequestParam(required = false) String id) {
		MedicineSell entity = null;
		if (StringUtils.isNotBlank(id)) {
			entity = medicineSellService.get(id);
		}
		if (entity == null) {
			entity = new MedicineSell();
		}
		return entity;
	}

	@RequiresPermissions("medicine_sell:medicineSell:view")
	@RequestMapping(value = { "list", "" })
	public String list(MedicineSell medicineSell, HttpServletRequest request, HttpServletResponse response,
			Model model) {
		Page<MedicineSell> page = medicineSellService.findPage(new Page<MedicineSell>(request, response), medicineSell);
		model.addAttribute("page", page);
		return "modules/medicine_sell/medicineSellList";
	}

	@RequiresPermissions("medicine_sell:medicineSell:view")
	@RequestMapping(value = "form")
	public String form(MedicineSell medicineSell, Model model) {
		model.addAttribute("medicineSell", medicineSell);
		return "modules/medicine_sell/medicineSellForm";
	}

	@RequiresPermissions("medicine_sell:medicineSell:view")
	@RequestMapping(value = "form1")
	public String form1(MedicineSell medicineSell, Model model) {
		model.addAttribute("medicineSell", medicineSell);
		return "modules/medicine_sell/medicineSellForm2";
	}

	@RequiresPermissions("medicine_sell:medicineSell:edit")
	@RequestMapping(value = "save")
	public String save(MedicineSell medicineSell, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, medicineSell)) {
			return form(medicineSell, model);
		}
		Date date = new Date();
		medicineSell.setUpdateTime(date);
		if ("".equals(medicineSell.getId())) {
			medicineSell.setCreateTime(date);
			medicineSell.setIsNewRecord(true);
		}
		medicineSellService.save(medicineSell);
		addMessage(redirectAttributes, "保存商品销售成功");
		return "redirect:" + Global.getAdminPath() + "/medicine_sell/medicineSell/?repage";
	}

	@RequiresPermissions("medicine_sell:medicineSell:edit")
	@RequestMapping(value = "delete")
	public String delete(MedicineSell medicineSell, RedirectAttributes redirectAttributes) {
		medicineSellService.delete(medicineSell);
		addMessage(redirectAttributes, "删除商品销售成功");
		return "redirect:" + Global.getAdminPath() + "/medicine_sell/medicineSell/?repage";
	}

}