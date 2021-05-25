package com.bit189.haroo.dao;

import java.util.List;
import java.util.Map;
import com.bit189.haroo.domain.LearningReview;

public interface LearningReviewDao {
  int insert(LearningReview review) throws Exception;

  List<LearningReview> findListByLearningNo(Map<String,Object> params) throws Exception;

  List<LearningReview> findListByMemberNo(Map<String,Object> params) throws Exception;

  LearningReview findByNo(int reviewNo) throws Exception;

  int update(LearningReview review) throws Exception;

  List<LearningReview> findByKeyword(String keyword) throws Exception;
}