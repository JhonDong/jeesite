/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.product_package.entity;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 商品包装Entity
 * 
 * @author 董志强
 * @version 2018-03-08
 */
public class ProductPackage extends DataEntity<ProductPackage> {

	private static final long serialVersionUID = 1L;
	private Long gjId; // 高济商品id
	private String packingSpecifications; // 装箱规格
	private Integer boxWidth; // 外装箱长（cm）
	private Integer boxWide; // 外装箱宽（cm）
	private Integer boxHeight; // 外装箱高（cm）
	private Integer boxWeight; // 外箱毛重（kg）
	private String storageConditions; // 存贮条件
	private String shippingConditions; // 运输条件
	private String isFragile; // 是否易碎商品
	private String gjName; // 冗余字段

	// 附加字段
	public String getGjName() {
		return gjName;
	}

	public void setGjName(String gjName) {
		this.gjName = gjName;
	}

	public ProductPackage() {
		super();
	}

	public ProductPackage(String id) {
		super(id);
	}

	@NotNull(message = "高济商品id不能为空")
	public Long getGjId() {
		return gjId;
	}

	public void setGjId(Long gjId) {
		this.gjId = gjId;
	}

	@Length(min = 1, max = 120, message = "装箱规格长度必须介于 1 和 120 之间")
	public String getPackingSpecifications() {
		return packingSpecifications;
	}

	public void setPackingSpecifications(String packingSpecifications) {
		this.packingSpecifications = packingSpecifications;
	}

	@NotNull(message = "外装箱长（cm）不能为空")
	public Integer getBoxWidth() {
		return boxWidth;
	}

	public void setBoxWidth(Integer boxWidth) {
		this.boxWidth = boxWidth;
	}

	@NotNull(message = "外装箱宽（cm）不能为空")
	public Integer getBoxWide() {
		return boxWide;
	}

	public void setBoxWide(Integer boxWide) {
		this.boxWide = boxWide;
	}

	@NotNull(message = "外装箱高（cm）不能为空")
	public Integer getBoxHeight() {
		return boxHeight;
	}

	public void setBoxHeight(Integer boxHeight) {
		this.boxHeight = boxHeight;
	}

	@NotNull(message = "外箱毛重（kg）不能为空")
	public Integer getBoxWeight() {
		return boxWeight;
	}

	public void setBoxWeight(Integer boxWeight) {
		this.boxWeight = boxWeight;
	}

	@Length(min = 1, max = 80, message = "存贮条件长度必须介于 1 和 80 之间")
	public String getStorageConditions() {
		return storageConditions;
	}

	public void setStorageConditions(String storageConditions) {
		this.storageConditions = storageConditions;
	}

	@Length(min = 1, max = 120, message = "运输条件长度必须介于 1 和 120 之间")
	public String getShippingConditions() {
		return shippingConditions;
	}

	public void setShippingConditions(String shippingConditions) {
		this.shippingConditions = shippingConditions;
	}

	@Length(min = 1, max = 2, message = "是否易碎商品长度必须介于 1 和 2 之间")
	public String getIsFragile() {
		return isFragile;
	}

	public void setIsFragile(String isFragile) {
		this.isFragile = isFragile;
	}

}