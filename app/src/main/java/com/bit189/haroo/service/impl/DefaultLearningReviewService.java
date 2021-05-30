package com.bit189.haroo.service.impl;

import java.util.HashMap;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.support.TransactionTemplate;
import com.bit189.haroo.dao.LearningReviewDao;
import com.bit189.haroo.dao.LearningReviewRecommendDao;
import com.bit189.haroo.dao.PostDao;
import com.bit189.haroo.domain.LearningReview;
import com.bit189.haroo.service.LearningReviewService;

@Service
public class DefaultLearningReviewService implements LearningReviewService {

  TransactionTemplate transactionTemplate;
  LearningReviewDao learningReviewDao;
  LearningReviewRecommendDao learningReviewRecommendDao;
  PostDao postDao;

  public DefaultLearningReviewService(PlatformTransactionManager txManager,
      LearningReviewDao learningReviewDao,  
      LearningReviewRecommendDao learningReviewRecommendDao,
      PostDao postDao) {
    this.transactionTemplate = new TransactionTemplate(txManager);
    this.learningReviewDao = learningReviewDao;
    this.learningReviewRecommendDao = learningReviewRecommendDao;
    this.postDao = postDao;
    System.out.println("DefaultLearningReviewService 객체 생성됨!");
  }

  @Override
  public int add(LearningReview review) throws Exception {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public List<LearningReview> listByLearning(int learningNo, String sortingItem, String sortingType)
      throws Exception {
    HashMap<String,Object> params = new HashMap<>();
    params.put("learningNo", learningNo);
    params.put("sortingItem", sortingItem);
    params.put("sortingType", sortingType);

    return learningReviewDao.findListByLearningNo(params);
  }

  @Override
  public List<LearningReview> listByMember(int memberNo, String sortingItem, String sortingType)
      throws Exception {
    HashMap<String,Object> params = new HashMap<>();
    params.put("memberNo", memberNo);
    params.put("sortingItem", sortingItem);
    params.put("sortingType", sortingType);

    return learningReviewDao.findListByMemberNo(params);
  }

  @Override
  public LearningReview get(int reviewNo) throws Exception {

    LearningReview learningReview = learningReviewDao.findByNo(reviewNo);

    //    if(learningReview != null) {
    //      postDao.updateViewCount(reviewNo);
    //    }

    return learningReview;
  }

  @Override
  public int update(LearningReview review) throws Exception {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public List<LearningReview> Search(String keyword) throws Exception {
    // TODO Auto-generated method stub
    return null;
  }

}