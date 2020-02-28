package com.situ.myshop.address.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.situ.myshop.address.domain.Address;

public interface AddressService {

	Long saveAddress(Address address, HttpSession session);//新增收货地址

	List<Address> find(String userCode);//查询某个用户所有的收货地址

}
