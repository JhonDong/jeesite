/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.product.web;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.thinkgem.jeesite.common.config.Global;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.modules.product.entity.Product;
import com.thinkgem.jeesite.modules.product.service.ProductService;
import com.thinkgem.jeesite.modules.sys.utils.IDUtils;

/**
 * 高济商品Controller
 * 
 * @author 董志强
 * @version 2018-03-05
 */
@Controller
@RequestMapping(value = "${adminPath}/product/product")
public class ProductController extends BaseController {

	@Autowired
	private ProductService productService;

	@ModelAttribute
	public Product get(@RequestParam(required = false) String id) {
		Product entity = null;
		if (StringUtils.isNotBlank(id)) {
			entity = productService.get(id);
		}
		if (entity == null) {
			entity = new Product();
		}
		return entity;
	}

	@RequiresPermissions("product:product:view")
	@RequestMapping(value = { "list", "" })
	public String list(Product product, HttpServletRequest request, HttpServletResponse response, Model model) {
		if(product.getIsDelete()==null){
			product.setIsDelete("0");
		}
		Page<Product> page = productService.findPage(new Page<Product>(request, response), product);
		model.addAttribute("page", page);
		return "modules/product/productList";
	}

	@RequiresPermissions("product:product:view")
	@RequestMapping(value = "form")
	public String form(Product product, Model model) {
		model.addAttribute("product", product);
		return "modules/product/productForm";
	}

	@RequiresPermissions("product:product:edit")
	@RequestMapping(value = "save")
	public String save(Product product, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, product)) {
			return form(product, model);
		}
		Date date = new Date();
		product.setUpdateTime(date);
		// 获得主键ID
		// 插入
		if ("".equals(product.getId())) {
			String getpPrimaryKey = IDUtils.getpPrimaryKey();
			if (getpPrimaryKey != null) {
				product.setIsNewRecord(true);
				product.setId(getpPrimaryKey);
				product.setCreateTime(date);
			} else {
				addMessage(redirectAttributes, "保存高济商品成功失败");
				return "redirect:" + Global.getAdminPath() + "/product/product/?repage";
			}
		}
		productService.save(product);
		addMessage(redirectAttributes, "保存高济商品成功");
		return "redirect:" + Global.getAdminPath() + "/product/product/?repage";
	}

	@RequiresPermissions("product:product:edit")
	@RequestMapping(value = "delete")
	public String delete(Product product, RedirectAttributes redirectAttributes) {
		//软删除
		productService.delete(product);
		addMessage(redirectAttributes, "删除高济商品成功");
		return "redirect:" + Global.getAdminPath() + "/product/product/?repage";
	}

	// ajax请求返回所有json串
	@RequiresPermissions("product:product:view")
	@RequestMapping(value = "search")
	@ResponseBody
	public List<Map<String, Object>> search(HttpServletRequest request) {
		String q = request.getParameter("q");
		try {
			q=new String(q.getBytes("ISO-8859-1"),"UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		List<Product> list = productService.search(q);
		List<Map<String, Object>> l = new ArrayList<Map<String, Object>>();
		for (Product product : list) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("id", product.getId());
			map.put("text", product.getName());
			l.add(map);
		}
		return l;
	}
	// ajax请求返回所有json串 回显
	@RequiresPermissions("product:product:view")
	@RequestMapping(value = "callback")
	@ResponseBody
	public Map<String, Object> callback(HttpServletRequest request) {
		String id = request.getParameter("id");
		Product p = productService.get(id);
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("id", p.getId());
		map.put("text", p.getName());
		return map;
	}

}