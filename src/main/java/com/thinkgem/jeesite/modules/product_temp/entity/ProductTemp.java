/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.product_temp.entity;

import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 数据字典Entity
 * @author 董志强
 * @version 2018-03-19
 */
public class ProductTemp extends DataEntity<ProductTemp> {
	
	private static final long serialVersionUID = 1L;
	private String approvalNumber;		// 批准文号
	private String productName;		// 产品名称
	private String productNameEn;		// 英文名称
	private String commodityName;		// 商品名
	private String commodityNameEn;		// 英文名称
	private String dosage;		// 剂型
	private String specification;		// 规格
	private String manufacturer;		// 生产单位名称
	private String manufacturerEn;		// 生产单位英文名
	private String manufacturingAddress;		// 生产地址
	private String manufacturingAddressEn;		// 产地英文
	private String medType;		// 药品类别
	private String verifyDate;		// 批准日期
	private String validDate;		// 有效期截止
	private String oldApprovalNumber;		// 原批准文号
	private String medCode;		// 药品本位码
	private String medCodeMark;		// 药品本位码
	private String updateTime;		// 更新时间
	private String createTime;		// 创建时间
	private String productType;		// 产品类别：0国产药1进口药
	private String internationalBarCode;		// 国际条形码
	
	public ProductTemp() {
		super();
	}

	public ProductTemp(String id){
		super(id);
	}

	@Length(min=1, max=80, message="批准文号长度必须介于 1 和 80 之间")
	public String getApprovalNumber() {
		return approvalNumber;
	}

	public void setApprovalNumber(String approvalNumber) {
		this.approvalNumber = approvalNumber;
	}
	
	@Length(min=1, max=120, message="产品名称长度必须介于 1 和 120 之间")
	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	@Length(min=1, max=225, message="英文名称长度必须介于 1 和 225 之间")
	public String getProductNameEn() {
		return productNameEn;
	}

	public void setProductNameEn(String productNameEn) {
		this.productNameEn = productNameEn;
	}
	
	@Length(min=1, max=120, message="商品名长度必须介于 1 和 120 之间")
	public String getCommodityName() {
		return commodityName;
	}

	public void setCommodityName(String commodityName) {
		this.commodityName = commodityName;
	}
	
	@Length(min=1, max=120, message="英文名称长度必须介于 1 和 120 之间")
	public String getCommodityNameEn() {
		return commodityNameEn;
	}

	public void setCommodityNameEn(String commodityNameEn) {
		this.commodityNameEn = commodityNameEn;
	}
	
	@Length(min=1, max=30, message="剂型长度必须介于 1 和 30 之间")
	public String getDosage() {
		return dosage;
	}

	public void setDosage(String dosage) {
		this.dosage = dosage;
	}
	
	@Length(min=1, max=60, message="规格长度必须介于 1 和 60 之间")
	public String getSpecification() {
		return specification;
	}

	public void setSpecification(String specification) {
		this.specification = specification;
	}
	
	@Length(min=1, max=150, message="生产单位名称长度必须介于 1 和 150 之间")
	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	
	@Length(min=1, max=150, message="生产单位英文名长度必须介于 1 和 150 之间")
	public String getManufacturerEn() {
		return manufacturerEn;
	}

	public void setManufacturerEn(String manufacturerEn) {
		this.manufacturerEn = manufacturerEn;
	}
	
	@Length(min=1, max=150, message="生产地址长度必须介于 1 和 150 之间")
	public String getManufacturingAddress() {
		return manufacturingAddress;
	}

	public void setManufacturingAddress(String manufacturingAddress) {
		this.manufacturingAddress = manufacturingAddress;
	}
	
	@Length(min=1, max=150, message="产地英文长度必须介于 1 和 150 之间")
	public String getManufacturingAddressEn() {
		return manufacturingAddressEn;
	}

	public void setManufacturingAddressEn(String manufacturingAddressEn) {
		this.manufacturingAddressEn = manufacturingAddressEn;
	}
	
	@Length(min=1, max=50, message="药品类别长度必须介于 1 和 50 之间")
	public String getMedType() {
		return medType;
	}

	public void setMedType(String medType) {
		this.medType = medType;
	}
	
	public String getVerifyDate() {
		return verifyDate;
	}

	public void setVerifyDate(String verifyDate) {
		this.verifyDate = verifyDate;
	}
	
	public String getValidDate() {
		return validDate;
	}

	public void setValidDate(String validDate) {
		this.validDate = validDate;
	}
	
	@Length(min=1, max=80, message="原批准文号长度必须介于 1 和 80 之间")
	public String getOldApprovalNumber() {
		return oldApprovalNumber;
	}

	public void setOldApprovalNumber(String oldApprovalNumber) {
		this.oldApprovalNumber = oldApprovalNumber;
	}
	
	@Length(min=1, max=80, message="药品本位码长度必须介于 1 和 80 之间")
	public String getMedCode() {
		return medCode;
	}

	public void setMedCode(String medCode) {
		this.medCode = medCode;
	}
	
	@Length(min=1, max=255, message="药品本位码长度必须介于 1 和 255 之间")
	public String getMedCodeMark() {
		return medCodeMark;
	}

	public void setMedCodeMark(String medCodeMark) {
		this.medCodeMark = medCodeMark;
	}
	
	@Length(min=1, max=11, message="更新时间长度必须介于 1 和 11 之间")
	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}
	
	@Length(min=1, max=11, message="创建时间长度必须介于 1 和 11 之间")
	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	
	@Length(min=1, max=2, message="产品类别：0国产药1进口药长度必须介于 1 和 2 之间")
	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}
	
	@Length(min=1, max=80, message="国际条形码长度必须介于 1 和 80 之间")
	public String getInternationalBarCode() {
		return internationalBarCode;
	}

	public void setInternationalBarCode(String internationalBarCode) {
		this.internationalBarCode = internationalBarCode;
	}
	
}