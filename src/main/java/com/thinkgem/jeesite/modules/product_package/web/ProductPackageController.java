/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.product_package.web;

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
import com.thinkgem.jeesite.modules.product_package.entity.ProductPackage;
import com.thinkgem.jeesite.modules.product_package.service.ProductPackageService;

/**
 * 商品包装Controller
 * 
 * @author 董志强
 * @version 2018-03-08
 */
@Controller
@RequestMapping(value = "${adminPath}/product_package/productPackage")
public class ProductPackageController extends BaseController {

	@Autowired
	private ProductPackageService productPackageService;

	@ModelAttribute
	public ProductPackage get(@RequestParam(required = false) String id) {
		ProductPackage entity = null;
		if (StringUtils.isNotBlank(id)) {
			entity = productPackageService.get(id);
		}
		if (entity == null) {
			entity = new ProductPackage();
		}
		return entity;
	}

	@RequiresPermissions("product_package:productPackage:view")
	@RequestMapping(value = { "list", "" })
	public String list(ProductPackage productPackage, HttpServletRequest request, HttpServletResponse response,
			Model model) {
		Page<ProductPackage> page = productPackageService.findPage(new Page<ProductPackage>(request, response),
				productPackage);
		model.addAttribute("page", page);
		return "modules/product_package/productPackageList";
	}

	/**
	 * 插入页面
	 * 
	 * @param productPackage
	 * @param model
	 * @return
	 */
	@RequiresPermissions("product_package:productPackage:view")
	@RequestMapping(value = "form")
	public String form(ProductPackage productPackage, Model model) {
		model.addAttribute("productPackage", productPackage);
		return "modules/product_package/productPackageForm";
	}

	/**
	 * 更新页面
	 * 
	 * @param productPackage
	 * @param model
	 * @return
	 */
	@RequiresPermissions("product_package:productPackage:view")
	@RequestMapping(value = "form1")
	public String form1(ProductPackage productPackage, Model model) {
		model.addAttribute("productPackage", productPackage);
		return "modules/product_package/productPackageForm2";
	}

	@RequiresPermissions("product_package:productPackage:edit")
	@RequestMapping(value = "save")
	public String save(ProductPackage productPackage, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, productPackage)) {
			return form(productPackage, model);
		}
		productPackageService.save(productPackage);
		addMessage(redirectAttributes, "保存商品包装成功");
		return "redirect:" + Global.getAdminPath() + "/product_package/productPackage/?repage";
	}

	@RequiresPermissions("product_package:productPackage:edit")
	@RequestMapping(value = "delete")
	public String delete(ProductPackage productPackage, RedirectAttributes redirectAttributes) {
		productPackageService.delete(productPackage);
		addMessage(redirectAttributes, "删除商品包装成功");
		return "redirect:" + Global.getAdminPath() + "/product_package/productPackage/?repage";
	}

}