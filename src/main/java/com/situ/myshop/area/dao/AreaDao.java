package com.situ.myshop.area.dao;

import java.awt.geom.Area;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface AreaDao {

	List<Area> findOne();//查询一级数据

	List<Area> findTwo(Long parentCode);//查询二级和三级数据

}
