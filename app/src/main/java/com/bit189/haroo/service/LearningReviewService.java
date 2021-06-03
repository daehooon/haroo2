package com.bit189.haroo.service;

import java.util.List;
import com.bit189.haroo.domain.AttachedFile;
import com.bit189.haroo.domain.LearningReview;
import com.bit189.haroo.domain.Post;

public interface LearningReviewService {

  int add(Post post, List<AttachedFile> files, int lrn_appl_no, String title, double rate, int mno) throws Exception;

  List<LearningReview> listByLearning(int learningNo, String sortingItem, String sortingType) throws Exception;

  List<LearningReview> listByMember(int memberNo, String sortingItem, String sortingType) throws Exception;

  LearningReview get(int postNo) throws Exception;

  Boolean isReviewed(int applicationNo) throws Exception;

  int update(LearningReview review) throws Exception;

  List<LearningReview> Search(String keyword) throws Exception;

  int recommend(int mno, int rno) throws Exception;

  int unRecommend(int mno, int rno) throws Exception;

  boolean isRecommended(int mno, int rno) throws Exception;

  int getApplicationNo(int mno, int lno) throws Exception;
}
