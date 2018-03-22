/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.medicine_sell.dao;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.medicine_sell.entity.MedicineSell;

/**
 * 商品销售DAO接口
 * @author 董志强
 * @version 2018-03-08
 */
@MyBatisDao
public interface MedicineSellDao extends CrudDao<MedicineSell> {
	
}