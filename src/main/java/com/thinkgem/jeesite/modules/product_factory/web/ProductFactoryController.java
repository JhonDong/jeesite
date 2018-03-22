/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.product_factory.web;

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
import com.thinkgem.jeesite.modules.product_factory.entity.ProductFactory;
import com.thinkgem.jeesite.modules.product_factory.service.ProductFactoryService;

/**
 * 商品厂家模块Controller
 * 
 * @author 董志强
 * @version 2018-03-07
 */
@Controller
@RequestMapping(value = "${adminPath}/product_factory/productFactory")
public class ProductFactoryController extends BaseController {

	@Autowired
	private ProductFactoryService productFactoryService;

	@ModelAttribute
	public ProductFactory get(@RequestParam(required = false) String id) {
		ProductFactory entity = null;
		if (StringUtils.isNotBlank(id)) {
			entity = productFactoryService.get(id);
		}
		if (entity == null) {
			entity = new ProductFactory();
		}
		return entity;
	}

	@RequiresPermissions("product_factory:productFactory:view")
	@RequestMapping(value = { "list", "" })
	public String list(ProductFactory productFactory, HttpServletRequest request, HttpServletResponse response,
			Model model) {
		if(productFactory.getIsDelete()==null){
			productFactory.setIsDelete("0");
		}
		Page<ProductFactory> page = productFactoryService.findPage(new Page<ProductFactory>(request, response),
				productFactory);
		model.addAttribute("page", page);
		return "modules/product_factory/productFactoryList";
	}

	// 插入页面
	@RequiresPermissions("product_factory:productFactory:view")
	@RequestMapping(value = "form")
	public String form(ProductFactory productFactory, Model model) {
		model.addAttribute("productFactory", productFactory);
		return "modules/product_factory/productFactoryForm";
	}

	// 更新页面
	@RequiresPermissions("product_factory:productFactory:view")
	@RequestMapping(value = "form1")
	public String form1(ProductFactory productFactory, Model model) {
		model.addAttribute("productFactory", productFactory);
		return "modules/product_factory/productFactoryForm2";
	}

	@RequiresPermissions("product_factory:productFactory:edit")
	@RequestMapping(value = "save")
	public String save(ProductFactory productFactory, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, productFactory)) {
			return form(productFactory, model);
		}
		Date date = new Date();
		productFactory.setUpdateTime(date);
		if ("".equals(productFactory.getId())) {
			productFactory.setCreateTime(date);
		}
		productFactoryService.save(productFactory);
		addMessage(redirectAttributes, "保存商品厂家成功");
		return "redirect:" + Global.getAdminPath() + "/product_factory/productFactory/?repage";
	}

	@RequiresPermissions("product_factory:productFactory:edit")
	@RequestMapping(value = "delete")
	public String delete(ProductFactory productFactory, RedirectAttributes redirectAttributes) {
		productFactoryService.delete(productFactory);
		addMessage(redirectAttributes, "删除商品厂家成功");
		return "redirect:" + Global.getAdminPath() + "/product_factory/productFactory/?repage";
	}

}