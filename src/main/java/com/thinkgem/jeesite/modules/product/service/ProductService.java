/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.product.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.product.dao.ProductDao;
import com.thinkgem.jeesite.modules.product.entity.Product;

/**
 * 高济商品Service
 * @author 董志强
 * @version 2018-03-05
 */
@Service
@Transactional(readOnly = true)
public class ProductService extends CrudService<ProductDao, Product> {
	
	/**
	 * 持久层对象
	 */
	@Autowired
	private ProductDao productDao;
	
	public Product get(String id) {
		return super.get(id);
	}
	/**
	 * 模糊查詢
	 * @param name
	 * @return
	 */
	public List<Product> search(String name) {
		Product p=new Product();
		p.setName(name);
		return productDao.search(p);
	}
	
	public List<Product> findList(Product product) {
		return productDao.findList2(product);
	}
	
	public Page<Product> findPage(Page<Product> page, Product product) {
		return super.findPage(page, product);
	}
	
	//关联分页查询
	public Page<Product> findPage2(Page<Product> page, Product product) {
		product.setPage(page);
		page.setList(dao.findList2(product));
		return page;
	}
	
	
	@Transactional(readOnly = false)
	public void save(Product product) {
		super.save(product);
	}
	@Transactional(readOnly = false)
	public void delete(Product product) {
		super.delete(product);
	}
	
}