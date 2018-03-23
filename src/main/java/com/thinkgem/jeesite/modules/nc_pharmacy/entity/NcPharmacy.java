/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.nc_pharmacy.entity;

import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 门店映射Entity
 * @author 董志强
 * @version 2018-03-23
 */
public class NcPharmacy extends DataEntity<NcPharmacy> {
	
	private static final long serialVersionUID = 1L;
	private String ncId;		// NCID
	private String pharmacyId;		// 企业门店id
	private String pharmacyName;		// 门店名称
	private String corpName;		// 企业名
	
	public NcPharmacy() {
		super();
	}

	public NcPharmacy(String id){
		super(id);
	}

	@Length(min=1, max=20, message="NCID长度必须介于 1 和 20 之间")
	public String getNcId() {
		return ncId;
	}

	public void setNcId(String ncId) {
		this.ncId = ncId;
	}
	
	@Length(min=1, max=20, message="企业门店id长度必须介于 1 和 20 之间")
	public String getPharmacyId() {
		return pharmacyId;
	}

	public void setPharmacyId(String pharmacyId) {
		this.pharmacyId = pharmacyId;
	}
	
	@Length(min=1, max=80, message="门店名称长度必须介于 1 和 80 之间")
	public String getPharmacyName() {
		return pharmacyName;
	}

	public void setPharmacyName(String pharmacyName) {
		this.pharmacyName = pharmacyName;
	}
	
	@Length(min=1, max=20, message="企业名长度必须介于 1 和 20 之间")
	public String getCorpName() {
		return corpName;
	}

	public void setCorpName(String corpName) {
		this.corpName = corpName;
	}
	
}