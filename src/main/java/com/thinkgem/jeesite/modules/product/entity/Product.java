/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.product.entity;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 高济商品Entity
 * @author 董志强
 * @version 2018-03-05
 */
public class Product extends DataEntity<Product> {
	
	private static final long serialVersionUID = 1L;
	private String name;		// 通用名
	private String productName;		// 商品名
	private String productNameEn;		// 英文名
	private String specification;		// 规格
	private String dosage;		// 剂型
	private String approvalNumber;		// 批准文号
	private String barcode;		// 商品编码
	private String nationalStandardCode;		// 国家本位码
	private String unit;		// 单位
	private String productFactory;		// 生产厂家
	private String productAddress;		// 产地
	private String adaptationDisease;		// 适应症
	private String status;		// 商品状态
	private Date approvalDate;		// 批准日期
	private String marketingLevel;		// 营销级别
	private String model;		// 型号
	private String gj4thCid;		// 高济四级分类
	private String isDelete;		// 是否删除
	private Date createTime;		// 创建时间
	private Date updateTime;		// 更新时间
	private String mark;		// 预留备注字段
	
	//附加字段
	private String gj4thCidName;
	public String getGj4thCidName() {
		return gj4thCidName;
	}

	public void setGj4thCidName(String gj4thCidName) {
		this.gj4thCidName = gj4thCidName;
	}

	public Product() {
		super();
	}

	public Product(String id){
		super(id);
	}

	
	
	@Length(min=1, max=120, message="通用名长度必须介于 1 和 120 之间")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Length(min=1, max=120, message="商品名长度必须介于 1 和 120 之间")
	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	@Length(min=1, max=120, message="英文名长度必须介于 1 和 120 之间")
	public String getProductNameEn() {
		return productNameEn;
	}

	public void setProductNameEn(String productNameEn) {
		this.productNameEn = productNameEn;
	}
	
	@Length(min=1, max=50, message="规格长度必须介于 1 和 50 之间")
	public String getSpecification() {
		return specification;
	}

	public void setSpecification(String specification) {
		this.specification = specification;
	}
	
	@Length(min=1, max=30, message="剂型长度必须介于 1 和 30 之间")
	public String getDosage() {
		return dosage;
	}

	public void setDosage(String dosage) {
		this.dosage = dosage;
	}
	
	@Length(min=1, max=100, message="批准文号长度必须介于 1 和 100 之间")
	public String getApprovalNumber() {
		return approvalNumber;
	}

	public void setApprovalNumber(String approvalNumber) {
		this.approvalNumber = approvalNumber;
	}
	
	@Length(min=1, max=60, message="商品编码长度必须介于 1 和 60 之间")
	public String getBarcode() {
		return barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}
	
	@Length(min=1, max=80, message="国家本位码长度必须介于 1 和 80 之间")
	public String getNationalStandardCode() {
		return nationalStandardCode;
	}

	public void setNationalStandardCode(String nationalStandardCode) {
		this.nationalStandardCode = nationalStandardCode;
	}
	
	@Length(min=1, max=20, message="单位长度必须介于 1 和 20 之间")
	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}
	
	@Length(min=1, max=255, message="生产厂家长度必须介于 1 和 255 之间")
	public String getProductFactory() {
		return productFactory;
	}

	public void setProductFactory(String productFactory) {
		this.productFactory = productFactory;
	}
	
	@Length(min=1, max=155, message="产地长度必须介于 1 和 155 之间")
	public String getProductAddress() {
		return productAddress;
	}

	public void setProductAddress(String productAddress) {
		this.productAddress = productAddress;
	}
	
	public String getAdaptationDisease() {
		return adaptationDisease;
	}

	public void setAdaptationDisease(String adaptationDisease) {
		this.adaptationDisease = adaptationDisease;
	}
	
	@Length(min=1, max=2, message="商品状态长度必须介于 1 和 2 之间")
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@NotNull(message="批准日期不能为空")
	public Date getApprovalDate() {
		return approvalDate;
	}

	public void setApprovalDate(Date approvalDate) {
		this.approvalDate = approvalDate;
	}
	
	@Length(min=1, max=20, message="营销级别长度必须介于 1 和 20 之间")
	public String getMarketingLevel() {
		return marketingLevel;
	}

	public void setMarketingLevel(String marketingLevel) {
		this.marketingLevel = marketingLevel;
	}
	
	@Length(min=1, max=20, message="型号长度必须介于 1 和 20 之间")
	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}
	
	@Length(min=1, max=11, message="高济四级分类长度必须介于 1 和 11 之间")
	@NotNull(message="高济四级分类不能为空")
	public String getGj4thCid() {
		return gj4thCid;
	}

	public void setGj4thCid(String gj4thCid) {
		this.gj4thCid = gj4thCid;
	}
	
	@Length(min=1, max=2, message="是否删除长度必须介于 1 和 2 之间")
	@NotNull(message="是否删除不能为空")
	public String getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(String isDelete) {
		this.isDelete = isDelete;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	
	@Length(min=0, max=255, message="预留备注字段长度必须介于 0 和 255 之间")
	public String getMark() {
		return mark;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}
}