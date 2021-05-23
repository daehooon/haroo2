package com.bit189.haroo.service.impl;

import java.util.List;
import com.bit189.haroo.dao.SigunguDao;
import com.bit189.haroo.domain.Sigungu;
import com.bit189.haroo.service.SigunguService;

public class DefaultSigunguService implements SigunguService {

  SigunguDao sigunguDao;

  public DefaultSigunguService(SigunguDao sigunguDao) {
    this.sigunguDao = sigunguDao;
  }

  @Override
  public List<Sigungu> list() throws Exception {
    return sigunguDao.findAll();
  }
}
