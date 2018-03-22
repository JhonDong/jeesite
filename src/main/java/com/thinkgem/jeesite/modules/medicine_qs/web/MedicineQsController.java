/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.medicine_qs.web;

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
import com.thinkgem.jeesite.modules.medicine_qs.entity.MedicineQs;
import com.thinkgem.jeesite.modules.medicine_qs.service.MedicineQsService;

/**
 * 商品安全质量信息表Controller
 * @author 董志强
 * @version 2018-03-08
 */
@Controller
@RequestMapping(value = "${adminPath}/medicine_qs/medicineQs")
public class MedicineQsController extends BaseController {

	@Autowired
	private MedicineQsService medicineQsService;
	
	@ModelAttribute
	public MedicineQs get(@RequestParam(required=false) String id) {
		MedicineQs entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = medicineQsService.get(id);
		}
		if (entity == null){
			entity = new MedicineQs();
		}
		return entity;
	}
	
	@RequiresPermissions("medicine_qs:medicineQs:view")
	@RequestMapping(value = {"list", ""})
	public String list(MedicineQs medicineQs, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<MedicineQs> page = medicineQsService.findPage(new Page<MedicineQs>(request, response), medicineQs); 
		model.addAttribute("page", page);
		return "modules/medicine_qs/medicineQsList";
	}

	/**
	 * 插入
	 * @param medicineQs
	 * @param model
	 * @return
	 */
	@RequiresPermissions("medicine_qs:medicineQs:view")
	@RequestMapping(value = "form")
	public String form(MedicineQs medicineQs, Model model) {
		model.addAttribute("medicineQs", medicineQs);
		return "modules/medicine_qs/medicineQsForm";
	}
	/**
	 * 更新
	 * @param medicineQs
	 * @param model
	 * @return
	 */
	@RequiresPermissions("medicine_qs:medicineQs:view")
	@RequestMapping(value = "form1")
	public String form1(MedicineQs medicineQs, Model model) {
		model.addAttribute("medicineQs", medicineQs);
		return "modules/medicine_qs/medicineQsForm2";
	}

	@RequiresPermissions("medicine_qs:medicineQs:edit")
	@RequestMapping(value = "save")
	public String save(MedicineQs medicineQs, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, medicineQs)){
			return form(medicineQs, model);
		}
		medicineQsService.save(medicineQs);
		addMessage(redirectAttributes, "保存商品安全质量信息成功");
		return "redirect:"+Global.getAdminPath()+"/medicine_qs/medicineQs/?repage";
	}
	
	@RequiresPermissions("medicine_qs:medicineQs:edit")
	@RequestMapping(value = "delete")
	public String delete(MedicineQs medicineQs, RedirectAttributes redirectAttributes) {
		medicineQsService.delete(medicineQs);
		addMessage(redirectAttributes, "删除商品安全质量信息成功");
		return "redirect:"+Global.getAdminPath()+"/medicine_qs/medicineQs/?repage";
	}

}