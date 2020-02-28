package com.situ.myshop.orderlist.domain;

import java.io.Serializable;

import com.situ.myshop.base.domain.BaseClass;

public class OrderList extends BaseClass implements Serializable {
	private static final long serialVersionUID = 1L;
	private String orderNum;//订单编号，要关联订单的编号
	private String goodsCode;//商品编号
	private Integer buyCount;//购买数量
	private Double totalPrice;//商品总价格
	public String getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}
	public String getGoodsCode() {
		return goodsCode;
	}
	public void setGoodsCode(String goodsCode) {
		this.goodsCode = goodsCode;
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
	

}
