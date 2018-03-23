/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.pharmacy.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolationException;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.google.common.collect.Lists;
import com.thinkgem.jeesite.common.beanvalidator.BeanValidators;
import com.thinkgem.jeesite.common.config.Global;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.utils.DateUtils;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.common.utils.excel.ExportExcel;
import com.thinkgem.jeesite.common.utils.excel.ImportExcel;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.modules.pharmacy.entity.Pharmacy;
import com.thinkgem.jeesite.modules.pharmacy.service.PharmacyService;
import com.thinkgem.jeesite.modules.sys.entity.User;
import com.thinkgem.jeesite.modules.sys.service.SystemService;
import com.thinkgem.jeesite.modules.sys.utils.UserUtils;

/**
 * 门户管理Controller
 * @author 董志强
 * @version 2018-03-21
 */
@Controller
@RequestMapping(value = "${adminPath}/pharmacy/pharmacy")
public class PharmacyController extends BaseController {

	@Autowired
	private PharmacyService pharmacyService;
	
	@ModelAttribute
	public Pharmacy get(@RequestParam(required=false) String id) {
		Pharmacy entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = pharmacyService.get(id);
		}
		if (entity == null){
			entity = new Pharmacy();
		}
		return entity;
	}
	
	@RequiresPermissions("pharmacy:pharmacy:view")
	@RequestMapping(value = {"list", ""})
	public String list(Pharmacy pharmacy, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<Pharmacy> page = pharmacyService.findPage(new Page<Pharmacy>(request, response), pharmacy); 
		model.addAttribute("page", page);
		return "modules/pharmacy/pharmacyList";
	}

	@RequiresPermissions("pharmacy:pharmacy:view")
	@RequestMapping(value = "form")
	public String form(Pharmacy pharmacy, Model model) {
		model.addAttribute("pharmacy", pharmacy);
		return "modules/pharmacy/pharmacyForm";
	}

	@RequiresPermissions("pharmacy:pharmacy:edit")
	@RequestMapping(value = "save")
	public String save(Pharmacy pharmacy, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, pharmacy)){
			return form(pharmacy, model);
		}
		pharmacyService.save(pharmacy);
		addMessage(redirectAttributes, "保存门户管理成功");
		return "redirect:"+Global.getAdminPath()+"/pharmacy/pharmacy/?repage";
	}
	
	@RequiresPermissions("pharmacy:pharmacy:edit")
	@RequestMapping(value = "delete")
	public String delete(Pharmacy pharmacy, RedirectAttributes redirectAttributes) {
		pharmacyService.delete(pharmacy);
		addMessage(redirectAttributes, "删除门户管理成功");
		return "redirect:"+Global.getAdminPath()+"/pharmacy/pharmacy/?repage";
	}
	
	/**
	 * 导出用户数据
	 * @param user
	 * @param request
	 * @param response
	 * @param redirectAttributes
	 * @return
	 */
	@RequiresPermissions("pharmacy:pharmacy:view")
    @RequestMapping(value = "export", method=RequestMethod.POST)
    public String exportFile(Pharmacy pharmacy, HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "门户数据"+DateUtils.getDate("yyyyMMddHHmmss")+".xlsx";
            Page<Pharmacy> page = pharmacyService.findPharmacy(new Page<Pharmacy>(request, response, -1), pharmacy);
    		ExportExcel exportExcel = new ExportExcel("门户数据", Pharmacy.class);
    		exportExcel.setDataList(page.getList());
    		exportExcel.write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导出门户数据！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/pharmacy/pharmacy/?repage";
    }

/*	*//**
	 * 导入用户数据
	 * @param file
	 * @param redirectAttributes
	 * @return
	 *//*
	@RequiresPermissions("sys:pharmacy:edit")
    @RequestMapping(value = "import", method=RequestMethod.POST)
    public String importFile(MultipartFile file, RedirectAttributes redirectAttributes) {
		if(Global.isDemoMode()){
			addMessage(redirectAttributes, "演示模式，不允许操作！");
			return "redirect:" + adminPath + "/sys/user/list?repage";
		}
		try {
			int successNum = 0;
			int failureNum = 0;
			StringBuilder failureMsg = new StringBuilder();
			ImportExcel ei = new ImportExcel(file, 1, 0);
			List<User> list = ei.getDataList(User.class);
			for (User user : list){
				try{
					if ("true".equals(checkLoginName("", user.getLoginName()))){
						user.setPassword(SystemService.entryptPassword("123456"));
						BeanValidators.validateWithException(validator, user);
						systemService.saveUser(user);
						successNum++;
					}else{
						failureMsg.append("<br/>登录名 "+user.getLoginName()+" 已存在; ");
						failureNum++;
					}
				}catch(ConstraintViolationException ex){
					failureMsg.append("<br/>登录名 "+user.getLoginName()+" 导入失败：");
					List<String> messageList = BeanValidators.extractPropertyAndMessageAsList(ex, ": ");
					for (String message : messageList){
						failureMsg.append(message+"; ");
						failureNum++;
					}
				}catch (Exception ex) {
					failureMsg.append("<br/>登录名 "+user.getLoginName()+" 导入失败："+ex.getMessage());
				}
			}
			if (failureNum>0){
				failureMsg.insert(0, "，失败 "+failureNum+" 条用户，导入信息如下：");
			}
			addMessage(redirectAttributes, "已成功导入 "+successNum+" 条用户"+failureMsg);
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入用户失败！失败信息："+e.getMessage());
		}
		return "redirect:" + adminPath + "/sys/user/list?repage";
    }*/
	
	/**
	 * 下载导入用户数据模板
	 * @param response
	 * @param redirectAttributes
	 * @return
	 */
	@RequiresPermissions("sys:user:view")
    @RequestMapping(value = "import/template")
    public String importFileTemplate(HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "门户数据导入模板.xlsx";
    		List<Pharmacy> list = Lists.newArrayList(); list.add(new Pharmacy());
    		new ExportExcel("门户数据", Pharmacy.class, 2).setDataList(list).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入模板下载失败！失败信息："+e.getMessage());
		}
		return "redirect:" + adminPath + "/sys/user/list?repage";
    }

}