/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.product_temp.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.product_temp.entity.ProductTemp;
import com.thinkgem.jeesite.modules.product_temp.dao.ProductTempDao;

/**
 * 数据字典Service
 * @author 董志强
 * @version 2018-03-19
 */
@Service
@Transactional(readOnly = true)
public class ProductTempService extends CrudService<ProductTempDao, ProductTemp> {

	public ProductTemp get(String id) {
		return super.get(id);
	}
	
	public List<ProductTemp> findList(ProductTemp productTemp) {
		return super.findList(productTemp);
	}
	
	public Page<ProductTemp> findPage(Page<ProductTemp> page, ProductTemp productTemp) {
		return super.findPage(page, productTemp);
	}
	
	@Transactional(readOnly = false)
	public void save(ProductTemp productTemp) {
		super.save(productTemp);
	}
	
	@Transactional(readOnly = false)
	public void delete(ProductTemp productTemp) {
		super.delete(productTemp);
	}
	
}