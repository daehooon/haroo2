package com.bit189.haroo.service;

import java.util.List;
import com.bit189.haroo.domain.LearningReview;

public interface LearningReviewService {
  int WRITED_DATE = 1;
  int AVERAGE_RATE = 2;
  int RECOMMEND_COUNT = 3;

  int add(LearningReview review) throws Exception;

  List<LearningReview> listByLearning(int learningNo, int sortingStd, boolean isAsc) throws Exception;

  List<LearningReview> listByMember(int memberNo, int sortingStd, boolean isAsc) throws Exception;

  LearningReview get(int postNo) throws Exception;

  int update(LearningReview review) throws Exception;

  List<LearningReview> Search(String keyword) throws Exception;
}
