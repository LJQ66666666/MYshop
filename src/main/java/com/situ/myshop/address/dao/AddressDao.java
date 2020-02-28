package com.situ.myshop.address.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.situ.myshop.address.domain.Address;

@Repository
public interface AddressDao {

	Long save(Address address);//新增收货地址

	List<Address> find(String userCode);//查询出所有的收货地址
	
	

}
