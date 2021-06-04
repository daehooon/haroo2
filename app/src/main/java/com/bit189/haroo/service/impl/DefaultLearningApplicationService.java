package com.bit189.haroo.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;
import com.bit189.haroo.dao.LearningApplicationDao;
import com.bit189.haroo.dao.LearningScheduleDao;
import com.bit189.haroo.domain.LearningApplication;
import com.bit189.haroo.service.LearningApplicationService;

@Service
public class DefaultLearningApplicationService implements LearningApplicationService{

  TransactionTemplate transactionTemplate;
  LearningApplicationDao learningApplicationDao;
  LearningScheduleDao learningScheduleDao;


  public DefaultLearningApplicationService(PlatformTransactionManager txManager, 
      LearningApplicationDao learningApplicationDao,LearningScheduleDao learningScheduleDao) {
    this.transactionTemplate = new TransactionTemplate(txManager);
    this.learningApplicationDao = learningApplicationDao;
    this.learningScheduleDao = learningScheduleDao;
  }


  @Override
  public int add(LearningApplication learningApplication) throws Exception {
    return transactionTemplate.execute(new TransactionCallback<Integer>() {
      @Override
      public Integer doInTransaction(TransactionStatus status) {
        try {
          return learningApplicationDao.insert(learningApplication);
        } catch (Exception e) {
          throw new RuntimeException(e);
        }
      }
    });
  }


  @Override
  public List<LearningApplication> list() throws Exception {
    return learningApplicationDao.findAll();
  }


  @Override
  public int update(LearningApplication learningApplication) throws Exception {
    return learningApplicationDao.update(learningApplication);
  }


  @Override
  public LearningApplication get(int no) throws Exception {
    return learningApplicationDao.findByNo(no);
  }


  @Override
  public int delete(int no) throws Exception {
    return learningApplicationDao.delete(no);
  }



}