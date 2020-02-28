package com.situ.myshop.goods.domain;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.situ.myshop.base.domain.BaseClass;
@Alias("Goods")
public class Goods extends BaseClass implements Serializable {
	private static final long serialVersionUID = 1L;
	private String goodsName;// 商品名称
	private String goodsCode;// 商品编号
	private String goodsImg;// 商品图片
	private Double goodsPrice;// 商品价格
	private Integer goodsNum;// 商品库存数量
	private Integer goodsUpAndDown;// 商品上下架状态
	private String goodsInfo;// 商品介绍
	private CommonsMultipartFile goodsPhotoFile;

																																					
	
	public CommonsMultipartFile getGoodsPhotoFile() {
		return goodsPhotoFile;
	}

	public void setGoodsPhotoFile(CommonsMultipartFile goodsPhotoFile) {
		this.goodsPhotoFile = goodsPhotoFile;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public String getGoodsCode() {
		return goodsCode;
	}

	public void setGoodsCode(String goodsCode) {
		this.goodsCode = goodsCode;
	}

	public String getGoodsImg() {
		return goodsImg;
	}

	public void setGoodsImg(String filePath) {
		this.goodsImg = filePath;
	}

	public Double getGoodsPrice() {
		return goodsPrice;
	}

	public void setGoodsPrice(Double goodsPrice) {
		this.goodsPrice = goodsPrice;
	}

	public Integer getGoodsNum() {
		return goodsNum;
	}

	public void setGoodsNum(Integer goodsNum) {
		this.goodsNum = goodsNum;
	}

	public Integer getGoodsUpAndDown() {
		return goodsUpAndDown;
	}

	public void setGoodsUpAndDown(Integer goodsUpAndDown) {
		this.goodsUpAndDown = goodsUpAndDown;
	}

	public String getGoodsInfo() {
		return goodsInfo;
	}

	public void setGoodsInfo(String goodsInfo) {
		this.goodsInfo = goodsInfo;
	}

}
