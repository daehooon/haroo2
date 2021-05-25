package com.bit189.haroo.service.impl;

import java.util.HashMap;
import java.util.List;
import com.bit189.haroo.dao.CommentDao;
import com.bit189.haroo.dao.FeedDao;
import com.bit189.haroo.dao.LikeDao;
import com.bit189.haroo.dao.PostDao;
import com.bit189.haroo.domain.Feed;
import com.bit189.haroo.domain.Post;
import com.bit189.haroo.service.FeedService;

public class DefaultFeedService implements FeedService{

  FeedDao feedDao;
  CommentDao commentDao;
  LikeDao likeDao;
  PostDao postDao;

  public DefaultFeedService(FeedDao feedDao, CommentDao commentDao, LikeDao likeDao, PostDao postDao) {
    this.feedDao = feedDao;
    this.commentDao = commentDao;
    this.likeDao = likeDao;
    this.postDao = postDao;
  }

  @Override
  public int add(Post post, Feed feed) throws Exception {
    // 튜터가 스토리를 올리기위한 과정 
    // : har_post 에 먼저 insert되고, 그때 자동증가 된 pno를 가지고 har_feed테이블에 insert 해야함


    // 1. 파라미터로 받은 post객체를 har_post에 insert
    postDao.insert(post);

    // 2. 파라미터로 받은 feed 객체와 har_post에 insert 하자마자 자동증가 된 pno를
    //    한번에 보내 주기위해 HashMap사용하여 insert
    HashMap<String,Object> param = new HashMap<>();
    param.put("no", post.getNo());
    param.put("feed", feed);

    return feedDao.insert(param);
  }

  @Override
  public List<Feed> list() throws Exception {
    List<Feed> feeds = feedDao.findAll();

    //    for (Feed f : feeds) {
    //      f.setCommentCount(Integer.parseInt(commentDao.commentCount(f.getNo())));
    //      f.setLikeCount(Integer.parseInt(likeDao.likeCount(f.getNo())));
    //    }

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



}