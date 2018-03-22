/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.medicine_qs.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.medicine_qs.entity.MedicineQs;
import com.thinkgem.jeesite.modules.medicine_qs.dao.MedicineQsDao;

/**
 * 商品安全质量信息表Service
 * @author 董志强
 * @version 2018-03-08
 */
@Service
@Transactional(readOnly = true)
public class MedicineQsService extends CrudService<MedicineQsDao, MedicineQs> {

	public MedicineQs get(String id) {
		return super.get(id);
	}
	
	public List<MedicineQs> findList(MedicineQs medicineQs) {
		return super.findList(medicineQs);
	}
	
	public Page<MedicineQs> findPage(Page<MedicineQs> page, MedicineQs medicineQs) {
		return super.findPage(page, medicineQs);
	}
	
	@Transactional(readOnly = false)
	public void save(MedicineQs medicineQs) {
		super.save(medicineQs);
	}
	
	@Transactional(readOnly = false)
	public void delete(MedicineQs medicineQs) {
		super.delete(medicineQs);
	}
	
}