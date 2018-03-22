/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.product_company.entity;

import javax.validation.constraints.NotNull;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 商品企业对照Entity
 * @author 董志强
 * @version 2018-03-19
 */
public class ProductCompany extends DataEntity<ProductCompany> {
	
	private static final long serialVersionUID = 1L;
	private Long gjId;		// 高济ID
	private Long dsId;		// 东升ID
	private Long hxId;		// 华杏ID
	private Long hysId;		// 好一生ID
	private Long rtId;		// 仁泰ID
	private Long kbxId;		// 康佰馨ID
	private String productName;//高济商品
	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public ProductCompany() {
		super();
	}

	public ProductCompany(String id){
		super(id);
	}

	@NotNull(message="高济ID不能为空")
	public Long getGjId() {
		return gjId;
	}

	public void setGjId(Long gjId) {
		this.gjId = gjId;
	}
	
	public Long getDsId() {
		return dsId;
	}

	public void setDsId(Long dsId) {
		this.dsId = dsId;
	}
	
	public Long getHxId() {
		return hxId;
	}

	public void setHxId(Long hxId) {
		this.hxId = hxId;
	}
	
	public Long getHysId() {
		return hysId;
	}

	public void setHysId(Long hysId) {
		this.hysId = hysId;
	}
	
	public Long getRtId() {
		return rtId;
	}

	public void setRtId(Long rtId) {
		this.rtId = rtId;
	}
	
	public Long getKbxId() {
		return kbxId;
	}

	public void setKbxId(Long kbxId) {
		this.kbxId = kbxId;
	}
	
}