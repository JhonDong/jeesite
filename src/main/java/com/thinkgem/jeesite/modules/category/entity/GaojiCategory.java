/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.category.entity;

import java.util.Date;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.thinkgem.jeesite.common.persistence.TreeEntity;

/**
 * 树结构生成Entity
 * @author 董志强
 * @version 2018-03-02
 */
public class GaojiCategory extends TreeEntity<GaojiCategory> {
	
	private static final long serialVersionUID = 1L;
	private String name;		// 分类名称
	private GaojiCategory parent;		// 父级分类ID
	private String mark;		// 备注
	private Date createTime;		// create_time
	private Date updateTime;		// update_time
	private String parentIds;		// parent_ids
	
	public GaojiCategory() {
		super();
	}

	public GaojiCategory(String id){
		super(id);
	}

	@Length(min=1, max=40, message="分类名称长度必须介于 1 和 40 之间")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@JsonBackReference
	public GaojiCategory getParent() {
		return parent;
	}

	public void setParent(GaojiCategory parent) {
		this.parent = parent;
	}
	
	@Length(min=0, max=255, message="备注长度必须介于 0 和 255 之间")
	public String getMark() {
		return mark;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
//	@NotNull(message="create_time不能为空")
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
//	@NotNull(message="update_time不能为空")
	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	
	@Length(min=1, max=255, message="parent_ids长度必须介于 1 和 255 之间")
	public String getParentIds() {
		return parentIds;
	}

	public void setParentIds(String parentIds) {
		this.parentIds = parentIds;
	}
	
	public String getParentId() {
		return parent != null && parent.getId() != null ? parent.getId() : "0";
	}
}