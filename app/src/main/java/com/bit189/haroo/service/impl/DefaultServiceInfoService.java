package com.bit189.haroo.service.impl;

import java.util.List;
import com.bit189.haroo.dao.ServiceInfoDao;
import com.bit189.haroo.domain.Learning;
import com.bit189.haroo.service.ServiceInfoService;

public class DefaultServiceInfoService implements ServiceInfoService {

  ServiceInfoDao serviceInfoDao;

  public DefaultServiceInfoService(ServiceInfoDao serviceInfoDao) {
    this.serviceInfoDao = serviceInfoDao;
  }

  @Override
  public int add(Learning learning) throws Exception {
    return 0;
    // 미완성
  }

  @Override
  public List<Learning> list() throws Exception {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Learning get(int no) throws Exception {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public int update(Learning Learning) throws Exception {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public int delete(int no) throws Exception {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public Learning Search(int no) throws Exception {
    // TODO Auto-generated method stub
    return null;
  }
}
