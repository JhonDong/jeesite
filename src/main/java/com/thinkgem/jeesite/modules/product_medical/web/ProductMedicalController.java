/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.product_medical.web;

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
import com.thinkgem.jeesite.modules.product_medical.entity.ProductMedical;
import com.thinkgem.jeesite.modules.product_medical.service.ProductMedicalService;

/**
 * 医疗详情Controller
 * @author 董志强
 * @version 2018-03-05
 */
@Controller
@RequestMapping(value = "${adminPath}/product_medical/productMedical")
public class ProductMedicalController extends BaseController {

	@Autowired
	private ProductMedicalService productMedicalService;

	
	@ModelAttribute
	public ProductMedical get(@RequestParam(required=false) String id) {
		ProductMedical entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = productMedicalService.get(id);
		}
		if (entity == null){
			entity = new ProductMedical();
		}
		return entity;
	}
	
	@RequiresPermissions("product_medical:productMedical:view")
	@RequestMapping(value = {"list", ""})
	public String list(ProductMedical productMedical, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<ProductMedical> page = productMedicalService.findPage(new Page<ProductMedical>(request, response), productMedical); 
		model.addAttribute("page", page);
		return "modules/product_medical/productMedicalList";
	}

	/**
	 * 
	 * @param productMedical
	 * @param model
	 * @return
	 */
	@RequiresPermissions("product_medical:productMedical:view")
	@RequestMapping(value = "form")
	public String form(ProductMedical productMedical, Model model) {
		model.addAttribute("productMedical", productMedical);
		return "modules/product_medical/productMedicalForm";
	}
	/**
	 * 更新操作
	 * @param productMedical
	 * @param model
	 * @return
	 */
	@RequiresPermissions("product_medical:productMedical:view")
	@RequestMapping(value = "form1")
	public String form1(ProductMedical productMedical, Model model) {
		model.addAttribute("productMedical", productMedical);
		return "modules/product_medical/productMedicalForm2";
	}

	@RequiresPermissions("product_medical:productMedical:edit")
	@RequestMapping(value = "save")
	public String save(ProductMedical productMedical, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, productMedical)){
			return form(productMedical, model);
		}
		Date date = new Date();
		productMedical.setUpdateTime(date);
		if("".equals(productMedical.getId())){
			productMedical.setCreateTime(date);
		}
		productMedicalService.save(productMedical);
		addMessage(redirectAttributes, "保存医疗详情成功");
		return "redirect:"+Global.getAdminPath()+"/product_medical/productMedical/?repage";
	}
	
	@RequiresPermissions("product_medical:productMedical:edit")
	@RequestMapping(value = "delete")
	public String delete(ProductMedical productMedical, RedirectAttributes redirectAttributes) {
		productMedicalService.delete(productMedical);
		addMessage(redirectAttributes, "删除医疗详情成功");
		return "redirect:"+Global.getAdminPath()+"/product_medical/productMedical/?repage";
	}
	
	
}