package com.situ.myshop.area.domain;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;
@Alias("Area")
public class area implements Serializable {
	private static final long serialVersionUID = 1L;//
	private String areaCode;//区域编号
	private String areaName;//区域名称
	private Long parentCode;//父节点
	private Integer areaRunk;//区域级别
	private Integer hasChild;//有无子节点（1有，0无）
	public String getAreaCode() {
		return areaCode;
	}
	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}
	public String getAreaName() {
		return areaName;
	}
	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}
	public Long getParentCode() {
		return parentCode;
	}
	public void setParentCode(Long parentCode) {
		this.parentCode = parentCode;
	}
	public Integer getAreaRunk() {
		return areaRunk;
	}
	public void setAreaRunk(Integer areaRunk) {
		this.areaRunk = areaRunk;
	}
	public Integer getHasChild() {
		return hasChild;
	}
	public void setHasChild(Integer hasChild) {
		this.hasChild = hasChild;
	}
	

}
