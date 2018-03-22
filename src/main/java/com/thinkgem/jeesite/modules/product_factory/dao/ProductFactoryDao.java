/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.product_factory.dao;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.product_factory.entity.ProductFactory;

/**
 * 商品厂家模块DAO接口
 * @author 董志强
 * @version 2018-03-07
 */
@MyBatisDao
public interface ProductFactoryDao extends CrudDao<ProductFactory> {
	
}