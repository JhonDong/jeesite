/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.medicine_sell.entity;

import javax.validation.constraints.NotNull;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 商品销售Entity
 * 
 * @author 董志强
 * @version 2018-03-08
 */
public class MedicineSell extends DataEntity<MedicineSell> {

	private static final long serialVersionUID = 1L;
	private Long gjId; // 高济商品id
	private Double suggestedRetailPrice; // 外包装建议零售价（元）
	private Double procurementPrice; // 采购价格（元）
	private Double retailPrice; // 零售价（元）
	private Double memberPrice; // 会员价（元）
	private Date createTime; // create_time
	private Date updateTime; // update_time
	// 附加字段
	private String gjName;

	public String getGjName() {
		return gjName;
	}

	public void setGjName(String gjName) {
		this.gjName = gjName;
	}

	public MedicineSell() {
		super();
	}

	public MedicineSell(String id) {
		super(id);
	}

	@NotNull(message = "高济商品id不能为空")
	public Long getGjId() {
		return gjId;
	}

	public void setGjId(Long gjId) {
		this.gjId = gjId;
	}
	@NotNull(message = "外包装建议零售价（元）不能为空")
	public Double getSuggestedRetailPrice() {
		return suggestedRetailPrice;
	}

	public void setSuggestedRetailPrice(Double suggestedRetailPrice) {
		this.suggestedRetailPrice = suggestedRetailPrice;
	}

	@NotNull(message = "采购价格（元）不能为空")
	public Double getProcurementPrice() {
		return procurementPrice;
	}

	public void setProcurementPrice(Double procurementPrice) {
		this.procurementPrice = procurementPrice;
	}

	@NotNull(message = "零售价（元）不能为空")
	public Double getRetailPrice() {
		return retailPrice;
	}

	public void setRetailPrice(Double retailPrice) {
		this.retailPrice = retailPrice;
	}

	@NotNull(message = "会员价（元）不能为空")
	public Double getMemberPrice() {
		return memberPrice;
	}

	public void setMemberPrice(Double memberPrice) {
		this.memberPrice = memberPrice;
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