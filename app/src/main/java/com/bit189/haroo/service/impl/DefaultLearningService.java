package com.bit189.haroo.service.impl;

import java.util.HashMap;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;
import com.bit189.haroo.dao.LearningDao;
import com.bit189.haroo.dao.LearningScheduleDao;
import com.bit189.haroo.dao.ServiceInfoDao;
import com.bit189.haroo.domain.Learning;
import com.bit189.haroo.domain.ServiceInfo;
import com.bit189.haroo.service.LearningService;

@Service
public class DefaultLearningService implements LearningService {

  TransactionTemplate transactionTemplate;
  ServiceInfoDao serviceInfoDao;
  LearningDao learningDao;
  LearningScheduleDao learningScheduleDao;

  public DefaultLearningService(PlatformTransactionManager txManager, ServiceInfoDao serviceInfoDao,
      LearningDao learningDao, LearningScheduleDao learningScheduleDao) {

    this.transactionTemplate = new TransactionTemplate(txManager);
    this.serviceInfoDao = serviceInfoDao;
    this.learningDao = learningDao;
    this.learningScheduleDao = learningScheduleDao;
  }

  @Override
  public int add(ServiceInfo serviceInfo, Learning learning) throws Exception {
    return transactionTemplate.execute(new TransactionCallback<Integer>() {
      @Override
      public Integer doInTransaction(TransactionStatus status) {
        try {
          serviceInfoDao.insert(serviceInfo);

          HashMap<String,Object> param = new HashMap<>();
          param.put("no", serviceInfo.getNo());
          param.put("learning", learning);
          learningDao.insert(param);

          HashMap<String,Object> params = new HashMap<>();
          params.put("learningNo", serviceInfo.getNo());
          params.put("schedules", learning.getSchedules());
          learningScheduleDao.insert(params);

          return serviceInfo.getNo();

        } catch (Exception e) {
          throw new RuntimeException(e);
        }
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
  public int update(ServiceInfo serviceInfo, Learning learning) throws Exception {
    return transactionTemplate.execute(new TransactionCallback<Integer>() {
      @Override
      public Integer doInTransaction(TransactionStatus status) {
        try {
          serviceInfoDao.update(serviceInfo);

          HashMap<String,Object> param = new HashMap<>();
          param.put("no", serviceInfo.getNo());
          param.put("learning", learning);
          learningDao.update(param);

          HashMap<String,Object> params = new HashMap<>();
          params.put("learningNo", serviceInfo.getNo());
          params.put("schedules", learning.getSchedules());
          learningScheduleDao.update(params);

          return serviceInfo.getNo();
        } catch (Exception e) {
          throw new RuntimeException(e);
        }
      }
    });
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