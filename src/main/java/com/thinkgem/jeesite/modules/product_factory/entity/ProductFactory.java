/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.product_factory.entity;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 商品厂家模块Entity
 * @author 董志强
 * @version 2018-03-07
 */
public class ProductFactory extends DataEntity<ProductFactory> {
	
	private static final long serialVersionUID = 1L;
	private Long gjId;		// 高济商品id
	private String code;		// 编码
	private String socialCreditCode;		// 社会信用代码/组织机构代码
	private String cateCode;		// 分类码
	private String province;		// 省市
	private String companyName;		// 生产企业名称
	private String legalManger;		// 法定代表人
	private String companyManger;		// 企业负责人
	private String qaManger;		// 质量负责人
	private String regAddress;		// 注册地址
	private String address;		// 生产地址
	private String productionRange;		// 生产范围
	private Date openingDate;		// 发证日期
	private Date indate;		// 有效期
	private String issuingAuthority;		// 发证机关
	private String signer;		// 签发人
	private String dailyRegulators;		// 日常监管机构
	private String dailySupervisor;		// 日常监管人员
	private String isDelete;		// 软删除，默认0，1已删除
	private String mark;		// 备注
	private String basis;		// 主要成分
	private String factoryLicenseNum;		// 生产厂家营业执照号
	private Date factoryLicenseIndate;		// 生产厂家营业执照有效期至
	private String manufacturersGroup;		// 厂家所属集团（中文）
	private String manufacturersGroupEn;		// 厂家所属集团（英文）
	private String manufacturersFactory;		// 生产厂家
	private String registeredTrademark;		// 注册商标（中文）
	private String registeredTrademarkEn;		// 注册商标（英文）
	private Date createTime;		// 创建时间
	private Date updateTime;		// 更新时间
	
	private String gjName; //冗余字段
	
	//附加字段
	public String getGjName() {
		return gjName;
	}

	public void setGjName(String gjName) {
		this.gjName = gjName;
	}

	
	public ProductFactory() {
		super();
	}

	public ProductFactory(String id){
		super(id);
	}

	@NotNull(message="高济商品id不能为空")
	public Long getGjId() {
		return gjId;
	}

	public void setGjId(Long gjId) {
		this.gjId = gjId;
	}
	
	@Length(min=1, max=50, message="编码长度必须介于 1 和 50 之间")
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	@Length(min=1, max=120, message="社会信用代码/组织机构代码长度必须介于 1 和 120 之间")
	public String getSocialCreditCode() {
		return socialCreditCode;
	}

	public void setSocialCreditCode(String socialCreditCode) {
		this.socialCreditCode = socialCreditCode;
	}
	
	@Length(min=1, max=40, message="分类码长度必须介于 1 和 40 之间")
	public String getCateCode() {
		return cateCode;
	}

	public void setCateCode(String cateCode) {
		this.cateCode = cateCode;
	}
	
