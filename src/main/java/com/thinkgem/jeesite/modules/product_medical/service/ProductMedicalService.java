/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.product_medical.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.product_medical.entity.ProductMedical;
import com.thinkgem.jeesite.modules.product_medical.dao.ProductMedicalDao;

/**
 * 医疗详情Service
 * @author 董志强
 * @version 2018-03-05
 */
@Service
@Transactional(readOnly = true)
public class ProductMedicalService extends CrudService<ProductMedicalDao, ProductMedical> {
	
	@Autowired
	private ProductMedicalDao productMedicalDao;

	public ProductMedical get(String id) {
		return super.get(id);
	}
	
	public List<ProductMedical> findList(ProductMedical productMedical) {
		return super.findList(productMedical);
	}
	
	public Page<ProductMedical> findPage(Page<ProductMedical> page, ProductMedical productMedical) {
		return super.findPage(page, productMedical);
	}
	
	@Transactional(readOnly = false)
	public void save(ProductMedical productMedical) {
		super.save(productMedical);
	}
	
	@Transactional(readOnly = false)
	public void delete(ProductMedical productMedical) {
		super.delete(productMedical);
	}

	/**
	 * 根据高济id获得商品详情数据
	 * 
	 * @param id
	 * @return
	 */
	public ProductMedical getproductMedicalByGaojiId(String id) {
		return productMedicalDao.getproductMedicalByGaojiId(id);
	}
	
}