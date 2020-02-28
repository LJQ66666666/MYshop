package com.situ.myshop.catalogue.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.situ.myshop.catalogue.domain.Catalogue;

@Repository
public interface CatalogueDao {

	Long save(Catalogue catalogue);//新增一级目录

	List<Catalogue> find();//查询出所有的记录

	Long delete(Long rowId);//删除目录

	Catalogue get(Long rowId);//查找到一个目录实例

	Long update(Catalogue catalogue);//修改

	

}
