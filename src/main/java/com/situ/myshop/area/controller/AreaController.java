package com.situ.myshop.area.controller;

import java.awt.geom.Area;
import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.situ.myshop.area.service.AreaService;
@Controller
@RequestMapping("/area")
public class AreaController implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final String PAGE_INDEX_ADDRESS = "address/address_index";
	@Autowired
	private AreaService areaService;
	
	@ResponseBody
	@RequestMapping("/province")
	public ModelAndView getProvince(ModelAndView modelAndView){
		List<Area> list = areaService.findOne();
		modelAndView.addObject("areaOneList", list);
		modelAndView.setViewName(PAGE_INDEX_ADDRESS);
		return modelAndView;
		
	}
	@ResponseBody
	@RequestMapping("/list/{parentCode}")
	List<Area> findCode(@PathVariable Long parentCode){
		List<Area> areaList =areaService.findTwo(parentCode);
		return areaList;
	}

}
