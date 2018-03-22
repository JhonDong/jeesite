/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.medicine_sell.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.medicine_sell.entity.MedicineSell;
import com.thinkgem.jeesite.modules.medicine_sell.dao.MedicineSellDao;

/**
 * 商品销售Service
 * @author 董志强
 * @version 2018-03-08
 */
@Service
@Transactional(readOnly = true)
public class MedicineSellService extends CrudService<MedicineSellDao, MedicineSell> {

	public MedicineSell get(String id) {
		return super.get(id);
	}
	
	public List<MedicineSell> findList(MedicineSell medicineSell) {
		return super.findList(medicineSell);
	}
	
	public Page<MedicineSell> findPage(Page<MedicineSell> page, MedicineSell medicineSell) {
		return super.findPage(page, medicineSell);
	}
	
	@Transactional(readOnly = false)
	public void save(MedicineSell medicineSell) {
		super.save(medicineSell);
	}
	
	@Transactional(readOnly = false)
	public void delete(MedicineSell medicineSell) {
		super.delete(medicineSell);
	}
	
}