/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.medicine_purchase.web;

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
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.modules.medicine_purchase.entity.MedicinePurchase;
import com.thinkgem.jeesite.modules.medicine_purchase.service.MedicinePurchaseService;

/**
 * 商品采购Controller
 * @author 董志强
 * @version 2018-03-08
 */
@Controller
@RequestMapping(value = "${adminPath}/medicine_purchase/medicinePurchase")
public class MedicinePurchaseController extends BaseController {

	@Autowired
	private MedicinePurchaseService medicinePurchaseService;
	
	@ModelAttribute
	public MedicinePurchase get(@RequestParam(required=false) String id) {
		MedicinePurchase entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = medicinePurchaseService.get(id);
		}
		if (entity == null){
			entity = new MedicinePurchase();
		}
		return entity;
	}
	
	@RequiresPermissions("medicine_purchase:medicinePurchase:view")
	@RequestMapping(value = {"list", ""})
	public String list(MedicinePurchase medicinePurchase, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<MedicinePurchase> page = medicinePurchaseService.findPage(new Page<MedicinePurchase>(request, response), medicinePurchase); 
		model.addAttribute("page", page);
		return "modules/medicine_purchase/medicinePurchaseList";
	}

	@RequiresPermissions("medicine_purchase:medicinePurchase:view")
	@RequestMapping(value = "form")
	public String form(MedicinePurchase medicinePurchase, Model model) {
		model.addAttribute("medicinePurchase", medicinePurchase);
		return "modules/medicine_purchase/medicinePurchaseForm";
	}
	@RequiresPermissions("medicine_purchase:medicinePurchase:view")
	@RequestMapping(value = "form1")
	public String form1(MedicinePurchase medicinePurchase, Model model) {
		model.addAttribute("medicinePurchase", medicinePurchase);
		return "modules/medicine_purchase/medicinePurchaseForm2";
	}

	@RequiresPermissions("medicine_purchase:medicinePurchase:edit")
	@RequestMapping(value = "save")
	public String save(MedicinePurchase medicinePurchase, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, medicinePurchase)){
			return form(medicinePurchase, model);
		}
		Date date=new Date();
		medicinePurchase.setUpdateTime(date);
		//插入操作
		if("".equals(medicinePurchase.getId())){
			medicinePurchase.setCreateTime(date);
			medicinePurchase.setIsNewRecord(true);
		}
		medicinePurchaseService.save(medicinePurchase);
		addMessage(redirectAttributes, "保存商品采购成功");
		return "redirect:"+Global.getAdminPath()+"/medicine_purchase/medicinePurchase/?repage";
	}
	
	@RequiresPermissions("medicine_purchase:medicinePurchase:edit")
	@RequestMapping(value = "delete")
	public String delete(MedicinePurchase medicinePurchase, RedirectAttributes redirectAttributes) {
		medicinePurchaseService.delete(medicinePurchase);
		addMessage(redirectAttributes, "删除商品采购成功");
		return "redirect:"+Global.getAdminPath()+"/medicine_purchase/medicinePurchase/?repage";
	}

}