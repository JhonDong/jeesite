/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.medicine_zh.web;

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
import com.thinkgem.jeesite.modules.medicine_zh.entity.MedicineZh;
import com.thinkgem.jeesite.modules.medicine_zh.service.MedicineZhService;

/**
 * 中药信息表Controller
 * @author 董志强
 * @version 2018-03-08
 */
@Controller
@RequestMapping(value = "${adminPath}/medicine_zh/medicineZh")
public class MedicineZhController extends BaseController {

	@Autowired
	private MedicineZhService medicineZhService;
	
	@ModelAttribute
	public MedicineZh get(@RequestParam(required=false) String id) {
		MedicineZh entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = medicineZhService.get(id);
		}
		if (entity == null){
			entity = new MedicineZh();
		}
		return entity;
	}
	
	@RequiresPermissions("medicine_zh:medicineZh:view")
	@RequestMapping(value = {"list", ""})
	public String list(MedicineZh medicineZh, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<MedicineZh> page = medicineZhService.findPage(new Page<MedicineZh>(request, response), medicineZh); 
		model.addAttribute("page", page);
		return "modules/medicine_zh/medicineZhList";
	}

	/**
	 * 插入
	 * @param medicineZh
	 * @param model
	 * @return
	 */
	@RequiresPermissions("medicine_zh:medicineZh:view")
	@RequestMapping(value = "form")
	public String form(MedicineZh medicineZh, Model model) {
		model.addAttribute("medicineZh", medicineZh);
		return "modules/medicine_zh/medicineZhForm";
	}
	/**
	 * 更新
	 * @param medicineZh
	 * @param model
	 * @return
	 */
	@RequiresPermissions("medicine_zh:medicineZh:view")
	@RequestMapping(value = "form1")
	public String form1(MedicineZh medicineZh, Model model) {
		model.addAttribute("medicineZh", medicineZh);
		return "modules/medicine_zh/medicineZhForm2";
	}

	@RequiresPermissions("medicine_zh:medicineZh:edit")
	@RequestMapping(value = "save")
	public String save(MedicineZh medicineZh, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, medicineZh)){
			return form(medicineZh, model);
		}
		medicineZhService.save(medicineZh);
		addMessage(redirectAttributes, "保存中药信息成功");
		return "redirect:"+Global.getAdminPath()+"/medicine_zh/medicineZh/?repage";
	}
	
	@RequiresPermissions("medicine_zh:medicineZh:edit")
	@RequestMapping(value = "delete")
	public String delete(MedicineZh medicineZh, RedirectAttributes redirectAttributes) {
		medicineZhService.delete(medicineZh);
		addMessage(redirectAttributes, "删除中药信息成功");
		return "redirect:"+Global.getAdminPath()+"/medicine_zh/medicineZh/?repage";
	}

}