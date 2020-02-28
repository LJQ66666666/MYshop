package com.situ.myshop.cart.controller;

import java.io.Serializable;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.situ.myshop.cart.domain.Cart;
import com.situ.myshop.cart.service.CartService;
import com.situ.myshop.goods.service.GoodsService;
import com.situ.myshop.user.domain.User;

@Controller
@RequestMapping("/cart")
public class CartController implements Serializable {
	private static final long serialVersionUID = 1L;
	@Autowired
	private CartService cartService;

	
	private static final String CART_INDEX = "shop/gouwuche";

	// 新增一条购物车信息
	@RequestMapping("/addcart/{rowId}")
	@ResponseBody
	public Long doCartAdd(Cart cart,@PathVariable Long rowId, HttpSession session) {
		return cartService.addCart(cart,rowId, session);
	}
	//删除一条购物车的记录
	@ResponseBody
	@RequestMapping("/deletecart/{goodsId}")
	public Long doDeleteCart(@PathVariable Long goodsId,HttpSession session) {
		return cartService.deleteCart(goodsId,session);
	}
	//查询出某用户所有的购物车记录
		@RequestMapping("/find")
		public ModelAndView goCartIndex(ModelAndView modelAndView,HttpSession session) {
			User user = (User)session.getAttribute("userLogin");
			String userCode=user.getUserCode();
			//查看所有购物车
			modelAndView.addObject("cartList",cartService.find(userCode));
			
			modelAndView.setViewName(CART_INDEX);
			return modelAndView ; 
		}

}
