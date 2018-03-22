/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.medicine_purchase.dao;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.medicine_purchase.entity.MedicinePurchase;

/**
 * 商品采购DAO接口
 * @author 董志强
 * @version 2018-03-08
 */
@MyBatisDao
public interface MedicinePurchaseDao extends CrudDao<MedicinePurchase> {
	
}