package com.situ.myshop.catalogue.service.impl;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.situ.myshop.catalogue.dao.CatalogueDao;
import com.situ.myshop.catalogue.domain.Catalogue;
import com.situ.myshop.catalogue.service.CatalogueService;
@Service
public class CatalogueServiceImpl implements CatalogueService, Serializable {
	private static final long serialVersionUID = 1L;
	@Autowired
	private CatalogueDao catalogueDao;
	@Override
	public Long addFirstCatalogue(Catalogue catalogue) {
		catalogue.setActiveFlag(1);
		catalogue.setCreateBy("admin");
		catalogue.setCreateDate(new Date());
		return catalogueDao.save(catalogue);
	}
	@Override
	public List<Catalogue> findCatelogue() {
		return catalogueDao.find();
	}
	@Override
	public Long deleteCatelogue(Long rowId) {
		return catalogueDao.delete(rowId);
	}
	@Override
	public Catalogue getCatalogue(Long rowId) {
		return catalogueDao.get(rowId);
	}
	@Override
	public Long updateCatalogue(Catalogue catalogue) {
		return catalogueDao.update(catalogue);
	}

}
