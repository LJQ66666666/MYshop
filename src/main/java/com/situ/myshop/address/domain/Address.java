package com.situ.myshop.address.domain;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

import com.situ.myshop.base.domain.BaseClass;
@Alias("Address")
public class Address extends BaseClass implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long addressId;//收货地址Id
	private String userCode;//用户ID
	private String conSignee;//收货人姓名
	private String province;//省（直辖市）CODE
	private String city;//市 CODE
	private String county;//县
	private String detailed;//详细地址
	private Integer postCode;//邮编
	private Long consigneePhone;//收货人电话
	public Long getAddressId() {
		return addressId;
	}
	public void setAddressId(Long addressId) {
		this.addressId = addressId;
	}
	public String getUserCode() {
		return userCode;
	}
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}
	public String getConSignee() {
		return conSignee;
	}
	public void setConSignee(String conSignee) {
		this.conSignee = conSignee;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCounty() {
		return county;
	}
	public void setCounty(String county) {
		this.county = county;
	}
	public String getDetailed() {
		return detailed;
	}
	public void setDetailed(String detailed) {
		this.detailed = detailed;
	}
	public Integer getPostCode() {
		return postCode;
	}
	public void setPostCode(Integer postCode) {
		this.postCode = postCode;
	}
	public Long getConsigneePhone() {
		return consigneePhone;
	}
	public void setConsigneePhone(Long consigneePhone) {
		this.consigneePhone = consigneePhone;
	}
	
}
