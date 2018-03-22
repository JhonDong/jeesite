/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.product_medical.dao;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.product_medical.entity.ProductMedical;

/**
 * 医疗详情DAO接口
 * @author 董志强
 * @version 2018-03-05
 */
@MyBatisDao
public interface ProductMedicalDao extends CrudDao<ProductMedical> {

	/**
	 * 根据高济Id获得商品详情
	 * @param id
	 * @return
	 */
	ProductMedical getproductMedicalByGaojiId(String id);
	
}