package com.situ.myshop.cart.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.situ.myshop.cart.domain.Cart;

public interface CartService {

	Long addCart(Cart cart,Long rowId, HttpSession session);//新增一条购物车记录

	List<Cart> find(String userCode);//查询购物车记录

	Long deleteCart(Long goodsId, HttpSession session);//删除一条购物车记录



	

}
