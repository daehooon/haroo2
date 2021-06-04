package com.bit189.haroo.service.impl;

import org.springframework.stereotype.Service;
import com.bit189.haroo.dao.ServiceInfoDao;
import com.bit189.haroo.domain.ServiceInfo;
import com.bit189.haroo.service.ServiceInfoService;

@Service
public class DefaultServiceInfoService implements ServiceInfoService {


  ServiceInfoDao serviceInfoDao;


  public DefaultServiceInfoService( ServiceInfoDao serviceInfoDao) {


    this.serviceInfoDao = serviceInfoDao;

  }


  @Override
  public ServiceInfo get(int no) throws Exception {
    return serviceInfoDao.findByNo(no);
  }



}