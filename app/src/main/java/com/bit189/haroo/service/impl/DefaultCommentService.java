package com.bit189.haroo.service.impl;

import java.util.List;
import com.bit189.haroo.dao.CommentDao;
import com.bit189.haroo.domain.Comment;
import com.bit189.haroo.service.CommentService;

public class DefaultCommentService implements CommentService{

  CommentDao commentDao;

  public DefaultCommentService(CommentDao commentDao) {
    this.commentDao = commentDao;
  }

  @Override
  public int add(Comment comment) throws Exception {
    return commentDao.insert(comment);
  }

  @Override
  public List<Comment> get(int feedNo) throws Exception {
    return commentDao.findByComments(feedNo);
  }
}