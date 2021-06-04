package com.bit189.haroo.service.impl;

import java.util.HashMap;
import java.util.List;
import javax.servlet.ServletException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;
import com.bit189.haroo.dao.LearningReviewDao;
import com.bit189.haroo.dao.PostDao;
import com.bit189.haroo.domain.AttachedFile;
import com.bit189.haroo.domain.LearningReview;
import com.bit189.haroo.domain.Post;
import com.bit189.haroo.service.LearningReviewService;

@Service
public class DefaultLearningReviewService implements LearningReviewService {

  TransactionTemplate transactionTemplate;
  LearningReviewDao learningReviewDao;
  PostDao postDao;

  public DefaultLearningReviewService(PlatformTransactionManager txManager,
      LearningReviewDao learningReviewDao,
      PostDao postDao) {
    this.transactionTemplate = new TransactionTemplate(txManager);
    this.learningReviewDao = learningReviewDao;
    this.postDao = postDao;
    System.out.println("DefaultLearningReviewService 객체 생성됨!");
  }

  @Override
  public int add(Post post, List<AttachedFile> files, int lrn_appl_no, String title, double rate)
      throws Exception {
    System.out.println(post);

    return transactionTemplate.execute(new TransactionCallback<Integer>(){
      @Override
      public Integer doInTransaction(TransactionStatus status) {
        try {

          if (learningReviewDao.isReviewedByApplicationNo(lrn_appl_no) == 1) {
            throw new RuntimeException("이미 리뷰 하였습니다.");
          } else {

            int count = postDao.insert(post);

            for (AttachedFile file : files) {
              file.setPostNo(post.getNo());
              postDao.insertFile(file);
            }

            HashMap<String,Object> params = new HashMap<String,Object>();
            params.put("reviewNo", post.getNo());
            params.put("title", title);
            params.put("rate", rate);
            params.put("applNo", lrn_appl_no);

            learningReviewDao.insert(params);

            return count;
          }
        } catch (Exception e) {
          throw new RuntimeException(e);
        }
      }
    });
  }

  @Override
  public int update(Post post, List<AttachedFile> files, String title, double rate)
      throws Exception {

    return transactionTemplate.execute(new TransactionCallback<Integer>(){
      @Override
      public Integer doInTransaction(TransactionStatus status) {
        try {
          System.out.println("post" + post);
          postDao.deleteFile(post.getNo());

          int count = postDao.update(post);

          for (AttachedFile file : files) {
            file.setPostNo(post.getNo());
            postDao.insertFile(file);
          }

          System.out.println("post.no"+post.getNo());

          HashMap<String,Object> params = new HashMap<String,Object>();
          params.put("reviewNo", post.getNo());
          params.put("title", title);
          params.put("rate", rate);

          learningReviewDao.update(params);

          return count;

        } catch (Exception e) {
          throw new RuntimeException(e);
        }
      }
    });
  }

  @Override
  public List<LearningReview> listByLearning(int learningNo, String sortingItem, String sortingType)
      throws Exception {
    HashMap<String,Object> params = new HashMap<>();
    params.put("learningNo", learningNo);
    params.put("sortingItem", sortingItem);
    params.put("sortingType", sortingType);

    return learningReviewDao.findListByLearningNo(params);
  }

  @Override
  public List<LearningReview> listByMember(int memberNo, String sortingItem, String sortingType)
      throws Exception {
    HashMap<String,Object> params = new HashMap<>();
    params.put("memberNo", memberNo);
    params.put("sortingItem", sortingItem);
    params.put("sortingType", sortingType);

    return learningReviewDao.findListByMemberNo(params);
  }

  @Override
  public LearningReview get(int reviewNo) throws Exception {

    if(learningReviewDao.findByNo(reviewNo) != null) {
      postDao.updateViewCount(reviewNo);
    }

    return learningReviewDao.findByNo(reviewNo);
  }

  @Override
  public int update(LearningReview review) throws Exception {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public List<LearningReview> Search(String keyword) throws Exception {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public int recommend(int mno, int rno) throws Exception {
    HashMap<String, Object> params = new HashMap<>();
    params.put("memberNo", mno);
    params.put("reviewNo", rno);

    return learningReviewDao.insertRecommend(params);
  }

  @Override
  public int unRecommend(int mno, int rno) throws Exception {
    HashMap<String, Object> params = new HashMap<>();
    params.put("memberNo", mno);
    params.put("reviewNo", rno);

    return learningReviewDao.deleteRecommend(params);
  }

  @Override
  public boolean isRecommended(int mno, int rno) throws Exception {
    HashMap<String, Object> params = new HashMap<>();
    params.put("memberNo", mno);
    params.put("reviewNo", rno);

    if (learningReviewDao.findRecommend(params) == 1) {
      return true;
    }

    if (learningReviewDao.findRecommend(params) == 0) {
      return false;
    }

    throw new ServletException("har_lrnrv_rcm 정상 동작 범위 벗어난 치명적 에러");
  }

  @Override
  public Boolean isReviewed(int applicationNo) throws Exception {

    if (learningReviewDao.isReviewedByApplicationNo(applicationNo) == 1) {
      return true;
    }

    return false;
  }

  @Override
  public int getApplicationNo(int mno, int lno) throws Exception {
    HashMap<String, Object> params = new HashMap<>();
    params.put("memberNo", mno);
    params.put("learningNo", lno);

    String applNo = learningReviewDao.findApllicationNo(params);

    if ( applNo == null) {
      return 0;
    }

    return Integer.parseInt(applNo); 
  }

  @Override
  public int delete(int rno) throws Exception {
    return transactionTemplate.execute(new TransactionCallback<Integer>(){
      @Override
      public Integer doInTransaction(TransactionStatus status) {
        try {

          learningReviewDao.deleteReviewRecommend(rno);

          int count = learningReviewDao.deleteReview(rno);

          postDao.deleteFile(rno);

          postDao.delete(rno);

          return count;

        } catch (Exception e) {
          throw new RuntimeException(e);
        }
      }
    });
  }

}