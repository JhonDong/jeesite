/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.product_company.web;

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
import com.thinkgem.jeesite.modules.product_company.entity.ProductCompany;
import com.thinkgem.jeesite.modules.product_company.service.ProductCompanyService;

/**
 * 商品企业对照Controller
 * @author 董志强
 * @version 2018-03-19
 */
@Controller
@RequestMapping(value = "${adminPath}/product_company/productCompany")
public class ProductCompanyController extends BaseController {

	@Autowired
	private ProductCompanyService productCompanyService;
	
	@ModelAttribute
	public ProductCompany get(@RequestParam(required=false) String id) {
		ProductCompany entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = productCompanyService.get(id);
		}
		if (entity == null){
			entity = new ProductCompany();
		}
		return entity;
	}
	
	@RequiresPermissions("product_company:productCompany:view")
	@RequestMapping(value = {"list", ""})
	public String list(ProductCompany productCompany, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<ProductCompany> page = productCompanyService.findPage(new Page<ProductCompany>(request, response), productCompany); 
		model.addAttribute("page", page);
		return "modules/product_company/productCompanyList";
	}

	@RequiresPermissions("product_company:productCompany:view")
	@RequestMapping(value = "form")
	public String form(ProductCompany productCompany, Model model) {
		model.addAttribute("productCompany", productCompany);
		return "modules/product_company/productCompanyForm";
	}

	@RequiresPermissions("product_company:productCompany:edit")
	@RequestMapping(value = "save")
	public String save(ProductCompany productCompany, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, productCompany)){
			return form(productCompany, model);
		}
		productCompanyService.save(productCompany);
		addMessage(redirectAttributes, "保存商品企业对照成功");
		return "redirect:"+Global.getAdminPath()+"/product_company/productCompany/?repage";
	}
	
	@RequiresPermissions("product_company:productCompany:edit")
	@RequestMapping(value = "delete")
	public String delete(ProductCompany productCompany, RedirectAttributes redirectAttributes) {
		productCompanyService.delete(productCompany);
		addMessage(redirectAttributes, "删除商品企业对照成功");
		return "redirect:"+Global.getAdminPath()+"/product_company/productCompany/?repage";
	}

}