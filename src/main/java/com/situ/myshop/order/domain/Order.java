package com.situ.myshop.order.domain;

import java.io.Serializable;

import com.situ.myshop.base.domain.BaseClass;

public class Order extends BaseClass implements Serializable {
	private static final long serialVersionUID = 1L;
	private String orderNum;//订单编号
	private String userCode;//用户ID
	private Double totalPrice;//总价格
	private String orderAddress;//收货地址
	private Integer orderStatus;//订单状态
	private String payMethod;//支付方式
	public String getOrderCode() {
		return orderNum;
	}
	public void setOrderCode(String orderCode) {
		this.orderNum = orderCode;
	}
	public String getUserID() {
		return userCode;
	}
	public void setUserID(String userID) {
		this.userCode = userID;
	}
	public Double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public String getOrderAddress() {
		return orderAddress;
	}
	public void setOrderAddress(String orderAddress) {
		this.orderAddress = orderAddress;
	}
	public Integer getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(Integer orderStatus) {
		this.orderStatus = orderStatus;
	}
	public String getPayMethod() {
		return payMethod;
	}
	public void setPayMethod(String payMethod) {
		this.payMethod = payMethod;
	}
	

}
