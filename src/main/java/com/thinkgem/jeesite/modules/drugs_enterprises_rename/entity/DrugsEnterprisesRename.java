/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.drugs_enterprises_rename.entity;

import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 药品生产企业Entity
 * @author 董志强
 * @version 2018-03-12
 */
public class DrugsEnterprisesRename extends DataEntity<DrugsEnterprisesRename> {
	
	private static final long serialVersionUID = 1L;
	private String title;		// 厂家名
	private String description;		// 描述
	private String mId;		// 商品编码
	private String status;		// 状态
	private String serialNumber;		// 编号
	private String socialCreditCode;		// 社会信用代码
	private String classificationCode;		// 分类码
	private String provinceCity;		// 省市
	private String firmName;		// 企业名称
	private String legalRepresentative;		// 法定代表人
	private String responsiblePersons;		// 企业负责人
	private String qualityDirecter;		// 质量负责人
	private String registeredAddress;		// 注册地址
	private String productionAddress;		// 生产地址
	private String productionRange;		// 生产范围
	private String dateOfExpiry;		// 有效期至
	private String licenceIssuingAuthority;		// 发证机关
	private String signer;		// 签发人
	private String dailyOrganization;		// 日常监管机构
	private String dailyPeople;		// 日常监管人员
	private String reportTelphone;		// 监督举报电话
	private String certificate;		// 发证日期
	
	public DrugsEnterprisesRename() {
		super();
	}

	public DrugsEnterprisesRename(String id){
		super(id);
	}

	@Length(min=0, max=1000, message="厂家名长度必须介于 0 和 1000 之间")
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	@Length(min=0, max=1000, message="描述长度必须介于 0 和 1000 之间")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	@Length(min=0, max=11, message="商品编码长度必须介于 0 和 11 之间")
	public String getMId() {
		return mId;
	}

	public void setMId(String mId) {
		this.mId = mId;
	}
	
	@Length(min=0, max=11, message="状态长度必须介于 0 和 11 之间")
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	@Length(min=0, max=255, message="编号长度必须介于 0 和 255 之间")
	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}
	
	@Length(min=0, max=255, message="社会信用代码长度必须介于 0 和 255 之间")
	public String getSocialCreditCode() {
		return socialCreditCode;
	}

	public void setSocialCreditCode(String socialCreditCode) {
		this.socialCreditCode = socialCreditCode;
	}
	
	@Length(min=0, max=255, message="分类码长度必须介于 0 和 255 之间")
	public String getClassificationCode() {
		return classificationCode;
	}

	public void setClassificationCode(String classificationCode) {
		this.classificationCode = classificationCode;
	}
	
	@Length(min=0, max=255, message="省市长度必须介于 0 和 255 之间")
	public String getProvinceCity() {
		return provinceCity;
	}

	public void setProvinceCity(String provinceCity) {
		this.provinceCity = provinceCity;
	}
	
	@Length(min=0, max=255, message="企业名称长度必须介于 0 和 255 之间")
	public String getFirmName() {
		return firmName;
	}

	public void setFirmName(String firmName) {
		this.firmName = firmName;
	}
	
	@Length(min=0, max=255, message="法定代表人长度必须介于 0 和 255 之间")
	public String getLegalRepresentative() {
		return legalRepresentative;
	}

	public void setLegalRepresentative(String legalRepresentative) {
		this.legalRepresentative = legalRepresentative;
	}
	
	@Length(min=0, max=255, message="企业负责人长度必须介于 0 和 255 之间")
	public String getResponsiblePersons() {
		return responsiblePersons;
	}

	public void setResponsiblePersons(String responsiblePersons) {
		this.responsiblePersons = responsiblePersons;
	}
	
	@Length(min=0, max=255, message="质量负责人长度必须介于 0 和 255 之间")
	public String getQualityDirecter() {
		return qualityDirecter;
	}

	public void setQualityDirecter(String qualityDirecter) {
		this.qualityDirecter = qualityDirecter;
	}
	
	@Length(min=0, max=255, message="注册地址长度必须介于 0 和 255 之间")
	public String getRegisteredAddress() {
		return registeredAddress;
	}

	public void setRegisteredAddress(String registeredAddress) {
		this.registeredAddress = registeredAddress;
	}
	
	@Length(min=0, max=255, message="生产地址长度必须介于 0 和 255 之间")
	public String getProductionAddress() {
		return productionAddress;
	}

	public void setProductionAddress(String productionAddress) {
		this.productionAddress = productionAddress;
	}
	
	@Length(min=0, max=255, message="生产范围长度必须介于 0 和 255 之间")
	public String getProductionRange() {
		return productionRange;
	}

	public void setProductionRange(String productionRange) {
		this.productionRange = productionRange;
	}
	
	@Length(min=0, max=255, message="有效期至长度必须介于 0 和 255 之间")
	public String getDateOfExpiry() {
		return dateOfExpiry;
	}

	public void setDateOfExpiry(String dateOfExpiry) {
		this.dateOfExpiry = dateOfExpiry;
	}
	
	@Length(min=0, max=255, message="发证机关长度必须介于 0 和 255 之间")
	public String getLicenceIssuingAuthority() {
		return licenceIssuingAuthority;
	}

	public void setLicenceIssuingAuthority(String licenceIssuingAuthority) {
		this.licenceIssuingAuthority = licenceIssuingAuthority;
	}
	
	@Length(min=0, max=255, message="签发人长度必须介于 0 和 255 之间")
	public String getSigner() {
		return signer;
	}

	public void setSigner(String signer) {
		this.signer = signer;
	}
	
	@Length(min=0, max=255, message="日常监管机构长度必须介于 0 和 255 之间")
	public String getDailyOrganization() {
		return dailyOrganization;
	}

	public void setDailyOrganization(String dailyOrganization) {
		this.dailyOrganization = dailyOrganization;
	}
	
	@Length(min=0, max=255, message="日常监管人员长度必须介于 0 和 255 之间")
	public String getDailyPeople() {
		return dailyPeople;
	}

	public void setDailyPeople(String dailyPeople) {
		this.dailyPeople = dailyPeople;
	}
	
	@Length(min=0, max=255, message="监督举报电话长度必须介于 0 和 255 之间")
	public String getReportTelphone() {
		return reportTelphone;
	}

	public void setReportTelphone(String reportTelphone) {
		this.reportTelphone = reportTelphone;
	}
	
	@Length(min=0, max=1000, message="发证日期长度必须介于 0 和 1000 之间")
	public String getCertificate() {
		return certificate;
	}

	public void setCertificate(String certificate) {
		this.certificate = certificate;
	}
	
}