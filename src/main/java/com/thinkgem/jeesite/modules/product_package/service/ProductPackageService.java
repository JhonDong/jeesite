/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.product_package.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.product_package.entity.ProductPackage;
import com.thinkgem.jeesite.modules.product_package.dao.ProductPackageDao;

/**
 * 商品包装Service
 * @author 董志强
 * @version 2018-03-08
 */
@Service
@Transactional(readOnly = true)
public class ProductPackageService extends CrudService<ProductPackageDao, ProductPackage> {

	public ProductPackage get(String id) {
		return super.get(id);
	}
	
	public List<ProductPackage> findList(ProductPackage productPackage) {
		return super.findList(productPackage);
	}
	
	public Page<ProductPackage> findPage(Page<ProductPackage> page, ProductPackage productPackage) {
		return super.findPage(page, productPackage);
	}
	
	@Transactional(readOnly = false)
	public void save(ProductPackage productPackage) {
		super.save(productPackage);
	}
	
	@Transactional(readOnly = false)
	public void delete(ProductPackage productPackage) {
		super.delete(productPackage);
	}
	
}