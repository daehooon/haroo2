package com.bit189.haroo.dao;

import java.util.List;
import com.bit189.haroo.domain.Review;

public interface LearningReviewDao {
  int insert(Review review) throws Exception;

  List<Review> findAll() throws Exception;

  Review findByNo(int no) throws Exception;
}
