package com.bit189.haroo.service.impl;

import java.util.HashMap;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;
import com.bit189.haroo.dao.CommentDao;
import com.bit189.haroo.dao.FeedDao;
import com.bit189.haroo.dao.LikeDao;
import com.bit189.haroo.dao.PostDao;
import com.bit189.haroo.domain.AttachedFile;
import com.bit189.haroo.domain.Feed;
import com.bit189.haroo.domain.Post;
import com.bit189.haroo.service.FeedService;

@Service
public class DefaultFeedService implements FeedService{

  TransactionTemplate transactionTemplate;

  FeedDao feedDao;
  CommentDao commentDao;
  LikeDao likeDao;
  PostDao postDao;

  public DefaultFeedService(PlatformTransactionManager  txManager,
      FeedDao feedDao, CommentDao commentDao, LikeDao likeDao, PostDao postDao) {
    this.transactionTemplate = new TransactionTemplate(txManager);
    this.feedDao = feedDao;
    this.commentDao = commentDao;
    this.likeDao = likeDao;
    this.postDao = postDao;
  }

  @Override
  public int add(Post post, List<AttachedFile> files, Feed feed) throws Exception {
    //    postDao.insert(post);
    //
    //    for (AttachedFile file : files) {
    //      file.setPostNo(post.getNo());
    //
    //      postDao.insertFile(file);
    //    }
    //
    //    HashMap<String,Object> param = new HashMap<>();
    //    param.put("no", post.getNo());
    //    param.put("feed", feed);
    //
    //    return feedDao.insert(param);
    return transactionTemplate.execute(new TransactionCallback<Integer>(){
      @Override
      public Integer doInTransaction(TransactionStatus status) {
        try {
          int count = postDao.insert(post);

          for (AttachedFile file : files) {
            file.setPostNo(post.getNo());

            postDao.insertFile(file);
          }

          HashMap<String,Object> param = new HashMap<>();
          param.put("no", post.getNo());
          param.put("feed", feed);

          feedDao.insert(param);

          return count;
        } catch (Exception e) {
          throw new RuntimeException(e);
        }
      }
    });
  }

  @Override
  public List<Feed> list(int no) throws Exception {
    List<Feed> feeds = feedDao.findAll(no);

    for (Feed f : feeds) {
      f.setCommentCount(Integer.parseInt(commentDao.commentCount(f.getNo())));
      f.setLikeCount(Integer.parseInt(likeDao.likeCount(f.getNo())));
    }

    return feeds;
  }

  @Override
  public Feed get(int no) throws Exception {
    Feed feed = feedDao.findByNo(no);

    feed.setCommentCount(Integer.parseInt(commentDao.commentCount(no)));
    feed.setLikeCount(Integer.parseInt(likeDao.likeCount(no)));

    if (feed != null) {
      postDao.updateViewCount(no);
    }

    return feed;
  }

  @Override
  public Feed getCheck(int no) throws Exception {
    Feed feed = feedDao.findByNo(no);

    return feed;
  }

  @Override
  public int getLike(int feedNo, int memberNo) throws Exception {
    HashMap<String, Object> params = new HashMap<>();
    params.put("feedNo", feedNo);
    params.put("memberNo", memberNo);

    return Integer.parseInt(feedDao.findLike(params));
  }

  @Override
  public int addLike(int feedNo, int memberNo) throws Exception {
    HashMap<String, Object> params = new HashMap<>();
    params.put("feedNo", feedNo);
    params.put("memberNo", memberNo);

    return feedDao.insertLike(params);
  }

  @Override
  public int deleteLike(int feedNo, int memberNo) throws Exception {
    HashMap<String, Object> params = new HashMap<>();
    params.put("feedNo", feedNo);
    params.put("memberNo", memberNo);

    return feedDao.deleteLike(params);
  }

  @Override
  public int update(Post post, List<AttachedFile> files) throws Exception {
    return transactionTemplate.execute(new TransactionCallback<Integer>(){
      @Override
      public Integer doInTransaction(TransactionStatus status) {
        try {
          int count = postDao.update(post);

          postDao.deleteFile(post.getNo());

          for (AttachedFile f : files) {
            f.setPostNo(post.getNo());

            postDao.insertFile(f);
          }

          return count;
        } catch (Exception e) {
          throw new RuntimeException(e);
        }
      }
    });
  }



}