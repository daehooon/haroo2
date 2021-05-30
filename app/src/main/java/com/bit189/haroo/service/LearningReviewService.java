package com.bit189.haroo.service;

import java.util.List;
import com.bit189.haroo.domain.LearningReview;

public interface LearningReviewService {

  int add(LearningReview review) throws Exception;

  List<LearningReview> listByLearning(int learningNo, String sortingItem, String sortingType) throws Exception;

  List<LearningReview> listByMember(int memberNo, String sortingItem, String sortingType) throws Exception;

  LearningReview get(int postNo) throws Exception;

  int update(LearningReview review) throws Exception;

  List<LearningReview> Search(String keyword) throws Exception;
}
