/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.product_medical.entity;

import javax.validation.constraints.NotNull;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 医疗详情Entity
 * 
 * @author 董志强
 * @version 2018-03-05
 */
public class ProductMedical extends DataEntity<ProductMedical> {

	private static final long serialVersionUID = 1L;
	private Long gjId; // 高济商品id
	private String isSpecialExternalUse; // 是否外用商品
	private String isSpecialStimulant; // 是否兴奋剂
	private String isSpecialPsychotropicDrugs; // 是否精神类药物
	private String isSpecialMedicalInstruments; // 是否三类医疗器械
	private String isSpecialEfedrina; // 是否麻黄碱
	private String isBaseDrugList; // 是否基药目录
	private String isMedicalInsurance; // 是否医保目录
	private Date createTime; // 创建时间
	private Date updateTime; // 更新时间

	private String gjName; // 冗余字段

	// 附加字段
	public String getGjName() {
		return gjName;
	}

	public void setGjName(String gjName) {
		this.gjName = gjName;
	}

	public ProductMedical() {
		super();
	}

	public ProductMedical(String id) {
		super(id);
	}

	@NotNull(message = "高济商品id不能为空")
	public Long getGjId() {
		return gjId;
	}

	public void setGjId(Long gjId) {
		this.gjId = gjId;
	}

	public String getIsSpecialExternalUse() {
		return isSpecialExternalUse;
	}

	public void setIsSpecialExternalUse(String isSpecialExternalUse) {
		this.isSpecialExternalUse = isSpecialExternalUse;
	}

	public String getIsSpecialStimulant() {
		return isSpecialStimulant;
	}

	public void setIsSpecialStimulant(String isSpecialStimulant) {
		this.isSpecialStimulant = isSpecialStimulant;
	}

	public String getIsSpecialPsychotropicDrugs() {
		return isSpecialPsychotropicDrugs;
	}

	public void setIsSpecialPsychotropicDrugs(String isSpecialPsychotropicDrugs) {
		this.isSpecialPsychotropicDrugs = isSpecialPsychotropicDrugs;
	}

	public String getIsSpecialMedicalInstruments() {
		return isSpecialMedicalInstruments;
	}

	public void setIsSpecialMedicalInstruments(String isSpecialMedicalInstruments) {
		this.isSpecialMedicalInstruments = isSpecialMedicalInstruments;
	}

	public String getIsSpecialEfedrina() {
		return isSpecialEfedrina;
	}

	public void setIsSpecialEfedrina(String isSpecialEfedrina) {
		this.isSpecialEfedrina = isSpecialEfedrina;
	}

	public String getIsBaseDrugList() {
		return isBaseDrugList;
	}

	public void setIsBaseDrugList(String isBaseDrugList) {
		this.isBaseDrugList = isBaseDrugList;
	}

	public String getIsMedicalInsurance() {
		return isMedicalInsurance;
	}

	public void setIsMedicalInsurance(String isMedicalInsurance) {
		this.isMedicalInsurance = isMedicalInsurance;
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