package com.bit189.haroo.service.impl;

import java.util.HashMap;
import java.util.List;
import com.bit189.haroo.dao.CommentDao;
import com.bit189.haroo.dao.FeedDao;
import com.bit189.haroo.dao.ReCommentDao;
import com.bit189.haroo.domain.Comment;
import com.bit189.haroo.domain.Feed;
import com.bit189.haroo.service.FeedService;

public class DefaultFeedService implements FeedService{

  FeedDao feedDao;
  CommentDao commentDao;
  ReCommentDao reCommentDao;

  public DefaultFeedService(FeedDao feedDao, CommentDao commentDao, ReCommentDao reCommentDao) {
    this.feedDao = feedDao;
    this.commentDao = commentDao;
    this.reCommentDao = reCommentDao;
  }

  @Override
  public int add(int postNo, Feed feed) throws Exception {
    HashMap<String,Object> param = new HashMap<>();
    param.put("no", postNo);
    param.put("feed", feed);

    return feedDao.insert(param);
  }

  @Override
  public List<Feed> list() throws Exception {
    List<Feed> feeds = feedDao.findAll();


    for (Feed f : feeds) {
      int commentCount = 0;

      List<Comment> comments = commentDao.findByComments(f.getNo());

      for (Comment c : comments) {
        commentCount += (Integer.parseInt(reCommentDao.reCommentCount(c.getNo())) + 1);
      }

      f.setCommentCount(commentCount);
      f.setLikeCount(Integer.parseInt(feedDao.likeCount(f.getNo())));
    }

    return feeds;
  }

  @Override
  public Feed get(int no) throws Exception {
    Feed feed = feedDao.findByNo(no);

    int commentCount = 0;

    List<Comment> comments = commentDao.findByComments(feed.getNo());

    for (Comment c : comments) {
      commentCount += (Integer.parseInt(reCommentDao.reCommentCount(c.getNo())) + 1);
    }

    feed.setCommentCount(commentCount);
    feed.setLikeCount(Integer.parseInt(feedDao.likeCount(feed.getNo())));

    return feed;
  }



}