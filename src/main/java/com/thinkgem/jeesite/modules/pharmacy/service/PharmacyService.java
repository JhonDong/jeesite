/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.pharmacy.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.pharmacy.entity.Pharmacy;
import com.thinkgem.jeesite.modules.pharmacy.dao.PharmacyDao;

/**
 * 门户管理Service
 * @author 董志强
 * @version 2018-03-21
 */
@Service
@Transactional(readOnly = true)
public class PharmacyService extends CrudService<PharmacyDao, Pharmacy> {

	public Pharmacy get(String id) {
		return super.get(id);
	}
	
	public List<Pharmacy> findList(Pharmacy pharmacy) {
		return super.findList(pharmacy);
	}
	
	public Page<Pharmacy> findPage(Page<Pharmacy> page, Pharmacy pharmacy) {
		return super.findPage(page, pharmacy);
	}
	
	@Transactional(readOnly = false)
	public void save(Pharmacy pharmacy) {
		super.save(pharmacy);
	}
	
	@Transactional(readOnly = false)
	public void delete(Pharmacy pharmacy) {
		super.delete(pharmacy);
	}
	
}