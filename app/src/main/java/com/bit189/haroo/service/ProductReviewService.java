package com.bit189.haroo.service;

import java.util.List;
import com.bit189.haroo.domain.LearningReview;

public interface ProductReviewService {

  int add(LearningReview Review) throws Exception;

  List<LearningReview> list() throws Exception;

  LearningReview get(int no) throws Exception;

  int update(LearningReview Review) throws Exception;

  int delete(int no) throws Exception;

  List<LearningReview> Search(int no) throws Exception;
}
