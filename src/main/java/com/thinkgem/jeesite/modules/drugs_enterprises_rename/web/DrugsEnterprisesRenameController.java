/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.drugs_enterprises_rename.web;

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
import com.thinkgem.jeesite.modules.drugs_enterprises_rename.entity.DrugsEnterprisesRename;
import com.thinkgem.jeesite.modules.drugs_enterprises_rename.service.DrugsEnterprisesRenameService;

/**
 * 药品生产企业Controller
 * @author 董志强
 * @version 2018-03-12
 */
@Controller
@RequestMapping(value = "${adminPath}/drugs_enterprises_rename/drugsEnterprisesRename")
public class DrugsEnterprisesRenameController extends BaseController {

	@Autowired
	private DrugsEnterprisesRenameService drugsEnterprisesRenameService;
	
	@ModelAttribute
	public DrugsEnterprisesRename get(@RequestParam(required=false) String id) {
		DrugsEnterprisesRename entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = drugsEnterprisesRenameService.get(id);
		}
		if (entity == null){
			entity = new DrugsEnterprisesRename();
		}
		return entity;
	}
	
	@RequiresPermissions("drugs_enterprises_rename:drugsEnterprisesRename:view")
	@RequestMapping(value = {"list", ""})
	public String list(DrugsEnterprisesRename drugsEnterprisesRename, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<DrugsEnterprisesRename> page = drugsEnterprisesRenameService.findPage(new Page<DrugsEnterprisesRename>(request, response), drugsEnterprisesRename); 
		model.addAttribute("page", page);
		return "modules/drugs_enterprises_rename/drugsEnterprisesRenameList";
	}

	@RequiresPermissions("drugs_enterprises_rename:drugsEnterprisesRename:view")
	@RequestMapping(value = "form")
	public String form(DrugsEnterprisesRename drugsEnterprisesRename, Model model) {
		model.addAttribute("drugsEnterprisesRename", drugsEnterprisesRename);
		return "modules/drugs_enterprises_rename/drugsEnterprisesRenameForm";
	}

	@RequiresPermissions("drugs_enterprises_rename:drugsEnterprisesRename:edit")
	@RequestMapping(value = "save")
	public String save(DrugsEnterprisesRename drugsEnterprisesRename, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, drugsEnterprisesRename)){
			return form(drugsEnterprisesRename, model);
		}
		drugsEnterprisesRenameService.save(drugsEnterprisesRename);
		addMessage(redirectAttributes, "保存药品生产企业成功");
		return "redirect:"+Global.getAdminPath()+"/drugs_enterprises_rename/drugsEnterprisesRename/?repage";
	}
	
	@RequiresPermissions("drugs_enterprises_rename:drugsEnterprisesRename:edit")
	@RequestMapping(value = "delete")
	public String delete(DrugsEnterprisesRename drugsEnterprisesRename, RedirectAttributes redirectAttributes) {
		drugsEnterprisesRenameService.delete(drugsEnterprisesRename);
		addMessage(redirectAttributes, "删除药品生产企业成功");
		return "redirect:"+Global.getAdminPath()+"/drugs_enterprises_rename/drugsEnterprisesRename/?repage";
	}

}