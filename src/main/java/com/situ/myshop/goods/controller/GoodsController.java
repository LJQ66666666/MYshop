package com.situ.myshop.goods.controller;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.situ.myshop.goods.domain.Goods;
import com.situ.myshop.goods.service.GoodsService;
import com.situ.myshop.util.PageUtils;

@Controller
@RequestMapping("/goods")
public class GoodsController implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final String PAGE_GOODS_INDEX = "goods/goods_index";
	private static final String PAGE_GOODS_LIST = "goods/goods_list";
	private static final String PAGE_SHOPPING_LIST="goods/shopping_list";
	@Autowired
	private GoodsService goodsService;
	
	//这个是前端页面的商品展示
	@RequestMapping("/findShopping")
	public ModelAndView findAllShopping(ModelAndView modelAndView) {
		modelAndView.addObject("goodsList", goodsService.findAllGoods());
		modelAndView.setViewName(PAGE_SHOPPING_LIST);
		return modelAndView;
	}

	@RequestMapping("/index")
	// 跳转到用户管理首页
	public ModelAndView goIndex(ModelAndView modelAndView) {
		modelAndView.setViewName(PAGE_GOODS_INDEX);
		return modelAndView;
	}

	/**
	 * 查询所有的记录
	 * 
	 * @param pageNo
	 * @param searchGoods
	 * @param modelAndView
	 * @return
	 */
	@RequestMapping("/find/{pageNo}")
	public ModelAndView findAllGoods(@PathVariable Integer pageNo, Goods searchGoods, ModelAndView modelAndView) {
		// 通过工具类将查询条件中的""设置为null
		searchGoods = PageUtils.buildSearchParam(searchGoods);
		// 要展示的列表数据
		modelAndView.addObject("goodsList", goodsService.findByPage(pageNo, searchGoods));
		// 分页信息
		modelAndView.addObject("pageData", goodsService.buildPageData(pageNo, searchGoods));
		modelAndView.setViewName(PAGE_GOODS_LIST);
		return modelAndView;
	}

	@ResponseBody
	@RequestMapping("/add")
	public Long addGoods(Goods goods, HttpServletRequest request) {
		CommonsMultipartFile goodsPhotoFile = goods.getGoodsPhotoFile();
		// String name = comPhotoFile.getName();
		// System.out.println("上传的文件的ParamName=" + name);
		String originalFilename = goodsPhotoFile.getOriginalFilename();
		// System.out.println("上传的文件名称=" + originalFilename);
		// Long size = comPhotoFile.getSize();
		// System.out.println("上传文件的大小=" + size);

		// 文件的后缀
		String suffix = originalFilename.substring(originalFilename.lastIndexOf("."));
		// 写出的文件地址#此路径应该写到数据库中
		String filePath = "assert/uploads/" + Calendar.getInstance().getTimeInMillis() + suffix;
		// 项目的根路径
		String realPath = request.getServletContext().getRealPath("/");
		// 要写出的文件
		File toFile = new File(realPath + filePath);
		// 通过 transferTo 直接将文件写出
		try {
			goodsPhotoFile.transferTo(toFile);
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		goods.setGoodsImg(filePath);
		goods.setActiveFlag(1);
		goods.setCreateBy("admin");
		goods.setCreateDate(new Date());
		return goodsService.saveGoods(goods);
	}

	// 执行删除
	@ResponseBody
	@RequestMapping("/dodelete/{rowId}")
	public Long doDelete(@PathVariable Long rowId) {
		return this.goodsService.doDeleteGoods(rowId);
	}

	// 找到需要修改信息的用户实例
	@ResponseBody
	@RequestMapping("/updatefind/{rowId}")
	public Goods doUpdate(@PathVariable("rowId") Long rowId) {
		return this.goodsService.findGoodsById(rowId);
	}

	// 执行修改
	@ResponseBody
	@RequestMapping("/update")
	public Long doUpdateGoods(Goods goods) {
		return goodsService.updateGoods(goods);
	}

}
