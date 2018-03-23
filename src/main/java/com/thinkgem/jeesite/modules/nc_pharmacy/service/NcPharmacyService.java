/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.nc_pharmacy.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.nc_pharmacy.entity.NcPharmacy;
import com.thinkgem.jeesite.modules.nc_pharmacy.dao.NcPharmacyDao;

/**
 * 门店映射Service
 * @author 董志强
 * @version 2018-03-23
 */
@Service
@Transactional(readOnly = true)
public class NcPharmacyService extends CrudService<NcPharmacyDao, NcPharmacy> {

	public NcPharmacy get(String id) {
		return super.get(id);
	}
	
	public List<NcPharmacy> findList(NcPharmacy ncPharmacy) {
		return super.findList(ncPharmacy);
	}
	
	public Page<NcPharmacy> findPage(Page<NcPharmacy> page, NcPharmacy ncPharmacy) {
		return super.findPage(page, ncPharmacy);
	}
	
	@Transactional(readOnly = false)
	public void save(NcPharmacy ncPharmacy) {
		super.save(ncPharmacy);
	}
	
	@Transactional(readOnly = false)
	public void delete(NcPharmacy ncPharmacy) {
		super.delete(ncPharmacy);
	}
	
}