/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.medicine_purchase.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.medicine_purchase.entity.MedicinePurchase;
import com.thinkgem.jeesite.modules.medicine_purchase.dao.MedicinePurchaseDao;

/**
 * 商品采购Service
 * @author 董志强
 * @version 2018-03-08
 */
@Service
@Transactional(readOnly = true)
public class MedicinePurchaseService extends CrudService<MedicinePurchaseDao, MedicinePurchase> {

	public MedicinePurchase get(String id) {
		return super.get(id);
	}
	
	public List<MedicinePurchase> findList(MedicinePurchase medicinePurchase) {
		return super.findList(medicinePurchase);
	}
	
	public Page<MedicinePurchase> findPage(Page<MedicinePurchase> page, MedicinePurchase medicinePurchase) {
		return super.findPage(page, medicinePurchase);
	}
	
	@Transactional(readOnly = false)
	public void save(MedicinePurchase medicinePurchase) {
		super.save(medicinePurchase);
	}
	
	@Transactional(readOnly = false)
	public void delete(MedicinePurchase medicinePurchase) {
		super.delete(medicinePurchase);
	}
	
}