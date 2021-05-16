package com.bit189.haroo.service.impl;

import java.util.List;
import com.bit189.haroo.dao.NarrowCategoryDao;
import com.bit189.haroo.domain.NarrowCategory;
import com.bit189.haroo.service.NarrowCategoryService;

public class DefaultNarrowCategoryService implements NarrowCategoryService {

  NarrowCategoryDao narrowCategoryDao;

  public DefaultNarrowCategoryService(NarrowCategoryDao narrowCategoryDao) {
    this.narrowCategoryDao = narrowCategoryDao;
  }

  @Override
  public List<NarrowCategory> list() throws Exception {
    return narrowCategoryDao.findAll();
  }
}
