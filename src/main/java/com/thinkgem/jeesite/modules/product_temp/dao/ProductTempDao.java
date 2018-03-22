/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.product_temp.dao;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.product_temp.entity.ProductTemp;

/**
 * 数据字典DAO接口
 * @author 董志强
 * @version 2018-03-19
 */
@MyBatisDao
public interface ProductTempDao extends CrudDao<ProductTemp> {
	
}