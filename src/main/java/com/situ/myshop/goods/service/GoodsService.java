package com.situ.myshop.goods.service;

import java.util.List;

import com.situ.myshop.base.domain.PageData;
import com.situ.myshop.goods.domain.Goods;

public interface GoodsService {

	List<Goods> findByPage(Integer pageNo, Goods searchGoods);

	PageData buildPageData(Integer pageNo, Goods searchGoods);

	Long saveGoods(Goods goods);

	Long doDeleteGoods(Long rowId);

	Goods findGoodsById(Long rowId);//根据主键找出需要修改信息的商品

	Long updateGoods(Goods goods);//修改商品信息

	List<Goods> findAllGoods();//前台商品展示

	Goods findByGoodsCode(String goodsCode);//根据商品编号查询出一条商品的信息

}
