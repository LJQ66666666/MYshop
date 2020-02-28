package com.situ.myshop.area.service.impl;

import java.awt.geom.Area;
import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.situ.myshop.area.dao.AreaDao;
import com.situ.myshop.area.service.AreaService;
@Service
public class AreaServiceImpl implements AreaService, Serializable {
	private static final long serialVersionUID = 1L;
	@Autowired
	private AreaDao areaDao;

	@Override
	public List<Area> findOne() {
		return areaDao.findOne();
	}

	@Override
	public List<Area> findTwo(Long parentCode) {
		return areaDao.findTwo(parentCode);
	}

}
