/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.product.dao;

import java.util.List;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.product.entity.Product;

/**
 * 高济商品DAO接口
 * 
 * @author 董志强
 * @version 2018-03-05
 */
@MyBatisDao
public interface ProductDao extends CrudDao<Product> {

	// 根据商品名模糊查询
	public List<Product> search(Product name);

	// 联合查询
	public List<Product> findList2(Product entity);

}