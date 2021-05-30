package com.bit189.haroo.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import com.bit189.haroo.dao.BroadCategoryDao;
import com.bit189.haroo.domain.BroadCategory;
import com.bit189.haroo.service.BroadCategoryService;

@Service
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
