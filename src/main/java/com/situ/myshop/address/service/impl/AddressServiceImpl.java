package com.situ.myshop.address.service.impl;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.situ.myshop.address.dao.AddressDao;
import com.situ.myshop.address.domain.Address;
import com.situ.myshop.address.service.AddressService;
import com.situ.myshop.user.domain.User;
@Service
public class AddressServiceImpl implements AddressService, Serializable {
	private static final long serialVersionUID = 1L;
	@Autowired
	private AddressDao addressDao;
	@Override
	public Long saveAddress(Address address, HttpSession session) {
		User user=(User)session.getAttribute("userLogin");
		address.setUserCode(user.getUserCode());
		address.setActiveFlag(1);
		address.setCreateBy("admin");
		address.setCreateDate(new Date());
		return addressDao.save(address);
	}
	@Override
	public List<Address> find(String userCode) {
		return addressDao.find(userCode);
	}

}
