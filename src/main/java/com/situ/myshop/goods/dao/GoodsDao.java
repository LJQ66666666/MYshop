package com.situ.myshop.goods.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.situ.myshop.goods.domain.Goods;
@Repository
public interface GoodsDao {
	//分页查询
	List<Goods> findByPage(@Param("searchGoods")Goods searchGoods, @Param("firstResult")Integer firstResult,@Param("maxResults") Integer maxResults);
	//
	Integer getCount(@Param("searchGoods")Goods searchGoods);
	//商品新增
	Long saveGoods(Goods goods);
	//商品删除
	void delete(Long rowId);
	//根据主键找到一条商品
	Goods get(Long rowId);
	//商品信息修改
	void update(Goods goods);
	//前台商品展示
	List<Goods> find();
	//根据商品编号查询出一条商品的信息
	Goods getByGoodsCode(String goodsCode);

}
