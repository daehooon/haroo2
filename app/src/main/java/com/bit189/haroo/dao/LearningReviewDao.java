package com.bit189.haroo.dao;

import java.util.List;
import java.util.Map;
import com.bit189.haroo.domain.LearningReview;

public interface LearningReviewDao {
  int insert(Map<String,Object> params) throws Exception;

  List<LearningReview> findListByLearningNo(Map<String,Object> params) throws Exception;

  List<LearningReview> findListByMemberNo(Map<String,Object> params) throws Exception;

  LearningReview findByNo(int reviewNo) throws Exception;

  int isReviewedByApplicationNo(int applicationNo) throws Exception;

  int update(Map<String,Object> params) throws Exception;

  int deleteReview(int reviewNo) throws Exception;

  List<LearningReview> findByKeyword(String keyword) throws Exception;

  int insertRecommend (Map<String,Object> params) throws Exception;

  int deleteRecommend (Map<String,Object> params) throws Exception;

  int deleteReviewRecommend (int reviewNo) throws Exception;

  int findRecommend (Map<String,Object> params) throws Exception;

  String findApllicationNo(Map<String,Object> params) throws Exception;
}