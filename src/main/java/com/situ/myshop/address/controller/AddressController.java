package com.situ.myshop.address.controller;

import java.io.Serializable;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.situ.myshop.address.domain.Address;
import com.situ.myshop.address.service.AddressService;
import com.situ.myshop.user.domain.User;
@Controller
@RequestMapping("/address")
public class AddressController implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final String PAGE_INDEX_ADDRESS="address/address_index";
	private static final String PAGE_LIST_ADDRESS="address/address_list";
	@Autowired
	private AddressService addressService;
	//进入收货地址页面
	@RequestMapping("/index")
	public ModelAndView goaddressIndex(ModelAndView modelAndView) {
		modelAndView.setViewName(PAGE_INDEX_ADDRESS);
		return modelAndView;
	}
	//新增一条收货地址
	@ResponseBody
	@RequestMapping("/add")
	public Long saveAddress(Address address,HttpSession session) {
		return addressService.saveAddress(address, session);
	}
	//查询所有收货地址
	@RequestMapping("/find")
	public ModelAndView findAllAddress(ModelAndView modelAndView, HttpSession session) {
		Object object = session.getAttribute("userLogin");
		if (object != null) {
			User user = (User) object;
			String userCode = user.getUserCode();
			modelAndView.addObject("addressList", addressService.find(userCode));
		}
		modelAndView.setViewName(PAGE_LIST_ADDRESS);
		return modelAndView;
	}
	

}
