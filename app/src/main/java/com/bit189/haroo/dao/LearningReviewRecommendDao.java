package com.bit189.haroo.dao;

import com.bit189.haroo.domain.LearningReview;

public interface LearningReviewRecommendDao {
  int insert (LearningReview review) throws Exception;

  int delete (int no) throws Exception;
}