/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.medicine_zh.entity;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 中药信息表Entity
 * 
 * @author 董志强
 * @version 2018-03-08
 */
public class MedicineZh extends DataEntity<MedicineZh> {

	private static final long serialVersionUID = 1L;
	private Long gjId; // 高济商品id
	private String zhMedicineQs; // 中药质量标准依据
	private String zhMedicineCm; // 中药制法
	private String zhMedicineSite; // 中药药用部位
	private Integer zhMedicineQuantity; // 中药饮片包装量
	private String zhMedicineStandardName; // 中药饮片国家标准品名
	private String packagingType; // 包装类型
	private String tabletType; // 片型
	private String isSpecialToxicTablets; // 是否毒性饮片
	private String isFreshZhMedicine; // 是否鲜品中药
	private String compatibilityTabooVarieties; // 配伍禁忌品种
	private String isZhControlMedicine; // 是否国家管控中药
	private String medicineFoodHomology; // 是否药食同源
	private String isNewResourcesFood; // 是否新资源食品

	// 附加字段
	private String gjName;

	public String getGjName() {
		return gjName;
	}

	public void setGjName(String gjName) {
		this.gjName = gjName;
	}

	public MedicineZh() {
		super();
	}

	public MedicineZh(String id) {
		super(id);
	}

	@NotNull(message = "高济商品id不能为空")
	public Long getGjId() {
		return gjId;
	}

	public void setGjId(Long gjId) {
		this.gjId = gjId;
	}

	@Length(min = 1, max = 60, message = "中药质量标准依据长度必须介于 1 和 60 之间")
	public String getZhMedicineQs() {
		return zhMedicineQs;
	}

	public void setZhMedicineQs(String zhMedicineQs) {
		this.zhMedicineQs = zhMedicineQs;
	}

	@Length(min = 1, max = 255, message = "中药制法长度必须介于 1 和 255 之间")
	public String getZhMedicineCm() {
		return zhMedicineCm;
	}

	public void setZhMedicineCm(String zhMedicineCm) {
		this.zhMedicineCm = zhMedicineCm;
	}

	@Length(min = 1, max = 255, message = "中药药用部位长度必须介于 1 和 255 之间")
	public String getZhMedicineSite() {
		return zhMedicineSite;
	}

	public void setZhMedicineSite(String zhMedicineSite) {
		this.zhMedicineSite = zhMedicineSite;
	}

	@NotNull(message = "中药饮片包装量不能为空")
	public Integer getZhMedicineQuantity() {
		return zhMedicineQuantity;
	}

	public void setZhMedicineQuantity(Integer zhMedicineQuantity) {
		this.zhMedicineQuantity = zhMedicineQuantity;
	}

	@Length(min = 1, max = 120, message = "中药饮片国家标准品名长度必须介于 1 和 120 之间")
	public String getZhMedicineStandardName() {
		return zhMedicineStandardName;
	}

	public void setZhMedicineStandardName(String zhMedicineStandardName) {
		this.zhMedicineStandardName = zhMedicineStandardName;
	}

	@Length(min = 1, max = 30, message = "包装类型长度必须介于 1 和 30 之间")
	public String getPackagingType() {
		return packagingType;
	}

	public void setPackagingType(String packagingType) {
		this.packagingType = packagingType;
	}

	@Length(min = 1, max = 20, message = "片型长度必须介于 1 和 20 之间")
	public String getTabletType() {
		return tabletType;
	}

	public void setTabletType(String tabletType) {
		this.tabletType = tabletType;
	}

	@Length(min = 1, max = 2, message = "是否毒性饮片长度必须介于 1 和 2 之间")
	public String getIsSpecialToxicTablets() {
		return isSpecialToxicTablets;
	}

	public void setIsSpecialToxicTablets(String isSpecialToxicTablets) {
		this.isSpecialToxicTablets = isSpecialToxicTablets;
	}

	@Length(min = 1, max = 2, message = "是否鲜品中药长度必须介于 1 和 2 之间")
	public String getIsFreshZhMedicine() {
		return isFreshZhMedicine;
	}

	public void setIsFreshZhMedicine(String isFreshZhMedicine) {
		this.isFreshZhMedicine = isFreshZhMedicine;
	}

	@Length(min = 1, max = 255, message = "配伍禁忌品种长度必须介于 1 和 255 之间")
	public String getCompatibilityTabooVarieties() {
		return compatibilityTabooVarieties;
	}

	public void setCompatibilityTabooVarieties(String compatibilityTabooVarieties) {
		this.compatibilityTabooVarieties = compatibilityTabooVarieties;
	}

	@Length(min = 1, max = 2, message = "是否国家管控中药长度必须介于 1 和 2 之间")
	public String getIsZhControlMedicine() {
		return isZhControlMedicine;
	}

	public void setIsZhControlMedicine(String isZhControlMedicine) {
		this.isZhControlMedicine = isZhControlMedicine;
	}

	@Length(min = 1, max = 2, message = "是否药食同源长度必须介于 1 和 2 之间")
	public String getMedicineFoodHomology() {
		return medicineFoodHomology;
	}

	public void setMedicineFoodHomology(String medicineFoodHomology) {
		this.medicineFoodHomology = medicineFoodHomology;
	}

	@Length(min = 1, max = 2, message = "是否新资源食品长度必须介于 1 和 2 之间")
	public String getIsNewResourcesFood() {
		return isNewResourcesFood;
	}

	public void setIsNewResourcesFood(String isNewResourcesFood) {
		this.isNewResourcesFood = isNewResourcesFood;
	}

}