	@Length(min=1, max=35, message="省市长度必须介于 1 和 35 之间")
	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}
	
	@Length(min=1, max=255, message="生产企业名称长度必须介于 1 和 255 之间")
	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	
	@Length(min=1, max=35, message="法定代表人长度必须介于 1 和 35 之间")
	public String getLegalManger() {
		return legalManger;
	}

	public void setLegalManger(String legalManger) {
		this.legalManger = legalManger;
	}
	
	@Length(min=1, max=255, message="企业负责人长度必须介于 1 和 255 之间")
	public String getCompanyManger() {
		return companyManger;
	}

	public void setCompanyManger(String companyManger) {
		this.companyManger = companyManger;
	}
	
	@Length(min=1, max=35, message="质量负责人长度必须介于 1 和 35 之间")
	public String getQaManger() {
		return qaManger;
	}

	public void setQaManger(String qaManger) {
		this.qaManger = qaManger;
	}
	
	@Length(min=1, max=255, message="注册地址长度必须介于 1 和 255 之间")
	public String getRegAddress() {
		return regAddress;
	}

	public void setRegAddress(String regAddress) {
		this.regAddress = regAddress;
	}
	
	@Length(min=1, max=255, message="生产地址长度必须介于 1 和 255 之间")
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	@Length(min=1, max=255, message="生产范围长度必须介于 1 和 255 之间")
	public String getProductionRange() {
		return productionRange;
	}

	public void setProductionRange(String productionRange) {
		this.productionRange = productionRange;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@NotNull(message="发证日期不能为空")
	public Date getOpeningDate() {
		return openingDate;
	}

	public void setOpeningDate(Date openingDate) {
		this.openingDate = openingDate;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@NotNull(message="有效期不能为空")
	public Date getIndate() {
		return indate;
	}

	public void setIndate(Date indate) {
		this.indate = indate;
	}
	
	@Length(min=1, max=120, message="发证机关长度必须介于 1 和 120 之间")
	public String getIssuingAuthority() {
		return issuingAuthority;
	}

	public void setIssuingAuthority(String issuingAuthority) {
		this.issuingAuthority = issuingAuthority;
	}
	
	@Length(min=1, max=50, message="签发人长度必须介于 1 和 50 之间")
	public String getSigner() {
		return signer;
	}

	public void setSigner(String signer) {
		this.signer = signer;
	}
	
	@Length(min=1, max=120, message="日常监管机构长度必须介于 1 和 120 之间")
	public String getDailyRegulators() {
		return dailyRegulators;
	}

	public void setDailyRegulators(String dailyRegulators) {
		this.dailyRegulators = dailyRegulators;
	}
	
	@Length(min=1, max=50, message="日常监管人员长度必须介于 1 和 50 之间")
	public String getDailySupervisor() {
		return dailySupervisor;
	}

	public void setDailySupervisor(String dailySupervisor) {
		this.dailySupervisor = dailySupervisor;
	}
	
	@Length(min=1, max=2, message="软删除，默认0，1已删除长度必须介于 1 和 2 之间")
	public String getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(String isDelete) {
		this.isDelete = isDelete;
	}
	
	@Length(min=0, max=255, message="备注长度必须介于 0 和 255 之间")
	public String getMark() {
		return mark;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}
	
	public String getBasis() {
		return basis;
	}

	public void setBasis(String basis) {
		this.basis = basis;
	}
	
	@Length(min=1, max=100, message="生产厂家营业执照号长度必须介于 1 和 100 之间")
	public String getFactoryLicenseNum() {
		return factoryLicenseNum;
	}

	public void setFactoryLicenseNum(String factoryLicenseNum) {
		this.factoryLicenseNum = factoryLicenseNum;
	}
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@NotNull(message="发证日期不能为空")
	public Date getFactoryLicenseIndate() {
		return factoryLicenseIndate;
	}

	public void setFactoryLicenseIndate(Date factoryLicenseIndate) {
		this.factoryLicenseIndate = factoryLicenseIndate;
	}
	
	@Length(min=1, max=80, message="厂家所属集团（中文）长度必须介于 1 和 80 之间")
	public String getManufacturersGroup() {
		return manufacturersGroup;
	}

	public void setManufacturersGroup(String manufacturersGroup) {
		this.manufacturersGroup = manufacturersGroup;
	}
	
	@Length(min=1, max=80, message="厂家所属集团（英文）长度必须介于 1 和 80 之间")
	public String getManufacturersGroupEn() {
		return manufacturersGroupEn;
	}

	public void setManufacturersGroupEn(String manufacturersGroupEn) {
		this.manufacturersGroupEn = manufacturersGroupEn;
	}
	
	@Length(min=1, max=255, message="生产厂家长度必须介于 1 和 255 之间")
	public String getManufacturersFactory() {
		return manufacturersFactory;
	}

	public void setManufacturersFactory(String manufacturersFactory) {
		this.manufacturersFactory = manufacturersFactory;
	}
	
	@Length(min=1, max=255, message="注册商标（中文）长度必须介于 1 和 255 之间")
	public String getRegisteredTrademark() {
		return registeredTrademark;
	}

	public void setRegisteredTrademark(String registeredTrademark) {
		this.registeredTrademark = registeredTrademark;
	}
	
	@Length(min=1, max=255, message="注册商标（英文）长度必须介于 1 和 255 之间")
	public String getRegisteredTrademarkEn() {
		return registeredTrademarkEn;
	}

	public void setRegisteredTrademarkEn(String registeredTrademarkEn) {
		this.registeredTrademarkEn = registeredTrademarkEn;
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
	
}