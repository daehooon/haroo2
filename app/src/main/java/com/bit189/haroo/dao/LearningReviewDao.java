package com.bit189.haroo.dao;

import java.util.List;
import com.bit189.haroo.domain.Review;

public interface LearningReviewDao {
  int insert(Review review) throws Exception;

  List<Review> findListByLearningNo(int lno) throws Exception;

  List<Review> findListByMemberNo(int mno) throws Exception;

  Review findByNo(int no) throws Exception;

  int update(Review review) throws Exception;

  int delete(int no) throws Exception;
}