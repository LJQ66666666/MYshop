package com.situ.myshop.goods.service.impl;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.situ.myshop.base.domain.PageData;
import com.situ.myshop.goods.dao.GoodsDao;
import com.situ.myshop.goods.domain.Goods;
import com.situ.myshop.goods.service.GoodsService;
import com.situ.myshop.util.PageUtils;
@Service
public class GoodsServiceImpl implements Serializable, GoodsService {
	private static final long serialVersionUID = 1L;
	@Autowired
	private GoodsDao goodsDao;

	@Override
	public List<Goods> findByPage(Integer pageNo, Goods searchGoods) {
		// limit查询数据开始的下标
		Integer firstResult = (pageNo - 1) * PageUtils.PAGE_ROWS;
		// limit查询数据 要显示的条数
		Integer maxResults = PageUtils.PAGE_ROWS;
		return goodsDao.findByPage(searchGoods, firstResult, maxResults);
	}

	@Override
	public PageData buildPageData(Integer pageNo, Goods searchGoods) {
		// 查询出数据总数
		Integer dataCount = goodsDao.getCount(searchGoods);
		return PageUtils.buildPageData(dataCount, pageNo);
	}

	@Override
	public Long saveGoods(Goods goods) {
		return goodsDao.saveGoods(goods);
	}

	@Override
	public Long doDeleteGoods(Long rowId) {
		goodsDao.delete(rowId);
		return rowId;
	}

	@Override
	public Goods findGoodsById(Long rowId) {
		return goodsDao.get(rowId);
	}

	@Override
	public Long updateGoods(Goods goods) {
		goods.setUpdateBy("admin1");
		goods.setUpdateDate(new Date());
		goodsDao.update(goods);
		return goods.getRowId();
	}

	@Override
	public List<Goods> findAllGoods() {
		return goodsDao.find();
	}

	@Override
	public Goods findByGoodsCode(String goodsCode) {
		return goodsDao.getByGoodsCode(goodsCode);
	}

}
