package com.situ.myshop.cart.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.situ.myshop.cart.domain.Cart;

@Repository
public interface CartDao {

	Cart getByGoodsId(@Param("goodsId")Long goodsId, @Param("userCode")String userCode);// 根据购物车的goodsId得到一条购物车记录

	Long update(Cart cart1);// 更新一条购物车记录

	Long save(Cart cart);// 保存一条购物车记录

	List<Cart> find(String userCode);// 查询一个用户的购物车记录

	Long delete(@Param("goodsId")Long goodsId, @Param("userCode")String userCode);//删除一条购物车记录

}
