/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.category.web;

import java.util.Date;
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

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.thinkgem.jeesite.common.config.Global;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.modules.category.entity.GaojiCategory;
import com.thinkgem.jeesite.modules.category.service.GaojiCategoryService;

/**
 * 树结构生成Controller
 * @author 董志强
 * @version 2018-03-02
 */
@Controller
@RequestMapping(value = "${adminPath}/category/gaojiCategory")
public class GaojiCategoryController extends BaseController {

	@Autowired
	private GaojiCategoryService gaojiCategoryService;
	
	@ModelAttribute
	public GaojiCategory get(@RequestParam(required=false) String id) {
		GaojiCategory entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = gaojiCategoryService.get(id);
		}
		if (entity == null){
			entity = new GaojiCategory();
		}
		return entity;
	}
	
	@RequiresPermissions("category:gaojiCategory:view")
	@RequestMapping(value = {"list", ""})
	public String list(GaojiCategory gaojiCategory, HttpServletRequest request, HttpServletResponse response, Model model) {
		List<GaojiCategory> list = gaojiCategoryService.findList(gaojiCategory); 
		model.addAttribute("list", list);
		return "modules/category/gaojiCategoryList";
	}

	@RequiresPermissions("category:gaojiCategory:view")
	@RequestMapping(value = "form")
	public String form(GaojiCategory gaojiCategory, Model model) {
		if (gaojiCategory.getParent()!=null && StringUtils.isNotBlank(gaojiCategory.getParent().getId())){
			gaojiCategory.setParent(gaojiCategoryService.get(gaojiCategory.getParent().getId()));
			// 获取排序号，最末节点排序号+30
			if (StringUtils.isBlank(gaojiCategory.getId())){
				GaojiCategory gaojiCategoryChild = new GaojiCategory();
				gaojiCategoryChild.setParent(new GaojiCategory(gaojiCategory.getParent().getId()));
				List<GaojiCategory> list = gaojiCategoryService.findList(gaojiCategory); 
				if (list.size() > 0){
					gaojiCategory.setSort(list.get(list.size()-1).getSort());
					if (gaojiCategory.getSort() != null){
						gaojiCategory.setSort(gaojiCategory.getSort() + 30);
					}
				}
			}
		}
		if (gaojiCategory.getSort() == null){
			gaojiCategory.setSort(30);
		}
		model.addAttribute("gaojiCategory", gaojiCategory);
		return "modules/category/gaojiCategoryForm";
	}

	@RequiresPermissions("category:gaojiCategory:edit")
	@RequestMapping(value = "save")
	public String save(GaojiCategory gaojiCategory, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, gaojiCategory)){
			return form(gaojiCategory, model);
		}
		//新增
		Date date=new Date();
		gaojiCategory.setUpdateTime(date);
		if("".equals(gaojiCategory.getId())){
			gaojiCategory.setIsNewRecord(true);
			gaojiCategory.setCreateTime(date);
		}
		gaojiCategoryService.save(gaojiCategory);
		addMessage(redirectAttributes, "保存商品分类列表成功");
		return "redirect:"+Global.getAdminPath()+"/category/gaojiCategory/?repage";
	}
	
	@RequiresPermissions("category:gaojiCategory:edit")
	@RequestMapping(value = "delete")
	public String delete(GaojiCategory gaojiCategory, RedirectAttributes redirectAttributes) {
		gaojiCategoryService.delete(gaojiCategory);
		addMessage(redirectAttributes, "删除商品分类列表成功");
		return "redirect:"+Global.getAdminPath()+"/category/gaojiCategory/?repage";
	}

	@RequiresPermissions("user")
	@ResponseBody
	@RequestMapping(value = "treeData")
	public List<Map<String, Object>> treeData(@RequestParam(required=false) String extId, HttpServletResponse response) {
		List<Map<String, Object>> mapList = Lists.newArrayList();
		List<GaojiCategory> list = gaojiCategoryService.findList(new GaojiCategory());
		for (int i=0; i<list.size(); i++){
			GaojiCategory e = list.get(i);
			if (StringUtils.isBlank(extId) || (extId!=null && !extId.equals(e.getId()) && e.getParentIds().indexOf(","+extId+",")==-1)){
				Map<String, Object> map = Maps.newHashMap();
				map.put("id", e.getId());
				map.put("pId", e.getParentId());
				map.put("name", e.getName());
				mapList.add(map);
			}
		}
		return mapList;
	}
	
}