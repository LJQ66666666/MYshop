package com.situ.myshop.area.service;

import java.awt.geom.Area;
import java.util.List;

public interface AreaService {

	List<Area> findOne();//查询一级数据

	List<Area> findTwo(Long parentCode);//查询二级数据

}
