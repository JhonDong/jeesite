/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.medicine_purchase.entity;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 商品采购Entity
 * @author 董志强
 * @version 2018-03-22
 */
public class MedicinePurchase extends DataEntity<MedicinePurchase> {
	
	private static final long serialVersionUID = 1L;
	private Long gjId;		// 高济商品id
	private String settlementMethod;		// 结算方式
	private String purchasingAttr;		// 采购属性
	private Long vmiMinNum;		// 铺底数量
	private String vmiMinMoney;		// 铺底金额（元）
	private String ownBrand;		// 是否自有品牌
	private String deliveryMethod;		// 配送方式
	private String returnsCode;		// 退货识别
	private String purchaserId;		// 采购员编号
	private String purchaserName;		// 采购员姓名
	private String taxControlCode;		// 税控编码
	private Double taxRate;		// 税率
	private String supplierCode;		// 供应商编码
	private String supplierName;		// 供应商名称
	private Date createTime;		// create_time
	private Date updateTime;		// update_time
	
	public MedicinePurchase() {
		super();
	}

	public MedicinePurchase(String id){
		super(id);
	}

	@NotNull(message="高济商品id不能为空")
	public Long getGjId() {
		return gjId;
	}

	public void setGjId(Long gjId) {
		this.gjId = gjId;
	}
	
	@Length(min=1, max=2, message="结算方式长度必须介于 1 和 2 之间")
	public String getSettlementMethod() {
		return settlementMethod;
	}

	public void setSettlementMethod(String settlementMethod) {
		this.settlementMethod = settlementMethod;
	}
	
	@Length(min=1, max=20, message="采购属性长度必须介于 1 和 20 之间")
	public String getPurchasingAttr() {
		return purchasingAttr;
	}

	public void setPurchasingAttr(String purchasingAttr) {
		this.purchasingAttr = purchasingAttr;
	}
	
	@NotNull(message="铺底数量不能为空")
	public Long getVmiMinNum() {
		return vmiMinNum;
	}

	public void setVmiMinNum(Long vmiMinNum) {
		this.vmiMinNum = vmiMinNum;
	}
	
	public String getVmiMinMoney() {
		return vmiMinMoney;
	}

	public void setVmiMinMoney(String vmiMinMoney) {
		this.vmiMinMoney = vmiMinMoney;
	}
	
	@Length(min=1, max=2, message="是否自有品牌长度必须介于 1 和 2 之间")
	public String getOwnBrand() {
		return ownBrand;
	}

	public void setOwnBrand(String ownBrand) {
		this.ownBrand = ownBrand;
	}
	
	@Length(min=1, max=2, message="配送方式长度必须介于 1 和 2 之间")
	public String getDeliveryMethod() {
		return deliveryMethod;
	}

	public void setDeliveryMethod(String deliveryMethod) {
		this.deliveryMethod = deliveryMethod;
	}
	
	@Length(min=1, max=35, message="退货识别长度必须介于 1 和 35 之间")
	public String getReturnsCode() {
		return returnsCode;
	}

	public void setReturnsCode(String returnsCode) {
		this.returnsCode = returnsCode;
	}
	
	@Length(min=1, max=40, message="采购员编号长度必须介于 1 和 40 之间")
	public String getPurchaserId() {
		return purchaserId;
	}

	public void setPurchaserId(String purchaserId) {
		this.purchaserId = purchaserId;
	}
	
	@Length(min=1, max=60, message="采购员姓名长度必须介于 1 和 60 之间")
	public String getPurchaserName() {
		return purchaserName;
	}

	public void setPurchaserName(String purchaserName) {
		this.purchaserName = purchaserName;
	}
	
	@Length(min=1, max=60, message="税控编码长度必须介于 1 和 60 之间")
	public String getTaxControlCode() {
		return taxControlCode;
	}

	public void setTaxControlCode(String taxControlCode) {
		this.taxControlCode = taxControlCode;
	}
	
	@NotNull(message="税率不能为空")
	public Double getTaxRate() {
		return taxRate;
	}

	public void setTaxRate(Double taxRate) {
		this.taxRate = taxRate;
	}
	
	@Length(min=1, max=40, message="供应商编码长度必须介于 1 和 40 之间")
	public String getSupplierCode() {
		return supplierCode;
	}

	public void setSupplierCode(String supplierCode) {
		this.supplierCode = supplierCode;
	}
	
	@Length(min=1, max=255, message="供应商名称长度必须介于 1 和 255 之间")
	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@NotNull(message="create_time不能为空")
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@NotNull(message="update_time不能为空")
	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	
}