package com.bit189.haroo.service.impl;

import java.util.HashMap;
import java.util.List;
import org.springframework.stereotype.Service;
import com.bit189.haroo.dao.CommentDao;
import com.bit189.haroo.domain.Comment;
import com.bit189.haroo.service.CommentService;

@Service
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
  public List<Comment> list(int feedNo) throws Exception {
    return commentDao.findByComments(feedNo);
  }

  @Override
  public Comment get(int commentNo) throws Exception {
    return commentDao.findByComment(commentNo);
  }

  @Override
  public int delete(int commentNo) throws Exception {
    return commentDao.delete(commentNo);
  }

  @Override
  public int update(Comment comment) throws Exception {
    return commentDao.update(comment);
  }

  @Override
  public int getLike(int commentNo, int memberNo) throws Exception {
    HashMap<String, Object> params = new HashMap<>();
    params.put("commentNo", commentNo);
    params.put("memberNo", memberNo);

    return Integer.parseInt(commentDao.findLike(params));
  }

  @Override
  public int deleteLike(int commentNo, int memberNo) throws Exception {
    HashMap<String, Object> params = new HashMap<>();
    params.put("commentNo", commentNo);
    params.put("memberNo", memberNo);

    return commentDao.deleteLike(params);
  }

  @Override
  public int addLike(int commentNo, int memberNo) throws Exception {
    HashMap<String, Object> params = new HashMap<>();
    params.put("commentNo", commentNo);
    params.put("memberNo", memberNo);

    return commentDao.addLike(params);
  }



}
