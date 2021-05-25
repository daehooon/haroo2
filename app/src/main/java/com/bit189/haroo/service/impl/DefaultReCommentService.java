package com.bit189.haroo.service.impl;

import java.util.List;
import com.bit189.haroo.dao.ReCommentDao;
import com.bit189.haroo.domain.ReComment;
import com.bit189.haroo.service.ReCommentService;

public class DefaultReCommentService implements ReCommentService{

  ReCommentDao reCommentDao;

  public DefaultReCommentService(ReCommentDao reCommentDao) {
    this.reCommentDao = reCommentDao;
  }

  @Override
  public int add(ReComment reComment) throws Exception {
    return reCommentDao.insert(reComment);
  }

  @Override
  public List<ReComment> list(int commentNo) throws Exception {
    return reCommentDao.findByReComments(commentNo);
  }

  @Override
  public ReComment get(int reCommentNo) throws Exception {
    return reCommentDao.findByReComment(reCommentNo);
  }

  @Override
  public int delete(int reCommentNo) throws Exception {
    return reCommentDao.delete(reCommentNo);
  }


}
