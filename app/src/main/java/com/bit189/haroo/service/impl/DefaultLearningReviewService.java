package com.bit189.haroo.service.impl;

import java.util.List;
import com.bit189.Mybatis.TransactionManager;
import com.bit189.Mybatis.TransactionTemplate;
import com.bit189.haroo.dao.LearningReviewDao;
import com.bit189.haroo.dao.LearningReviewRecommendDao;
import com.bit189.haroo.domain.Review;
import com.bit189.haroo.service.LearningReviewService;

public class DefaultLearningReviewService implements LearningReviewService {

  TransactionTemplate transactionTemplate;
  LearningReviewDao learningReviewDao;
  LearningReviewRecommendDao learningReviewRecommendDao;

  public DefaultLearningReviewService(TransactionManager txManager,
      LearningReviewDao learningReviewDao,  
      LearningReviewRecommendDao learningReviewRecommendDao) {
    this.transactionTemplate = new TransactionTemplate(txManager);
    this.learningReviewDao = learningReviewDao;
    this.learningReviewRecommendDao = learningReviewRecommendDao;
  }

  @Override
  public int add(Review Review) throws Exception {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public List<Review> listByLearning(int lno) throws Exception {
    return learningReviewDao.findListByLearningNo(lno);
  }

  @Override
  public List<Review> listByMember(int mno) throws Exception {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Review get(int no) throws Exception {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public int update(Review Review) throws Exception {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public int delete(int no) throws Exception {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public List<Review> Search(int no) throws Exception {
    // TODO Auto-generated method stub
    return null;
  }

}