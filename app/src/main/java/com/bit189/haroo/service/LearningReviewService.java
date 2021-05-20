package com.bit189.haroo.service;

import java.util.List;
import com.bit189.haroo.domain.Review;

public interface LearningReviewService {

  int add(Review Review) throws Exception;

  List<Review> listByLearning(int lno) throws Exception;

  List<Review> listByMember(int mno) throws Exception;

  Review get(int no) throws Exception;

  int update(Review Review) throws Exception;

  int delete(int no) throws Exception;

  List<Review> Search(int no) throws Exception;
}
