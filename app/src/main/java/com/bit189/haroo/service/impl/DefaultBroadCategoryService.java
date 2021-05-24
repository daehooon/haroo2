package com.bit189.haroo.service.impl;

import java.util.List;
import com.bit189.haroo.dao.BroadCategoryDao;
import com.bit189.haroo.domain.BroadCategory;
import com.bit189.haroo.service.BroadCategoryService;

public class DefaultBroadCategoryService implements BroadCategoryService {

  BroadCategoryDao broadCategoryDao;

  public DefaultBroadCategoryService(BroadCategoryDao broadCategoryDao) {
    this.broadCategoryDao = broadCategoryDao;
  }

  @Override
  public List<BroadCategory> list() throws Exception {
    return broadCategoryDao.findAll();
  }
}
