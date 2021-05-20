package com.bit189.haroo.service.impl;

import java.util.List;
import com.bit189.Mybatis.TransactionCallback;
import com.bit189.Mybatis.TransactionManager;
import com.bit189.Mybatis.TransactionTemplate;
import com.bit189.haroo.dao.BroadCategoryDao;
import com.bit189.haroo.dao.LearningDao;
import com.bit189.haroo.dao.LearningScheduleDao;
import com.bit189.haroo.dao.NarrowCategoryDao;
import com.bit189.haroo.dao.ServiceInfoDao;
import com.bit189.haroo.dao.SidoDao;
import com.bit189.haroo.dao.SigunguDao;
import com.bit189.haroo.domain.Learning;
import com.bit189.haroo.domain.ServiceInfo;
import com.bit189.haroo.service.LearningService;

public class DefaultLearningService implements LearningService {

  TransactionTemplate transactionTemplate;
  ServiceInfoDao serviceInfoDao;
  LearningDao learningDao;
  LearningScheduleDao learningScheduleDao;
  BroadCategoryDao broadCategoryDao;
  NarrowCategoryDao narrowCategoryDao;
  SidoDao sidoDao;
  SigunguDao sigunguDao;

  public DefaultLearningService(TransactionManager txManager, ServiceInfoDao serviceInfoDao,
      LearningDao learningDao, LearningScheduleDao learningScheduleDao, BroadCategoryDao broadCategoryDao,
      NarrowCategoryDao narrowCategoryDao, SidoDao sidoDao, SigunguDao sigunguDao) {

    this.transactionTemplate = new TransactionTemplate(txManager);
    this.serviceInfoDao = serviceInfoDao;
    this.learningDao = learningDao;
    this.learningScheduleDao = learningScheduleDao;
    this.broadCategoryDao = broadCategoryDao;
    this.narrowCategoryDao = narrowCategoryDao;
    this.sidoDao = sidoDao;
    this.sigunguDao = sigunguDao;
  }

  @Override
  public int add(ServiceInfo serviceInfo, Learning learning) throws Exception {

    return (int) transactionTemplate.execute(new TransactionCallback() {
      @Override
      public Object doInTransaction() throws Exception {
        int count = serviceInfoDao.insert(serviceInfo);
        learningDao.insert(learning);

        return count;
      }
    });
  }

  @Override
  public List<Learning> list() throws Exception {
    return learningDao.findAll();
  }

  @Override
  public Learning get(int no) throws Exception {
    return learningDao.findByNo(no);
  }

  @Override
  public int update(Learning Learning) throws Exception {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public int delete(int no) throws Exception {
    return serviceInfoDao.delete(no);
  }

  @Override
  public Learning Search(int no) throws Exception {
    // TODO Auto-generated method stub
    return null;
  }
}