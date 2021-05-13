package com.bit189.haroo.dao;

import java.util.List;
import com.bit189.haroo.domain.ServiceInfo;

public interface ServiceInfoDao {

  int insert(ServiceInfo serviceInfo) throws Exception;

  List<ServiceInfo> findAll() throws Exception;

  ServiceInfo findByNo(int no) throws Exception;

  ServiceInfo findByName(String name) throws Exception;

  int update(int no) throws Exception;

  int delete(int no) throws Exception;
}   
