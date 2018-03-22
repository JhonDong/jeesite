/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.product_temp.web;

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
import com.thinkgem.jeesite.modules.product_temp.entity.ProductTemp;
import com.thinkgem.jeesite.modules.product_temp.service.ProductTempService;

/**
 * 数据字典Controller
 * @author 董志强
 * @version 2018-03-19
 */
@Controller
@RequestMapping(value = "${adminPath}/product_temp/productTemp")
public class ProductTempController extends BaseController {

	@Autowired
	private ProductTempService productTempService;
	
	@ModelAttribute
	public ProductTemp get(@RequestParam(required=false) String id) {
		ProductTemp entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = productTempService.get(id);
		}
		if (entity == null){
			entity = new ProductTemp();
		}
		return entity;
	}
	
	@RequiresPermissions("product_temp:productTemp:view")
	@RequestMapping(value = {"list", ""})
	public String list(ProductTemp productTemp, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<ProductTemp> page = productTempService.findPage(new Page<ProductTemp>(request, response), productTemp); 
		model.addAttribute("page", page);
		return "modules/product_temp/productTempList";
	}

	@RequiresPermissions("product_temp:productTemp:view")
	@RequestMapping(value = "form")
	public String form(ProductTemp productTemp, Model model) {
		model.addAttribute("productTemp", productTemp);
		return "modules/product_temp/productTempForm";
	}

	@RequiresPermissions("product_temp:productTemp:edit")
	@RequestMapping(value = "save")
	public String save(ProductTemp productTemp, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, productTemp)){
			return form(productTemp, model);
		}
		productTempService.save(productTemp);
		addMessage(redirectAttributes, "保存数据字典成功");
		return "redirect:"+Global.getAdminPath()+"/product_temp/productTemp/?repage";
	}
	
	@RequiresPermissions("product_temp:productTemp:edit")
	@RequestMapping(value = "delete")
	public String delete(ProductTemp productTemp, RedirectAttributes redirectAttributes) {
		productTempService.delete(productTemp);
		addMessage(redirectAttributes, "删除数据字典成功");
		return "redirect:"+Global.getAdminPath()+"/product_temp/productTemp/?repage";
	}

}