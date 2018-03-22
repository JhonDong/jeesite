/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.category.dao;

import com.thinkgem.jeesite.common.persistence.TreeDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.category.entity.GaojiCategory;

/**
 * 树结构生成DAO接口
 * @author 董志强
 * @version 2018-03-02
 */
@MyBatisDao
public interface GaojiCategoryDao extends TreeDao<GaojiCategory> {
	
}