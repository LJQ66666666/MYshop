package com.situ.myshop.cart.service.impl;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.situ.myshop.cart.dao.CartDao;
import com.situ.myshop.cart.domain.Cart;
import com.situ.myshop.cart.service.CartService;
import com.situ.myshop.goods.dao.GoodsDao;
import com.situ.myshop.user.domain.User;

@Service
public class CartServiceImpl implements CartService, Serializable {
	private static final long serialVersionUID = 1L;

	@Autowired
	private CartDao cartDao;
	

	@Override
	public Long addCart(Cart cart,Long rowId, HttpSession session) {
		Long goodsId = rowId;
		User user = (User) session.getAttribute("userLogin");
		String userCode =user.getUserCode();
		Cart cart1 = cartDao.getByGoodsId(goodsId,userCode);
		
		if (cart1 != null) {
			// 如果此商品购物车已存在，则进行商品数量+1
			Integer t = cart1.getBuyCount();
			Integer buyCount = t + 1;
			cart1.setBuyCount(buyCount);
			return cartDao.update(cart1);
		} else {
			cart.setUserCode(userCode);
			cart.setGoodsId(rowId);
			cart.setActiveFlag(1);
			cart.setBuyCount(1);
			cart.setTotalPrice(cart.getGoodsPrice());
			cart.setCreateBy("admin");
			cart.setCreateDate(new Date());
			
			return cartDao.save(cart);
		}
	}

	@Override
	public List<Cart> find(String userCode) {
		return cartDao.find(userCode);
	}

	@Override
	public Long deleteCart(Long goodsId, HttpSession session) {
		User user = (User) session.getAttribute("userLogin");
		String userCode =user.getUserCode();
		return cartDao.delete(goodsId,userCode);
	}
	

}
