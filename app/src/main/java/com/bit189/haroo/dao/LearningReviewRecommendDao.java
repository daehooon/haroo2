package com.bit189.haroo.dao;

import com.bit189.haroo.domain.Review;

public interface LearningReviewRecommendDao {
  int insert (Review review) throws Exception;

  int delete (int no) throws Exception;
}