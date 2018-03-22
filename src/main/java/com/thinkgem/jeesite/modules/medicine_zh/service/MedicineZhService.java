/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.medicine_zh.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.medicine_zh.entity.MedicineZh;
import com.thinkgem.jeesite.modules.medicine_zh.dao.MedicineZhDao;

/**
 * 中药信息表Service
 * @author 董志强
 * @version 2018-03-08
 */
@Service
@Transactional(readOnly = true)
public class MedicineZhService extends CrudService<MedicineZhDao, MedicineZh> {

	public MedicineZh get(String id) {
		return super.get(id);
	}
	
	public List<MedicineZh> findList(MedicineZh medicineZh) {
		return super.findList(medicineZh);
	}
	
	public Page<MedicineZh> findPage(Page<MedicineZh> page, MedicineZh medicineZh) {
		return super.findPage(page, medicineZh);
	}
	
	@Transactional(readOnly = false)
	public void save(MedicineZh medicineZh) {
		super.save(medicineZh);
	}
	
	@Transactional(readOnly = false)
	public void delete(MedicineZh medicineZh) {
		super.delete(medicineZh);
	}
	
}