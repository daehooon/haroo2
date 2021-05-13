package com.bit189.haroo.service.impl;

import java.util.List;
import com.bit189.haroo.dao.LearningDao;
import com.bit189.haroo.domain.Learning;
import com.bit189.haroo.service.LearningService;

public class DefaultLearningService implements LearningService {

  LearningDao learningDao;

  public DefaultLearningService(LearningDao learningDao) {
    this.learningDao = learningDao;
  }

  @Override
  public int add(Learning learning) throws Exception {
    return 0;
    // 튜터번호 add
  }

  @Override
  public List<Learning> list() throws Exception {
    return learningDao.findAll();
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
