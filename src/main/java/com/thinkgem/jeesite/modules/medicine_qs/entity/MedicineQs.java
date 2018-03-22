/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.medicine_qs.entity;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 商品安全质量信息表Entity
 * @author 董志强
 * @version 2018-03-08
 */
public class MedicineQs extends DataEntity<MedicineQs> {
	
	private static final long serialVersionUID = 1L;
	private Long gjId;		// 高济商品id
	private String industryStandard;		// 行业标准
	private Long nationalStandardCode;		// 国家本位码/追溯码
	private Long internationalBarCode;		// 国际条形码
	private Integer prescriptionLabel;		// 处方标示
	private Integer useDays;		// 使用期长（天）
	private Integer courseDays;		// 疗程（天）
	private Integer validityPeriod;		// 有效期（天）
	//附加字段
	private String gjName;
	
	
	public String getGjName() {
		return gjName;
	}

	public void setGjName(String gjName) {
		this.gjName = gjName;
	}

	public MedicineQs() {
		super();
	}

	public MedicineQs(String id){
		super(id);
	}

	@NotNull(message="高济商品id不能为空")
	public Long getGjId() {
		return gjId;
	}

	public void setGjId(Long gjId) {
		this.gjId = gjId;
	}
	
	@Length(min=1, max=100, message="行业标准长度必须介于 1 和 100 之间")
	public String getIndustryStandard() {
		return industryStandard;
	}

	public void setIndustryStandard(String industryStandard) {
		this.industryStandard = industryStandard;
	}
	
	@NotNull(message="国家本位码/追溯码不能为空")
	public Long getNationalStandardCode() {
		return nationalStandardCode;
	}

	public void setNationalStandardCode(Long nationalStandardCode) {
		this.nationalStandardCode = nationalStandardCode;
	}
	
	@NotNull(message="国际条形码不能为空")
	public Long getInternationalBarCode() {
		return internationalBarCode;
	}

	public void setInternationalBarCode(Long internationalBarCode) {
		this.internationalBarCode = internationalBarCode;
	}
	
	@NotNull(message="处方标示不能为空")
	public Integer getPrescriptionLabel() {
		return prescriptionLabel;
	}

	public void setPrescriptionLabel(Integer prescriptionLabel) {
		this.prescriptionLabel = prescriptionLabel;
	}
	
	@NotNull(message="使用期长（天）不能为空")
	public Integer getUseDays() {
		return useDays;
	}

	public void setUseDays(Integer useDays) {
		this.useDays = useDays;
	}
	
	@NotNull(message="疗程（天）不能为空")
	public Integer getCourseDays() {
		return courseDays;
	}

	public void setCourseDays(Integer courseDays) {
		this.courseDays = courseDays;
	}
	
	@NotNull(message="有效期（天）不能为空")
	public Integer getValidityPeriod() {
		return validityPeriod;
	}

	public void setValidityPeriod(Integer validityPeriod) {
		this.validityPeriod = validityPeriod;
	}
	
}