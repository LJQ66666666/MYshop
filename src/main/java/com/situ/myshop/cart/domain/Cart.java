package com.situ.myshop.cart.domain;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

import com.situ.myshop.base.domain.BaseClass;
@Alias("Cart")
public class Cart extends BaseClass implements Serializable {
	private static final long serialVersionUID = 1L;
	private String userCode;//用户账号
	private Long goodsId;//商品Id
	private Integer buyCount;//购买数量
	private Double totalPrice;//总价格
	/*额外的属性-开始*/
	private String goodsCode;//商品编号
	private String goodsName;//商品名称
	private String goodsImg;//商品图片
	private Double goodsPrice;//商品价格
	/*额外的属性-开始*/
	public String getUserCode() {
		return userCode;
	}
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}
	public Long getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(Long goodsId) {
		this.goodsId = goodsId;
	}
	public Integer getBuyCount() {
		return buyCount;
	}
	public void setBuyCount(Integer buyCount) {
		this.buyCount = buyCount;
	}
	public Double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public String getGoodsCode() {
		return goodsCode;
	}
	public void setGoodsCode(String goodsCode) {
		this.goodsCode = goodsCode;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public String getGoodsImg() {
		return goodsImg;
	}
	public void setGoodsImg(String goodsImg) {
		this.goodsImg = goodsImg;
	}
	public Double getGoodsPrice() {
		return goodsPrice;
	}
	public void setGoodsPrice(Double goodsPrice) {
		this.goodsPrice = goodsPrice;
	}

	
	
	
	

}
