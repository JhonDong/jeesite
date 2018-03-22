/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.drugs_enterprises_rename.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.drugs_enterprises_rename.entity.DrugsEnterprisesRename;
import com.thinkgem.jeesite.modules.drugs_enterprises_rename.dao.DrugsEnterprisesRenameDao;

/**
 * 药品生产企业Service
 * @author 董志强
 * @version 2018-03-12
 */
@Service
@Transactional(readOnly = true)
public class DrugsEnterprisesRenameService extends CrudService<DrugsEnterprisesRenameDao, DrugsEnterprisesRename> {

	public DrugsEnterprisesRename get(String id) {
		return super.get(id);
	}
	
	public List<DrugsEnterprisesRename> findList(DrugsEnterprisesRename drugsEnterprisesRename) {
		return super.findList(drugsEnterprisesRename);
	}
	
	public Page<DrugsEnterprisesRename> findPage(Page<DrugsEnterprisesRename> page, DrugsEnterprisesRename drugsEnterprisesRename) {
		return super.findPage(page, drugsEnterprisesRename);
	}
	
	@Transactional(readOnly = false)
	public void save(DrugsEnterprisesRename drugsEnterprisesRename) {
		super.save(drugsEnterprisesRename);
	}
	
	@Transactional(readOnly = false)
	public void delete(DrugsEnterprisesRename drugsEnterprisesRename) {
		super.delete(drugsEnterprisesRename);
	}
	
}