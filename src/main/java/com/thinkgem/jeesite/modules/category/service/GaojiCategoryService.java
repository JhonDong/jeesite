/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.category.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.service.TreeService;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.modules.category.entity.GaojiCategory;
import com.thinkgem.jeesite.modules.category.dao.GaojiCategoryDao;

/**
 * 树结构生成Service
 * @author 董志强
 * @version 2018-03-02
 */
@Service
@Transactional(readOnly = true)
public class GaojiCategoryService extends TreeService<GaojiCategoryDao, GaojiCategory> {

	public GaojiCategory get(String id) {
		return super.get(id);
	}
	
	public List<GaojiCategory> findList(GaojiCategory gaojiCategory) {
		if (StringUtils.isNotBlank(gaojiCategory.getParentIds())){
			gaojiCategory.setParentIds(","+gaojiCategory.getParentIds()+",");
		}
		return super.findList(gaojiCategory);
	}
	
	@Transactional(readOnly = false)
	public void save(GaojiCategory gaojiCategory) {
		super.save(gaojiCategory);
	}
	
	@Transactional(readOnly = false)
	public void delete(GaojiCategory gaojiCategory) {
		super.delete(gaojiCategory);
	}
	
}