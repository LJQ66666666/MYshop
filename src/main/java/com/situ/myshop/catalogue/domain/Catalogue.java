package com.situ.myshop.catalogue.domain;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

import com.situ.myshop.base.domain.BaseClass;
@Alias("Catalogue")
public class Catalogue extends BaseClass implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer parentCatalogueId; // 父级目录ID
	private String catalogueName; // 目录名称
	private String catalogueInfo; // 目录简介
	//生成getter和setter方法
	public Integer getparentCatalogueId() {
		return parentCatalogueId;
	}
	public void setparentCatalogueId(Integer parentCatalogueId) {
		this.parentCatalogueId = parentCatalogueId;
	}
	public String getcatalogueName() {
		return catalogueName;
	}
	public void setcatalogueName(String catalogueName) {
		this.catalogueName = catalogueName;
	}
	public String getcatalogueInfo() {
		return catalogueInfo;
	}
	public void setcatalogueInfo(String catalogueInfo) {
		this.catalogueInfo = catalogueInfo;
	}
	

	

	
	

}
