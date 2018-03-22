/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.product_company.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.product_company.entity.ProductCompany;
import com.thinkgem.jeesite.modules.product_company.dao.ProductCompanyDao;

/**
 * 商品企业对照Service
 * @author 董志强
 * @version 2018-03-19
 */
@Service
@Transactional(readOnly = true)
public class ProductCompanyService extends CrudService<ProductCompanyDao, ProductCompany> {

	public ProductCompany get(String id) {
		return super.get(id);
	}
	
	public List<ProductCompany> findList(ProductCompany productCompany) {
		return super.findList(productCompany);
	}
	
	public Page<ProductCompany> findPage(Page<ProductCompany> page, ProductCompany productCompany) {
		return super.findPage(page, productCompany);
	}
	
	@Transactional(readOnly = false)
	public void save(ProductCompany productCompany) {
		super.save(productCompany);
	}
	
	@Transactional(readOnly = false)
	public void delete(ProductCompany productCompany) {
		super.delete(productCompany);
	}
	
}