package com.bit189.haroo.service.impl;

import java.util.HashMap;
import java.util.List;
import com.bit189.Mybatis.TransactionManager;
import com.bit189.Mybatis.TransactionTemplate;
import com.bit189.haroo.dao.LearningDao;
import com.bit189.haroo.dao.LearningScheduleDao;
import com.bit189.haroo.dao.ServiceInfoDao;
import com.bit189.haroo.domain.Learning;
import com.bit189.haroo.domain.ServiceInfo;
import com.bit189.haroo.service.LearningService;

public class DefaultLearningService implements LearningService {

  TransactionTemplate transactionTemplate; // 보류
  ServiceInfoDao serviceInfoDao;
  LearningDao learningDao;
  LearningScheduleDao learningScheduleDao; // 보류

  public DefaultLearningService(TransactionManager txManager, ServiceInfoDao serviceInfoDao,
      LearningDao learningDao, LearningScheduleDao learningScheduleDao) {

    this.transactionTemplate = new TransactionTemplate(txManager);
    this.serviceInfoDao = serviceInfoDao;
    this.learningDao = learningDao;
    this.learningScheduleDao = learningScheduleDao;
  }

  @Override
  public int add(ServiceInfo serviceInfo, Learning learning) throws Exception {

    int count = serviceInfoDao.insert(serviceInfo);

    HashMap<String,Object> param = new HashMap<>();
    param.put("no", serviceInfo.getNo());
    param.put("learning", learning);
    learningDao.insert(param);

    HashMap<String,Object> param2 = new HashMap<>();
    param2.put("no", learning.getNo());
    param2.put("schedules", learning.getSchedules());
    learningDao.insertSchedules(param2);

    return count;
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
    return 0;
  }

  @Override
  public int delete(int no) throws Exception {
    return serviceInfoDao.delete(no);
  }

  @Override
  public Learning Search(int no) throws Exception {
    return null;
  }
}