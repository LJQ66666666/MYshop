package com.situ.myshop.catalogue.controller;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.situ.myshop.catalogue.domain.Catalogue;
import com.situ.myshop.catalogue.service.CatalogueService;

@Controller
@RequestMapping("/catalogue")
public class CatalogueController implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final String PAGE_CATALOGUE_LIST = "catalogue/catalogue_list";
	private static final String PAGE_CATALOGIE_INDEX = "catalogue/catalogue_index";
	@Autowired
	private CatalogueService catalogueService;

	// 进入目录管理首页
	@RequestMapping("/index")
	public ModelAndView goIndex(ModelAndView modelAndView) {// 视图解析器，用来存储处理完后的结果数据，以及显示该数据的视图
		modelAndView.setViewName(PAGE_CATALOGIE_INDEX);
		return modelAndView;
	}

	// 一级目录增加
	@RequestMapping("/addParent")
	@ResponseBody
	public Long goAddCatalogue(Catalogue catalogue) {
		return catalogueService.addFirstCatalogue(catalogue);
	}

	// 查询所有数据的信息
	@RequestMapping("/find")
	@ResponseBody
	public ModelAndView goFind(ModelAndView modelAndView) {
		modelAndView.addObject("catalogueList", catalogueService.findCatelogue());
		modelAndView.setViewName(PAGE_CATALOGUE_LIST);
		return modelAndView;
	}

	// 删除目录
	@RequestMapping("/delete/{rowId}")
	@ResponseBody
	public Long godelete(@PathVariable("rowId") Long rowId) {
		return catalogueService.deleteCatelogue(rowId);
	}
	//找到需要修改的目录对象
	@RequestMapping("/update/{rowId}")
	@ResponseBody
	public Catalogue goUpdate(@PathVariable("rowId")Long rowId) {
		Catalogue catelogue	=catalogueService.getCatalogue(rowId);
		return catelogue ;
		
	}
	//执行目录修改
	@RequestMapping("/doupdate")
	@ResponseBody
	public Long doUpdate(Catalogue catalogue) {
		return catalogueService.updateCatalogue(catalogue);
	}

}
