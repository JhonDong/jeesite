/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.product_factory.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.product_factory.entity.ProductFactory;
import com.thinkgem.jeesite.modules.product_factory.dao.ProductFactoryDao;

/**
 * 商品厂家模块Service
 * @author 董志强
 * @version 2018-03-07
 */
@Service
@Transactional(readOnly = true)
public class ProductFactoryService extends CrudService<ProductFactoryDao, ProductFactory> {

	public ProductFactory get(String id) {
		return super.get(id);
	}
	
	public List<ProductFactory> findList(ProductFactory productFactory) {
		return super.findList(productFactory);
	}
	
	public Page<ProductFactory> findPage(Page<ProductFactory> page, ProductFactory productFactory) {
		return super.findPage(page, productFactory);
	}
	
	@Transactional(readOnly = false)
	public void save(ProductFactory productFactory) {
		super.save(productFactory);
	}
	
	@Transactional(readOnly = false)
	public void delete(ProductFactory productFactory) {
		super.delete(productFactory);
	}
	
}