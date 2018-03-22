/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.medicine_qs.dao;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.medicine_qs.entity.MedicineQs;

/**
 * 商品安全质量信息表DAO接口
 * @author 董志强
 * @version 2018-03-08
 */
@MyBatisDao
public interface MedicineQsDao extends CrudDao<MedicineQs> {
	
}