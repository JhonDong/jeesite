/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.nc_pharmacy.dao;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.nc_pharmacy.entity.NcPharmacy;

/**
 * 门店映射DAO接口
 * @author 董志强
 * @version 2018-03-23
 */
@MyBatisDao
public interface NcPharmacyDao extends CrudDao<NcPharmacy> {
	
}