package com.bit189.haroo.dao;

import com.bit189.haroo.domain.ServiceInfo;

public interface ServiceInfoDao {

  int insert(ServiceInfo serivceInfo) throws Exception;

  int update(ServiceInfo serivceInfo) throws Exception;

  int delete(int no) throws Exception;
}
