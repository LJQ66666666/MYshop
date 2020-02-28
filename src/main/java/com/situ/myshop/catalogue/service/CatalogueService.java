package com.situ.myshop.catalogue.service;

import java.util.List;

import com.situ.myshop.catalogue.domain.Catalogue;

public interface CatalogueService {

	Long addFirstCatalogue(Catalogue catalogue);//新增一级目录

	List<Catalogue> findCatelogue();//查询所有记录

	Long deleteCatelogue(Long rowId);

	Catalogue getCatalogue(Long rowId);

	Long updateCatalogue(Catalogue catalogue);

}
